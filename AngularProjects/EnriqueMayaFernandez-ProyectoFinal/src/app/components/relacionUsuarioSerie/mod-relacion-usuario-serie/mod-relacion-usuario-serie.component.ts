import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelacionUsuarioSerie } from 'src/app/modelos/series/relacion-usuario-serie';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-mod-relacion-usuario-serie',
  templateUrl: './mod-relacion-usuario-serie.component.html',
  styleUrls: ['./mod-relacion-usuario-serie.component.css']
})
export class ModRelacionUsuarioSerieComponent implements OnInit {

  item: RespuestaLogin = {};
  mensaje: string;
  public relacionUsuarioSerie: RelacionUsuarioSerie = {
    id: '',
    idSerie:'',
    idUsuario:'',
    puntuacion:'',
    estado:'',
    nombreSerie:'',
    notas:''
  };
  constructor(
    private router: Router,
    private service: SerieService
  ) {}

  ngOnInit(): void {
    this.item = JSON.parse(localStorage.getItem('usuario'));
    this.service.getRelacionUsuarioSerie(localStorage.getItem('idRelacionUsuarioSerie')).subscribe((data) =>{
      this.relacionUsuarioSerie=data;
      $('#nombreSerie').val(this.relacionUsuarioSerie.nombreSerie);
      $('#puntuacion'+this.relacionUsuarioSerie.puntuacion).prop("checked", true);
      $('#estado').val(this.relacionUsuarioSerie.estado);
      $('#notas').val(this.relacionUsuarioSerie.notas);
    });
  }

  ModificarRelacionUsuarioSerie() {
    this.relacionUsuarioSerie.id=String(localStorage.getItem('idRelacionUsuarioPelicula'));
    this.relacionUsuarioSerie.idSerie = String(this.relacionUsuarioSerie.idSerie);
    this.relacionUsuarioSerie.idUsuario = String(this.relacionUsuarioSerie.idUsuario);
    this.relacionUsuarioSerie.puntuacion = String($('input[name=radioPuntuacion]:checked', '#relacionForm').val());
    this.relacionUsuarioSerie.estado = String($('#estado').val());
    this.relacionUsuarioSerie.notas = String($('#notas').val());
    if (
      this.relacionUsuarioSerie.puntuacion == '' ||
      this.relacionUsuarioSerie.estado == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.modificarRelacion(this.relacionUsuarioSerie).subscribe(
        (data) => {
          alert(data.mensaje);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
    }
    this.router.navigate(['miListaSerie']);
  }

  Volver() {
    this.router.navigate(['miListaSerie']);
  }

}
