import { Component, OnInit , Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { ListaPeliculas } from 'src/app/modelos/peliculas/lista-peliculas';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { PeliculaService } from '../../services/pelicula.service';
import { Pelicula } from 'src/app/modelos/peliculas/pelicula';

@Component({
  selector: 'app-peliculas',
  templateUrl: './peliculas.component.html',
  styleUrls: ['./peliculas.component.css'],
})
export class PeliculasComponent implements OnInit {
  item: RespuestaLogin = {};
  peliculas: ListaPeliculas;
  esAdmin: boolean;
  estaVacio: boolean;
  mensaje: string;
  constructor(
    private service: PeliculaService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idPelicula');
    localStorage.removeItem('nombrePelicula');
    this.service.getPeliculas().subscribe((data) => {
      this.peliculas = data;
      console.log(this.peliculas.mensaje);
    });
  }

  InsertarPelicula(){
    this.router.navigate(['insertarPelicula']);
  }

  InsertarRelacionUsuarioPelicula(id:string,nombrePelicula:string){
    localStorage.setItem('idPelicula', id);
    localStorage.setItem('nombrePelicula',nombrePelicula);
    this.router.navigate(['insertarRelacionUsuarioPelicula']);
  }

  ModificarPelicula(id: string) {
    localStorage.setItem('idPelicula', id);
    this.router.navigate(['modificarPelicula']);
  }

  BorrarPelicula(id: string) {
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
    if ((this.peliculas.listaPeliculas.length == 0)) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar la pelicula');
    return opcion;
  }

}
