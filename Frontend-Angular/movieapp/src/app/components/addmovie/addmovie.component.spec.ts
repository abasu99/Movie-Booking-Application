import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { AddmovieComponent } from './addmovie.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule } from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';

describe('AddmovieComponent', () => {
  let component: AddmovieComponent;
  let fixture: ComponentFixture<AddmovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddmovieComponent ],
      imports:[FormsModule, ReactiveFormsModule,HttpClientTestingModule , BrowserAnimationsModule,MatButtonModule,
        MatIconModule,MatInputModule,MatFormFieldModule,MatDialogModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddmovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });


  //The Component Should have the movie name

 it('should have the movie name',()=>{
  expect(fixture.debugElement.query(By.css('.movieName'))).toBeTruthy();

});

it('should have the theatre name',()=>{
  expect(fixture.debugElement.query(By.css('.theatreName'))).toBeTruthy();

});



  //It tests the input type of movie name

  // it('should check the input type of movie name',()=>{

  //   const name3=fixture.debugElement.query(By.css('.movieName'));
  //   const name:any=component.movieObj.movieName;
  //   const name2='DisneyLand';
  //   name.setValue(name2);

  //   fixture.detectChanges();
  //   expect(name3.nativeElement.value).toEqual(name2);

  // });


});
