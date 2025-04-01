import { Component, OnInit } from '@angular/core';
import { NasaService } from '../../services/nasa.service';
import { Apod } from '../../model/apod';


@Component({
  selector: 'app-latest-apod',
  templateUrl: './latest-apod.component.html',
  styleUrls: ['./latest-apod.component.css']
})
export class LatestApodComponent implements OnInit {
  latestApod!: Apod;
  isLoading: boolean = true;

  constructor(private nasaService: NasaService) {}

  ngOnInit(): void {
    this.fetchLatestApod();
  }

  fetchLatestApod(): void {
    this.nasaService.getLatestApod().subscribe((data) => {
      this.latestApod = data;
      this.isLoading = false;
    });
  }
}
