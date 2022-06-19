import { OnInit } from '@angular/core';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { Usuario } from 'src/app/modelos/usuarios/Usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit{
  respuesta: RespuestaLogin={};

  constructor(private router: Router, private service: UsuarioService) {}
  ngOnInit(): void {
    localStorage.clear();
  }

  Logearse() {
    const usuario:Usuario = {id:"",nombreUsuario:String($("#nombreUsuario").val()),clave:String($("#clave").val())}
    this.service.logeo(usuario).subscribe((data) => {
      console.log(data)
      this.respuesta=data;
      alert(this.respuesta.mensaje);
      if(this.respuesta.codigoLogeo==1 || this.respuesta.codigoLogeo==2){
        localStorage.setItem('usuario', JSON.stringify(this.respuesta));
        this.router.navigate(['home']);
      }
    });
  }
}
