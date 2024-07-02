package Aufgabe4;

/*


Schreiben Sie ein C-Programm, das eine Liste ganzer Zahlen aufsteigend sortiert.


Implementieren Sie hierzu den Bubblesort-Algorithmus.


Der Algorithmus vergleicht immer
zwei nebeneinander liegende Elemente und vertauscht die beiden, falls das rechte kleiner ist als
das linke.


Der Name kommt daher, dass die großen Werte wie Blasen aufsteigen und nach
rechts wandern.


Definieren Sie, wie in der Vorlesung gezeigt, die Größe des Arrays als
Konstante. Überlegen Sie sich, welche Komplexität der Algorithmus hat (O-Notation).
(Alles in Java !)
*/

public class BubbleSort {
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap elements
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }


            }
        }


    }
    public static void main(String[] args) {
        int arr[] ={3,60,35,2,45,320,5};


        System.out.println("Array Before Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        bubbleSort(arr);//sorting array elements using bubble sort


        System.out.println("Array After Bubble Sort");
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }


    }
}

