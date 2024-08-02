public enum EXOS {
    //region Enumération EXOS
    EXIT(0),
    EXO1(1),
    EXO2(2),
    EXO3(3),
    EXO4(4),
    EXO5(5),
    EXO6(6),
    EX07(7);

    /**
     * Valeur associée à une enumération de la liste.
     * @param value
     */
    EXOS(int value) {
        numeric = value;
    }
    //endregion
    //region variables
    public final int numeric;
    //endregion
    //region fonctions
    /**
     * Récupère l'enum correspondant à une valeur.
     * @param value Numéro ou nom d'un exercices.
     * @return null ou l'enum EXOS correspondant à la valeur transmise.
     */
    public static EXOS fromString(String value) {
        EXOS exo = null;
        try {
            int numericValue = Integer.parseInt(value);
            for (EXOS e : EXOS.values()) {
                if (e.numeric == numericValue) {
                    return e;
                }
            }
        } catch (Exception e) {} // On ne traite pas mais on controle l'arret du programme
        try {
            exo = EXOS.valueOf(value.toUpperCase());
            return exo;
        } catch (Exception e) {} // On ne traite pas mais on controle l'arret du programme
        return exo;
    }
    //endregion
}