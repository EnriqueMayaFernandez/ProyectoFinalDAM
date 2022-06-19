import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerInformacionSerieComponent } from './ver-informacion-serie.component';

describe('VerInformacionSerieComponent', () => {
  let component: VerInformacionSerieComponent;
  let fixture: ComponentFixture<VerInformacionSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerInformacionSerieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerInformacionSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
