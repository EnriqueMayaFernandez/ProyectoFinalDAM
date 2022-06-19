import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelacionUsuarioAnime } from 'src/app/modelos/animes/relacion-usuario-anime';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { AnimeService } from 'src/app/services/anime.service';

@Component({
  selector: 'app-mod-relacion-usuario-anime',
  templateUrl: './mod-relacion-usuario-anime.component.html',
  styleUrls: ['./mod-relacion-usuario-anime.component.css']
})
export class ModRelacionUsuarioAnimeComponent implements OnInit {

  item: RespuestaLogin = {};
  mensaje: string;
  public relacionUsuarioAnime: RelacionUsuarioAnime = {
    id: '',
    idAnime:'',
    idUsuario:'',
    puntuacion:'',
    estado:'',
    nombreAnime:'',
    notas:''
  };
  constructor(
    private router: Router,
    private service: AnimeService
  ) {}

  ngOnInit(): void {
    this.item = JSON.parse(localStorage.getItem('usuario'));
    this.service.getRelacionUsuarioAnime(localStorage.getItem('idRelacionUsuarioAnime')).subscribe((data) =>{
      this.relacionUsuarioAnime=data;
      $('#nombreAnime').val(this.relacionUsuarioAnime.nombreAnime);
      $('#puntuacion'+this.relacionUsuarioAnime.puntuacion).prop("checked", true);
      $('#estado').val(this.relacionUsuarioAnime.estado);
      $('#notas').val(this.relacionUsuarioAnime.notas);
    });
  }

  ModificarRelacionUsuarioAnime() {
    this.relacionUsuarioAnime.id=String(localStorage.getItem('idRelacionUsuarioAnime'));
    this.relacionUsuarioAnime.idAnime = String(this.relacionUsuarioAnime.idAnime);
    this.relacionUsuarioAnime.idUsuario = String(this.relacionUsuarioAnime.idUsuario);
    this.relacionUsuarioAnime.puntuacion = String($('input[name=radioPuntuacion]:checked', '#relacionForm').val());
    this.relacionUsuarioAnime.estado = String($('#estado').val());
    this.relacionUsuarioAnime.notas = String($('#notas').val());
    if (
      this.relacionUsuarioAnime.puntuacion == '' ||
      this.relacionUsuarioAnime.estado == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.modificarRelacion(this.relacionUsuarioAnime).subscribe(
        (data) => {
          alert(data.mensaje);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
    }
    this.router.navigate(['miListaAnime']);
  }

  Volver() {
    this.router.navigate(['miListaAnime']);
  }

}
