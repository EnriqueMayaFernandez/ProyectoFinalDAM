import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { ListaSeries } from 'src/app/modelos/series/lista-series';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.css'],
})
export class SeriesComponent implements OnInit {
  item: RespuestaLogin = {};
  public series: ListaSeries;
  esAdmin: boolean;
  estaVacio: boolean;
  mensaje: string;
  constructor(
    private service: SerieService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idSerie');
    localStorage.removeItem('nombreSerie');
    this.service.getSeries().subscribe((data) => {
      this.series = data;
      console.log(this.series.mensaje);
    });
  }

  InsertarSerie() {
    this.router.navigate(['insertarSerie']);
  }

  InsertarRelacionUsuarioAnime(id:string,nombreSerie:string){
    localStorage.setItem('idSerie', id);
    localStorage.setItem('nombreSerie',nombreSerie);
    this.router.navigate(['insertarRelacionUsuarioSerie']);
  }

  ModificarSerie(id: string) {
    localStorage.setItem('idSerie', id);
    this.router.navigate(['modificarSerie']);
  }

  BorrarSerie(id: string) {
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
    if (this.series.listaSeries.length == 0) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar la serie');
    return opcion;
  }
}
