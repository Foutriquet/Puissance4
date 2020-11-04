/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Jeton
 */

/**
 *
 * @author Utilisateur
 */
public class Jeton { //Initialisation de la classe
    String couleur;
    


public Jeton(String jeton) {  //Constructeur de la classe
    couleur = jeton;
}



public String lireCouleur(){ // Méthode qui renvoie la couleur 
    return couleur;
    
}

}
