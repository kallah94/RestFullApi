import { Component, OnInit } from '@angular/core';
import { Agence } from '../models/agence';
import { Compte } from '../models/compte';
import { AgenceService } from '../services/agence.service';

@Component({
  selector: 'app-agence',
  templateUrl: './agence.component.html',
  styleUrls: ['./agence.component.css']
})
export class AgenceComponent implements OnInit {
agences: Agence[] | undefined;
comptes: Compte[] | undefined;
  constructor(
    private agenceService: AgenceService
  ) { }

  // tslint:disable-next-line:typedef
  ngOnInit(){
    this.loadAgences();
    this.loadAgenceComptes();
  }

  // tslint:disable-next-line:typedef
  private loadAgences() {
   this.agenceService.getAll()
   .subscribe(agences => {
     this.agences = agences;
     console.log(agences);
   });
  }

  // tslint:disable-next-line:typedef
  private loadAgenceComptes() {
    this.agenceService.getAllComptes(11)
    .subscribe(comptes => {
      this.comptes = comptes;
      console.log(comptes);
    });
  }

  delete(id: number) {}

  update(id: number) {}

}
