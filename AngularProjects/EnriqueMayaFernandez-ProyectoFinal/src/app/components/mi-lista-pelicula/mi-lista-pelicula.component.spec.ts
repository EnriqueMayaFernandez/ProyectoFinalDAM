import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiListaPeliculaComponent } from './mi-lista-pelicula.component';

describe('MiListaPeliculaComponent', () => {
  let component: MiListaPeliculaComponent;
  let fixture: ComponentFixture<MiListaPeliculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiListaPeliculaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiListaPeliculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
