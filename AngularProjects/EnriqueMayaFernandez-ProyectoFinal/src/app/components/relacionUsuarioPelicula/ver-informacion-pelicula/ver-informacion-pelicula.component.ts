import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pelicula } from 'src/app/modelos/peliculas/pelicula';
import { PeliculaService } from 'src/app/services/pelicula.service';

@Component({
  selector: 'app-ver-informacion-pelicula',
  templateUrl: './ver-informacion-pelicula.component.html',
  styleUrls: ['./ver-informacion-pelicula.component.css']
})
export class VerInformacionPeliculaComponent implements OnInit {

  mensaje: string;
  public serie: Pelicula = {
    id: '',
    nombrePelicula: '',
    director: '',
    fechaEmision: '',
    duracion: '',
    genero: { id: '' },
  };
  constructor(private router: Router,
    private service: PeliculaService) { }

  ngOnInit(): void {
    this.service.getPelicula(localStorage.getItem('idPelicula')).subscribe((data) =>{
      this.serie=data;
      $('#nombrePelicula').val(this.serie.nombrePelicula);
      $('#director').val(this.serie.director);
      $('#fechaEmision').val(this.serie.fechaEmision);
      $('#duracion').val(this.serie.duracion+"h");
      $('#genero').val(this.serie.genero.nombreGenero);
    });
  }

  Volver(){
    this.router.navigate(['miListaPelicula']);
  }

}
