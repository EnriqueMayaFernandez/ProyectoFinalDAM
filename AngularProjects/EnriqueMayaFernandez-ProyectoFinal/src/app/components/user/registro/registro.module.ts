import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistroComponent } from './registro.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [RegistroComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule
  ],
  exports:[RegistroComponent],
})
export class RegistroModule { }
