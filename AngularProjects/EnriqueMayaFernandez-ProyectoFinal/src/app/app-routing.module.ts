import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { PeliculasComponent } from './components/peliculas/peliculas.component';
import { SeriesComponent } from './components/series/series.component';
import { AnimesComponent } from './components/animes/animes.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/user/login/login.component';
import { RegistroComponent } from './components/user/registro/registro.component';
import { AppComponent } from './components/main/app.component';
import { AddPeliculaComponent } from './components/admin/peliculas/add-pelicula/add-pelicula.component';
import { AddAnimeComponent } from './components/admin/animes/add-anime/add-anime.component';
import { AddSerieComponent } from './components/admin/series/add-serie/add-serie.component';
import { ModSerieComponent } from './components/admin/series/mod-serie/mod-serie.component';
import { ModAnimeComponent } from './components/admin/animes/mod-anime/mod-anime.component';
import { ModPeliculaComponent } from './components/admin/peliculas/mod-pelicula/mod-pelicula.component';
import { AddAnimeMiListaComponent } from './components/relacionUsuarioAnime/add-anime-mi-lista/add-anime-mi-lista.component';
import { MiListaAnimeComponent } from './components/mi-lista-anime/mi-lista-anime.component';
import { VerInformacionAnimeComponent } from './components/relacionUsuarioAnime/ver-informacion-anime/ver-informacion-anime.component';
import { ModRelacionUsuarioAnimeComponent } from './components/relacionUsuarioAnime/mod-relacion-usuario-anime/mod-relacion-usuario-anime.component';
import { MiListaSerieComponent } from './components/mi-lista-serie/mi-lista-serie.component';
import { AddSerieMiListaComponent } from './components/relacionUsuarioSerie/add-serie-mi-lista/add-serie-mi-lista.component';
import { VerInformacionSerieComponent } from './components/relacionUsuarioSerie/ver-informacion-serie/ver-informacion-serie.component';
import { ModRelacionUsuarioSerieComponent } from './components/relacionUsuarioSerie/mod-relacion-usuario-serie/mod-relacion-usuario-serie.component';
import { VerInformacionPeliculaComponent } from './components/relacionUsuarioPelicula/ver-informacion-pelicula/ver-informacion-pelicula.component';
import { MiListaPeliculaComponent } from './components/mi-lista-pelicula/mi-lista-pelicula.component';
import { ModRelacionUsuarioPeliculaComponent } from './components/relacionUsuarioPelicula/mod-relacion-usuario-pelicula/mod-relacion-usuario-pelicula.component';
import { AddPeliculaMiListaComponent } from './components/relacionUsuarioPelicula/add-pelicula-mi-lista/add-pelicula-mi-lista.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { AddUsuarioComponent } from './components/admin/usuarios/add-usuarios/add-usuario.component';
import { ModUsuarioComponent } from './components/admin/usuarios/mod-usuario/mod-usuario.component';


const routes: Routes = [
  {path:'peliculas',component:PeliculasComponent},
  {path:'series',component:SeriesComponent},
  {path:'animes',component:AnimesComponent},
  {path:'usuarios',component:UsuariosComponent},
  {path:'home',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'registro',component:RegistroComponent},
  {path:'insertarPelicula',component:AddPeliculaComponent},
  {path:'insertarAnime',component:AddAnimeComponent},
  {path:'insertarSerie',component:AddSerieComponent},
  {path:'insertarUsuario',component:AddUsuarioComponent},
  {path:'modificarSerie',component:ModSerieComponent},
  {path:'modificarAnime',component:ModAnimeComponent},
  {path:'modificarPelicula',component:ModPeliculaComponent},
  {path:'modificarUsuario',component:ModUsuarioComponent},
  {path:'insertarRelacionUsuarioAnime',component:AddAnimeMiListaComponent},
  {path:'miListaAnime',component:MiListaAnimeComponent},
  {path:'verInformacionAnime',component:VerInformacionAnimeComponent},
  {path:'modRelacionUsuarioAnime',component:ModRelacionUsuarioAnimeComponent},
  {path:'insertarRelacionUsuarioSerie',component:AddSerieMiListaComponent},
  {path:'miListaSerie',component:MiListaSerieComponent},
  {path:'verInformacionUsuarioSerie',component:VerInformacionSerieComponent},
  {path:'modRelacionUsuarioSerie',component:ModRelacionUsuarioSerieComponent},
  {path:'insertarRelacionUsuarioPelicula',component:AddPeliculaMiListaComponent},
  {path:'miListaPelicula',component:MiListaPeliculaComponent},
  {path:'verInformacionPelicula',component:VerInformacionPeliculaComponent},
  {path:'modRelacionUsuarioPelicula',component:ModRelacionUsuarioPeliculaComponent},


  {path:'',redirectTo:'login',pathMatch:'full'},
]

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
