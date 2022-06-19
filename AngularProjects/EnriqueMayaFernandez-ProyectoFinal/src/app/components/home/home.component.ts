import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/modelos/usuarios/Usuario';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  usuario:Usuario={};
  constructor() { }

  ngOnInit(): void {
    this.usuario=JSON.parse(localStorage.getItem('usuario'));
  }

}
