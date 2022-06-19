import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddPeliculaMiListaComponent } from './add-pelicula-mi-lista.component';

describe('AddPeliculaMiListaComponent', () => {
  let component: AddPeliculaMiListaComponent;
  let fixture: ComponentFixture<AddPeliculaMiListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddPeliculaMiListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddPeliculaMiListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
