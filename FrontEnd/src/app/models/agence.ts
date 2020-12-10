export class Agence {
  id!: number;
  nom: string;
  addresse: string;
  telephone: string;

  constructor(
    nom: string,
    addresse: string,
    telephone: string
  ) {
    this.nom = nom;
    this.addresse = addresse;
    this.telephone = telephone;
  }
}
