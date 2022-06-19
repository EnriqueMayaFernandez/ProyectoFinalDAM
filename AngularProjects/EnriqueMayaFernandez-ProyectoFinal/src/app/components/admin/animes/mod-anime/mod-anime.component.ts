import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Anime } from 'src/app/modelos/animes/anime';
import { Genero } from 'src/app/modelos/genero';
import { ListaGeneros } from 'src/app/modelos/lista-generos';
import { AnimeService } from 'src/app/services/anime.service';
import { GeneroService } from 'src/app/services/genero.service';

@Component({
  selector: 'app-mod-anime',
  templateUrl: './mod-anime.component.html',
  styleUrls: ['./mod-anime.component.css']
})
export class ModAnimeComponent implements OnInit {
  mensaje: string;
  listaGeneros: ListaGeneros;
  generos: Genero[];
  public genero: Genero = { id: '', nombreGenero: '' };
  public anime: Anime = {
    id: '',
    nombreAnime: '',
    estudioAnimacion: '',
    fechaEmision: '',
    fechaFinalizacion: '',
    numeroCapitulos: '',
    genero: { id: '' },
  };
  constructor(private router: Router,
    private service: AnimeService,
    private serviceGenero: GeneroService) { }

  ngOnInit(): void {
    this.service.getAnime(localStorage.getItem('idAnime')).subscribe((data) =>{
      this.anime=data;
      $('#nombreAnime').val(this.anime.nombreAnime);
      $('#estudioAnimacion').val(this.anime.estudioAnimacion);
      $('#fechaEmision').val(this.anime.fechaEmision);
      $('#fechaFinalizacion').val(this.anime.fechaFinalizacion);
      $('#numeroCapitulos').val(this.anime.numeroCapitulos);
      $('#genero').val(this.anime.genero.id);
    });
    this.serviceGenero.getGeneros().subscribe((data) => {
      this.listaGeneros = data;
      console.log(this.listaGeneros.mensaje);
    });
  }

  ModificarAnime(){
    this.anime.nombreAnime = String($('#nombreAnime').val());
    this.anime.estudioAnimacion = String($('#estudioAnimacion').val());
    this.anime.fechaEmision = String($('#fechaEmision').val());
    this.anime.fechaFinalizacion = String($('#fechaFinalizacion').val());
    this.anime.numeroCapitulos = String($('#numeroCapitulos').val());
    this.anime.genero.id = String($('#genero').val());
    if (
      this.anime.nombreAnime == '' ||
      this.anime.estudioAnimacion == '' ||
      this.anime.fechaEmision == '' ||
      this.anime.fechaFinalizacion == '' ||
      this.anime.numeroCapitulos == '' ||
      this.anime.genero.id == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    } else {
      var fechauno = new Date(this.anime.fechaEmision);
      var fechados = new Date(this.anime.fechaFinalizacion);
      if (fechauno < fechados) {
        this.service.modificar(this.anime).subscribe(
          (data) => {
            alert(data.mensaje);
            this.router.navigate(['animes']);
          },
          (err) => {
            alert(err.mensaje);
          }
        );
      } else {
        alert(
          'Por favor la fecha de emision debe ser antes que la de finalizacion'
        );
      }
    }
  }

  Volver(){
    this.router.navigate(['animes']);
  }
}
