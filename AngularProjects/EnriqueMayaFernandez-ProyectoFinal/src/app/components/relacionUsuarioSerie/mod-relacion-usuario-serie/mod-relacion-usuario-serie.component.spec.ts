import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModRelacionUsuarioSerieComponent } from './mod-relacion-usuario-serie.component';

describe('ModRelacionUsuarioSerieComponent', () => {
  let component: ModRelacionUsuarioSerieComponent;
  let fixture: ComponentFixture<ModRelacionUsuarioSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModRelacionUsuarioSerieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModRelacionUsuarioSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
