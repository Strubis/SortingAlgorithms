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
public class MergeSortBU {
    private static int comp = 0, change = 0;
    
    public static void sort(Comparable[] a) {
        int n = a.length, mi = 0, mj = 0;
        Comparable[] aux = new Comparable[n];
        
        long start = System.currentTimeMillis();
        for (int len = 1; len < n; len *= 2) {
            
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                
                merge(a, aux, lo, mid, hi);
                show( a, mi, mj );
                mi++;
                mj++;
            }
            
        }
        long end = System.currentTimeMillis();
        
        System.out.println("\nComp: " + comp + " - Change: " + change + 
                " - Duration (ms): " + (end - start) + "\n");
    }
    
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        
        change++;
        
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid){
                a[k] = aux[j++];
                comp++;
            }else if (j > hi){
                a[k] = aux[i++];
                comp+=2;
            }else if (less(aux[j], aux[i])){
                a[k] = aux[j++];
                comp+=3;
            }else{
                a[k] = aux[i++];
                comp+=4;
            }
            
        }
        
        show( a );
    }
    
    public static int[] getCompChange(){
        int aux[] = {comp, change};
        
        return aux;
    }
}
