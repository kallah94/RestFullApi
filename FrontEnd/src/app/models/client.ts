export class Client {
  id!: number;
  prenom: string;
  nom: string;
  // tslint:disable-next-line:variable-name
  date_naissance: string;

  constructor(
    prenom: string,
    nom: string,
    // tslint:disable-next-line:variable-name
    date_naissance: string
  ) {
    this.prenom = prenom;
    this.nom = nom;
    this.date_naissance = date_naissance;
  }
}
