import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mensaje } from '../modelos/mensaje';
import { ListaRoles } from '../modelos/usuarios/lista-roles';
import { ListaUsuarios } from '../modelos/usuarios/lista-usuarios';
import { RespuestaLogin } from '../modelos/usuarios/respuestaLogin';
import { Rol } from '../modelos/usuarios/rol';
import { Usuario } from '../modelos/usuarios/Usuario';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {

  constructor(private http: HttpClient) {}

  insertar(usuario: Usuario) {
    const url = 'http://localhost:8080/usuario/insertar';
    return this.http.post<Mensaje>(url, usuario);
  }

  logeo(usuario:Usuario) {
    const url = 'http://localhost:8080/usuario/logeo';
    return this.http.post<RespuestaLogin>(url, usuario);
  }

  modificar(usuario:Usuario){
    const url='http://localhost:8080/usuario/modificar';
    return this.http.put<Mensaje>(url,usuario);
  }

  borrar(id:string){
    const url='http://localhost:8080/usuario/borrar/'+id;
    return this.http.delete<Mensaje>(url);
  }

  getUsuario(id:string){
    const url='http://localhost:8080/usuario/get-usuario/'+id;
    return this.http.get<Usuario>(url);
  }

  getUsuarios(){
    const url='http://localhost:8080/usuario/get-usuarios';
    return this.http.get<ListaUsuarios>(url);
  }
}
