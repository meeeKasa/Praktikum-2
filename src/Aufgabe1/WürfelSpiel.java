package Aufgabe2;

/*


Sie spielen ein Würfelspiel mit 5 Würfeln. Schreiben Sie ein C-Programm, das aus 5
eingelesenen Augenzahlen ermittelt, ob eine der folgenden Figuren gewürfelt wurde und wenn
ja, welche.


GRAND gleiche Augenzahl auf allen 5 Würfeln
POKER gleiche Augenzahl auf 4 Würfeln
FULL HOUSE 3 gleiche und 2 gleiche Augenzahlen
Hinweis: Benutzen Sie für das Abspeichern der Augenzahlen ein Array. Definieren Sie die
Größe als Konstante.
Programm Würfelspiel
Würfel 1: ___
Würfel 2: ___
.
.
.
Würfel 5: ___
Die Ausgabe sieht dann so aus:
Es wurde gewürfelt:
Würfel 1 2 3 4 5
Augenzahl x x x x x


Gewonnen! Grand! (als Beispiel) bzw.
Leider nichts gewonnen!
(Alles in Java !)

*/




import java.util.Scanner;


public class WürfelSpiel {
    // Größe des Würfel-Arrays
    public static final int ANZAHL_WUERFEL = 5;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] wuerfel = new int[ANZAHL_WUERFEL];


        // Würfel eingeben
        for (int i = 0; i < ANZAHL_WUERFEL; i++) {
            System.out.print("Würfel " + (i + 1) + ": ");
            wuerfel[i] = scanner.nextInt();
        }


        // Ergebnis anzeigen
        System.out.println("Es wurde gewürfelt:");
        System.out.print("Würfel  ");
        for (int i = 1; i <= ANZAHL_WUERFEL; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.print("Augenzahl ");
        for (int w : wuerfel) {
            System.out.print(w + " ");
        }
        System.out.println();


        // Häufigkeiten der Augenzahlen zählen
        int[] counts = new int[7]; // Index 0 wird nicht verwendet
        for (int w : wuerfel) {
            counts[w]++;
        }


        // Figuren überprüfen und Ergebnis ausgeben
        if (istGrand(counts)) {
            System.out.println("Gewonnen! Grand!");
        } else if (istPoker(counts)) {
            System.out.println("Gewonnen! Poker!");
        } else if (istFullHouse(counts)) {
            System.out.println("Gewonnen! Full House!");
        } else {
            System.out.println("Leider nichts gewonnen!");
        }
    }


    // Überprüfen, ob Grand geworfen wurde
    public static boolean istGrand(int[] counts) {
        for (int count : counts) {
            if (count == 5) {
                return true;
            }
        }
        return false;
    }


    // Überprüfen, ob Poker geworfen wurde
    public static boolean istPoker(int[] counts) {
        for (int count : counts) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }


    // Überprüfen, ob Full House geworfen wurde
    public static boolean istFullHouse(int[] counts) {
        boolean dreiGleiche = false;
        boolean zweiGleiche = false;
        for (int count : counts) {
            if (count == 3) {
                dreiGleiche = true;
            } else if (count == 2) {
                zweiGleiche = true;
            }
        }
        return dreiGleiche && zweiGleiche;
    }
}
