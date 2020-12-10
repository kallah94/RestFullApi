import { Component, OnInit } from '@angular/core';
import { Client } from '../models/client';
import { Compte } from '../models/compte';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  clients: Client[] | undefined;
  comptes: Compte[] | undefined;
  constructor(
    private clientService: ClientService
  ) { }

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.loadClients();
    this.loadClientComptes();
  }

  // tslint:disable-next-line:typedef
  private loadClients() {
    this.clientService.getAll()
    .subscribe(clients => {
      this.clients = clients;
      console.log(clients);
    });
  }

  private loadClientComptes() {
    this.clientService.getAllComptes(12)
    .subscribe(comptes => {
      this.comptes = comptes;
      console.log(comptes);
    })
  }
  delete(id: number) {}

  update(id: number) {}

}
