import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home.component';
import { NavbarComponent } from '../navbar/navbar.component';
import { PeliculasComponent } from '../peliculas/peliculas.component';
import { SeriesComponent } from '../series/series.component';
import { AnimesComponent } from '../animes/animes.component';
import { AddSerieComponent } from '../admin/series/add-serie/add-serie.component';
import { AddPeliculaComponent } from '../admin/peliculas/add-pelicula/add-pelicula.component';
import { FormsModule } from '@angular/forms';
import { AddAnimeComponent } from '../admin/animes/add-anime/add-anime.component';
import { ModAnimeComponent } from '../admin/animes/mod-anime/mod-anime.component';
import { ModPeliculaComponent } from '../admin/peliculas/mod-pelicula/mod-pelicula.component';
import { ModSerieComponent } from '../admin/series/mod-serie/mod-serie.component';
import { AddAnimeMiListaComponent } from '../relacionUsuarioAnime/add-anime-mi-lista/add-anime-mi-lista.component';
import { MiListaAnimeComponent } from '../mi-lista-anime/mi-lista-anime.component';
import { VerInformacionAnimeComponent } from '../relacionUsuarioAnime/ver-informacion-anime/ver-informacion-anime.component';
import { AddSerieMiListaComponent } from '../relacionUsuarioSerie/add-serie-mi-lista/add-serie-mi-lista.component';
import { MiListaSerieComponent } from '../mi-lista-serie/mi-lista-serie.component';
import { VerInformacionSerieComponent } from '../relacionUsuarioSerie/ver-informacion-serie/ver-informacion-serie.component';
import { ModRelacionUsuarioAnimeComponent } from '../relacionUsuarioAnime/mod-relacion-usuario-anime/mod-relacion-usuario-anime.component';
import { ModRelacionUsuarioSerieComponent } from '../relacionUsuarioSerie/mod-relacion-usuario-serie/mod-relacion-usuario-serie.component';
import { AddPeliculaMiListaComponent } from '../relacionUsuarioPelicula/add-pelicula-mi-lista/add-pelicula-mi-lista.component';
import { ModRelacionUsuarioPeliculaComponent } from '../relacionUsuarioPelicula/mod-relacion-usuario-pelicula/mod-relacion-usuario-pelicula.component';
import { VerInformacionPeliculaComponent } from '../relacionUsuarioPelicula/ver-informacion-pelicula/ver-informacion-pelicula.component';
import { MiListaPeliculaComponent } from '../mi-lista-pelicula/mi-lista-pelicula.component';
import { UsuariosComponent } from '../usuarios/usuarios.component';
import { ModUsuarioComponent } from '../admin/usuarios/mod-usuario/mod-usuario.component';
import { AddUsuarioComponent } from '../admin/usuarios/add-usuarios/add-usuario.component';



@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    PeliculasComponent,
    SeriesComponent,
    AnimesComponent,
    UsuariosComponent,
    AddSerieComponent,
    AddPeliculaComponent,
    AddAnimeComponent,
    AddUsuarioComponent,
    ModAnimeComponent,
    ModPeliculaComponent,
    ModSerieComponent,
    ModUsuarioComponent,
    AddAnimeMiListaComponent,
    AddPeliculaMiListaComponent,
    AddSerieMiListaComponent,
    MiListaAnimeComponent,
    VerInformacionAnimeComponent,
    MiListaSerieComponent,
    MiListaPeliculaComponent,
    VerInformacionSerieComponent,
    ModRelacionUsuarioAnimeComponent,
    ModRelacionUsuarioSerieComponent,
    ModRelacionUsuarioPeliculaComponent,
    VerInformacionPeliculaComponent,
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
  ],
  exports:[
    HomeComponent,
    NavbarComponent,
    PeliculasComponent,
    SeriesComponent,
    AnimesComponent,
    UsuariosComponent,
    AddSerieComponent,
    AddPeliculaComponent,
    AddAnimeComponent,
    AddUsuarioComponent,
    ModAnimeComponent,
    ModPeliculaComponent,
    ModSerieComponent,
    ModUsuarioComponent,
    AddAnimeMiListaComponent,
    AddPeliculaMiListaComponent,
    AddSerieMiListaComponent,
    MiListaAnimeComponent,
    VerInformacionAnimeComponent,
    MiListaSerieComponent,
    MiListaPeliculaComponent,
    VerInformacionSerieComponent,
    ModRelacionUsuarioAnimeComponent,
    ModRelacionUsuarioSerieComponent,
  ]
})
export class HomeModule { }
