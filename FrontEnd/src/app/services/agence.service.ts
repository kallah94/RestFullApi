import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Agence } from '../models/agence';
import { Compte } from '../models/compte';

@Injectable({
  providedIn: 'root'
})
export class AgenceService {

  apiUrl = 'http://parrot:8080/restFulService-1.0-SNAPSHOT/api';
  constructor(private http: HttpClient) { }

  // tslint:disable-next-line:typedef
  getAll() {
    return this.http.get<Agence[]>(`${this.apiUrl}/agence`);
  }

  // tslint:disable-next-line:typedef
  getAllComptes(agenceId: number) {
    return this.http.get<Compte[]>(`${this.apiUrl}/agence/${agenceId}/comptes`);
  }
}
