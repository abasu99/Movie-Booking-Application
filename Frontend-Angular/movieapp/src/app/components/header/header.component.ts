import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { StorageService } from 'src/app/services/storage.service';
import { AddmovieComponent } from '../addmovie/addmovie.component';
import { SearchComponent } from '../search/search.component';
import {BreakpointObserver, BreakpointState, Breakpoints} from '@angular/cdk/layout';
import { Observable } from 'rxjs';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  isHandset:Observable<BreakpointState>=this.BreakpointObserver.observe(Breakpoints.Handset);


  constructor(private storage:StorageService, private route:Router, private matdialog:MatDialog,
    private BreakpointObserver:BreakpointObserver){}

  welcome='Welcome '+this.storage.getUsername();
  
  isLoggedIn(){
    return this.storage.isLoggedIn();
  }

  logout(){
    this.storage.clear();
    this.route.navigate(['/login']);
  }

  openDialog(){
    this.matdialog.open(AddmovieComponent,{width:'350px'});
  }

  openSearchDialog(){
    this.matdialog.open(SearchComponent,{width:'350px'});
  }

  isAdmin(){
   if(this.storage.getRole()==='Admin' && this.isLoggedIn()){
    return true;
   }
   return false;
  }

  isUser(){
    if(this.storage.getRole()==='User' && this.isLoggedIn()){
      return true;
     }
     return false;
  }

}
