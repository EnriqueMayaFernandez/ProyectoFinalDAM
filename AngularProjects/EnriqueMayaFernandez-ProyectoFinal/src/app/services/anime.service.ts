import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Anime } from '../modelos/animes/anime';
import { ListaAnimes } from '../modelos/animes/lista-animes';
import { ListadoRelacionUsuarioAnime } from '../modelos/animes/listado-relacion-usuario-anime';
import { RelacionUsuarioAnime } from '../modelos/animes/relacion-usuario-anime';
import { Mensaje } from '../modelos/mensaje';

@Injectable({
  providedIn: 'root'
})
export class AnimeService {

  animes:Anime[];
  animeNuevo:Anime;


    constructor(private http:HttpClient) { }

    //animes
    getAnimes(){
      const url='http://localhost:8080/anime/get-animes';
      return this.http.get<ListaAnimes>(url);
    }

    insertar(animeNuevo:Anime) {
      const url='http://localhost:8080/anime/insertar';
      return this.http.post<Mensaje>(url, animeNuevo);
    }

    modificar(animeModificado:Anime){
      const url='http://localhost:8080/anime/modificar';
      return this.http.put<Mensaje>(url, animeModificado);
    }

    borrar(id:string){
      const url='http://localhost:8080/anime/borrar/'+id;
      return this.http.delete<Mensaje>(url);
    }

    getAnime(id:string){
      const url='http://localhost:8080/anime/get-anime/'+id;
      return this.http.get<Anime>(url);
    }

    //relacionUsuarioAnime
    getRelacionesUsuarioAnime(){
      const url='http://localhost:8080/relacion-usuario-anime/get-relaciones-usuario-anime';
      return this.http.get<ListadoRelacionUsuarioAnime>(url);
    }

    insertarRelacion(animeNuevo:Anime) {
      const url='http://localhost:8080/relacion-usuario-anime/insertar';
      return this.http.post<Mensaje>(url, animeNuevo);
    }

    modificarRelacion(relacionUsuarioAnime:RelacionUsuarioAnime){
      const url='http://localhost:8080/relacion-usuario-anime/modificar';
      return this.http.put<Mensaje>(url, relacionUsuarioAnime);
    }

    borrarRelacion(id:string){
      const url='http://localhost:8080/relacion-usuario-anime/borrar/'+id;
      return this.http.delete<Mensaje>(url);
    }

    getRelacionUsuarioAnime(id:string){
      const url='http://localhost:8080/relacion-usuario-anime/get-relacion-usuario-anime/'+id;
      return this.http.get<RelacionUsuarioAnime>(url);
    }


}
