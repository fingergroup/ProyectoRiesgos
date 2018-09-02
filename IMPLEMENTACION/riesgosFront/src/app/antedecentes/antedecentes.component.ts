import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import * as enLocale from 'date-fns/locale/en';

@Component({
  selector: 'app-antedecentes',
  templateUrl: './antedecentes.component.html',
  styleUrls: ['./antedecentes.component.css']
})
export class AntedecentesComponent implements OnInit {

  date: Date;
 

  constructor(private router: Router) {
    this.date = new Date();
   }

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
