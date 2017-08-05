import { NgModule }      from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent }  from './app.component';
import { MainComponent }  from './main.component';
import { ReportComponent }  from './report.component';
import { UploadComponent }  from './upload.component';
import { PageNotFoundComponent }  from './pagenotfound.component';
import { HttpModule } from "@angular/http";

import { ChartsModule } from 'ng2-charts';

const appRoutes: Routes = [
  { path: 'upload',   component: UploadComponent },
  { path: 'report',  component: ReportComponent },
  { path: '',         component: MainComponent },
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports:      [
    FormsModule,
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpModule,
    ChartsModule],
  declarations: [ AppComponent, UploadComponent, ReportComponent, MainComponent, PageNotFoundComponent ],
  bootstrap:    [ AppComponent ],
})

export class AppModule { }
