import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Serie } from 'src/app/modelos/series/serie';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-ver-informacion-serie',
  templateUrl: './ver-informacion-serie.component.html',
  styleUrls: ['./ver-informacion-serie.component.css']
})
export class VerInformacionSerieComponent implements OnInit {

  mensaje: string;
  public serie: Serie = {
    id: '',
    nombreSerie: '',
    director: '',
    fechaEmision: '',
    fechaFinalizacion: '',
    numeroCapitulos: '',
    genero: { id: '' },
  };
  constructor(private router: Router,
    private service: SerieService) { }

  ngOnInit(): void {
    this.service.getSerie(localStorage.getItem('idSerie')).subscribe((data) =>{
      this.serie=data;
      $('#nombreSerie').val(this.serie.nombreSerie);
      $('#estudioAnimacion').val(this.serie.director);
      $('#fechaEmision').val(this.serie.fechaEmision);
      $('#fechaFinalizacion').val(this.serie.fechaFinalizacion);
      $('#numeroCapitulos').val(this.serie.numeroCapitulos);
      $('#genero').val(this.serie.genero.nombreGenero);
    });
  }

  Volver(){
    this.router.navigate(['miListaSerie']);
  }

}
