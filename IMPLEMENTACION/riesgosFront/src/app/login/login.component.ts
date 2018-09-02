import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  /**
   * Método que atiende el evento de seleccionar evidencia.
   */
  eviarHome() {           
    this.router.navigate(["home"]); 
  }

  ngOnInit() {
  }

}
