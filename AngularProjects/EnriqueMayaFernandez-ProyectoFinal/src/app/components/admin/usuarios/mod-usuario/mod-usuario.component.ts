import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rol } from 'src/app/modelos/usuarios/rol';
import { Usuario } from 'src/app/modelos/usuarios/Usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-mod-usuario',
  templateUrl: './mod-usuario.component.html',
  styleUrls: ['./mod-usuario.component.css'],
})
export class ModUsuarioComponent implements OnInit {
  mensaje: string;
  usuario: Usuario = {
    id: '',
    nombreUsuario: '',
    clave: '',
    rol: { id: '' },
  };
  rol: Rol={id:''};
  constructor(private router: Router, private service: UsuarioService) {}

  ngOnInit(): void {
    this.service
      .getUsuario(localStorage.getItem('idUsuario'))
      .subscribe((data) => {
        this.usuario = data;
        $('#nombreUsuario').val(this.usuario.nombreUsuario);
        $('#clave').val(this.usuario.clave);
        $('#repiteClave').val(this.usuario.clave);
        $('#rol').val(this.usuario.rol.id);
      });
  }

  ModificarUsuario() {
    this.usuario.id=String(localStorage.getItem('idUsuario'));
    this.usuario.nombreUsuario = String($('#nombreUsuario').val());
    this.usuario.clave = String($('#clave').val());
    this.usuario.rol.id = String($('#rol').val());
    if (
      this.usuario.nombreUsuario == '' ||
      this.usuario.clave == '' ||
      this.usuario.rol == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    } else if ($('#clave').val() != $('#repiteClave').val()) {
      alert('Por favor las dos contraseñas deben ser igual');
      $('#clave').addClass('bg-danger');
      $('#repiteClave').addClass('bg-danger');
    } else {
      this.service.modificar(this.usuario).subscribe(
        (data) => {
          alert(data.mensaje);
          this.router.navigate(['usuarios']);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
    }
  }

  Volver() {
    this.router.navigate(['usuarios']);
  }
}
