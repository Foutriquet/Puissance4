/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Grille
 */

/**
 *
 * @author Utilisateur
 */
public class Grille {
    Cellule [][] Cellule = new Cellule [6][7];


public boolean ajouterJetonDansColonne(Jeton jetonajouter, int colonne) {
    
   int j = colonne;
   for (int i = 6; i > 0; i--){
       if (Cellule[i][j].affecterJeton(jetonajouter) == true) {
           return true; 
       }
         
}
   return false;

}

public boolean etreRemplie(){
    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 7; j++){
            if (Cellule[i][j] != null){
                return true;
            }
        }
    }
    return false;
}

public void viderGrille(){
    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 7; j++){
            Cellule[i][j] = null;
               
            }
        }
    }
  

public void afficherGrilleSurConsole(){
    
    System.out.print("\n\n\n| ");
    
    for (int i = 0; i < 6; i++){
        
        for (int j = 0; j < 7; j++){
            System.out.print(Cellule[i][j]+" ; ");
        } 
        System.out.print("|\n| ");
    }
    
}

public boolean celluleOccupee(int ligne, int colonne){
    if (Cellule[ligne][colonne].recupererJeton() == null){
        return false;
    }
    return true;
}

public String lireCouleurDuJeton1(int ligne, int colonne){
    return (Cellule[ligne][colonne].lireCouleurDuJeton());
}


public boolean etreGagnantePourJoueur(Joueur joueur){
 
    //Ligne
    
    for (int i = 0; i<6 ; i++){
        for (int j = 0; j<7 ; j++){
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i+1, j) && lireCouleurDuJeton1(i + 1, j) == lireCouleurDuJeton1(i+2, j) && lireCouleurDuJeton1(i+2, j) == lireCouleurDuJeton1(i+3, j)){
            return true;
        }
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i, j+1) && lireCouleurDuJeton1(i, j+1) == lireCouleurDuJeton1(i, j+2) && lireCouleurDuJeton1(i, j+2) == lireCouleurDuJeton1(i, j+3)){
            return true;
            
        }
        
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i+1, j+1) && lireCouleurDuJeton1(i+1, j+1) == lireCouleurDuJeton1(i+2, j+2) && lireCouleurDuJeton1(i+2, j+2) == lireCouleurDuJeton1(i+3, j+3)){
            return true;
            
        }
        
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i-1, j+1) && lireCouleurDuJeton1(i-1, j+1) == lireCouleurDuJeton1(i-2, j+2) && lireCouleurDuJeton1(i-2, j+2) == lireCouleurDuJeton1(i-3, j+3)){
            return true;
            
        }
        
    }
          
    }
    return false;
    
}


public boolean colonneRemplie(int colonne){
    
    if (celluleOccupee(0,colonne) == true){
        return true;
    }
    return false;
    
}


public boolean placerTrouNoir2(int ligne, int colonne){
    
    if (Cellule[ligne][colonne].presenceTrouNoir() == false){
        
        Cellule[ligne][colonne].placerTrouNoir();
        return true;
    }
    return false;
    
}


public boolean placerDesintegrateur2(int ligne, int colonne){
    
    if (Cellule[ligne][colonne].presenceDesintegrateur() == false){
        
        Cellule[ligne][colonne].placerDesintegrateur();
        return true;
    }
    return false;
    
}


public boolean supprimerJeton2(int ligne, int colonne){
    
    if (Cellule[ligne][colonne].recupererJeton() != null){
        
        Cellule[ligne][colonne].supprimerJeton();
        return true;
    }
    return false;
    
}

public Jeton recupererJeton2(int ligne, int colonne){
    
    Jeton recupererlejeton = Cellule[ligne][colonne].recupererJeton();
        
        return recupererlejeton;
    }


public void tasserGrille(int ligne, int colonne){
    
    if (supprimerJeton2(ligne, colonne) == true) {
        for (int i = ligne; i>=0; i--){
            Cellule[i][colonne].jetonCourant = Cellule[i+1][colonne].jetonCourant;
            
        }
    }
    
    }



}
