import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Anime } from 'src/app/modelos/animes/anime';
import { AnimeService } from 'src/app/services/anime.service';

@Component({
  selector: 'app-ver-informacion-anime',
  templateUrl: './ver-informacion-anime.component.html',
  styleUrls: ['./ver-informacion-anime.component.css']
})
export class VerInformacionAnimeComponent implements OnInit {

  mensaje: string;
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
    private service: AnimeService) { }

  ngOnInit(): void {
    this.service.getAnime(localStorage.getItem('idAnime')).subscribe((data) =>{
      this.anime=data;
      $('#nombreAnime').val(this.anime.nombreAnime);
      $('#estudioAnimacion').val(this.anime.estudioAnimacion);
      $('#fechaEmision').val(this.anime.fechaEmision);
      $('#fechaFinalizacion').val(this.anime.fechaFinalizacion);
      $('#numeroCapitulos').val(this.anime.numeroCapitulos);
      $('#genero').val(this.anime.genero.nombreGenero);
    });
  }

  Volver(){
    this.router.navigate(['miListaAnime']);
  }

}
