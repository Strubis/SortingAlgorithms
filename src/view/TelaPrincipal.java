/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import compalgoritmosord.InsertionSort;
import compalgoritmosord.MergeSort;
import compalgoritmosord.MergeSortBU;
import compalgoritmosord.QuickSort;
import compalgoritmosord.SelectionSort;
import compalgoritmosord.ShellSort;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author Emerson
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        
        len = getTamanho();
        
        if( len > 0)
            gerarComparable();
        
    }
    private int len;
    private Comparable vet[];
    private Comparable aux[];

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelection = new javax.swing.JButton();
        btnInsertion = new javax.swing.JButton();
        btnMergeSort = new javax.swing.JButton();
        btnMergeSortBU = new javax.swing.JButton();
        btnShell = new javax.swing.JButton();
        btnQuick = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNumbers = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Ordenação");
        setResizable(false);

        btnSelection.setText("Selection Sort");
        btnSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionActionPerformed(evt);
            }
        });

        btnInsertion.setText("Insertion Sort");
        btnInsertion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertionActionPerformed(evt);
            }
        });

        btnMergeSort.setText("Merge Sort");
        btnMergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeSortActionPerformed(evt);
            }
        });

        btnMergeSortBU.setText("Merge Sort BU");
        btnMergeSortBU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMergeSortBUActionPerformed(evt);
            }
        });

        btnShell.setText("Shell Sort");
        btnShell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShellActionPerformed(evt);
            }
        });

        btnQuick.setText("Quick Sort");
        btnQuick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuickActionPerformed(evt);
            }
        });

        tblNumbers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Selection", "", ""},
                {"Insertion", "", ""},
                {"Merge", "", null},
                {"Merge BU", "", null},
                {"Shell", "", null},
                {"Quick", "", null}
            },
            new String [] {
                "Algoritmo", "Comparações", "Trocas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNumbers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMergeSortBU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMergeSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInsertion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnShell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuick, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSelection)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertion)
                        .addGap(18, 18, 18)
                        .addComponent(btnMergeSort)
                        .addGap(18, 18, 18)
                        .addComponent(btnMergeSortBU)
                        .addGap(18, 18, 18)
                        .addComponent(btnShell)
                        .addGap(18, 18, 18)
                        .addComponent(btnQuick)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void gerarComparable(){
        vet = new Comparable[len];
        aux = new Comparable[len];
        
        for(int i = 0; i < vet.length; i++){
            vet[i] = StdRandom.uniform( 0.0, 1.0 );
            aux[i] = vet[i];
        }
    }
    
    private int getTamanho(){
        int len = 0; 
        try{
            len = Integer.parseInt( 
                    JOptionPane.showInputDialog(rootPane, "Digite o tamanho:", 
                    "Entrada", JOptionPane.QUESTION_MESSAGE));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Erro!");
            System.exit(0);
            throw ex;
        }
        
        return len;
    }
    
    // Resgata os valores originais do comparable
    private static void transVal(Comparable aux[], Comparable vet[]){
        for(int i = 0; i < vet.length; i++){
            vet[i] = aux[i];
        }
    }
    
    private void btnSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionActionPerformed
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        SelectionSort.sort( vet );
        // Retornando os valores originais
        transVal(aux, vet);
        
        // Adicionando na table os valores de comparação e trocas
        if( tblNumbers.getValueAt(0, 1) == "" ){
            int num[] = SelectionSort.getCompChange();
            tblNumbers.setValueAt(num[0], 0, 1);
            tblNumbers.setValueAt(num[1], 0, 2);
        }
    }//GEN-LAST:event_btnSelectionActionPerformed

    private void btnInsertionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertionActionPerformed
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        InsertionSort.sort( vet );
        transVal(aux, vet);
        
        if( tblNumbers.getValueAt(1, 1) == "" ){
            int num[] = InsertionSort.getCompChange();
            tblNumbers.setValueAt(num[0], 1, 1);
            tblNumbers.setValueAt(num[1], 1, 2);
        }
    }//GEN-LAST:event_btnInsertionActionPerformed

    private void btnShellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShellActionPerformed
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        ShellSort.sort( vet );
        transVal(aux, vet);
        
        if( tblNumbers.getValueAt(4, 1) == "" ){
            int num[] = ShellSort.getCompChange();
            tblNumbers.setValueAt(num[0], 4, 1);
            tblNumbers.setValueAt(num[1], 4, 2);
        }
    }//GEN-LAST:event_btnShellActionPerformed

    private void btnMergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeSortActionPerformed
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        MergeSort.sort( vet );
        transVal(aux, vet);
        
        if( tblNumbers.getValueAt(2, 1) == "" ){
            int num[] = MergeSort.getCompChange();
            tblNumbers.setValueAt(num[0], 2, 1);
            tblNumbers.setValueAt(num[1], 2, 2);
        }
    }//GEN-LAST:event_btnMergeSortActionPerformed

    private void btnQuickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuickActionPerformed
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        QuickSort.sort( vet );
        transVal(aux, vet);
        
        if( tblNumbers.getValueAt(5, 1) == "" ){
            int num[] = QuickSort.getCompChange();
            tblNumbers.setValueAt(num[0], 5, 1);
            tblNumbers.setValueAt(num[1], 5, 2);
        }
    }//GEN-LAST:event_btnQuickActionPerformed

    private void btnMergeSortBUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMergeSortBUActionPerformed
        StdDraw.setCanvasSize(160, 640);
        StdDraw.setXscale(-1, len+1);
        StdDraw.setPenRadius(0.006);
        
        MergeSortBU.sort( vet );
        transVal(aux, vet);
        
        if( tblNumbers.getValueAt(3, 1) == "" ){
            int num[] = MergeSortBU.getCompChange();
            tblNumbers.setValueAt(num[0], 3, 1);
            tblNumbers.setValueAt(num[1], 3, 2);
        }
    }//GEN-LAST:event_btnMergeSortBUActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsertion;
    private javax.swing.JButton btnMergeSort;
    private javax.swing.JButton btnMergeSortBU;
    private javax.swing.JButton btnQuick;
    private javax.swing.JButton btnSelection;
    private javax.swing.JButton btnShell;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNumbers;
    // End of variables declaration//GEN-END:variables
}
