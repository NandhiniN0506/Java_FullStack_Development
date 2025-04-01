import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-bar',
  templateUrl: './menu-bar.component.html',
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent implements OnInit {
  loggedIn: boolean = false;
  username: string | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    // Check login status from localStorage
    this.username = localStorage.getItem('user');
    this.loggedIn = this.username !== null;
  }

  /**
   * Redirects user to the login page (Home Page)
   */
  login(): void {
    this.router.navigate(['/home']); // Redirect to Home where login happens
  }

  /**
   * Logs out user after confirmation
   */
  logout(): void {
    if (confirm('Are you sure you want to log out?')) {
      localStorage.removeItem('user'); // Remove user data
      this.loggedIn = false;
      this.username = null;
      this.router.navigate(['/']); // Redirect to home or login page
    }
  }
}
