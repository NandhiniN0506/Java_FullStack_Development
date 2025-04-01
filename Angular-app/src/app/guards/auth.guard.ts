import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(route: unknown, state: unknown): boolean {
    const user = localStorage.getItem('userAccess');
    if (user === 'granted') {
      return true;
    } else {
      alert('Access Denied! You must log in.');
      this.router.navigate(['/']);
      return false;
    }
  }

}
