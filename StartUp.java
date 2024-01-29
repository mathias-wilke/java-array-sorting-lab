import java.util.Random;

public class StartUp {

    public static void main(String[] args) {
        ArrayVisualizer visualizer = new ArrayVisualizer();
        visualizer.setVisible(true);

        // Erstellen eines Arrays mit 100 zufälligen Werten zwischen 1 und 100
        int[] sampleArray = new int[100];
        Random random = new Random();
        for (int i = 0; i < sampleArray.length; i++) {
            sampleArray[i] = random.nextInt(100) + 1; // Zufallszahlen zwischen 1 und 100
        }

        // Anzeigen des Arrays im Visualizer
        visualizer.drawIntArray(sampleArray);
        
        //Beispiel für ein Delay
        delay(100);
        
        //Beispiel für eine Hervorhebung
        visualizer.highlightIndex(0);
        visualizer.highlightIndex(1);

        // Beispielaufrufe der Sortiermethoden (auskommentiert)
        bubbleSort(sampleArray, visualizer);
        // selectionSort(sampleArray, visualizer);
        // insertionSort(sampleArray, visualizer);
        // mergeSort(sampleArray, visualizer);
        // quickSort(sampleArray, visualizer);
    }

    public static void bubbleSort(int[] array, ArrayVisualizer visualizer) {
    	// Implementierung des Bubble-Sort-Algorithmus
    }

    public static void selectionSort(int[] array, ArrayVisualizer visualizer) {
        // Implementierung des Selection-Sort-Algorithmus
    }

    public static void insertionSort(int[] array, ArrayVisualizer visualizer) {
        // Implementierung des Insertion-Sort-Algorithmus
    }

    public static void mergeSort(int[] array, ArrayVisualizer visualizer) {
        // Implementierung des Merge-Sort-Algorithmus
    }

    public static void quickSort(int[] array, ArrayVisualizer visualizer) {
        // Implementierung des Quick-Sort-Algorithmus
    }

    // Weitere Sortieralgorithmen können hier hinzugefügt werden
    
    private static void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread wurde unterbrochen");
        }
    }



}