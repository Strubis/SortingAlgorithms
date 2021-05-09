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
public class SelectionSort {
    private static int comp = 0, change = 0;
    
    public static void sort(Comparable com[]) {
        int len = com.length;
        
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < len; i++) {
            int min = i, j;
            show( com, i, min );
            
            for (j = i+1; j < len; j++) {
                comp++;
                if (less(com[j], com[min])) min = j;
            }
            
            exch( com, i, min );
            show( com );
            change++;
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
