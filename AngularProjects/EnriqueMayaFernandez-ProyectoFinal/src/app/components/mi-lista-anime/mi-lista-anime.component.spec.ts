import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiListaAnimeComponent } from './mi-lista-anime.component';

describe('MiListaAnimeComponent', () => {
  let component: MiListaAnimeComponent;
  let fixture: ComponentFixture<MiListaAnimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiListaAnimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiListaAnimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
