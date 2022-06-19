import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor() {
    console.log("Component hedaer Creandose")
   }

  ngOnInit(): void {
    console.log("Component hedaer ya creado")
  }

  nombre = "Enrique"

}
