public class HeapSort {


    // Función principal para ordenar el arreglo usando Heap Sort recursivo

    //                                {12, 11, 13, 5, 6, 7}

    public static void ordenarConHeapSort(int[] arreglo) {
        int tamaño = arreglo.length;

        // Construir el heap (convertir el arreglo en un heap)
        //       {12, 11, 13, 5, 6, 7}    6               2
        construirHeapRecursivo(arreglo, tamaño, tamaño / 2 - 1);

        // Extraer los elementos del heap uno por uno, ordenándolos
        ordenarHeapRecursivo(arreglo, tamaño);
    }




    // Función recursiva para construir el heap
    //                                    {12, 11, 13, 5, 6, 7}      6           2
    private static void construirHeapRecursivo(int[] arreglo, int tamaño, int indice) {
        // Caso base: Si el índice es negativo, hemos terminado de construir el heap
        if (indice < 0) {
            return;
        }

        // Restaurar la propiedad del heap en el subárbol con raíz en el índice
        //         {12, 11, 13, 5, 6, 7}   6       2
        restaurarHeapRecursivo(arreglo, tamaño, indice);

        // Llamada recursiva para el siguiente nodo (movemos hacia la raíz)
        construirHeapRecursivo(arreglo, tamaño, indice - 1);
    }




    // Función recursiva para restaurar la propiedad del heap en un subárbol con raíz en el índice
    //                                    {12, 11, 13, 5, 6, 7}      6           2
    private static void restaurarHeapRecursivo(int[] arreglo, int tamaño, int indice) {
        int mayor = indice; // Inicializamos el mayor como la raíz
        int hijoIzquierdo = 2 * indice + 1; // Hijo izquierdo
        int hijoDerecho = 2 * indice + 2; // Hijo derecho

        // Si el hijo izquierdo es mayor que la raíz
        if (hijoIzquierdo < tamaño && arreglo[hijoIzquierdo] > arreglo[mayor]) {
            mayor = hijoIzquierdo;
        }

        // Si el hijo derecho es mayor que el mayor actual
        if (hijoDerecho < tamaño && arreglo[hijoDerecho] > arreglo[mayor]) {
            mayor = hijoDerecho;
        }

        // Si el mayor no es la raíz, intercambiar y continuar con restaurarHeapRecursivo
        if (mayor != indice) {
            intercambiar(arreglo, indice, mayor);

            // Llamar recursivamente a restaurarHeapRecursivo sobre el subárbol afectado
            restaurarHeapRecursivo(arreglo, tamaño, mayor);
        }
    }




    // Función recursiva para ordenar el heap, moviendo el mayor elemento al final
    private static void ordenarHeapRecursivo(int[] arreglo, int tamaño) {
        // Caso base: Si el tamaño es 1 o menor, no hay nada más que ordenar
        if (tamaño <= 1) {
            return;
        }

        // Mover la raíz (el mayor elemento) al final del arreglo
        intercambiar(arreglo, 0, tamaño - 1);

        // Llamar a restaurarHeapRecursivo en el heap reducido
        restaurarHeapRecursivo(arreglo, tamaño - 1, 0);

        // Llamar recursivamente a ordenarHeapRecursivo sobre el heap restante
        ordenarHeapRecursivo(arreglo, tamaño - 1);
    }




    // Función auxiliar para intercambiar elementos en el arreglo
    private static void intercambiar(int[] arreglo, int i, int j) {
        int temporal = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temporal;
    }




    // Función para imprimir el arreglo
    public void imprimirArregloRecursivo(int[] arreglo, int indice) {
        if (indice == arreglo.length) {
            return;
        }

        System.out.print(arreglo[indice] + " ");

        imprimirArregloRecursivo(arreglo, indice + 1);
    }

}
