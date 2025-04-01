import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-apod-detail',
  templateUrl: './apod-detail.component.html',
  styleUrl: './apod-detail.component.css'
})
export class ApodDetailComponent implements OnInit {
  apodData: any = {};

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.apodData = params;
    });
  }

}
