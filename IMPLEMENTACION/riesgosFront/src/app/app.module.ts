import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NgDatepickerModule } from 'ng2-datepicker';
import { FormWizardModule } from 'angular-wizard-form';
import { ArchwizardModule } from 'angular-archwizard';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { SedesComponent } from './sedes/sedes.component';
import { InstitucionesComponent } from './instituciones/instituciones.component';
import { LoginComponent } from './login/login.component';
import { PlantillaComponent } from './plantilla/plantilla.component';
import { DatosPoblacionComponent } from './datos-poblacion/datos-poblacion.component';
import { AntedecentesComponent } from './antedecentes/antedecentes.component';
import { AmenazasComponent } from './amenazas/amenazas.component';
import { VulnerabilidadComponent } from './vulnerabilidad/vulnerabilidad.component';
import { RiesgoComponent } from './riesgo/riesgo.component';
import { ReportesComponent } from './reportes/reportes.component';

const appRoutes: Routes = [    
  { path: 'instituciones', component: InstitucionesComponent},
  { path: 'datosPoblacion', component: DatosPoblacionComponent},
  { path: 'antecedentes', component: AntedecentesComponent},
  { path: 'amenazas', component: AmenazasComponent},
  { path: 'vulnerabilidad', component: VulnerabilidadComponent},
  { path: 'riesgo', component: RiesgoComponent},
  { path: 'reportes', component: ReportesComponent},
  { path: 'sedes', component: SedesComponent},
  { path: 'home', component: HomeComponent},
  { path: '', component: LoginComponent}  
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SedesComponent,
    InstitucionesComponent,
    LoginComponent,
    PlantillaComponent,
    DatosPoblacionComponent,
    AntedecentesComponent,
    AmenazasComponent,
    VulnerabilidadComponent,
    RiesgoComponent,
    ReportesComponent
  ],
  imports: [
    BrowserModule,
    NgDatepickerModule,
    FormWizardModule,
    ArchwizardModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
