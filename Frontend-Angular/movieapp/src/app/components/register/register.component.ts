import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  user:User=new User();

  constructor(private authService:AuthService,private router:Router){}

  register(){
    this.authService.register(this.user).subscribe(data=>{
      console.log(data);
      alert('Registration Successful');
      this.router.navigate(['/login']);

    },error=>{
      
      console.log(error);
      alert('Registration Unsuccessful');
    })
  }

}
