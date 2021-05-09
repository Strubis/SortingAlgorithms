/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compalgoritmosord;

import static compalgoritmosord.CompAlgoritmosOrd.*;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Emerson
 */
public class QuickSort {
    private static int comp = 0, change = 0;
    private static final int CUTOFF = 8;
    
    public static void sort(Comparable[] a) {
        long start = System.currentTimeMillis();
        
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        long end = System.currentTimeMillis();
        
        System.out.println("\nComp: " + comp + " - Change: " + change + 
                " - Duration (ms): " + (end - start) + "\n");
    }
    
    private static void sort(Comparable[] a, int lo, int hi) { 
        comp++;
        int n = hi - lo - 1;
        
        if( n <= CUTOFF){
            InsertionSort.sort( a );
            return;
        }
        
        int m = median3(a, lo, lo + n/2, hi);
        exch( a, m, lo );
        
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        show( a, j, j );
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }
    
    private static int median3(Comparable a[], int i, int j, int k){
        return ( less(a[i], a[j] ) ?
               ( less(a[j], a[k] ) ? j : less(a[i], a[k]) ? k : i ) :
               ( less(a[k], a[j] ) ? j : less(a[k], a[i]) ? k : i ) );
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        
        while (true) { 
            
            while (less(a[++i], v)) {
                comp++;
                
                if (i == hi) break;
            }

            while (less(v, a[--j])) {
                comp++;
                
                if (j == lo) break;
            }
            
            comp++;
            if (i >= j) break;
            
            exch( a, i, j );
            show( a );
            
            change++;
        }
        
        exch(a, lo, j);
        show( a );
        
        change++;
        
        return j;
    }
    
    public static int[] getCompChange(){
        int aux[] = {comp, change};
        
        return aux;
    }
}
