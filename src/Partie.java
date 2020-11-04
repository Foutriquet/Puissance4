
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
public class Partie {
    Joueur ListeJoueurs[] = new Joueur[2];
    Grille grilledejeu;
    Joueur joueurCourant;
    
    
public void attribuerCouleursAuxJoueurs(){
    
   
    Random couleuraleatoire = new Random();
    int valeuraleatoire = couleuraleatoire.nextInt(1);
    
    ListeJoueurs[valeuraleatoire].Couleur = "rouge";
    
    if (valeuraleatoire == 1) {
        valeuraleatoire = 0;
        ListeJoueurs[valeuraleatoire].Couleur = "jaune";
    } else {
        valeuraleatoire = 1;
        ListeJoueurs[valeuraleatoire].Couleur = "jaune";
    }
    
    
}
    
    
    public void initialiserPartie() {
        
        for ( int i = 0; i < 6; i++) { 
            for (int j =0; j<7; j++) {
                if (grilledejeu.Cellule[i][j].jetonCourant != null) {
                    grilledejeu.Cellule[i][j].jetonCourant = null;
                }
            }
        }
        
        for ( int i = 0; i<5; i++) {
            Random a = new Random();
            int aa = a.nextInt(5);
            Random b = new Random();
            int bb = b.nextInt(6);
            
            grilledejeu.Cellule[aa][bb].placerTrouNoir();
            
            if (i > 3) {
                grilledejeu.Cellule[aa][bb].placerDesintegrateur();
            }
        }
        
        for ( int i = 0; i<2; i++) {
            
            Random c = new Random();
            int cc = c.nextInt(5);
            Random d = new Random();
            int dd = d.nextInt(6);
            
            while (grilledejeu.Cellule[cc][dd].presenceTrouNoir() == true || grilledejeu.Cellule[cc][dd].presenceDesintegrateur() == true) {
                cc = c.nextInt(5);
                dd = d.nextInt(6);
            }
            grilledejeu.Cellule[cc][dd].placerDesintegrateur();
            
        }
        
        Joueur joueur1 = ListeJoueurs[0];
        Joueur joueur2 = ListeJoueurs[1];
        
        attribuerCouleursAuxJoueurs();
        
        for (int i = 0; i <21; i++) {
            
            String couleurj1 = joueur1.Couleur;
            Jeton J = new Jeton(couleurj1);
            joueur1.ajouterJeton(J);
            
            String couleurj2 = joueur2.Couleur;
            Jeton J2 = new Jeton(couleurj2);
            joueur2.ajouterJeton(J2);
        }
       
        
    }
    
    
    
    
    
    
    
    
}
