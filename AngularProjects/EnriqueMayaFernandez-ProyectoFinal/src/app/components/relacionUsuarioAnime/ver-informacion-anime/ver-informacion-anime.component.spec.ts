import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerInformacionAnimeComponent } from './ver-informacion-anime.component';

describe('VerInformacionAnimeComponent', () => {
  let component: VerInformacionAnimeComponent;
  let fixture: ComponentFixture<VerInformacionAnimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VerInformacionAnimeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VerInformacionAnimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
