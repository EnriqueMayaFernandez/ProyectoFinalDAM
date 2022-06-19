import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MiListaSerieComponent } from './mi-lista-serie.component';

describe('MiListaSerieComponent', () => {
  let component: MiListaSerieComponent;
  let fixture: ComponentFixture<MiListaSerieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MiListaSerieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MiListaSerieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
