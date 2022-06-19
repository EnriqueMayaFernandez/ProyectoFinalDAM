import { Component, OnInit ,Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { Router } from '@angular/router';
import { ListadoRelacionUsuarioSerie } from 'src/app/modelos/series/listado-relacion-usuario-serie';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-mi-lista-serie',
  templateUrl: './mi-lista-serie.component.html',
  styleUrls: ['./mi-lista-serie.component.css']
})
export class MiListaSerieComponent implements OnInit {

  item: RespuestaLogin = {};
  public relacionesUsuarioSerie: ListadoRelacionUsuarioSerie;
  estaVacio: boolean;
  mensaje: string;
  constructor(
    private service: SerieService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idSerie');
    localStorage.removeItem('idRelacionUsuarioSerie');
    this.service.getRelacionesUsuarioSerie().subscribe((data) => {
      this.relacionesUsuarioSerie = data;
      console.log(data);
      console.log(this.relacionesUsuarioSerie.mensaje);
    });
  }

  VerInformacion(id:string) {
    localStorage.setItem('idSerie', id);
    this.router.navigate(['verInformacionUsuarioSerie']);
  }

  ModificarRelacion(id:string){
    localStorage.setItem('idRelacionUsuarioSerie', id);
    this.router.navigate(['modRelacionUsuarioSerie']);
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
    if ((this.relacionesUsuarioSerie.listadoRelacionUsuarioSerie.length == 0)) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar la serie de su lista');
    return opcion;
  }

  VolverAlMenu(){
    this.router.navigate(['series']);
  }

}
