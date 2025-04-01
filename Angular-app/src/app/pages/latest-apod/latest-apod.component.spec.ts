import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestAPODComponent } from './latest-apod.component';

describe('LatestAPODComponent', () => {
  let component: LatestAPODComponent;
  let fixture: ComponentFixture<LatestAPODComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LatestAPODComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LatestAPODComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
