public class Quicksort {
    public static void Main(string[] args) {
        Quicksort test = new Quicksort();
        test.Start();
    }
    public void Start() {
        int[] test1 = {2, 5, 3, 7, 7, 6, 8, 9, 10, 13};
        int[] test2 = {2, 5, 3, 8, 6, 1, 9, 7, 4, 0, 12, 11, 10, 15, 13, 14};
        int[] test3 = {25, 50, 75, -100, 125, 150, 175, 200, -225, 250, 275, 300, 325, 350, -375};
        int[] test4 = {1, 2};
        int[] test5 = {2, 1};
        int[] test6 = {1, 2, 3};
        int[] test7 = {3, 2, 1};
        int[] test8 = {3, 2, 1};
        int[] test9 = {99, -88, 77, 66, 55, 44, 33, 22, 11, 0, 100, 200, 300, -400, 500};
        PrintTest(test1);
        PrintTest(test2);
        PrintTest(test3);
        PrintTest(test4);
        PrintTest(test5);
        PrintTest(test6);
        PrintTest(test7);
        PrintTest(test8);
        PrintTest(test9);
    }
    private void Sort(int[] tableau, int indexDebut, int indexFin) {
        if (!(indexFin - indexDebut < 1)) {
            int pivot = tableau[indexFin];
            int positionFinale = indexDebut;
            for (int i = indexDebut; i <= indexFin - 1; i++) {
                if (tableau[i] < pivot) {
                    Intervertir(tableau, positionFinale, i);
                    positionFinale++;
                }
            }
            Intervertir(tableau, positionFinale, indexFin);
            Sort(tableau, indexDebut, positionFinale- 1);
            Sort(tableau, positionFinale + 1, indexFin);
        }
    }
    private void Intervertir(int[] tableau, int indexDebut, int indexFin) {
        int temp = tableau[indexDebut];
        tableau[indexDebut] = tableau[indexFin];
        tableau[indexFin] = temp;
    }
    private void PrintTest(int[] tableau) {
        System.Console.WriteLine("Test !");
        System.Console.WriteLine("[{0}]", string.Join(", ", tableau));
        Sort(tableau, 0, tableau.Length - 1);
        System.Console.WriteLine("[{0}]", string.Join(", ", tableau));
    }
}