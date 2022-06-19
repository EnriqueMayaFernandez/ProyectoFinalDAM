import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { ListadoRelacionUsuarioPelicula } from 'src/app/modelos/peliculas/listado-relacion-usuario-pelicula';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { PeliculaService } from 'src/app/services/pelicula.service';

@Component({
  selector: 'app-mi-lista-pelicula',
  templateUrl: './mi-lista-pelicula.component.html',
  styleUrls: ['./mi-lista-pelicula.component.css']
})
export class MiListaPeliculaComponent implements OnInit {

  item: RespuestaLogin = {};
  public relacionesUsuarioPelicula: ListadoRelacionUsuarioPelicula;
  estaVacio: boolean;
  mensaje: string;
  constructor(
    private service: PeliculaService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idPelicula');
    localStorage.removeItem('idRelacionUsuarioPelicula');
    this.service.getRelacionesUsuarioPelicula().subscribe((data) => {
      this.relacionesUsuarioPelicula = data;
      console.log(data);
      console.log(this.relacionesUsuarioPelicula.mensaje);
    });
  }

  VerInformacion(id:string) {
    localStorage.setItem('idPelicula', id);
    this.router.navigate(['verInformacionPelicula']);
  }

  ModificarRelacion(id:string){
    localStorage.setItem('idRelacionUsuarioPelicula', id);
    this.router.navigate(['modRelacionUsuarioPelicula']);
  }

  BorrarRelacion(id: string) {
    var opcion;
    opcion = this.alerta();
    if (opcion) {
      this.service.borrarRelacion(id).subscribe(
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

  ComprobarListadoVacio() {
    this.estaVacio = false;
    if ((this.relacionesUsuarioPelicula.listadoRelacionUsuarioPelicula.length == 0)) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar la pelicula de su lista');
    return opcion;
  }

  VolverAlMenu(){
    this.router.navigate(['peliculas']);
  }

}
