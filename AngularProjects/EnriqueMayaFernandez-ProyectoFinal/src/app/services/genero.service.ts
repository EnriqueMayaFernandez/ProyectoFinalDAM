import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Genero } from '../modelos/genero';
import { ListaGeneros } from '../modelos/lista-generos';

@Injectable({
  providedIn: 'root'
})
export class GeneroService {


  constructor(private http:HttpClient) { }

  getGeneros(){
    const url='http://localhost:8080/genero/get-generos';
    return this.http.get<ListaGeneros>(url);
  }
}
