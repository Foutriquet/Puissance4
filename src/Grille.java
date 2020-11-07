/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Grille
 */

/**
 *
 * @author Utilisateur
 */
public class Grille { //Initialisation de la classe
    Cellule [][] Cellule = new Cellule [6][7];

    
//CONSTRUCTEUR --------------------------------------------------------------
    
public Grille() {
    
    Cellule Cellule[][] = new Cellule[6][7];
    for ( int i = 0; i<6; i++) {
        for ( int j = 0; j<7; j++) {
            Cellule[i][j] = new Cellule();
        }
    }
    
}
    
public boolean ajouterJetonDansColonne(Jeton jetonajouter, int colonne) { //Méthode qui permet de jouer au jeu en ajoutant un jeton dans une colonne
    
   int j = colonne; //On enregistre la colonne choisie par l'utilisateur
   for (int i = 6; i > 0; i--){ //On fait une boucle pour faire tomber le Jeton sur la ligne la plus basse disponible
       if (Cellule[i][j].affecterJeton(jetonajouter) == true) { //On vérifie donc la présence des Jetons en décroissance dans la colonne
           return true; 
       }
         
}
   return false;

}

    
//METHODE --------------------------------------------------------------
    
   
public boolean etreRemplie(){ //Méthode qui vérifie si la grille est remplie
    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 7; j++){
            //On parcours toute la grille
            if (Cellule[i][j] != null){ //S'il y a un jeton dans chaque case, alors la grille est remplie
                return true;
            }
        }
    }
    return false;
}

    
//METHODE --------------------------------------------------------------
    
   
public void viderGrille(){ //Méthode pour vider une Grille
    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 7; j++){
            //On parcours toute la grille
            Cellule[i][j] = null; //On vide chaque case de la grille
               
            }
        }
    }
  

    
//METHODE --------------------------------------------------------------
    
   
public void afficherGrilleSurConsole(){ //Méthode d'affichage de la Grille sur la console
    
    System.out.print("\n\n\n| "); //Ligne pour espacer la présentation
    
    for (int i = 0; i < 6; i++){
        
        for (int j = 0; j < 7; j++){
            
            //On parcours la grille
            
            System.out.print(Cellule[i][j]+" ; "); //On affiche chaque cellule dans l'ordre en l'espacant pour aérer le jeu
        } 
        System.out.print("|\n| "); //Ligne pour espacer la présentation
    }
    
}

    
//METHODE --------------------------------------------------------------
    
   
public boolean celluleOccupee(int ligne, int colonne){  //Méthode qui vérifie qu'une cellule soit occupée
    if (Cellule[ligne][colonne].recupererJeton() == null){ //On vérifie que la cellule est occupée
        return false;
    }
    return true;
}

    
//METHODE --------------------------------------------------------------
    
   
public String lireCouleurDuJeton1(int ligne, int colonne){ //Méthode pour lire la couleur du Jeton dans la grille
    return (Cellule[ligne][colonne].lireCouleurDuJeton()); //Utilisation de la méthode lireCouleurDuJeton dans la classe cellule
}


    
//METHODE --------------------------------------------------------------
    
   
public boolean etreGagnantePourJoueur(Joueur joueur){ // Méthode pour vérifier si un joueur a gagné ou non
 
    //Ligne
    
    for (int i = 0; i<6 ; i++){
        for (int j = 0; j<7 ; j++){
            //En parcourant toute la grille
            
            //Vérifie les combinaisons sur une colonne
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i+1, j) && lireCouleurDuJeton1(i + 1, j) == lireCouleurDuJeton1(i+2, j) && lireCouleurDuJeton1(i+2, j) == lireCouleurDuJeton1(i+3, j)){
            return true;
        }
            //Vérifie les combinaisons sur une ligne
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i, j+1) && lireCouleurDuJeton1(i, j+1) == lireCouleurDuJeton1(i, j+2) && lireCouleurDuJeton1(i, j+2) == lireCouleurDuJeton1(i, j+3)){
            return true;
            
        }
            //Vérifie les combinaisons diagonales de gauche à droite
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i+1, j+1) && lireCouleurDuJeton1(i+1, j+1) == lireCouleurDuJeton1(i+2, j+2) && lireCouleurDuJeton1(i+2, j+2) == lireCouleurDuJeton1(i+3, j+3)){
            return true;
            
        }
            //Vérifie les combinaisons diagonales de droite à gauche
        if (lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i-1, j+1) && lireCouleurDuJeton1(i-1, j+1) == lireCouleurDuJeton1(i-2, j+2) && lireCouleurDuJeton1(i-2, j+2) == lireCouleurDuJeton1(i-3, j+3)){
            return true;
            
        }
        
    }
          
    }
    return false;
    
}


    
//METHODE --------------------------------------------------------------
    
   
public boolean colonneRemplie(int colonne){ //Méthode qui vérifie qu'une colonne soit remplie
    
    if (celluleOccupee(0,colonne) == true){ //On ne change pas de ligne, on vérifie que la dernière case de la colonne soit occupée en faisant intervenir la méthode celluleOccupee
        return true;
    }
    return false;
    
}


    
//METHODE --------------------------------------------------------------
    
   
public boolean placerTrouNoir2(int ligne, int colonne){ //Méthode pour placer un Trou Noir
    
    if (Cellule[ligne][colonne].presenceTrouNoir() == false){ //S'il n'y a pas déjà de trou noir, alors, on place trou noir dans la cellule avec la méthode placerTrouNoir
        
        Cellule[ligne][colonne].placerTrouNoir();
        return true;
    }
    return false;
    
}

    
//METHODE --------------------------------------------------------------
    
   

public boolean placerDesintegrateur2(int ligne, int colonne){ //Méthode pour placer un Désintégrateur
    
    if (Cellule[ligne][colonne].presenceDesintegrateur() == false){ //S'il n'y a pas déjà de Désintégrateur, alors, on place trou noir dans la cellule avec la méthode placerDesintegrateur
        
        Cellule[ligne][colonne].placerDesintegrateur();
        return true;
    }
    return false;
    
}

    
//METHODE --------------------------------------------------------------
    
   

public boolean supprimerJeton2(int ligne, int colonne){ //Méthode pour supprimer un Jeton
    
    if (Cellule[ligne][colonne].recupererJeton() != null){ //On vérifie la présence du Jeton
        
        Cellule[ligne][colonne].supprimerJeton(); //On le supprime avec la méthode supprimerJeton
        return true;
    }
    return false;
    
}

    
//METHODE --------------------------------------------------------------
    
   
public Jeton recupererJeton2(int ligne, int colonne){ //Méthode pour récupérer son Jeton
    
    Jeton recupererlejeton = Cellule[ligne][colonne].recupererJeton(); //On fait intervenir la méthode qui récupère la référence du jeton recupererJeton
        
        return recupererlejeton;
    }


    
//METHODE --------------------------------------------------------------
    
   
public void tasserGrille(int ligne, int colonne){ //Méthode pour décaler les jetons si l'un venait à être détruit
    
    if (supprimerJeton2(ligne, colonne) == true) { //Si un jeton a été détruit, alors, je parcours la colonne et descend d'une ligne chaque jeton
        for (int i = ligne; i>=0; i--){
            Cellule[i][colonne].jetonCourant = Cellule[i+1][colonne].jetonCourant;
            
        }
    }
    
    }



}
