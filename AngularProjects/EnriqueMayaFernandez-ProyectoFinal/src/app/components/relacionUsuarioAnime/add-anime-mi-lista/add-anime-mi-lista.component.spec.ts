import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAnimeMiListaComponent } from './add-anime-mi-lista.component';

describe('AddAnimeMiListaComponent', () => {
  let component: AddAnimeMiListaComponent;
  let fixture: ComponentFixture<AddAnimeMiListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddAnimeMiListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddAnimeMiListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
