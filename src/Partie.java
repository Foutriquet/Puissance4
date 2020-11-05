
import java.util.Random;

/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Partie
 */

/**
 * 
 * @author Utilisateur
 */
public class Partie { //Initialisation de la classe Partie
    Joueur ListeJoueurs[] = new Joueur[2];
    Grille grilledejeu;
    Joueur joueurCourant;
    
        
    
 //METHODE --------------------------------------------------------------  
    
    
public void attribuerCouleursAuxJoueurs(){ //Attribution des couleurs aux joueurs
    
   
    Random couleuraleatoire = new Random();
    int valeuraleatoire = couleuraleatoire.nextInt(1); //Pour rendre cela aléatoire, on utilise random
    
    ListeJoueurs[valeuraleatoire].Couleur = "rouge";
    
    if (valeuraleatoire == 1) { //On donne au deuxième joueur l'autre couleur 
        valeuraleatoire = 0;
        ListeJoueurs[valeuraleatoire].Couleur = "jaune";
    } else {
        valeuraleatoire = 1;
        ListeJoueurs[valeuraleatoire].Couleur = "jaune";
    }
    
    
}
        
    
 //METHODE --------------------------------------------------------------  
    
    
    
    public void initialiserPartie() {
        
        //On vide la grille si elle est pleine
        
        for ( int i = 0; i < 6; i++) { 
            for (int j =0; j<7; j++) {
                if (grilledejeu.Cellule[i][j].jetonCourant != null) {
                    grilledejeu.Cellule[i][j].jetonCourant = null;
                }
            }
        }
        
        //On place aléatoirement les Trou Noirs
        
        for ( int i = 0; i<5; i++) {
            Random a = new Random();
            int aa = a.nextInt(5);
            Random b = new Random();
            int bb = b.nextInt(6);
            
            grilledejeu.Cellule[aa][bb].placerTrouNoir(); //On en place 5
            
            if (i > 3) {
                grilledejeu.Cellule[aa][bb].placerDesintegrateur(); //Deux désintégrateurs doivent être sur des trous noirs, donc pour les deux derniers Trou Noir, on place 2 désintégrateurs
            }
        }
        
        //On place les 3 désintégrateurs restant aléatoirement
        for ( int i = 0; i<2; i++) {
            
            Random c = new Random();
            int cc = c.nextInt(5);
            Random d = new Random();
            int dd = d.nextInt(6);
            
            //On vérifie qu'aucun trou noir ne soit là où nous souhaitons mettre notre Désintégrateur
            while (grilledejeu.Cellule[cc][dd].presenceTrouNoir() == true || grilledejeu.Cellule[cc][dd].presenceDesintegrateur() == true) { 
                cc = c.nextInt(5);
                dd = d.nextInt(6);
            }
            grilledejeu.Cellule[cc][dd].placerDesintegrateur(); //On place
            
        }
        
        //On initialise les joueurs
        
        Joueur joueur1 = ListeJoueurs[0];
        Joueur joueur2 = ListeJoueurs[1];
        
        attribuerCouleursAuxJoueurs(); //On attribue leur couleur
        
        //On attribue leur jeton
        for (int i = 0; i <21; i++) {
            
            String couleurj1 = joueur1.Couleur; //On prend la couleur du joueur
            Jeton J = new Jeton(couleurj1); //On la donne au jeton
            joueur1.ajouterJeton(J); //On ajoute le jeton au joueur
            
            String couleurj2 = joueur2.Couleur;
            Jeton J2 = new Jeton(couleurj2);
            joueur2.ajouterJeton(J2);
        } //Et ce, 21 fois
        
    }
    
    
        
    
 //METHODE --------------------------------------------------------------  
    
    
    
    
    
    
    
}
