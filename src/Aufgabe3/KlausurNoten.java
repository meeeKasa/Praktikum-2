package Aufgabe3;

/*
Eine Klausur wurde geschrieben. Prof. Algo Rithmus hat sie bewertet und muss nun noch den
Notenspiegel, die Durchschnittsnote und die Durchfallquote ausgeben.

Durchgefallen ist, wer
eine 5 bekommen hat. (Es gibt nur die Noten 1 bis 5).

Schreiben Sie ein C-Programm, das per Benutzereingabe die Anzahl der jeweiligen Noten in
ein Array speichert. Anschließend sollen die Werte aus dem Array gelesen und formatiert in
einer Tabelle ausgegeben werden.

Außerdem werden die Durchschnittsnote und die
Durchfallquote in Prozent berechnet.

Hinweis: Benutzen Sie für die Ein- sowie die Ausgabe jeweils eine Schleife und definieren Sie
die Größe des Arrays als Konstante.

Die Ausgabe des Programms sollte in etwa so aussehen:

Programm Notenspiegel
Bitte geben Sie die Anzahl der Arbeiten mit der Note 1 ein: ___
…
Bitte geben Sie die Anzahl der Arbeiten mit der Note 5 ein: ___

Der Notenspiegel sieht dann so aus:

Note 1 2 3 4 5 Gesamt
Anzahl
Durchschnittsnote: 2.9 (als Beispielwert)
Durchfallquote: 52.5 % (als Beispielwert)
(Alles in Java !)
*/


import java.util.Scanner;


public class KlausurNoten {
    // Konstante für die Anzahl der Noten
    public static final int NUM_NOTES = 5;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] gradesCount = new int[NUM_NOTES + 1]; // Array zur Speicherung der Anzahl der Noten


        // Eingabe der Anzahl der Arbeiten für jede Note
        for (int i = 1; i <= NUM_NOTES; i++) {
            System.out.printf("Bitte geben Sie die Anzahl der Arbeiten mit der Note %d ein: ", i);
            gradesCount[i] = scanner.nextInt();
        }


        // Berechnung der Gesamtzahl der Arbeiten, der Durchschnittsnote und der Durchfallquote
        int totalStudents = 0;
        int totalSum = 0;
        int failedStudents = 0;


        for (int i = 1; i <= NUM_NOTES; i++) {
            totalStudents += gradesCount[i];
            totalSum += gradesCount[i] * i;
            if (i == 5) {
                failedStudents += gradesCount[i];
            }
        }


        double averageGrade = (double) totalSum / totalStudents;
        double failRate = (double) failedStudents / totalStudents * 100;


        // Ausgabe des Notenspiegels
        System.out.println("\nDer Notenspiegel sieht dann so aus:");
        System.out.printf("%-8s", "Note");
        for (int i = 1; i <= NUM_NOTES; i++) {
            System.out.printf("%4d", i);
        }
        System.out.printf("%8s\n", "Gesamt");


        System.out.printf("%-8s", "Anzahl");
        for (int i = 1; i <= NUM_NOTES; i++) {
            System.out.printf("%4d", gradesCount[i]);
        }
        System.out.printf("%8d\n", totalStudents);


        // Ausgabe der Durchschnittsnote und der Durchfallquote
        System.out.printf("Durchschnittsnote: %.2f\n", averageGrade);
        System.out.printf("Durchfallquote: %.2f %%\n", failRate);


        // Scanner schließen
        scanner.close();
    }
}

