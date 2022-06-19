import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Genero } from 'src/app/modelos/genero';
import { ListaGeneros } from 'src/app/modelos/lista-generos';
import { Serie } from 'src/app/modelos/series/serie';
import { GeneroService } from 'src/app/services/genero.service';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-add-serie',
  templateUrl: './add-serie.component.html',
  styleUrls: ['./add-serie.component.css'],
})
export class AddSerieComponent implements OnInit {
  mensaje: string;
  listaGeneros: ListaGeneros;
  generos: Genero[];
  public genero: Genero = { id: '', nombreGenero: '' };
  public serie: Serie = {
    id: '',
    nombreSerie: '',
    director: '',
    fechaEmision: '',
    fechaFinalizacion: '',
    numeroCapitulos: '',
    genero: { id: '' },
  };
  constructor(
    private router: Router,
    private service: SerieService,
    private serviceGenero: GeneroService
  ) {}

  ngOnInit(): void {
    this.serviceGenero.getGeneros().subscribe((data) => {
      this.listaGeneros = data;
      console.log(this.listaGeneros.mensaje);
    });
  }

  InsertarSerie() {
    this.serie.nombreSerie = String($('#nombreSerie').val());
    this.serie.director = String($('#director').val());
    this.serie.fechaEmision = String($('#fechaEmision').val());
    this.serie.fechaFinalizacion = String($('#fechaFinalizacion').val());
    this.serie.numeroCapitulos = String($('#numeroCapitulos').val());
    this.serie.genero.id = String($('#genero').val());
    if (
      this.serie.nombreSerie == '' ||
      this.serie.director == '' ||
      this.serie.fechaEmision == '' ||
      this.serie.fechaFinalizacion == '' ||
      this.serie.numeroCapitulos == '' ||
      this.serie.genero.id == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    } else {
      var fechauno = new Date(this.serie.fechaEmision);
      var fechados = new Date(this.serie.fechaFinalizacion);
      if (fechauno < fechados) {
        this.service.insertar(this.serie).subscribe(
          (data) => {
            alert(data.mensaje);
            this.router.navigate(['series']);
          },
          (err) => {
            alert("Lo siento la serie ya existe en la base de datos");
          }
        );
      } else {
        alert(
          'Por favor la fecha de emision debe ser antes que la de finalizacion'
        );
      }
    }
  }

  Volver() {
    this.router.navigate(['series']);
  }
}
