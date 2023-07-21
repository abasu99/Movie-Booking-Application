import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { JwtRequest } from 'src/app/models/jwt-request';
import { AuthService } from 'src/app/services/auth.service';
import { StorageService } from 'src/app/services/storage.service';
import { ForgotpasswordComponent } from '../forgotpassword/forgotpassword.component';
// import { NgToastService } from 'ng-angular-popup/public-api';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private authService:AuthService, private matdialog:MatDialog,
    private route:Router, private storage:StorageService){}

  hide=true;
  data:{}|any;
  jwtrequest:JwtRequest=new JwtRequest();

 

  loginAction(){
    this.authService.login(this.jwtrequest).subscribe((data:any)=>{
      this.data=JSON.stringify(data);
      this.storage.setRoles(data.user.role);
      this.storage.setToken(data.jwtToken);
      
      this.storage.setRole(data.user.role[0].roleName);
      this.storage.setUsername(data.user.userName);
      // this.toast.success({detail:"Success message",summary:"Welcome "+data.user.userName, duration:5000});
      this.route.navigate(['/home']);
      
      
      
    },error=>{
 
      alert('Wrong credentials. Cannot login')
      // this.toast.error({detail:"Error message",summary:"Invalid Username or Password", duration:5000});
      console.log(error);
      
    })
  }

  openDialog(){
    this.matdialog.open(ForgotpasswordComponent,{width:'350px'});
  }
  

}


