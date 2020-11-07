
import java.util.Random;
import java.util.Scanner;
/*
 * TP3 - Super Puissance
 * TROUILLET Nicolas - GOMBAULT Mallory 
 * Jeton - class Partie
 */

/**

 * @author Utilisateur
 */



public class Partie { //Initialisation de la classe Partie
    Joueur ListeJoueurs[] = new Joueur[2];
    Grille grilledejeu = new Grille();
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
        grilledejeu.viderGrille();
        
        
        
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
        
        
        
       
        
    }
    
    
        
    
 //METHODE --------------------------------------------------------------  
    
    
    
    
    public void debuterPartie() {
        
        //On initialise les joueurs
        Scanner sc; //J'introduis l'outil scanner
        
        sc = new Scanner (System.in); 
        System.out.print("Entrez le nom du premier joueur : ");  
        Joueur joueur1 = new Joueur(sc.nextLine()); //Demande au joueur son nom 
        
        System.out.print("Entrez le nom du deuxième joueur : ");  
        Joueur joueur2 = new Joueur(sc.nextLine());
       
        ListeJoueurs[0] = joueur1 ;
        ListeJoueurs[1] = joueur2 ;
        
        //On attribue leur couleur
        attribuerCouleursAuxJoueurs();
        
        //On attribue leur jeton
        for (int i = 0; i <21; i++) {
            
            String couleurj1 = joueur1.Couleur; //On prend la couleur du joueur
            Jeton J = new Jeton(couleurj1); //On la donne au jeton
            joueur1.ajouterJeton(J); //On ajoute le jeton au joueur
            
            String couleurj2 = joueur2.Couleur;
            Jeton J2 = new Jeton(couleurj2);
            joueur2.ajouterJeton(J2);
        } //Et ce, 21 fois
        
        initialiserPartie(); //J'initialise la grille
        
        grilledejeu.afficherGrilleSurConsole(); //On affiche la grille de départ

        Random joueurquicommence = new Random(); //On tire au sort le joueur qui jouera en premier
        
        int premiertour = joueurquicommence.nextInt(1);
        int numerojeton1 = 0; //Initialise les jetons qui seront joués  par les joueurs
        int numerojeton2 = 0; 
        //On commence le jeu
        
        while (grilledejeu.etreGagnantePourJoueur(joueur1) == false && grilledejeu.etreGagnantePourJoueur(joueur2) == false && grilledejeu.etreRemplie() == false) { //Boucle pour faire joueur les joueurs tour par tour
            
            if ( premiertour == 0) { //cette boucle permet de faire jouer le joueur 1
                System.out.println("\n\nC'est au tour de " + joueur1.nom);
                System.out.println("\n\n Choississez l'action que vous souhaitez faire : \n\n1)Placer un jeton\n2)Placer un Désintégrateur\n3)Récupérer un jeton\n\n");
                int choix = sc.nextInt();
                
                while (choix !=1 && choix != 2 && choix != 3) { //On vérifie que la saisie de l'utilisateur est correcte
                    System.out.println("\n\n Votre saisie n'est pas bonne. Tapez 1, 2 ou 3 ");
                    choix = sc.nextInt();
                }
                
               while (choix == 2 && joueur1.nombreDesintegrateurs ==0) {
                   System.out.println("\n\n Vous n'avez pas de désintégrateur actuellement. Tapez 1 ou 3 ");
                    choix = sc.nextInt();
               }
                
                //On traite trois par trois
                
                if (choix == 1){
                    
                    System.out.println("\n\n Choississez la colonne dans laquelle vous souhaitez déposer un jeton"); //On lui demande la colonne 
                    int colonne = sc.nextInt();
                    
                    
                    Jeton jeton1 = joueur1.ListeJetons[numerojeton1]; //On sélectionne le jeton qu'il va jouer
                    grilledejeu.ajouterJetonDansColonne(jeton1, colonne-1); //On le place dans la colonne
                    joueur1.ListeJetons[numerojeton1] = null; //On supprime le jeton de sa liste
                    
                    for (int ligne = 0; ligne < 6; ligne++) {
                        grilledejeu.Cellule[ligne][colonne-1].activerTrouNoir(); //On vérifie si le jeton est placé sur un trou noir. Si oui, on le supprime
                        if (grilledejeu.Cellule[ligne][colonne-1].recupererDesintegrateur() == true) {
                            joueur1.obtenirDesintegrateur(1);
                        } 
                        
                    }
                    
                    numerojeton1 +=1; //Ligne essentielle pour les prochains tours du joueur
                    
                    
                } else if (choix == 2) {
                    
                    
                    System.out.println("\n\n Indiquer la ligne et la colonne où vous souhaitez désintégrer votre jeton"); //il choisit le jeton à récupérer
                    
                    System.out.println("\nColonne ?");
                    int colonne1 = sc.nextInt();
                    System.out.println("\nLigne ?");
                    int ligne1 = sc.nextInt();
                            
                    while (grilledejeu.Cellule[ligne1-1][colonne1-1].jetonCourant != null){ //Vérifie qu'il choisit un jeton et non une case vide
                        
                        System.out.println("\n\n Veuillez choisir un jeton et non une case vide");
                    
                        System.out.println("\nColonne ?");
                        colonne1 = sc.nextInt();
                        System.out.println("\nLigne ?");
                        ligne1 = sc.nextInt();
                    
                    }
                    
                    joueur1.utiliserDesintegrateur(1); //On utilise le désintégrateur
                    
                    
                    grilledejeu.tasserGrille(ligne1-1, colonne1-1); //On tasse la grille en supprimant le jeton qui a été retiré
                    
                    
                } else { //Il récupère son jeton
                    
                    System.out.println("\n\n Indiquer la ligne et la colonne où vous souhaitez récupérer votre jeton"); //il choisit le jeton à récupérer
                    
                    System.out.println("\nColonne ?");
                    int colonne1 = sc.nextInt();
                    System.out.println("\nLigne ?");
                    int ligne1 = sc.nextInt();
                            
                    while (grilledejeu.Cellule[ligne1-1][colonne1-1].jetonCourant.couleur != joueur1.Couleur){ //Vérifie qu'il choisit un bon jeton
                        
                        System.out.println("\n\n Veuillez choisir un bon jeton disponible qui vous appartient");
                    
                        System.out.println("\nColonne ?");
                        colonne1 = sc.nextInt();
                        System.out.println("\nLigne ?");
                        ligne1 = sc.nextInt();
                    
                    }
                    
                    Jeton jetonrecuperer = grilledejeu.recupererJeton2(ligne1-1, colonne1-1); //On récupère la référence du Jeton
                    joueur1.ListeJetons[numerojeton1+1]= jetonrecuperer; //On le reinjecte dans la liste du joueur
                    
                    grilledejeu.tasserGrille(ligne1-1, colonne1-1); //On tasse la grille en supprimant le jeton qui a été retiré
                    
                    numerojeton1 -=1;
                } 
                    
                
                premiertour = 1;
                
            } else { //Cette boucle permet de faire jouer le joueur 2
                System.out.println("\n\nC'est au tour de " + joueur2.nom);
                System.out.println("\n\n Choississez l'action que vous souhaitez faire : \n\n1)Placer un jeton\n2)Placer un Désintégrateur\n3)Récupérer un jeton\n\n");
                int choix = sc.nextInt();
                
                while ((choix !=1 || choix != 2 || choix != 3) || (choix ==2 && joueur1.nombreDesintegrateurs ==0)) { //On vérifie que la saisie de l'utilisateur est correcte
                    System.out.println("\n\n Votre saisie n'est pas bonne ou alors vous n'avez pas de désintégrateur à votre disposition. Tapez 1, 2 ou 3 ");
                    choix = sc.nextInt();
                }
                
               
                
                //On traite trois par trois
                
                if (choix == 1) {
                    
                    System.out.println("\n\n Choississez la colonne dans laquelle vous souhaitez déposer un jeton"); //On lui demande la colonne 
                    int colonne = sc.nextInt();
                    
                    
                    Jeton jeton2 = joueur2.ListeJetons[numerojeton2]; //On sélectionne le jeton qu'il va jouer
                    grilledejeu.ajouterJetonDansColonne(jeton2, colonne-1); //On le place dans la colonne
                    joueur2.ListeJetons[numerojeton2] = null; //On supprime le jeton de sa liste
                    
                    for (int ligne = 0; ligne < 6; ligne++) {
                        grilledejeu.Cellule[ligne][colonne-1].activerTrouNoir(); //On vérifie si le jeton est placé sur un trou noir. Si oui, on le supprime
                        if (grilledejeu.Cellule[ligne][colonne-1].recupererDesintegrateur() == true) {
                            joueur2.obtenirDesintegrateur(1);
                        } 
                        
                    }
                    
                    numerojeton2 +=1; //Ligne essentielle pour les prochains tours du joueur
                    
                    
                } else if (choix == 2) {
                    
                    
                    System.out.println("\n\n Indiquer la ligne et la colonne où vous souhaitez désintégrer votre jeton"); //il choisit le jeton à récupérer
                    
                    System.out.println("\nColonne ?");
                    int colonne1 = sc.nextInt();
                    System.out.println("\nLigne ?");
                    int ligne1 = sc.nextInt();
                            
                    while (grilledejeu.Cellule[ligne1-1][colonne1-1].jetonCourant != null){ //Vérifie qu'il choisit un jeton
                        
                        System.out.println("\n\n Veuillez choisir un jeton et non une case vide");
                    
                        System.out.println("\nColonne ?");
                        colonne1 = sc.nextInt();
                        System.out.println("\nLigne ?");
                        ligne1 = sc.nextInt();
                    
                    }
                    
                    joueur2.utiliserDesintegrateur(1); //On utilise le désintégrateur
                    
                    
                    grilledejeu.tasserGrille(ligne1-1, colonne1-1); //On tasse la grille en supprimant le jeton qui a été retiré
                    
                    
                } else { //Il récupère son jeton
                    
                    System.out.println("\n\n Indiquer la ligne et la colonne où vous souhaitez récupérer votre jeton"); //il choisit le jeton à récupérer
                    
                    System.out.println("\nColonne ?");
                    int colonne1 = sc.nextInt();
                    System.out.println("\nLigne ?");
                    int ligne1 = sc.nextInt();
                            
                    while (grilledejeu.Cellule[ligne1-1][colonne1-1].jetonCourant.couleur != joueur2.Couleur){ //Vérifie qu'il choisit un bon jeton
                        
                        System.out.println("\n\n Veuillez choisir un bon jeton disponible qui vous appartient");
                    
                        System.out.println("\nColonne ?");
                        colonne1 = sc.nextInt();
                        System.out.println("\nLigne ?");
                        ligne1 = sc.nextInt();
                    
                    }
                    
                    Jeton jetonrecuperer = grilledejeu.recupererJeton2(ligne1-1, colonne1-1); //On récupère la référence du Jeton
                    joueur2.ListeJetons[numerojeton2+1]= jetonrecuperer; //On le reinjecte dans la liste du joueur
                    
                    grilledejeu.tasserGrille(ligne1-1, colonne1-1); //On tasse la grille en supprimant le jeton qui a été retiré
                    
                    numerojeton2 -=1;
                }
                premiertour = 0;
            }
            
            grilledejeu.afficherGrilleSurConsole();
            
        }
        
        if (grilledejeu.etreGagnantePourJoueur(joueur1) == true) {
            System.out.println("\n\n BRAVO A " + joueur1.nom + " !");
        } else if (grilledejeu.etreGagnantePourJoueur(joueur2) == true) {
            System.out.println("\n\n BRAVO A " + joueur2.nom + " !");
        } else {
            System.out.println("\n\n BRAVO AUX DEUX JOUEURS POUR L'ÉGALITÉ");
        }
        
        
    }
        
        
        
    }
    
    
    
    

