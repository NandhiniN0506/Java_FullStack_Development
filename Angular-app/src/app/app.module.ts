import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuBarComponent } from './common/menu-bar/menu-bar.component';
import { HomeComponent } from './pages/home/home.component';
import { LatestApodComponent } from './pages/latest-apod/latest-apod.component';
import { ApodArchiveComponent } from './pages/apod-archive/apod-archive.component';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ApodDateSelectorComponent } from './pages/apod-date-selector/apod-date-selector.component';
import { TitlecasePipe } from './pipes/titlecase.pipe';
import { ApodDetailComponent } from './pages/apod-detail/apod-detail.component';
import { LoginComponent } from './common/login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuBarComponent,
    HomeComponent,
    LatestApodComponent,
    ApodArchiveComponent,
    AboutComponent,
    ContactComponent,
    ApodDateSelectorComponent,
    TitlecasePipe,
    ApodDetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
