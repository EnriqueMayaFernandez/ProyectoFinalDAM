import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ListaSeries } from '../modelos/series/lista-series';
import { Mensaje } from '../modelos/mensaje';
import { Serie } from '../modelos/series/serie';
import { RelacionUsuarioSerie } from '../modelos/series/relacion-usuario-serie';
import { ListadoRelacionUsuarioSerie } from '../modelos/series/listado-relacion-usuario-serie';

@Injectable({
  providedIn: 'root'
})
export class SerieService {

series:Serie[];
serieNueva:Serie;


  constructor(private http:HttpClient) { }

  getSeries(){
    const url='http://localhost:8080/serie/get-series';
    return this.http.get<ListaSeries>(url);
  }

  insertar(serieNueva:Serie) {
    const url='http://localhost:8080/serie/insertar';
    return this.http.post<Mensaje>(url, serieNueva);
  }

  borrar(id:string){
    const url='http://localhost:8080/serie/borrar/'+id;
    return this.http.delete<Mensaje>(url);
  }

  modificar(animeModificado:Serie){
    const url='http://localhost:8080/serie/modificar';
    return this.http.put<Mensaje>(url, animeModificado);
  }

  getSerie(id:string){
    const url='http://localhost:8080/serie/get-serie/'+id;
    return this.http.get<Serie>(url);
  }

  //relacionUsuarioSerie
  getRelacionesUsuarioSerie(){
    const url='http://localhost:8080/relacion-usuario-serie/get-relaciones-usuario-serie';
    return this.http.get<ListadoRelacionUsuarioSerie>(url);
  }

  insertarRelacion(animeNuevo:Serie) {
    const url='http://localhost:8080/relacion-usuario-serie/insertar';
    return this.http.post<Mensaje>(url, animeNuevo);
  }

  modificarRelacion(relacionUsuarioSerie:RelacionUsuarioSerie){
    const url='http://localhost:8080/relacion-usuario-serie/modificar';
    return this.http.put<Mensaje>(url, relacionUsuarioSerie);
  }

  borrarRelacion(id:string){
    const url='http://localhost:8080/relacion-usuario-serie/borrar/'+id;
    return this.http.delete<Mensaje>(url);
  }

  getRelacionUsuarioSerie(id:string){
    const url='http://localhost:8080/relacion-usuario-serie/get-relacion-usuario-serie/'+id;
    return this.http.get<RelacionUsuarioSerie>(url);
  }

}
