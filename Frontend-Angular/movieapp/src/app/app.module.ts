import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { AboutComponent } from './components/about/about.component';

import { LayoutModule } from '@angular/cdk/layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import { MatSidenavModule } from "@angular/material/sidenav";
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import {MatListModule} from '@angular/material/list';
import {MatButtonModule} from '@angular/material/button'
import {MatIconModule} from '@angular/material/icon'
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatInputModule } from '@angular/material/input';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatDialogModule} from '@angular/material/dialog';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatTableModule} from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
// import { NgToastModule } from 'ng-angular-popup'; 

import {LoginComponent } from './components/login/login.component'
import { AuthGuard } from './models/auth.guard';
import { AuthInterceptor } from './models/auth.interceptor';
import { AuthService } from './services/auth.service';
import { HomeComponent } from './components/home/home.component';
import { AddmovieComponent } from './components/addmovie/addmovie.component';
import { BookticketComponent } from './components/bookticket/bookticket.component';
import { RegisterComponent } from './components/register/register.component';
import { ForgotpasswordComponent } from './components/forgotpassword/forgotpassword.component';
import { UserlistComponent } from './components/userlist/userlist.component';
import { SearchComponent } from './components/search/search.component';
import { UpdatemovieComponent } from './components/updatemovie/updatemovie.component';
import { MyticketsComponent } from './components/mytickets/mytickets.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AboutComponent,
    LoginComponent,
    HomeComponent,
    AddmovieComponent,
    BookticketComponent,
    RegisterComponent,
    ForgotpasswordComponent,
    UserlistComponent,
    SearchComponent,
    UpdatemovieComponent,
    MyticketsComponent
  ],
  imports: [
    LayoutModule,
    BrowserModule,
    AppRoutingModule, HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,MatSidenavModule,MatListModule,MatButtonModule,MatIconModule,
    MatCardModule,MatFormFieldModule,FormsModule, ReactiveFormsModule,MatDatepickerModule,MatPaginatorModule,
    MatNativeDateModule,MatInputModule,MatTooltipModule,MatDialogModule,MatExpansionModule,MatTableModule
  ],
  providers: [AuthGuard,{provide:HTTP_INTERCEPTORS,useClass:AuthInterceptor,multi:true},AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
