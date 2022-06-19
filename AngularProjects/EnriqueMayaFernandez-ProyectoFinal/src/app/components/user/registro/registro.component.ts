import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';
import { Rol } from 'src/app/modelos/usuarios/rol';
import { Usuario } from 'src/app/modelos/usuarios/Usuario';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.css'],
})
export class RegistroComponent implements OnInit {
  usuario: Usuario ={
    id:"",
    nombreUsuario:"",
    clave:"",
    rol:{
      id:""
    }
  };
  rol: Rol={id:""};
  constructor(private router: Router, private service: UsuarioService) {}

  ngOnInit() {}

  InsertarUsuario(usuario: Usuario) {
    if ($('#clave').val() != $('#repiteClave').val()) {
      alert("Por favor las dos contraseñas deben ser igual");
      $('#clave').addClass("bg-danger");
      $('#repiteClave').addClass("bg-danger");
    } else if($('#nombreUsuario').val()=="" || $('#clave').val()=="" || $('#repiteClave').val()==""){
      alert("Complete los datos que se requieren");
    }else{
      this.usuario.nombreUsuario=String($('#nombreUsuario').val());
      this.usuario.clave=String($('#clave').val());
      this.rol.id = "1";
      this.usuario.rol = this.rol;
      this.service.insertar(this.usuario).subscribe((data) => {
        alert(data.mensaje);
        this.router.navigate(['login']);
      },
      (err) => {
        alert("Lo siento el nombre del usuario ya esta registrado");
      });
    }
  }

  VolverLogin() {
    this.router.navigate(['login']);
  }
}
