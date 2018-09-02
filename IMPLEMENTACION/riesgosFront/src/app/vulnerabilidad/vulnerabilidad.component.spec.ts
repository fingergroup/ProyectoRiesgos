import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VulnerabilidadComponent } from './vulnerabilidad.component';

describe('VulnerabilidadComponent', () => {
  let component: VulnerabilidadComponent;
  let fixture: ComponentFixture<VulnerabilidadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VulnerabilidadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VulnerabilidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
