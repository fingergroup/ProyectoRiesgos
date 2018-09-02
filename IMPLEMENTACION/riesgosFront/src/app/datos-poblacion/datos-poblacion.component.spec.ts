import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DatosPoblacionComponent } from './datos-poblacion.component';

describe('DatosPoblacionComponent', () => {
  let component: DatosPoblacionComponent;
  let fixture: ComponentFixture<DatosPoblacionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatosPoblacionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatosPoblacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
