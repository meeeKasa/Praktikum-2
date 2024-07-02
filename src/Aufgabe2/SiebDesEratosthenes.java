package Aufgabe1;

/*
Schreiben Sie ein C-Programm, das die Primzahlen zwischen 2 bis maximal 1000 berechnet
und zwar nach der Methode „Sieb des Eratosthenes“ (3. Jahrhundert. v. Chr.):


Der Algorithmus berechnet für eine eingegebene natürliche Zahl (>1) alle Primzahlen bis einschließlich dieser
Zahl.


Für falsche oder gar keine Eingaben geben Sie bitte eine entsprechende Fehlermeldung
aus.


Überlegen Sie sich, welche Komplexität der Algorithmus hat (O-Notation).


Hinweis: Verwenden Sie ein int-Array, dessen Komponenten 0 oder 1 sein können. Das Ziel
besteht darin, dem i-ten Element den Wert 1 zuzuweisen, falls i eine Primzahl ist, und
andernfalls den Wert 0.


Dies wird erreicht, indem für jedes i alle Elemente des Arrays, die
einem beliebigen Vielfachen von i entsprechen, auf 0 gesetzt werden.


Danach wird das Array
nochmals durchlaufen, um alle gefundenen Primzahlen auszugeben.
(Alles in Java !)
*/




import java.util.Scanner;


    public class SiebDesEratosthenes {
        public static void main(String[] args) {
            // Scanner zum Lesen der Benutzereingabe
            Scanner scanner = new Scanner(System.in);
            System.out.println("Bitte geben Sie eine natürliche Zahl (>1) ein (maximal 1000):");


            // Überprüfen, ob die Eingabe eine ganze Zahl ist
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();


                // Überprüfen, ob die Zahl größer als 1 und maximal 1000 ist
                if (n > 1 && n <= 1000) {
                    // Array zur Markierung der Primzahlen
                    boolean[] isPrime = new boolean[n + 1];


                    // Initialisierung: Alle Zahlen als potentiell prim markieren
                    for (int i = 2; i <= n; i++) {
                        isPrime[i] = true;
                    }


                    // Sieb des Eratosthenes Algorithmus
                    for (int p = 2; p * p <= n; p++) {
                        // Wenn p eine Primzahl ist
                        if (isPrime[p]) {
                            // Markiere alle Vielfachen von p als nicht prim
                            for (int i = p * p; i <= n; i += p) {
                                isPrime[i] = false;
                            }
                        }
                    }


                    // Ausgabe der Primzahlen
                    System.out.println("Primzahlen bis " + n + ":");
                    for (int i = 2; i <= n; i++) {
                        if (isPrime[i]) {
                            System.out.print(i + " ");
                        }
                    }
                } else {
                    // Fehlermeldung für ungültige Zahlenbereiche
                    System.out.println("Bitte geben Sie eine natürliche Zahl größer als 1 und maximal 1000 ein.");
                }
            } else {
                // Fehlermeldung für ungültige Eingaben
                System.out.println("Ungültige Eingabe. Bitte geben Sie eine natürliche Zahl ein.");
            }


            // Scanner schließen
            scanner.close();
        }
    }

