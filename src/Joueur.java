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

    int ListeJetons;

    int nombreDesintegrateurs;
    
    int nombreJetonsRestant;
   

public Joueur (String unnom) { //Ligne de code qui permet d'attribuer les attributs aux variables en une ligne

    nom = unnom;

}


public void affecterCouleur(String couleurajouter){
    Couleur=couleurajouter ;
    
}

}


