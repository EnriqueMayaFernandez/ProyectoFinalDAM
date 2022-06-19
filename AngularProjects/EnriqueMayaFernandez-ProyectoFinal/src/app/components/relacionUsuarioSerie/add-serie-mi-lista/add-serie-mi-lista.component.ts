import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelacionUsuarioSerie } from 'src/app/modelos/series/relacion-usuario-serie';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { SerieService } from 'src/app/services/serie.service';

@Component({
  selector: 'app-add-serie-mi-lista',
  templateUrl: './add-serie-mi-lista.component.html',
  styleUrls: ['./add-serie-mi-lista.component.css']
})
export class AddSerieMiListaComponent implements OnInit {

  item: RespuestaLogin = {};
  mensaje: string;
  public relacionUsuarioSerie: RelacionUsuarioSerie = {
    id:'',
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
    $('#nombreSerie').val(localStorage.getItem('nombreSerie'));
    this.item = JSON.parse(localStorage.getItem('usuario'));
  }

  InsertarRelacionUsuarioSerie() {
    this.relacionUsuarioSerie.idSerie = String(localStorage.getItem('idSerie'));
    this.relacionUsuarioSerie.idUsuario = String(this.item.id);
    this.relacionUsuarioSerie.puntuacion = String($('input[name=radioPuntuacion]:checked', '#relacionForm').val());
    this.relacionUsuarioSerie.estado = String($('#estado').val());
    this.relacionUsuarioSerie.notas = String($('#notas').val());
    if (
      this.relacionUsuarioSerie.puntuacion == '' ||
      this.relacionUsuarioSerie.estado == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.insertarRelacion(this.relacionUsuarioSerie).subscribe(
        (data) => {
          alert(data.mensaje);
          this.router.navigate(['series']);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
    }
  }

  Volver() {
    this.router.navigate(['series']);
  }

}
