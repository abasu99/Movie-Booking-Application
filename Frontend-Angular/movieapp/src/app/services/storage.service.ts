import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }
 
  //role name and role desc is saved
  public setRoles(roles:[]){
    localStorage.setItem('roles',JSON.stringify(roles)); 
  }

  public getRoles():[]{
    return JSON.parse(localStorage.getItem('roles') || '{}');
  }

  //only role name is saved
  public setRole(role:string){
    localStorage.setItem("role",role);
  }

  public getRole():string{
    const role: string = localStorage.getItem("role")!;
    return role;
  }

  public setUsername(userName:string){
    localStorage.setItem("userName",userName);
  }

  public getUsername():string{
    const userName: string = localStorage.getItem("userName")!;
    return userName;
  }

  public setToken(jwtToken:string){
    localStorage.setItem("jwtToken",jwtToken);
  }

  public getToken():string{
    
    const token: string = localStorage.getItem("jwtToken")!;
    return token;
  }
  
  public isLoggedIn(){
    // return this.getRoles() && this.getToken();
    if(localStorage.getItem("jwtToken")!=null){
      return true;
    }
    return false;
  }

  public clear(){
    return localStorage.clear();
  }
}
