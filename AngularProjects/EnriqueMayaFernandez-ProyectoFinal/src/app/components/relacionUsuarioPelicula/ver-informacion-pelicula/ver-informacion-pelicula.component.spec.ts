import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerInformacionPeliculaComponent } from './ver-informacion-pelicula.component';

describe('VerInformacionPeliculaComponent', () => {
  let component: VerInformacionPeliculaComponent;
  let fixture: ComponentFixture<VerInformacionPeliculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerInformacionPeliculaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerInformacionPeliculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
