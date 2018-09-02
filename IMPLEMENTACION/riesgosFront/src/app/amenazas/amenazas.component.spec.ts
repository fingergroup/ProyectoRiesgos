import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AmenazasComponent } from './amenazas.component';

describe('AmenazasComponent', () => {
  let component: AmenazasComponent;
  let fixture: ComponentFixture<AmenazasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AmenazasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AmenazasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
