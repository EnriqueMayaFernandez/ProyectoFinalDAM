import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModSerieComponent } from './mod-serie.component';

describe('ModSerieComponent', () => {
  let component: ModSerieComponent;
  let fixture: ComponentFixture<ModSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModSerieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
