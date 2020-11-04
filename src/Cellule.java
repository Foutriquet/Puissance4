/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Cellule
 */

/**
 *
 * @author Utilisateur
 */
public class Cellule {
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    
public Cellule(Jeton jeton, boolean trou, boolean desinteg ) {  //Constructeur de la classe
    jetonCourant = jeton;
    trouNoir = trou;
    desintegrateur = desinteg;
    
}

public boolean affecterJeton(Jeton ja){
    
    Jeton reference;
    reference = recupererJeton();
    if (reference == null){
       jetonCourant = ja; 
       return true;
    }
    return false;
    
    
}

public Jeton recupererJeton(){
    Jeton jetonretourner = jetonCourant;
    jetonCourant = null;
    return jetonretourner;
}


public boolean supprimerJeton(){
    
    if (recupererJeton() != null) {
        
        jetonCourant = null;
        return true;

    }
    return false;
    
}

public boolean placerTrouNoir(){
    if (trouNoir == false){
        trouNoir = true;
        return true;
    }
    return false;
    
}

public boolean placerDesintegrateur(){
    if (desintegrateur == false){
        desintegrateur = true;
        return true;
    }
    return false;
    
}

public boolean presenceTrouNoir(){
    if (trouNoir == true){
        return true;
    }
    return false;
}

public boolean presenceDesintegrateur(){
    if (desintegrateur == true){
        return true;
    }
    return false;
}

public String lireCouleurDuJeton(){
    
    return(jetonCourant.lireCouleur());
    
    
}


public boolean recupererDesintegrateur(){
    
    if (presenceDesintegrateur() == true) {
        
        desintegrateur = false;
        return true;

    }
    return false;
    
}


public boolean activerTrouNoir(){
    if (jetonCourant == null) {
        return false;
    } else if (presenceTrouNoir() == false) {
        return false;
        
        
    } else {
        supprimerJeton();
        trouNoir = false;
        return true;
    }
}





}


