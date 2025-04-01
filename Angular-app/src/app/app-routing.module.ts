import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';
import { HomeComponent } from './pages/home/home.component';
import { ApodArchiveComponent } from './pages/apod-archive/apod-archive.component';
import { LatestApodComponent } from './pages/latest-apod/latest-apod.component';
import { ApodDateSelectorComponent } from './pages/apod-date-selector/apod-date-selector.component';
import { AuthGuard } from './guards/auth.guard';
import { ApodDetailComponent } from './pages/apod-detail/apod-detail.component';
import { LoginComponent } from './common/login/login.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'apod-archive', component: ApodArchiveComponent },
  { path: 'contact', component: ContactComponent,canActivate: [AuthGuard] },
  { path: 'latest-apod', component: LatestApodComponent },
  {path : "search", component: ApodDateSelectorComponent},
  { path: 'apod-detail', component: ApodDetailComponent},
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
