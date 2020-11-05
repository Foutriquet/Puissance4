/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Cellule
 */

/**
 *
 * @author Utilisateur
 */
public class Cellule { //Initialisation de la classe
    
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    
 //CONSTRUCTEUR --------------------------------------------------------------  
    
    
public Cellule(Jeton jeton, boolean trou, boolean desinteg ) {  //Constructeur de la classe
    jetonCourant = jeton;
    trouNoir = trou;
    desintegrateur = desinteg;
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean affecterJeton(Jeton ja){ //Méthode qui affecte un Jeton à l'attribut
    
    Jeton reference; 
    reference = recupererJeton();  //On cherche la référence du jeton
    if (reference == null){ //Si la référence n'existe pas, on ajoute le jeton
       jetonCourant = ja; 
       return true;
    }
    return false; //Sinon, on ne fait rien
    
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public Jeton recupererJeton(){ //Méthode pour récupérer un Jeton
    Jeton jetonretourner = jetonCourant;
    jetonCourant = null; //On stock le jeton dans une variable, puis re-initialise l'attribut de départ pour libérer de la place
    return jetonretourner;
}

    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean supprimerJeton(){ //Méthode pour supprimer un Jeton
    
    if (recupererJeton() != null) {
        
        jetonCourant = null; //On re-initialise le jeton s'il n'est pas déjà vide
        return true;

    }
    return false;
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean placerTrouNoir(){ //Méthode pour placer un Trou Noir
    if (trouNoir == false){ //S'il n'y a pas de trou Noir, alors, il place un trou Noir
        trouNoir = true;
        return true;
    }
    return false;
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean placerDesintegrateur(){ //Même raisonnement que le Trou Noir
    if (desintegrateur == false){
        desintegrateur = true;
        return true;
    }
    return false;
    
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean presenceTrouNoir(){ //Méthode qui vérifie la présence d'un Trou Noir
    if (trouNoir == true){ //On vérifie sa présence
        return true; //On renvoie oui s'il est présent, non sinon
    }
    return false;
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean presenceDesintegrateur(){ //Même raisonnement que le Trou Noir
    if (desintegrateur == true){
        return true;
    }
    return false;
}
    
    
 //METHODE --------------------------------------------------------------  
    
    
public String lireCouleurDuJeton(){ //Méthode qui lit la couleur du Jeton dans la classe Cellule
    
    return(jetonCourant.lireCouleur()); //On fait intervenir la méthode lireCouleur dans Jeton
    
    
}

    
    
 //METHODE --------------------------------------------------------------  
    
    
public boolean recupererDesintegrateur(){ //Méthode de récupération d'un désintégrateur
    
    if (presenceDesintegrateur() == true) { //On vérifie qu'il y a un désintégrateur
        
        desintegrateur = false; //On le récupère
        return true;

    }
    return false;
    
}


public boolean activerTrouNoir(){ //Méthode d'activation d'un Trou Noir
    if (jetonCourant == null) { //S'il n'y a aucun Jeton sur la case, le trou noir ne s'active pas
        return false;
        
        
    } else if (presenceTrouNoir() == false) { //S'il n'y a pas de trou noir sur la case du jeton, il ne peut pas s'activer
        return false;
        
        
    } else {
        supprimerJeton(); //On Supprime le jeton s'il est arrivé sur la case trou noir
        trouNoir = false; //Le trou noir disparaît après activation
        return true;
    }
}





}


