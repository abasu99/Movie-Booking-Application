import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './components/about/about.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import {AuthGuard} from './models/auth.guard';
import { BookticketComponent } from './components/bookticket/bookticket.component';
import { RegisterComponent } from './components/register/register.component';
import { UserlistComponent } from './components/userlist/userlist.component';
import { UpdatemovieComponent } from './components/updatemovie/updatemovie.component';
import { MyticketsComponent } from './components/mytickets/mytickets.component';

const routes: Routes = [
  {path:'',component:AboutComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:'home',component:HomeComponent, canActivate:[AuthGuard]},
  {path:'movie/:movieId',component:BookticketComponent, canActivate:[AuthGuard]},
  {path:'update/:movieId',component:UpdatemovieComponent, canActivate:[AuthGuard]},
  {path:'userList',component:UserlistComponent, canActivate:[AuthGuard]},
  {path:'my-tickets',component:MyticketsComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
