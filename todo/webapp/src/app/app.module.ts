import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ReactiveFormsModule, FormsModule, FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

import { AppComponent } from './app.component';
import { AddComponent } from '../components/add/add.component';
import { HeaderComponent } from '../components/header/header.component';
import { ContentComponent } from '../components/content/content.component';

import { TaskService } from '../providers/task.service';

@NgModule({
  declarations: [
    AppComponent,
    AddComponent,
    HeaderComponent,
    ContentComponent
  ], exports: [

  ],
  imports: [
    BrowserModule,
    HttpModule,
    FlexLayoutModule,
    FormsModule
  ],
  providers: [
    TaskService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
