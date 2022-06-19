import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RespuestaLogin } from 'src/app/modelos/usuarios/respuestaLogin';
import { Usuario } from 'src/app/modelos/usuarios/Usuario';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  item: RespuestaLogin={};
  usuario:Usuario={};
  esAdmin: boolean;
  constructor(private router: Router) { }

  ngOnInit(): void {
    this.usuario=JSON.parse(localStorage.getItem('usuario'));
  }

  Desconectarse(){
    localStorage.clear();
  }

  ComprobarUsuario(){
    this.item = JSON.parse(localStorage.getItem('usuario'));
    this.esAdmin=false;
    if(this.item.codigoLogeo==2){
      this.esAdmin=true;
    }
    return this.esAdmin;
  }



}
