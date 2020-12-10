import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from '../models/client';
import { Compte } from '../models/compte';
@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private apiUrl = 'http://parrot:8080/restFulService-1.0-SNAPSHOT/api';

  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  getAll() {
    return this.http.get<Client[]>(`${this.apiUrl}/client`);
  }

  // tslint:disable-next-line:typedef
  getAllComptes(clientId: number) {
    return this.http.get<Compte[]>(`${this.apiUrl}/client/${clientId}/comptes`);
  }
}
