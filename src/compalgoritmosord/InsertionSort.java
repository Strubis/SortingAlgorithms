/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compalgoritmosord;

import static compalgoritmosord.CompAlgoritmosOrd.*;

/**
 *
 * @author Emerson
 */
public class InsertionSort {
    private static int comp = 0, change = 0;
    
    public static void sort(Comparable[] a) {
        int n = a.length;
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            comp++;
            int j = i;
            for (; j >= 1 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
                show( a );
                
                comp++;
                change++;
            }
            show( a, i, j );
        }
        long end = System.currentTimeMillis();
        
        System.out.println("\nComp: " + comp + " - Change: " + change + 
                " - Duration (ms): " + (end - start) + "\n");
    }
    
    public static int[] getCompChange(){
        int aux[] = {comp, change};
        
        return aux;
    }
    
}
