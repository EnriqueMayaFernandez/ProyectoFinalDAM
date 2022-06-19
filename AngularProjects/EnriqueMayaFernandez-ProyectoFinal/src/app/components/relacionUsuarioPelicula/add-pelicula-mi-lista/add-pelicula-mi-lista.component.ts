import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelacionUsuarioPelicula } from 'src/app/modelos/peliculas/relacion-usuario-pelicula';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { PeliculaService } from 'src/app/services/pelicula.service';

@Component({
  selector: 'app-add-pelicula-mi-lista',
  templateUrl: './add-pelicula-mi-lista.component.html',
  styleUrls: ['./add-pelicula-mi-lista.component.css']
})
export class AddPeliculaMiListaComponent implements OnInit {

  item: RespuestaLogin = {};
  mensaje: string;
  public relacionUsuarioPelicula: RelacionUsuarioPelicula = {
    id: '',
    idPelicula:'',
    idUsuario:'',
    puntuacion:'',
    estado:'',
    nombrePelicula:'',
    notas:''
  };
  constructor(
    private router: Router,
    private service: PeliculaService
  ) {}

  ngOnInit(): void {
    $('#nombrePelicula').val(localStorage.getItem('nombrePelicula'));
    this.item = JSON.parse(localStorage.getItem('usuario'));
  }

  InsertarRelacionUsuarioPelicula() {
    this.relacionUsuarioPelicula.idPelicula = String(localStorage.getItem('idPelicula'));
    this.relacionUsuarioPelicula.idUsuario = String(this.item.id);
    this.relacionUsuarioPelicula.puntuacion = String($('input[name=radioPuntuacion]:checked', '#relacionForm').val());
    this.relacionUsuarioPelicula.estado = String($('#estado').val());
    this.relacionUsuarioPelicula.notas = String($('#notas').val());
    if (
      this.relacionUsuarioPelicula.puntuacion == '' ||
      this.relacionUsuarioPelicula.estado == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.insertarRelacion(this.relacionUsuarioPelicula).subscribe(
        (data) => {
          alert(data.mensaje);
          console.log(data);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
      this.router.navigate(['peliculas']);
    }
  }

  Volver() {
    this.router.navigate(['peliculas']);
  }

}
