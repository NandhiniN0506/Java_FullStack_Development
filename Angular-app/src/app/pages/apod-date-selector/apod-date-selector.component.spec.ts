import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApodDateSelectorComponent } from './apod-date-selector.component';

describe('ApodDateSelectorComponent', () => {
  let component: ApodDateSelectorComponent;
  let fixture: ComponentFixture<ApodDateSelectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ApodDateSelectorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ApodDateSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
