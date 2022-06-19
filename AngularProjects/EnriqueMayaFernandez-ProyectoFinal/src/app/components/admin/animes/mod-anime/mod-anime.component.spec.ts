import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModAnimeComponent } from './mod-anime.component';

describe('ModAnimeComponent', () => {
  let component: ModAnimeComponent;
  let fixture: ComponentFixture<ModAnimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModAnimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModAnimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
