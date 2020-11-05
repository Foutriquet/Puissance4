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
    
    
    
 //CONSTRUCTEUR --------------------------------------------------------------  
    
    

public Jeton(String jeton) {  //Constructeur de la classe
    couleur = jeton;
}

    
    
 //METHODE --------------------------------------------------------------  
    
    

public String lireCouleur(){ // Méthode qui renvoie la couleur du Jeton
    return couleur;
    
}

}
