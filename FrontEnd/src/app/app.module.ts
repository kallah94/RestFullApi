import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientComponent } from './client/client.component';
import { AgenceComponent } from './agence/agence.component';
import { CompteComponent } from './compte/compte.component';

@NgModule({
  declarations: [
    AppComponent,
    ClientComponent,
    AgenceComponent,
    CompteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
