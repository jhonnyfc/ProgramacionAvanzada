/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p6;

import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;

/**
 *
 * @author alumno
 */
public class ContactEditorUI extends javax.swing.JFrame{

    /**
     * Creates new form ContactEditorUI
     */
    private final UndoManager undoManager;
    public ContactEditorUI() {
        initComponents();
        undoManager = new UndoManager();
        jTextArea.getDocument().addUndoableEditListener(undoManager);
    }
   
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        Print = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        Cut = new javax.swing.JMenuItem();
        Copy = new javax.swing.JMenuItem();
        Paste = new javax.swing.JMenuItem();
        Undo = new javax.swing.JMenuItem();
        Redo = new javax.swing.JMenuItem();
        close = new javax.swing.JMenu();
        Close = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        file.setText("File");
        file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileActionPerformed(evt);
            }
        });

        New.setText("New");
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        file.add(New);

        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        file.add(open);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        file.add(Save);

        Print.setText("Print");
        Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintActionPerformed(evt);
            }
        });
        file.add(Print);

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        file.add(About);

        jMenuBar1.add(file);

        edit.setText("Edit");

        Cut.setText("Cut");
        Cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutActionPerformed(evt);
            }
        });
        edit.add(Cut);

        Copy.setText("Copy");
        Copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyActionPerformed(evt);
            }
        });
        edit.add(Copy);

        Paste.setText("Paste");
        Paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteActionPerformed(evt);
            }
        });
        edit.add(Paste);

        Undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        edit.add(Undo);

        Redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        Redo.setText("Redo");
        Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoActionPerformed(evt);
            }
        });
        edit.add(Redo);

        jMenuBar1.add(edit);

        close.setText("Close");

        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        close.add(Close);

        jMenuBar1.add(close);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileActionPerformed
        //BORRAR
    }//GEN-LAST:event_fileActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        jTextArea.setText("");//no poner null
    }//GEN-LAST:event_NewActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed

        //abrir ventana de dialogo
        JFileChooser chooser
                = new JFileChooser();
        //pone un filtro de archivos
        chooser.setFileFilter(
        new FileNameExtensionFilter(
            "Text Files",
             "txt"
         ));
        //abre la ventana modal ...
        int returnVal= chooser.showOpenDialog(chooser);
        //... y devuelve el estado de la ventana (ok o cancel)
        if (returnVal== JFileChooser.APPROVE_OPTION) {
            File fichero = chooser.getSelectedFile();
            
            try {
                jTextArea.read(new FileReader(fichero.getAbsolutePath()), null);
            } catch (IOException ex) {
                System.out.println("Problema al acceder al fichero "+fichero.getAbsolutePath());
            }
            
        }
        else{
            System.out.println("");
        }
        
        
    }//GEN-LAST:event_openActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        JDialog dialogo=new JDialog();
        JFileChooser chooser
                = new JFileChooser();
        //pone un filtro de archivos
        chooser.setFileFilter(
        new FileNameExtensionFilter(
            "Text Files",
             "txt"
         ));
        //abre la ventana modal ...
        int returnVal= chooser.showSaveDialog(dialogo);
        //... y devuelve el estado de la ventana (ok o cancel)
        if (returnVal== JFileChooser.APPROVE_OPTION) {
            File fichero=chooser.getSelectedFile();
            try {
                FileWriter fw=new FileWriter(fichero);
                fw.write(jTextArea.getText());
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ContactEditorUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Se ha guardado en : "+fichero.getAbsolutePath());
            
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void CutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutActionPerformed
        jTextArea.cut();
    }//GEN-LAST:event_CutActionPerformed

    private void CopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyActionPerformed
        jTextArea.copy();
    }//GEN-LAST:event_CopyActionPerformed

    private void PasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteActionPerformed
        jTextArea.paste();
    }//GEN-LAST:event_PasteActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        
        JOptionPane advertencia = new JOptionPane();
        if (advertencia.OK_OPTION==advertencia.showConfirmDialog(null, "¿Estas segusro de cerrar?","advertencia",advertencia.CANCEL_OPTION))
            System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed

    private void RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoActionPerformed
        //https://docs.oracle.com/javase/tutorial/uiswing/components/generaltext.html#undo
        undoManager.redo();
        
    }//GEN-LAST:event_RedoActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        undoManager.undo();
    }//GEN-LAST:event_UndoActionPerformed

    private void PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintActionPerformed
        try {
            jTextArea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(ContactEditorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PrintActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed

        
    }//GEN-LAST:event_AboutActionPerformed

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
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ContactEditorUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem Copy;
    private javax.swing.JMenuItem Cut;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Paste;
    private javax.swing.JMenuItem Print;
    private javax.swing.JMenuItem Redo;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem Undo;
    private javax.swing.JMenu close;
    private javax.swing.JMenu edit;
    private javax.swing.JMenu file;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JMenuItem open;
    // End of variables declaration//GEN-END:variables

}