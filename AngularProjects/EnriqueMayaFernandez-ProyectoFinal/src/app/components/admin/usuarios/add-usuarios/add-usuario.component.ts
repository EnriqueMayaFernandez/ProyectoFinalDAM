import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rol } from 'src/app/modelos/usuarios/rol';
import { Usuario } from 'src/app/modelos/usuarios/Usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-add-usuario',
  templateUrl: './add-usuario.component.html',
  styleUrls: ['./add-usuario.component.css']
})
export class AddUsuarioComponent implements OnInit {

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

  InsertarUsuario() {
    if ($('#clave').val() != $('#repiteClave').val()) {
      alert("Por favor las dos contraseñas deben ser igual");
      $('#clave').addClass("bg-danger");
      $('#repiteClave').addClass("bg-danger");
    } else if($('#nombreUsuario').val()=="" || $('#clave').val()=="" || $('#repiteClave').val()==""){
      alert("Complete los datos que se requieren");
    }
    else{
      this.usuario.nombreUsuario=String($('#nombreUsuario').val());
      this.usuario.clave=String($('#clave').val());
      this.rol.id = String($('#rol').val());
      this.usuario.rol = this.rol;
      this.service.insertar(this.usuario).subscribe((data) => {
        alert(data.mensaje);
        this.router.navigate(['usuarios']);
      },
      (err) => {
        alert("Lo siento el usuario ya existe en la base de datos");
      });
    }
  }

  Volver() {
    this.router.navigate(['usuarios']);
  }

}
