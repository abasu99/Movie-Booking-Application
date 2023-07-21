import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from '@angular/material/paginator';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { catchError, map, startWith, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']

})
export class UserlistComponent implements AfterViewInit{

  user:User[] | any;
  displayedColumns: string[] = ['userName', 'userFullName', 'userEmail', 'role[0].roleName'];
  dataSource:any;
  resultsLength=0;

  data:User[]|any;
  total: number|any;
  

  constructor(private userService:AuthService){}
  // ngOnInit(){
  //   this.getUsersList();
  // }

  getUsersList(){
    this.userService.getUserDetails().subscribe(data=>{
      this.user=data;
      this.dataSource=new MatTableDataSource<User>(this.user);
      this.resultsLength=this.user.length;
      console.log(data);
      
    },error=>{
      console.log(error);
      
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  @ViewChild('paginator') paginator: MatPaginator | any;

  ngAfterViewInit() {
    this.getUsersList();
    this.dataSource.paginator = this.paginator;

  }


}


