import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookticketComponent } from './bookticket.component';
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

describe('BookticketComponent', () => {
  let component: BookticketComponent;
  let fixture: ComponentFixture<BookticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookticketComponent ],
      imports:[FormsModule, ReactiveFormsModule,HttpClientTestingModule , BrowserAnimationsModule,MatButtonModule,
        MatIconModule,MatInputModule,MatFormFieldModule,MatDialogModule,MatToolbarModule,RouterTestingModule,
        MatTableModule],
        schemas: [
          CUSTOM_ELEMENTS_SCHEMA
        ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
