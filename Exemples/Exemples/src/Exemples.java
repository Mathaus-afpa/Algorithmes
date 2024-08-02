import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exemples {
    //region main
    public static void main(String[] args) {
        Exemples exemples = new Exemples();
        exemples.start();
    }
    //endregion
    //region variables
    private Scanner scanner = new Scanner(System.in);
    private final int LIGNE = 5;
    private final int COLONNE = 9;
    private int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
    //endregion
    //region Fonctions Publiques
    public void start() {
        EXOS exo = null;
        do {
            String value = Utilitaires.readLine(String.format("Liste des exercices : %s", Arrays.toString(EXOS.values())));
            exo = EXOS.fromString(value);
            if (exo == null) {
                System.out.println("Je ne connais pas cet exercice.");
            } else if (EXOS.EXIT.equals(exo))  {
                System.out.println("Au revoir.");
            } else {
                System.out.printf("Initialisation de l'exercice : %s.", exo);
                System.out.println();
                runExercices(exo);
            }
        } while (!EXOS.EXIT.equals(exo));
    }
    //endregion
    //region Fonctions Privées
    private void runExercices(EXOS exo) {
        switch (exo) {
            case EXIT: System.exit(0);
            case EXO1:
                exercice1();
                break;
            case EXO2:
                exercice2();
                break;
            case EXO3:
                exercice3();
                break;
            case EXO4:
                exercice4();
                break;
            case EXO5:
                exercice5();
                break;
            case EXO6:
                exercice6();
                break;
            case EX07:
                exercice7();
                break;
            default: break;
        }
    }
    /**
     * Equation du seconde degré
     */
    private void exercice1() {
        double a, b, c, delta;
        do {
            a = Utilitaires.askDouble("Entrez la valeur de a (différent de 0) :");
        } while (a == 0);
        b = Utilitaires.askDouble("Entrez la valeur de b :");
        c = Utilitaires.askDouble("Entrez la valeur de c :");
        delta = (int) Math.pow(b, 2) - (4 * a * c);
        if (delta == 0) {
            double result = -b / (2 * a);
            String text = String.format("Il n'y a qu'une solution à l'équation : %s soit %.2f.", Utilitaires.solutionFormat(a, b, c, delta), result);
            System.out.println(text);
        } else if (delta > 0) {
            System.out.println("Il y a deux solution à l'équation :");
            Utilitaires.solutionFormat(a, b, c, delta);
            double result = (-b - Math.sqrt(delta)) / (2 * a);
            String text = String.format("La première solution est %s soit %.2f.", Utilitaires.solutionFormat(a, b, c, -delta), result);
            System.out.println(text);
            result = (-b + Math.sqrt(delta)) / (2 * a);
            text = String.format("La seconde solution est %s soit %2f.", Utilitaires.solutionFormat(a, b, c, delta), result);
            System.out.println(text);
        } else {
            System.out.println("Il n'y a pas de solution à l'équation.");
        }
    }
    /**
     * Puissance
     */
    private void exercice2() {
        double nombre, puissance;
        nombre = Utilitaires.askDouble("Choisissez un nombre :");
        puissance = Utilitaires.askDouble("Choisissez un puissance :");
        //Entiers positif uniquement ???*
        //todo: remove this if both autorized
        nombre = (nombre < 0) ? -nombre : nombre;
        puissance = (puissance < 0) ? -puissance : puissance;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println(decimalFormat.format(puissance(nombre, puissance))); // function puissante = (nombre, puissance) => { Math.pow(nombre, puissance); }
    }
    private long puissance(double nombre, double puissance) {
        return (long) Math.pow(nombre, puissance);
    }
    /**
     * Dichotomie
     */
    private void exercice3() {
        System.out.println(Arrays.toString(array));
        int num = (int) Utilitaires.askDouble("Entrez un nombre (seule la partie entière sera conservée : ");
        int position = rechercherEntier(array, num);
        if (position == -1) {
            System.out.println("Je ne l'ai pas trouvé dans le tableau.");
        } else {
            System.out.printf("J'en ai trouvé un à la position %d .", position);
        }
    }
    public static int rechercherEntier(int[] tab, int x) {
        int left = 0;
        int right = tab.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Évite l'overflow par (left + right) / 2

            if (tab[mid] == x) {
                return mid;
            } else if (tab[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    /**
     * Val
     */
    private void exercice4() {
        int taille = (int) Utilitaires.askDouble("Taille");
        writeArray(taille);
        lireMaxEntier();
    }
    private void writeArray(int taille) {
        Random random = new Random();
        array = new int[taille];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    private int getMax(int[] array) {
        //return Arrays.stream(array).max().orElseThrow(); best way ?
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    private void lireMaxEntier() {
        /* Méthode getMax
        System.out.printf("La plus grande valeur est %d . ", getMax(array));
        System.out.println();
         */
        System.out.printf("Je m'occupe de trier le tableau pour l'exercice 3.");
        exercice6();
        System.out.printf("Cela me permet de te dire que la plus grande valeur est %d . ", array[array.length - 1]);
        System.out.println();
    }
    /**
     * Table de Multiplication
     */
    private void exercice5() {
        int[][] multiplicationTable = writeTable();
        int x, y;
        boolean doItAgain = false;
        do {
            x = (int) Utilitaires.askDouble("Choisissez un nombre X:");
            y = (int) Utilitaires.askDouble("Choisissez un nombre Y:");
            // oupsi, pas prevu de control on force les valuers
            if (x < 0 || x > LIGNE) {
                x = (x < 0) ? -x : x;
                x = (x > LIGNE) ? LIGNE : x;
                System.out.printf("X a été tronqué à %d : ", x);
                System.out.println();
            }
            if (y < 0 || y > COLONNE) {
                y = (y < 0) ? -y : y;
                y = (y > COLONNE) ? COLONNE : y;
                System.out.printf("Y a été tronqué à %d : ", y);
                System.out.println();
            }
            y = (y < 0) ? -y : y;
            y = (y > COLONNE) ? COLONNE : y;
            int product = multiplicationTable[x][y];
            System.out.println(product);
            String a = Utilitaires.readLine("Refaire ?").toUpperCase();
            if (a.equals("Y") || a.equals("O") || a.equals("YES") || a.equals("OUI")) {
                doItAgain = true;
            } else {
                System.out.println("Au revoir.");
                doItAgain = false;
            }
        } while (doItAgain);
    }
    private int[][] writeTable() {
        int[][] multiplicationTable = new int [LIGNE+1][COLONNE+1];
        for (int i = 0 ; i <= LIGNE; i++) {
            for (int j = 0 ; j <= COLONNE; j++) {
                multiplicationTable[i][j] = (i) * (j);
            }
        }
        return  multiplicationTable;
    }
    /**
     * Tri par insertion
     */
    private void exercice6() {
        for (int i = 1; i < array.length; i++) {
            int elementToInsert = array[i];
            System.out.printf("Insert : %d", elementToInsert);
            moveElements(array, i, elementToInsert);
            System.out.println(" ----- ");
        }
    }
    public void moveElements(int[] array, int pos, int key) {
        System.out.println(" ...");
        for (int i = pos; i >= 0; i--) {
            if (i == 0 || key > array[i - 1]) {
                array[i] = key;
                break;
            }
            System.out.printf("Swap : %d ", array[i]);
            System.out.printf("et : %d", array[i - 1]);
            System.out.println();
            array[i] = array[i - 1];
        }
        System.out.println(" --- array at step : ");
        System.out.println(Arrays.toString(array));
        System.out.println(" --- ");
        System.out.println();
    }
    /**
     * Calculatrice
     */
    private void exercice7() {
        OPERATEURS operator;
        do {
            operator = Utilitaires.askOperator("Choisi une operation parmi : +, -, *, /.");
        } while (operator == null);
        double x = Utilitaires.askDouble("Choisissez un nombre X:");
        double y = Utilitaires.askDouble("Choisissez un nombre Y:");
        double result = 0;
        switch (operator) {
            case ADDITION -> result = calculer('+', x, y);
            case MULTIPLICATION -> result = calculer('*', x, y);
            case SOUSTRACTION -> result = calculer('-', x, y);
            case DIVISION -> result = calculer('/', x, y);
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.printf("Le résultat est : %s.", decimalFormat.format(result));
        System.out.println();
    }
    private double calculer(char operateur, double operande1, double operande2) {
        switch (operateur) {
            case '+': return operande1 + operande2;
            case '-': return operande1 - operande2;
            case '/': return operande1 / operande2;
            case '*': return operande1 * operande2;
            default: throw new IllegalArgumentException();
        }
    }
    //endregion
}