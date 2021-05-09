/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compalgoritmosord;

import edu.princeton.cs.algs4.*;
import java.io.IOException;

/**
 * Esta classe é responsável por demonstrar os Algoritmos de Ordenação, 
 * comparando a quantidade de comparações e trocas realizadas por cada um com
 * uma mesma entrada.
 *
 * @author Emerson
 */
public class CompAlgoritmosOrd {
    private static Comparable vet[];
    
    public static void main(String[] args) throws IOException {
        // Número do nosso array para a ordenação
        int len = StdIn.readInt();
        
        // Cria o gráfico que irá exibir a ordenação
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        vet = new Comparable[len];
        
        // Comparable que irá guardar os valores originais
        Comparable aux[] = new Comparable[len];
        
        for(int i = 0; i < vet.length; i++){
            vet[i] = StdRandom.uniform( 0.0, 1.0 );
            aux[i] = vet[i];
        }
        
        StdOut.println("----------Selection Sort:----------");
        SelectionSort.sort( vet );
        StdOut.println();
        
        transVal(aux, vet);
        StdOut.println("----------Insertion Sort:----------");
        InsertionSort.sort( vet );
        StdOut.println();
        
        transVal(aux, vet);
        StdOut.println("----------Shell Sort:----------");
        ShellSort.sort( vet );
        StdOut.println();
        
        transVal(aux, vet);
        StdOut.println("----------Merge Sort:----------");
        MergeSort.sort( vet );
        StdOut.println();
        
        transVal(aux, vet);
        StdOut.println("----------Merge Sort (Bottom-Up):----------");
        MergeSortBU.sort( vet );
        StdOut.println();
        
        transVal(aux, vet);
        StdOut.println("----------Quick Sort:----------");
        QuickSort.sort( vet );
        StdOut.println();
        
    }
    
    // Resgata os valores originais do comparable
    private static void transVal(Comparable aux[], Comparable vet[]){
        for(int i = 0; i < vet.length; i++){
            vet[i] = aux[i];
        }
    }
    
    public static void show(Comparable[] a, int i, int j) {
        // Coloca a escala em Y de acordo com o tamanho do array 
        // e o valor passado em i, depois pinta de cinza.
        StdDraw.setYscale(-a.length + i + 0.8, i + 0.8);
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        // Adicionando os retângulos na figura de acordo com o seu tamanho.
        for (int k = 0; k < j; k++){
            double aux = Double.parseDouble( a[k].toString() );
            StdDraw.filledRectangle(k, aux * 0.3, 0.25, aux * 0.3);
        }
        
        // Pinta de vermelho o retângulo analisado.
        double aux = Double.parseDouble( a[j].toString() );
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.filledRectangle(j, aux * 0.3, 0.25, aux * 0.3);

        StdDraw.setPenColor(StdDraw.BLACK);
        
        // Adiciona os retângulos só que ao contrário do primeiro for, agora
        // começamos por j + 1.
        for (int k = j+1; k <= i; k++){
            double l = Double.parseDouble( a[k].toString() );
            StdDraw.filledRectangle(k, l * 0.3, 0.25, l * 0.3);
        }
        
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        
        // Repetimos o processo dos retângulos novamente.
        for (int k = i+1; k < a.length; k++){
            double l = Double.parseDouble( a[k].toString() );
            StdDraw.filledRectangle(k, l * 0.3, 0.25, l * 0.3);
        }
    }
    
    // Imprime o comparable
    public static void show(Comparable com[]){
        for(Comparable c : com)
            StdOut.print(c + " ");
        
        StdOut.println();
    }
    
    // se v < w?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    
    // Realiza a troca dos valores
    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
