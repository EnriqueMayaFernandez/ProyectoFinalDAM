import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RelacionUsuarioAnime } from 'src/app/modelos/animes/relacion-usuario-anime';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { AnimeService } from 'src/app/services/anime.service';

@Component({
  selector: 'app-add-anime-mi-lista',
  templateUrl: './add-anime-mi-lista.component.html',
  styleUrls: ['./add-anime-mi-lista.component.css']
})
export class AddAnimeMiListaComponent implements OnInit {
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
    $('#nombreAnime').val(localStorage.getItem('nombreAnime'));
    this.item = JSON.parse(localStorage.getItem('usuario'));
  }

  InsertarRelacionUsuarioAnime() {
    this.relacionUsuarioAnime.idAnime = String(localStorage.getItem('idAnime'));
    this.relacionUsuarioAnime.idUsuario = String(this.item.id);
    this.relacionUsuarioAnime.puntuacion = String($('input[name=radioPuntuacion]:checked', '#relacionForm').val());
    this.relacionUsuarioAnime.estado = String($('#estado').val());
    this.relacionUsuarioAnime.notas = String($('#notas').val());
    if (
      this.relacionUsuarioAnime.puntuacion == '' ||
      this.relacionUsuarioAnime.estado == ''
    ) {
      alert('Por favor complete todos los campos que se requieren');
    }else{
      this.service.insertarRelacion(this.relacionUsuarioAnime).subscribe(
        (data) => {
          alert(data.mensaje);
          this.router.navigate(['animes']);
        },
        (err) => {
          alert(err.mensaje);
        }
      );
    }
  }

  Volver() {
    this.router.navigate(['animes']);
  }

}
