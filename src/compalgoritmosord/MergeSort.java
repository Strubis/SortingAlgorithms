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
public class MergeSort {
    private static int comp = 0, change = 0;
    private static final int CUTOFF = 7;
    
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        
        long start = System.currentTimeMillis();
        sort(a, aux, 0, a.length-1);
        long end = System.currentTimeMillis();
        
        System.out.println("\nComp: " + comp + " - Change: " + change + 
                " - Duration (ms): " + (end - start) + "\n");
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        comp++;
        
        if (hi <= lo + CUTOFF) { 
            InsertionSort.sort(a);
            return;
        }
        
        if (hi <= lo) return;
        
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        
        if (!less(a[mid+1], a[mid])) {
            System.arraycopy(a, lo, aux, lo, hi - lo + 1);
            return;
        }
        
        merge(a, aux, lo, mid, hi);
    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        int i = lo, j = mid+1, mi = 0, mj = 0;
        for (int k = lo; k <= hi; k++) {
            change++;
            
            if(i > mid){
                a[k] = aux[j++];
                comp++;
            }else if(j > hi){
                a[k] = aux[i++];
                comp+=2;
            }else if(less(aux[j], aux[i])){
                a[k] = aux[j++];
                comp+=3;
            }else{
                a[k] = aux[i++];
                comp+=4;
            }
            
            show( a, mi, mj );
            show( a );
            mi++;
            mj++;
        }
    }
    
    public static int[] getCompChange(){
        int aux[] = {comp, change};
        
        return aux;
    }
}
