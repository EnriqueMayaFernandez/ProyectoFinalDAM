import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Genero } from 'src/app/modelos/genero';
import { ListaGeneros } from 'src/app/modelos/lista-generos';
import { Pelicula } from 'src/app/modelos/peliculas/pelicula';
import { GeneroService } from 'src/app/services/genero.service';
import { PeliculaService } from 'src/app/services/pelicula.service';

@Component({
  selector: 'app-add-pelicula',
  templateUrl: './add-pelicula.component.html',
  styleUrls: ['./add-pelicula.component.css'],
})
export class AddPeliculaComponent implements OnInit {
  mensaje: string;
  listaGeneros: ListaGeneros;
  generos: Genero[];
  public genero: Genero = { id: '', nombreGenero: '' };
  public pelicula: Pelicula = {
    id: '',
    nombrePelicula: '',
    director: '',
    fechaEmision: '',
    duracion: '',
    genero: { id: '' },
  };
  constructor(
    private router: Router,
    private service: PeliculaService,
    private serviceGenero: GeneroService
  ) {}

  ngOnInit(): void {
    this.serviceGenero.getGeneros().subscribe((data) => {
      this.listaGeneros = data;
      console.log(this.listaGeneros.mensaje);
    });
  }

  InsertarPelicula() {
    this.pelicula.nombrePelicula = String($('#nombrePelicula').val());
    this.pelicula.director = String($('#director').val());
    this.pelicula.fechaEmision = String($('#fechaEmision').val());
    this.pelicula.duracion = String($('#duracion').val());
    this.pelicula.genero.id = String($('#genero').val());
    if (
      this.pelicula.nombrePelicula == '' ||
      this.pelicula.director == '' ||
      this.pelicula.fechaEmision == '' ||
      this.pelicula.duracion == '' ||
      this.pelicula.genero.id == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.insertar(this.pelicula).subscribe(
        (data) => {
          alert(data.mensaje);
          this.router.navigate(['peliculas']);
        },
        (err) => {
          alert("Lo siento la pelicula ya existe en la base de datos");
        }
      );
    }
  }

  Volver() {
    this.router.navigate(['peliculas']);
  }
}
