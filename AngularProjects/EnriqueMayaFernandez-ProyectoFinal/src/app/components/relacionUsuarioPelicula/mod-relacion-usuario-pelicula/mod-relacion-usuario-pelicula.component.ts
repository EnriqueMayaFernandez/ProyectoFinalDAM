import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelacionUsuarioPelicula } from 'src/app/modelos/peliculas/relacion-usuario-pelicula';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { PeliculaService } from 'src/app/services/pelicula.service';

@Component({
  selector: 'app-mod-relacion-usuario-pelicula',
  templateUrl: './mod-relacion-usuario-pelicula.component.html',
  styleUrls: ['./mod-relacion-usuario-pelicula.component.css']
})
export class ModRelacionUsuarioPeliculaComponent implements OnInit {

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
    this.item = JSON.parse(localStorage.getItem('usuario'));
    this.service.getRelacionUsuarioPelicula(localStorage.getItem('idRelacionUsuarioPelicula')).subscribe((data) =>{
      this.relacionUsuarioPelicula=data;
      $('#nombrePelicula').val(this.relacionUsuarioPelicula.nombrePelicula);
      $('#puntuacion'+this.relacionUsuarioPelicula.puntuacion).prop("checked", true);
      $('#estado').val(this.relacionUsuarioPelicula.estado);
      $('#notas').val(this.relacionUsuarioPelicula.notas);
    });
  }

  ModificarRelacionUsuarioPelicula() {
    this.relacionUsuarioPelicula.id=String(localStorage.getItem('idRelacionUsuarioPelicula'));
    this.relacionUsuarioPelicula.idPelicula = String(this.relacionUsuarioPelicula.idPelicula);
    this.relacionUsuarioPelicula.idUsuario = String(this.relacionUsuarioPelicula.idUsuario);
    this.relacionUsuarioPelicula.puntuacion = String($('input[name=radioPuntuacion]:checked', '#relacionForm').val());
    this.relacionUsuarioPelicula.estado = String($('#estado').val());
    this.relacionUsuarioPelicula.notas = String($('#notas').val());
    if (
      this.relacionUsuarioPelicula.puntuacion == '' ||
      this.relacionUsuarioPelicula.estado == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.modificarRelacion(this.relacionUsuarioPelicula).subscribe(
        (data) => {
          alert(data.mensaje);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
    }
    this.router.navigate(['miListaPelicula']);
  }

  Volver() {
    this.router.navigate(['miListaPelicula']);
  }

}
