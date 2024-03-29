import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login.component';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { UsuarioService } from 'src/app/services/usuario.service';

@NgModule({
  declarations: [LoginComponent],
  imports: [CommonModule,
    RouterModule,
    FormsModule,
  ],
  exports: [LoginComponent],
  providers:[UsuarioService]
})
export class LoginModule {}
