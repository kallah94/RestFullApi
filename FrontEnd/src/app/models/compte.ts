export class Compte {
  id!: number;
  solde: number;
  decouvert: number;
  agenceCode: number;
  clientId: number;

  constructor(
    solde: number,
    decouvert: number,
    agenceCode: number,
    clientId: number
  ) {
    this.solde = solde;
    this.decouvert = decouvert;
    this.agenceCode = agenceCode;
    this.clientId = clientId;
  }
}
