import { Component } from '@angular/core';
import { Apod } from '../../model/apod';
import { NasaService } from '../../services/nasa.service';

@Component({
  selector: 'app-apod-date-selector',
  templateUrl: './apod-date-selector.component.html',
  styleUrl: './apod-date-selector.component.css'
})
export class ApodDateSelectorComponent {

  selectedDate: string = ''; // Stores the selected date
  maxDate: string = ''; // Restricts date selection to today
  apodData: any = null; // Stores APOD response

  constructor(private nasaService: NasaService) {}

  ngOnInit(): void {
    // Set maxDate to today (prevents future date selection)
    this.maxDate = new Date().toISOString().split('T')[0];
  }

  fetchAPOD(): void {
    if (!this.selectedDate) {
      alert('Please select a date first!');
      return;
    }

    this.nasaService.getApodByDate(this.selectedDate).subscribe(
      (data: Apod) => {
        this.apodData = data; // Store fetched APOD data
      },
      (error) => {
        console.error('Error fetching APOD:', error);
        alert('Failed to load APOD. Try another date.');
      }
    );
  }
}
