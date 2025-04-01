import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NasaService } from '../../services/nasa.service';
import { Apod } from '../../model/apod';

@Component({
  selector: 'app-apod-archive',
  templateUrl: './apod-archive.component.html',
  styleUrls: ['./apod-archive.component.css']
})
export class ApodArchiveComponent implements OnInit {
  apodArchive: Apod[] = [];
  isLoading: boolean = false;
  startDate!: string;
  endDate!: string;
  daysToFetch: number = 20;
  user: string | null = null; // User authentication check

  constructor(private nasaService: NasaService, private router: Router) {}

  ngOnInit(): void {
    this.user = localStorage.getItem('user'); // Get user from local storage
    if (!this.user) {
      this.router.navigate(['/login']); // Redirect to login if not logged in
      return;
    }
    this.setInitialDates();
    this.fetchApodArchive();
  }

  setInitialDates(): void {
    const today = new Date();
    today.setDate(today.getDate() - 1); // Yesterday
    this.startDate = today.toISOString().split('T')[0];

    const pastDate = new Date(today);
    pastDate.setDate(today.getDate() - this.daysToFetch);
    this.endDate = pastDate.toISOString().split('T')[0];
  }

  viewDetail(apod: Apod): void {
    this.router.navigate(['/apod-detail'], { 
      queryParams: { title: apod.title, url: apod.url, date: apod.date, explanation: apod.explanation }
    });
  }

  fetchApodArchive(): void {
    if (this.isLoading) return; // Prevent duplicate requests

    this.isLoading = true;
    this.nasaService.getApodArchive(this.endDate, this.startDate).subscribe(
      (data) => {
        this.apodArchive = [...this.apodArchive, ...data.reverse()];
        this.isLoading = false;
      },
      (error) => {
        console.error('Error fetching APOD archive:', error);
        this.isLoading = false;
      }
    );
  }

  loadMore(): void {
    if (this.isLoading) return; // Prevent multiple calls at once
  
    // Move the date range back by 20 days
    const newEndDate = new Date(this.endDate);
    newEndDate.setDate(newEndDate.getDate() - this.daysToFetch);
  
    const newStartDate = new Date(this.endDate); // Start from previous end date
    newStartDate.setDate(newStartDate.getDate() - 1); // One day before previous end
  
    // Convert to string format
    this.endDate = newEndDate.toISOString().split('T')[0];
    this.startDate = newStartDate.toISOString().split('T')[0];
  
    // Fetch new data
    this.fetchApodArchive();
  }
  

  
  
}
