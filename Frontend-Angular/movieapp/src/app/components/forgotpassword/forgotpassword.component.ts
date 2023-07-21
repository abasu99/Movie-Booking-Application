import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-forgotpassword',
  templateUrl: './forgotpassword.component.html',
  styleUrls: ['./forgotpassword.component.css']
})
export class ForgotpasswordComponent {

  hide=true;
  user:User=new User();

  constructor(private authService:AuthService, private router:Router){}

  updatePassword(){
    this.authService.forgotPassword(this.user.userName,this.user).subscribe(data=>{
      alert('Password changed successfully');
      console.log(data);
      alert('New Password created');
      window.location.reload();
    },
    error=>{alert('Wrong inputs. Cannot update password');
    console.log(error);
  })

  }

}
