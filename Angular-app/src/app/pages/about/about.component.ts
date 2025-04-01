import { Component } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.css']
})
export class AboutComponent {
  team = [
    { name: 'alice johnson', role: 'Developer', joinDate: new Date(2022, 3, 15) },
    { name: 'bob smith', role: 'Designer', joinDate: new Date(2023, 5, 20) },
    { name: 'charlie brown', role: 'Project Manager', joinDate: new Date(2021, 8, 10) }
  ];
}
