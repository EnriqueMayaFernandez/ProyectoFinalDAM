import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddSerieMiListaComponent } from './add-serie-mi-lista.component';

describe('AddSerieMiListaComponent', () => {
  let component: AddSerieMiListaComponent;
  let fixture: ComponentFixture<AddSerieMiListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddSerieMiListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSerieMiListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
