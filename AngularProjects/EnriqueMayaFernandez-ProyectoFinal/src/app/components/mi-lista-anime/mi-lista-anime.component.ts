import { Component, OnInit , Inject } from '@angular/core';
import { DOCUMENT } from '@angular/common';
import { Router } from '@angular/router';
import { ListadoRelacionUsuarioAnime } from 'src/app/modelos/animes/listado-relacion-usuario-anime';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { AnimeService } from 'src/app/services/anime.service';

@Component({
  selector: 'app-mi-lista-anime',
  templateUrl: './mi-lista-anime.component.html',
  styleUrls: ['./mi-lista-anime.component.css']
})
export class MiListaAnimeComponent implements OnInit {

  item: RespuestaLogin = {};
  public relacionesUsuarioAnime: ListadoRelacionUsuarioAnime;
  estaVacio: boolean;
  mensaje: string;
  constructor(
    private service: AnimeService,
    private router: Router,
    @Inject(DOCUMENT) private document: Document
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('idAnime');
    localStorage.removeItem('idRelacionUsuarioAnime');
    this.service.getRelacionesUsuarioAnime().subscribe((data) => {
      this.relacionesUsuarioAnime = data;
      console.log(data);
      console.log(this.relacionesUsuarioAnime.mensaje);
    });
  }

  VerInformacion(id:string) {
    localStorage.setItem('idAnime', id);
    this.router.navigate(['verInformacionAnime']);
  }

  ModificarRelacion(id:string){
    localStorage.setItem('idRelacionUsuarioAnime', id);
    this.router.navigate(['modRelacionUsuarioAnime']);
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
    if ((this.relacionesUsuarioAnime.listadoRelacionUsuarioAnime.length == 0)) {
      this.estaVacio = true;
    }
    return this.estaVacio;
  }

  alerta() {
    var opcion = confirm('Esta seguro de borrar el anime de su lista');
    return opcion;
  }

  VolverAlMenu(){
    this.router.navigate(['animes']);
  }

}
