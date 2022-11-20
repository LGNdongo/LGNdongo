
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
  * Programme permettant de corriger l'indentation d'un algorithme
  * écrit en pseudocode se trouvant dans un fichier texte.
  *
  * De plus, le programme permet de formater, soit en majuscules,
  * soit en minuscules, tous les mots réservés du langage pseudocode.
  *
  * INF1120 A22 TP2
  * @author LOUIS-GABIN NDONGO BODO
 * @version NDOL14349609_INF1120_TP2_A22
  */

public class IndenteurPseudocode {

     public final static String MSG_PRESENTATION = "Ce programme permet de corriger l'indentation d'un algorithme ecrit en pseudocode.\n";
     public final static String MSG_MENU = "----\n" +
                                         "MENU\n" +
                                         "----\n" +
                                         "1. Indenter pseudocode\n" +
                                         "2. Quitter\n" +
                                         "\n" +
                                         "Entrez votre choix : ";
     public final static String MSG_ERREUR_CHOIX_MENU = "ERREUR ! Choix invalide. Recommencez...\n";
     public final static String MSG_CHEMIN_FICHIER = "Entrez le chemin du fichier de pseudocode : ";
     public final static String MSG_ERREUR_CHOIX_FICHIER = "ERREUR ! Chemin de fichier invalide. Recommencez...\n";
     public final static String MSG_MOTS_RESERVES = "Mots reserves : en (m)inuscules ou en (M)ajuscules : ";
     public final static String MSG_ERREUR_CHOIX_MOTS_RESERVES = "ERREUR ! Entrez m ou M. Recommencez...";
     public final static String LIGNE_TIRETS = "--------------------\n";
     public final static String MSG_ENTREE_CONTINUER = "Tapez <ENTREE> pour continuer...";
     public final static String MSG_FIN = "\nF I N   N O R M A L E   D U   P R O G R A M M E";

     public final static List<String> MOTS_RESERVES = Arrays.asList(
                                                             "debut",
                                                             "fin",
                                                             "tant",
                                                             "que",
                                                             "si",
                                                             "alors",
                                                             "sinon",
                                                             "faire",
                                                             "afficher",
                                                             "ecrire",
                                                             "lire",
                                                             "saisir" );
     /**
      * cette methode permet d'afficher la presentation du programme
      * afficher le menu principale du programme 
      * demande a l'utilisateur de faire un choix dans le menu
      * appel la methode de validation entree par l'utilisateur 
      */

    public static void work() {
         String choixMenu;
         String choix;
         String contenuFic;

         System.out.println(MSG_PRESENTATION);
         System.out.println();
         do {
             System.out.println();
             // validation du choix du menu
             choixMenu = validationChoixMenu();
             if (choixMenu.equals("1")) {
                 // Validation du fichier
                 contenuFic = validationFichier();

                 // validation du choix de indentation
                 choix = validationChoixIndentation();

                 // indention du pseudocode
                 // TODO: à finir
                 if (choix.equals("m")) {
                     contenuFic = contenuFic.toLowerCase(Locale.ROOT);
                 } else {
                     contenuFic = contenuFic.toUpperCase(Locale.ROOT);
                 }

                 // affiche du résultat
                 System.out.println();
                 System.out.println(LIGNE_TIRETS);
                 System.out.println(contenuFic);
                 System.out.println(LIGNE_TIRETS);
                 System.out.println();
                 System.out.println(MSG_ENTREE_CONTINUER);
                 Clavier.lireFinLigne();
             }

         } while (!choixMenu.equals("2"));
         System.out.println(MSG_FIN);
    }
  
    
     /**
      * cette methode permet de faire la validation du choix menu entree par utilisateur
      * @return choixMenu 
      */
    public static String validationChoixMenu() {
         String choixMenu;
         do {
             System.out.print(MSG_MENU);
             choixMenu = Clavier.lireString();
             if (choixMenu == null || !(choixMenu.equals("1") || choixMenu.equals("2"))) {
                 System.out.println();
                 System.out.println(MSG_ERREUR_CHOIX_MENU);
             }
         } while (choixMenu == null || !(choixMenu.equals("1") || choixMenu.equals("2")));
         return choixMenu;
    }

    
     /**
      * cette methode permet de valider le chemin du fichier entree par l'utilisateur
      * @return contenuFic
      */
    public static String validationFichier() {
         String choix;
         String contenuFic;
         do {
             System.out.print(MSG_CHEMIN_FICHIER);
             choix = Clavier.lireString();
             contenuFic = TP2Utils.lireFichierTexte(choix);
             if (contenuFic == null) {
                 System.out.println();
                 System.out.print(MSG_ERREUR_CHOIX_FICHIER);
             }
         } while (contenuFic == null);
         return contenuFic;
    }

    
    /**
     * cette methode permet de valider les choix dans l'option choix d'indentation
     * il permet de verifier que la valeur entrer par l'utilisateur soit m (minuscule) ou M (majuscule) 
     * @return choix
     */
    public static String validationChoixIndentation() {
         String choix;
         do {
             System.out.print(MSG_MOTS_RESERVES);
             choix = Clavier.lireString();
             if (!(choix.equals("m") || choix.equals("M") )) {
                 System.out.println();
                 System.out.print(MSG_ERREUR_CHOIX_MOTS_RESERVES);
             }
         } while (!(choix.equals("m") || choix.equals("M")));
         return choix;
    }

     public static void main(String[] args) {
            
          work(); 
     }
}
 
        