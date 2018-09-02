import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-amenazas',
  templateUrl: './amenazas.component.html',
  styleUrls: ['./amenazas.component.css']
})
export class AmenazasComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  eviarInstituciones() {           
    this.router.navigate(["instituciones"]); 
  }
  eviarDatosPoblacion() {           
    this.router.navigate(["datosPoblacion"]); 
  }
  eviarAntecedentes() {           
    this.router.navigate(["antecedentes"]); 
  }
  eviarAmenazas() {           
    this.router.navigate(["amenazas"]); 
  }
  eviarVulnerabilidad() {           
    this.router.navigate(["vulnerabilidad"]); 
  }
  eviarRiesgo() {           
    this.router.navigate(["riesgo"]); 
  }
  eviarReportes() {           
    this.router.navigate(["reportes"]); 
  }
  eviarHome() {           
    this.router.navigate(["home"]); 
  }


}
