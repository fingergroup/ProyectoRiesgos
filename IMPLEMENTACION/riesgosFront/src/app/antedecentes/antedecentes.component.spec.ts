import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AntedecentesComponent } from './antedecentes.component';

describe('AntedecentesComponent', () => {
  let component: AntedecentesComponent;
  let fixture: ComponentFixture<AntedecentesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AntedecentesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AntedecentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
