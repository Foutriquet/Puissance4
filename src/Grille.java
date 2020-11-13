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
    Cellule Cellule [][] = new Cellule[6][7];

    
//CONSTRUCTEUR --------------------------------------------------------------
    
public Grille() {
    
    for ( int i = 0; i<6; i++) {
        for ( int j = 0; j<7; j++) {
            Cellule[i][j] = new Cellule();
        }
    }
    
}
 
    
//METHODE --------------------------------------------------------------
    
      
public boolean ajouterJetonDansColonne(Jeton jetonajouter, int colonne) { //Méthode qui permet de jouer au jeu en ajoutant un jeton dans une colonne
    
   if (colonneRemplie(colonne) == true) {
       return false;
   }
    //On enregistre la colonne choisie par l'utilisateur
   int i =0;
   while (Cellule[i][colonne].jetonCourant != null) {
       i += 1;
   }
   Cellule[i][colonne].affecterJeton(jetonajouter); //On vérifie donc la présence des Jetons en décroissance dans la colonne
        
      return true;    
}
  



    
//METHODE --------------------------------------------------------------
    
   
public boolean etreRemplie(){ //Méthode qui vérifie si la grille est remplie
    boolean v=false;
    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 7; j++){
            //On parcours toute la grille
            if (Cellule[i][j].jetonCourant != null){ //S'il y a un jeton dans chaque case, alors la grille est remplie
                v=true;
            }
            else{
                v=false;
            }
        }
    }
    return v;
}

    
//METHODE --------------------------------------------------------------
    
   
public void viderGrille(){ //Méthode pour vider une Grille
    for (int i = 0; i < 6; i++){
        for (int j = 0; j < 7; j++){
            //On parcours toute la grille
            Cellule[i][j].jetonCourant = null; //On vide chaque case de la grille
            Cellule[i][j].desintegrateur = false;
            Cellule[i][j].trouNoir = false;
            }
        }
    }
  

    
//METHODE --------------------------------------------------------------
    
   
public void afficherGrilleSurConsole(){ //Méthode d'affichage de la Grille sur la console
    
    System.out.print("\n\n\n"); //Ligne pour espacer la présentation
    
    for (int i = 5; i >= 0; i--){ //Pour afficher du bas vers le haut
        
        System.out.print("|"); //Pour l'esthétique
        
        for (int j = 0; j < 7; j++){
            
            //On parcours la grille en vérifiant les éléments
            
            if (Cellule[i][j].presenceTrouNoir() == true) {
                System.out.print("T|"); //T pour trou Noir
            } else if (Cellule[i][j].presenceDesintegrateur() == true) {
                System.out.print("D|"); //D pour trou Noir
            } else {
            
            if (Cellule[i][j].jetonCourant == null) {
                System.out.print(" |");
            } else if (Cellule[i][j].jetonCourant.couleur == "rouge") {
                System.out.print("r|"); //r pour rouge
            } else if (Cellule[i][j].jetonCourant.couleur == "jaune") {
                System.out.print("j|"); //j pour jaune
            } 
            }
            
            
       
    }
     System.out.print("\n"); //Esthétique
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
        if ( lireCouleurDuJeton1(i, j) == joueur.Couleur && lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i+1, j) && lireCouleurDuJeton1(i + 1, j) == lireCouleurDuJeton1(i+2, j) && lireCouleurDuJeton1(i+2, j) == lireCouleurDuJeton1(i+3, j)){
            return true;
        }
            //Vérifie les combinaisons sur une ligne
        if (lireCouleurDuJeton1(i, j) == joueur.Couleur && lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i, j+1) && lireCouleurDuJeton1(i, j+1) == lireCouleurDuJeton1(i, j+2) && lireCouleurDuJeton1(i, j+2) == lireCouleurDuJeton1(i, j+3)){
            return true;
            
        }
            //Vérifie les combinaisons diagonales montantes
        if (lireCouleurDuJeton1(i, j) == joueur.Couleur && lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i+1, j+1) && lireCouleurDuJeton1(i+1, j+1) == lireCouleurDuJeton1(i+2, j+2) && lireCouleurDuJeton1(i+2, j+2) == lireCouleurDuJeton1(i+3, j+3)){
            return true;
            
        }
            //Vérifie les combinaisons diagonales descendante
        if (i-3>=0 && lireCouleurDuJeton1(i, j) == joueur.Couleur && lireCouleurDuJeton1(i, j) == lireCouleurDuJeton1(i-1, j+1) && lireCouleurDuJeton1(i-1, j+1) == lireCouleurDuJeton1(i-2, j+2) && lireCouleurDuJeton1(i-2, j+2) == lireCouleurDuJeton1(i-3, j+3)){
            return true;
        
        }
    
    }
          
    }
    return false;
    
}


    
//METHODE --------------------------------------------------------------
    
   
public boolean colonneRemplie(int colonne){ //Méthode qui vérifie qu'une colonne soit remplie
    
    if (celluleOccupee(5,colonne) == true){ //On ne change pas de ligne, on vérifie que la dernière case de la colonne soit occupée en faisant intervenir la méthode celluleOccupee
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
    
        int j=colonne;
        for (int i = ligne; i<4; i++){
            Cellule[i][j].jetonCourant = Cellule[i+1][j].jetonCourant;
           
        }
}
}