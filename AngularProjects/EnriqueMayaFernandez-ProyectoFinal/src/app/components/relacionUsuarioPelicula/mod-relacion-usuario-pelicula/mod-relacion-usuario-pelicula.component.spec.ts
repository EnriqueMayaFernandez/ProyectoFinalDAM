import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModRelacionUsuarioPeliculaComponent } from './mod-relacion-usuario-pelicula.component';

describe('ModRelacionUsuarioPeliculaComponent', () => {
  let component: ModRelacionUsuarioPeliculaComponent;
  let fixture: ComponentFixture<ModRelacionUsuarioPeliculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModRelacionUsuarioPeliculaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModRelacionUsuarioPeliculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
