import { Component, OnInit } from '@angular/core';
import { Compte } from '../models/compte';
import { CompteService } from '../services/compte.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
comptes: Compte[] | undefined;
  constructor(
    private compteService: CompteService
  ) { }

  ngOnInit() {
    this.loadComptes();
  }

  private loadComptes() {
    this.compteService.getAll()
    .subscribe(comptes => {
      this.comptes = comptes;
      console.log(comptes);
    });
  }

  delete(id: number) {}

  update(id: number) {}
}
