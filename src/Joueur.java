/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Utilisateur
 */
public class Joueur {
    String nom;

    String Couleur;

    Jeton[] ListeJetons = new Jeton[21];

    int nombreDesintegrateurs;
    
    int nombreJetonsRestant;
   

public Joueur (String unnom) { //Ligne de code qui permet d'attribuer les attributs aux variables en une ligne

    nom = unnom;

}


public void affecterCouleur(String couleurajouter){
    Couleur=couleurajouter ;
    
}

public void ajouterJeton(Jeton jetonajouter) {
    
    for (int i = 0; i < ListeJetons.length; i++) {
        if (ListeJetons[i] != null) {
            ListeJetons[i] = jetonajouter;

        }
    }
    
}

public void obtenirDesintegrateur(int desintegrateur) {
    
    nombreDesintegrateurs += 1;
    
}

public boolean utiliserDesintegrateur(int desintegrateur) {
    
    if (nombreDesintegrateurs == 0) {
        return false;
    } else {
        nombreDesintegrateurs -= 1;
        return true;
    }
    
}



}


