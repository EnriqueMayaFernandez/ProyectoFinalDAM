import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { ListaUsuarios } from 'src/app/modelos/usuarios/lista-usuarios';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  item: RespuestaLogin = {};
  public usuarios: ListaUsuarios;
  esAdmin: boolean;
  estaVacio: boolean;
  esEsencial:boolean;
  mensaje: string;
  constructor(
    private service: UsuarioService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idUsuario');
    localStorage.removeItem('nombreUsuario');
    this.service.getUsuarios().subscribe((data) => {
      this.usuarios = data;
      console.log(this.usuarios.mensaje);
    });

  }

  InsertarUsuario(){
    this.router.navigate(['insertarUsuario']);
  }

  ModificarUsuario(id: string) {
    localStorage.setItem('idUsuario', id);
    this.router.navigate(['modificarUsuario']);
  }

  BorrarUsuario(id: string) {
    var opcion;
    opcion = this.alerta();
    if (opcion) {
      this.service.borrar(id).subscribe(
        (data) => {
          alert(data.mensaje);
        },
        (error) => {
          this.mensaje = error.mensaje;
          alert(this.mensaje);
        }
      );
      this.document.location.reload();
    }
  }

  ComprobarUsuario() {
    this.item = JSON.parse(localStorage.getItem('usuario'));
    this.esAdmin = false;
    if (this.item.codigoLogeo == 2) {
      this.esAdmin = true;
    }
    return this.esAdmin;
  }

  ComprobarListadoVacio() {
    this.estaVacio = false;
    if ((this.usuarios.listaUsuarios.length == 0)) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar el usuario');
    return opcion;
  }

  VolverAlMenu(){
    this.router.navigate(['home']);
  }

  ComprobarUsuariosEsenciales(nombreUsuario:string){
    this.esEsencial=false;
    if(nombreUsuario=="Admin" || nombreUsuario=="Prueba"){
      this.esEsencial=true;
    }
    return this.esEsencial;
  }
}
