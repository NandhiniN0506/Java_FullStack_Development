import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Apod } from '../model/apod';

@Injectable({
  providedIn: 'root'
})
export class NasaService {
  private apiKey = 'fkCqgeFZb0J4AxIpt9rb73QtA3BIg5iSa9l2skyZ';
  private baseUrl = 'https://api.nasa.gov/planetary/apod';
  private authToken: string | null = null;
  private userSubject = new BehaviorSubject<string | null>(null);

  constructor(private http: HttpClient) {
    // Check for logged-in user
    const storedUser = localStorage.getItem('loggedInUser');
    if (storedUser) {
      this.userSubject.next(storedUser);
    }
  }

  /**
   * Login User and Set Auth Token
   */
  login(username: string, token: string): void {
    localStorage.setItem('loggedInUser', username);
    localStorage.setItem('authToken', token);
    this.authToken = token;
    this.userSubject.next(username);
  }

  /**
   * Logout User and Remove Auth Token
   */
  logout(): void {
    localStorage.removeItem('loggedInUser');
    localStorage.removeItem('authToken');
    this.authToken = null;
    this.userSubject.next(null);
  }

  /**
   * Get the current logged-in user
   */
  getUser(): Observable<string | null> {
    return this.userSubject.asObservable();
  }

  /**
   * Get Latest APOD with Auth
   */
  getLatestApod(): Observable<Apod> {
    return this.http.get<Apod>(`${this.baseUrl}?api_key=${this.apiKey}`, {
      headers: this.getAuthHeaders()
    });
  }

  /**
   * Get APOD Archive with Auth
   */
  getApodArchive(startDate: string, endDate: string): Observable<Apod[]> {
    return this.http.get<Apod[]>(`${this.baseUrl}?api_key=${this.apiKey}&start_date=${startDate}&end_date=${endDate}`, {
      headers: this.getAuthHeaders()
    });
  }

  /**
   * Get APOD by Date with Auth
   */
  getApodByDate(date: string): Observable<Apod> {
    return this.http.get<Apod>(`${this.baseUrl}?api_key=${this.apiKey}&date=${date}`, {
      headers: this.getAuthHeaders()
    });
  }

  /**
   * Private method to get Authentication Headers
   */
  private getAuthHeaders(): HttpHeaders {
    let headers = new HttpHeaders();
    if (this.authToken) {
      headers = headers.set('Authorization', `Bearer ${this.authToken}`);
    }
    return headers;
  }
}
