import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModPeliculaComponent } from './mod-pelicula.component';

describe('ModPeliculaComponent', () => {
  let component: ModPeliculaComponent;
  let fixture: ComponentFixture<ModPeliculaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModPeliculaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModPeliculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
