import { ComponentFixture, TestBed } from '@angular/core/testing';

import { APODArchiveComponent } from './apod-archive.component';

describe('APODArchiveComponent', () => {
  let component: APODArchiveComponent;
  let fixture: ComponentFixture<APODArchiveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [APODArchiveComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(APODArchiveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
