import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] //  Fixed typo: `styleUrl` → `styleUrls`
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  @Output() loginSuccess = new EventEmitter<string>();

  constructor(private router: Router) {}

  login() {
    if (this.username === 'admin' && this.password === 'admin') {
      localStorage.setItem('user', this.username); // ✅ Store user in localStorage
      this.loginSuccess.emit(this.username);
      this.router.navigate(['/']); // ✅ Redirect to home page after login
    } else {
      this.errorMessage = 'Invalid username or password!';
    }
  }
}
