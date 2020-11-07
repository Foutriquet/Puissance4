/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Joueur
 */

/**
 *
 * @author Utilisateur
 */
public class Joueur { //Initialisation du joueur
    String nom;

    String Couleur;

    Jeton[] ListeJetons = new Jeton[21];

    int nombreDesintegrateurs;
    
    int nombreJetonsRestant;
   
    
    
 //CONSTRUCTEUR --------------------------------------------------------------  
    
    
public Joueur (String unnom) { //Méthode constructeur qui attribue un nom au joueur

    nom = unnom;

}
    
    
 //METHODE --------------------------------------------------------------  
    
    

public void affecterCouleur(String couleurajouter){ //Méthode pour affecter une couleur au Joueur
    Couleur=couleurajouter ;
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public void ajouterJeton(Jeton jetonajouter) { //Méthode pour ajouter un jeton au joueur
    
    for (int i = 0; i < ListeJetons.length; i++) { //On parcours ses jetons
        if (ListeJetons[i] != null) {  //S'il n'en existe pas, on en ajoute un
            ListeJetons[i] = jetonajouter;

        }
    }
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public void obtenirDesintegrateur(int desintegrateur) { //Méthode qui stock les désintégrateurs du joueur
    
    nombreDesintegrateurs += desintegrateur; //On les ajoute 
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean utiliserDesintegrateur(int desintegrateur) { //Méthode qui utilise un Désintégrateur
    
    if (nombreDesintegrateurs == 0) { //S'il n'en a pas, alors il ne peux pas en placer
        return false;
    } else {
        nombreDesintegrateurs -= 1; //Si en a un, on l'enlève après utilisation
        return true;
    }
    
}



}


