/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compalgoritmosord;

import static compalgoritmosord.CompAlgoritmosOrd.*;
import edu.princeton.cs.algs4.StdDraw;

/**
 *
 * @author Emerson
 */
public class ShellSort {
    private static int comp = 0, change = 0;
    private static final int FF = 2;
    
    public static void sort(Comparable[] a) {
        int n = a.length, k = 1;
        
        StdDraw.setYscale(-1 - FF, FF*(k+1));
        
        long start = System.currentTimeMillis();
        int h = 1;
        
        comp++;
        while (h < n/3){
            h = 3*h + 1;
            comp++;
            k++;
        } 
        
        show2( a, k);
        
        comp++;
        while (h >= 1) {
            comp++;
            for (int i = h; i < n; i++) {
                comp++;
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    comp++;
                    
                    exch( a, j, j-h );
                    show( a );
                    
                    change++;
                }
            }
            
            if(h < n) show2( a, --k);
            h /= 3;
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("\nComp: " + comp + " - Change: " + change + 
                " - Duration (ms): " + (end - start) + "\n");
    }
    
    private static void show2(Comparable[] a, int k) {
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++) {
            double aux = Double.parseDouble( a[i].toString() );
            StdDraw.filledRectangle(i, FF*k + aux*(FF-1)*0.3, 0.25, aux*(FF-1)*0.3);
        }
    }
    
    public static int[] getCompChange(){
        int aux[] = {comp, change};
        
        return aux;
    }
}
