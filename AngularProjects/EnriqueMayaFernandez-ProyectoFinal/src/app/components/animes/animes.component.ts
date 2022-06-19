import { Component, OnInit, Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { ListaAnimes } from 'src/app/modelos/animes/lista-animes';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { AnimeService } from 'src/app/services/anime.service';

@Component({
  selector: 'app-animes',
  templateUrl: './animes.component.html',
  styleUrls: ['./animes.component.css'],
})
export class AnimesComponent implements OnInit {
  item: RespuestaLogin = {};
  public animes: ListaAnimes;
  esAdmin: boolean;
  estaVacio: boolean;
  mensaje: string;
  constructor(
    private service: AnimeService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idAnime');
    localStorage.removeItem('nombreAnime');
    this.service.getAnimes().subscribe((data) => {
      this.animes = data;
      console.log(data);
      console.log(this.animes.mensaje);
    });
  }

  InsertarAnime() {
    this.router.navigate(['insertarAnime']);
  }

  InsertarRelacionUsuarioAnime(id:string,nombreAnime:string){
    localStorage.setItem('idAnime', id);
    localStorage.setItem('nombreAnime',nombreAnime);
    this.router.navigate(['insertarRelacionUsuarioAnime']);
  }

  ModificarAnime(id: string) {
    localStorage.setItem('idAnime', id);
    this.router.navigate(['modificarAnime']);
  }

  BorrarAnime(id: string) {
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
    if ((this.animes.listaAnimes.length == 0)) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar el anime');
    return opcion;
  }
}
