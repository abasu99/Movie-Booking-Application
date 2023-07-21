import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatemovieComponent } from './updatemovie.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { HttpClientTestingModule } from '@angular/common/http/testing';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule } from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import {MatToolbarModule} from '@angular/material/toolbar';
import { RouterTestingModule } from '@angular/router/testing';
import {MatTableModule} from '@angular/material/table';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

describe('UpdatemovieComponent', () => {
  let component: UpdatemovieComponent;
  let fixture: ComponentFixture<UpdatemovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatemovieComponent ],
      imports:[FormsModule, ReactiveFormsModule,HttpClientTestingModule , BrowserAnimationsModule,MatButtonModule,
        MatIconModule,MatInputModule,MatFormFieldModule,MatDialogModule,MatToolbarModule,RouterTestingModule,
        MatTableModule],
        schemas: [
          CUSTOM_ELEMENTS_SCHEMA
        ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdatemovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
