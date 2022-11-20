
public class IndenteurPseudocodeV2 {

	
	public static String MSG_PRESENTATION = "Ce programme permet de corriger l'indentation d'un algorithme ecrit en pseudocode.\n"
			+ "----\n"
			+ "MENU\n"
			+ "----\n"
			+ "1. Indenter pseudocode 2. Quitter";
	public static String MSG_SOL_CHOIX_MENU = "Entrez votre choix :"; 
    public static String MSG_FIN_PROGRAM = "F I N   N O R M A L E   D U   P R O G R A M M E";
	
    public static void main(String[] args) {

        //declaration des variables 
        String choixMenu = " ";
        String cheminFic =  " ";
        String contentFic = " ";
        
        boolean finProgram = false;

        //validation du choix Menu
        do{
            System.out.println(MSG_PRESENTATION); 
            System.out.println(MSG_SOL_CHOIX_MENU);
            choixMenu =  Clavier.lireString();

            //validation de la chaine de caractere
            if(choixMenu.length() == 1){

                //validation du character 
                if(choixMenu == "1" || choixMenu == "2"){
                	finProgram = false; 
                }
            }else {
            	finProgram = true; 
            }
        }while(!finProgram);

        //condition fin programme 
        if(choixMenu == "2"){
            System.out.println(MSG_FIN_PROGRAM);
        }else{

            //affichage du menu indenter pseudocode
            
        }
        
    }
}