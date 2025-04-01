import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();

        int[] arreglo = {12, 11, 13, 5, 6, 7};

        System.out.println("Arreglo original:");
        heapSort.imprimirArregloRecursivo(arreglo, 0);
        System.out.println();

        heapSort.ordenarConHeapSort(arreglo);

        System.out.println("Arreglo ordenado:");
        heapSort.imprimirArregloRecursivo(arreglo, 0);
        System.out.println();
    }
}