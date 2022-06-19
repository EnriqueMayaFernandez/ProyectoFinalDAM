import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mensaje } from '../modelos/mensaje';
import { ListaPeliculas } from '../modelos/peliculas/lista-peliculas';
import { ListadoRelacionUsuarioPelicula } from '../modelos/peliculas/listado-relacion-usuario-pelicula';
import { Pelicula } from '../modelos/peliculas/pelicula';
import { RelacionUsuarioPelicula } from '../modelos/peliculas/relacion-usuario-pelicula';

@Injectable({
  providedIn: 'root'
})
export class PeliculaService {

  constructor(private http:HttpClient) { }

  getPeliculas(){
    const url='http://localhost:8080/pelicula/get-peliculas';
    return this.http.get<ListaPeliculas>(url);
  }

  insertar(peliculaNueva:Pelicula) {
    const url='http://localhost:8080/pelicula/insertar';
    return this.http.post<Mensaje>(url, peliculaNueva);
  }

  borrar(id:string){
    const url='http://localhost:8080/pelicula/borrar/'+id;
    return this.http.delete<Mensaje>(url);
  }

  modificar(pelicula:Pelicula){
    const url='http://localhost:8080/pelicula/modificar';
    return this.http.put<Mensaje>(url,pelicula);
  }

  getPelicula(id:string){
    const url='http://localhost:8080/pelicula/get-pelicula/'+id;
    return this.http.get<Pelicula>(url);
  }

  //relacionUsuarioPelicula
  getRelacionesUsuarioPelicula(){
    const url='http://localhost:8080/relacion-usuario-pelicula/get-relaciones-usuario-pelicula';
    return this.http.get<ListadoRelacionUsuarioPelicula>(url);
  }

  insertarRelacion(peliculaNueva:Pelicula) {
    const url='http://localhost:8080/relacion-usuario-pelicula/insertar';
    return this.http.post<Mensaje>(url, peliculaNueva);
  }

  modificarRelacion(relacionUsuarioPelicula:RelacionUsuarioPelicula){
    const url='http://localhost:8080/relacion-usuario-pelicula/modificar';
    return this.http.put<Mensaje>(url, relacionUsuarioPelicula);
  }

  borrarRelacion(id:string){
    const url='http://localhost:8080/relacion-usuario-pelicula/borrar/'+id;
    return this.http.delete<Mensaje>(url);
  }

  getRelacionUsuarioPelicula(id:string){
    const url='http://localhost:8080/relacion-usuario-pelicula/get-relacion-usuario-pelicula/'+id;
    return this.http.get<RelacionUsuarioPelicula>(url);
  }
}
