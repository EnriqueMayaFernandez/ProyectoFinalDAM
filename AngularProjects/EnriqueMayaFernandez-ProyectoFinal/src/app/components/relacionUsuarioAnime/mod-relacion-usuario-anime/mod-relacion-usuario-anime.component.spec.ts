import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModRelacionUsuarioAnimeComponent } from './mod-relacion-usuario-anime.component';

describe('ModRelacionUsuarioAnimeComponent', () => {
  let component: ModRelacionUsuarioAnimeComponent;
  let fixture: ComponentFixture<ModRelacionUsuarioAnimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModRelacionUsuarioAnimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModRelacionUsuarioAnimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
