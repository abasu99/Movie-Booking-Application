import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtRequest } from '../models/jwt-request';
import { User } from '../models/user';
import { StorageService } from './storage.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http:HttpClient, private storage:StorageService) { }

  requestHeader=new HttpHeaders({'No-Auth':'True'});
  baseAuthApi='http://localhost:8081/auth';
  // baseAuthApi='http://ec2-34-220-181-255.us-west-2.compute.amazonaws.com:8081/auth';
  // baseAuthApi='https://idz0hv0mf7.execute-api.us-west-2.amazonaws.com/2141421-Arnab-MovieAPP/movieapp-login'


  public login(loginData: JwtRequest){
    return this.http.post(`${this.baseAuthApi}/login`,loginData, {headers:this.requestHeader});
  }

  public register(user:User){
    return this.http.post(`${this.baseAuthApi}/register`,user, {headers:this.requestHeader});
    // return this.http.post(`${this.baseAuthApi}/register-new-user`,user, {headers:this.requestHeader});
  }

  public forgotPassword(userName:string, user:User){
    return this.http.put(`${this.baseAuthApi}/forgotPassword/${userName}`,user, {headers:this.requestHeader});
    // return this.http.put(`${this.baseAuthApi}/${userName}`,user, {headers:this.requestHeader});
  }

  public getUserDetails():Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8081/api/v1.0/getAllUsers');
    // return this.http.get<User[]>(`${this.baseAuthApi}`);
  }


//this method might not be required
  public roleMatch(allowedRoles:any):boolean{
    let isMatch=false;
    const userRoles:any = this.storage.getRoles();

    if(userRoles!=null && userRoles){
      for(let i=0;i<userRoles.length;i++){
        for(let j=0;j<allowedRoles.length;j++){
          if(userRoles[i].roleName === allowedRoles[j]){
            isMatch=true;
            return isMatch;
          }
          
          return isMatch;
          
        }
      }
    }
    return isMatch;
  }

}
