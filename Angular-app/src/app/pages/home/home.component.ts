import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  visitCount: number = 0;
  user: string | null = localStorage.getItem('user');

  ngOnInit(): void {
    // Retrieve visit count from localStorage
    this.visitCount = Number(localStorage.getItem('visitCount')) || 0;
    this.visitCount++;
    localStorage.setItem('visitCount', this.visitCount.toString());

    // Check if user is logged in
    this.user = localStorage.getItem('user');
  }

  handleLogin(username: string) {
    this.user = username;
    localStorage.setItem('user', username);
  }

  logout() {
    localStorage.removeItem('user');
    this.user = null;
  }
}
