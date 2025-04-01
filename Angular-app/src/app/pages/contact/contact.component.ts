import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent {
  contactForm: FormGroup;

  constructor() {
    this.contactForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      email: new FormControl('', [Validators.required, Validators.email]),
      message: new FormControl('', [Validators.required, Validators.minLength(10)]),
    });
  }

  onSubmit() {
    if (this.contactForm.valid) {
      console.log("Form Submitted:", this.contactForm.value);
      alert("Message sent successfully!");
      this.contactForm.reset(); // Reset the form after submission
    } else {
      alert("Please fill in all required fields correctly.");
    }
  }
}
