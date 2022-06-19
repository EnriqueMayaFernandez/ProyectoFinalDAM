import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './components/main/app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import {PeliculaService} from './services/pelicula.service';
import { RouterModule } from '@angular/router';
import { LoginModule } from './components/user/login/login.module';
import { HomeModule } from './components/home/home.module';
import { RegistroModule } from './components/user/registro/registro.module';
import * as $ from 'jquery';
import { UsuarioService } from './services/usuario.service';
import { AnimeService } from './services/anime.service';
import { SerieService } from './services/serie.service';



@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    RouterModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    FormsModule,
    LoginModule,
    HomeModule,
    RegistroModule,
  ],
  providers: [PeliculaService,UsuarioService,AnimeService,SerieService],
  bootstrap: [AppComponent]
})
export class AppModule { }
