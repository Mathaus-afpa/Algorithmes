import java.text.DecimalFormat;
import java.util.Scanner;

public class Utilitaires {
    //region variables
    private static Scanner scanner = new Scanner(System.in);
    //endregion
    //region fonctions privées
    /**
     * Ecrit un texte de présentation dans la console s'il n'est pas null ou vide.
     * @param text Texte de présentation.
     */
    private static  void writeIf(String text) {
        if (!((text == null || text.isEmpty()))) {
            System.out.println(text);
        }
    }
    /**
     * Créé une indentation.
     */
    private static void writeIndent() {
        System.out.print("\t> ");
    }
    //endregion
    //region fonctions publiques
    /**
     * Demande une entrée utilisateur de type ligne.
     * @param text Texte de présentation.
     * @return Ligne lue dans la console.
     */
    public static String readLine(String text) {
        writeIf(text);
        writeIndent();
        return scanner.nextLine();
    }
    /**
     * Demande une entrée utilisateur de type double.
     * @param text Texte de présentation.
     * @return Nombre lu.
     */
    public static double askDouble(String text) {
        double number;
        writeIf(text);
        writeIndent();
        try {
            number = scanner.nextDouble();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Ce n'est pas un nombre correct.");
            scanner.nextLine();
            number = askDouble(text);
        }
        return number;
    }
    /**
     * Formatte les solutions d'équation du 2nd degré.
     * @param a
     * @param b
     * @param c
     * @param delta
     * @return Chaine de caractère formattée.
     */
    public static String solutionFormat(double a, double b, double c, double delta) {
        StringBuilder finalString = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double diviseur = 2 * a;
        if (delta == 0) {
            finalString.append(decimalFormat.format(-b));
        } else {
            double racine = Math.sqrt(Math.abs(delta));
            racine = (delta < 0) ? -racine : racine;
            if (racine == Math.floor(racine)) {
                finalString.append(decimalFormat.format(-b + racine));
            } else {
                finalString.append(decimalFormat.format(-b));
                finalString.append("\u221A(");
                finalString.append(decimalFormat.format(Math.abs(delta)));
                finalString.append(")");
            }
        }
        finalString.append(" / ");
        finalString.append(decimalFormat.format(diviseur));
        return finalString.toString();
    }
    /**
     * Demande une entrée utilisateur de type double.
     * @param text Texte de présentation.
     * @return Nombre lu.
     */
    public static OPERATEURS askOperator(String text) {
        String operatorString;
        char operator;
        String matchOperator = "+-*/";
        writeIf(text);
        writeIndent();
        operatorString = scanner.nextLine();
        if (operatorString.length() > 1) return  null;
        operator = operatorString.charAt(0);
        if (matchOperator.indexOf(operator) != -1) {
            switch (operator) {
                case '+': return OPERATEURS.ADDITION;
                case '-': return OPERATEURS.SOUSTRACTION;
                case '/': return OPERATEURS.DIVISION;
                case '*': return OPERATEURS.MULTIPLICATION;
                default :  return  null;
            }
        }
        return  null;
    }
    //endregion
}