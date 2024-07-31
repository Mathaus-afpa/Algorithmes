public class Quicksort {
    public static void main(String[] args) {
        Quicksort test = new Quicksort();
        test.start();
    }
    public void start() {
        int[] test1 = {2, 5, 3, 7, 7, 6, 8, 9, 10, 13};
        int[] test2 = {2, 5, 3, 8, 6, 1, 9, 7, 4, 0, 12, 11, 10, 15, 13, 14};
        int[] test3 = {25, 50, 75, -100, 125, 150, 175, 200, -225, 250, 275, 300, 325, 350, -375};
        int[] test4 = {1, 2};
        int[] test5 = {2, 1};
        int[] test6 = {1, 2, 3};
        int[] test7 = {3, 2, 1};
        int[] test8 = {3, 2, 1};
        int[] test9 = {99, -88, 77, 66, 55, 44, 33, 22, 11, 0, 100, 200, 300, -400, 500};
        printTest(test1);
        printTest(test2);
        printTest(test3);
        printTest(test4);
        printTest(test5);
        printTest(test6);
        printTest(test7);
        printTest(test8);
        printTest(test9);
    }
    private void sort(int[] tableau, int indexDebut, int indexFin) {
        if (!(indexFin - indexDebut < 1)) {
            int pivot = tableau[indexFin];
            int positionFinale = indexDebut;
            for (int i = indexDebut; i <= indexFin - 1; i++) {
                if (tableau[i] < pivot) {
                    intervertir(tableau, positionFinale, i);
                    positionFinale++;
                }
            }
            intervertir(tableau, positionFinale, indexFin);
            sort(tableau, indexDebut, positionFinale- 1);
            sort(tableau, positionFinale + 1, indexFin);
        }
    }
    private void intervertir(int[] tableau, int indexDebut, int indexFin) {
                    int temp = tableau[indexDebut];
                    tableau[indexDebut] = tableau[indexFin];
                    tableau[indexFin] = temp;
    }
    private void printTest(int[] tableau) {
        System.out.println("Test !");
        System.out.println(java.util.Arrays.toString(tableau));
        sort(tableau, 0, tableau.length - 1);
        System.out.println(java.util.Arrays.toString(tableau));
    }
}