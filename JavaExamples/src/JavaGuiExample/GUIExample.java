/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaGuiExample;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import javax.swing.undo.UndoManager;

/**
 *
 * @author User
 */
public class GUIExample extends javax.swing.JFrame {

    protected JTextArea textArea;
    JFrame f = new JFrame();
    JDialog dialog = new JDialog();
    JTextArea textArea1 = new JTextArea();
    //private UndoManager undoMgr__;
    UndoManager editManager = new UndoManager();
    Graphics g;
    
    
    private class UndoEditListener implements UndoableEditListener {
	@Override
	public void undoableEditHappened(UndoableEditEvent e) {
            editManager.addEdit(e.getEdit()); // remember the edit
	}
    }

    public GUIExample() {
        initComponents();
        setLocationRelativeTo(null);
          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        Panel = new javax.swing.JPanel();
        CloseButton = new javax.swing.JButton();
        AboutButton = new javax.swing.JButton();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        NewButton = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        OpenButton = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        SaveButton = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        PrintButton = new javax.swing.JMenuItem();
        EditMenu = new javax.swing.JMenu();
        CutButton = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        CopyButton = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        PasteButton = new javax.swing.JMenuItem();
        UndoButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        BoldButton = new javax.swing.JMenuItem();
        UnderlineButton = new javax.swing.JMenuItem();
        ItalicButton = new javax.swing.JMenuItem();
        ColorChooser = new javax.swing.JMenu();
        BGColor = new javax.swing.JMenuItem();
        LetterColor = new javax.swing.JMenuItem();
        PanelColor = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        AboutButton.setText("jButton1");
        AboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addComponent(AboutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(CloseButton))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseButton)
                    .addComponent(AboutButton)))
        );

        FileMenu.setText("File");

        NewButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        NewButton.setText("New");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });
        FileMenu.add(NewButton);
        FileMenu.add(jSeparator1);

        OpenButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        OpenButton.setText("Open");
        OpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenButtonActionPerformed(evt);
            }
        });
        FileMenu.add(OpenButton);
        FileMenu.add(jSeparator2);

        SaveButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        FileMenu.add(SaveButton);
        FileMenu.add(jSeparator3);

        PrintButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        PrintButton.setText("Print");
        PrintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintButtonActionPerformed(evt);
            }
        });
        FileMenu.add(PrintButton);

        MenuBar.add(FileMenu);

        EditMenu.setText("Edit");
        EditMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMenuActionPerformed(evt);
            }
        });

        CutButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        CutButton.setText("Cut");
        CutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutButtonActionPerformed(evt);
            }
        });
        EditMenu.add(CutButton);
        EditMenu.add(jSeparator4);

        CopyButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CopyButton.setText("Copy");
        CopyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopyButtonActionPerformed(evt);
            }
        });
        EditMenu.add(CopyButton);
        EditMenu.add(jSeparator5);

        PasteButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        PasteButton.setText("Paste");
        PasteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasteButtonActionPerformed(evt);
            }
        });
        EditMenu.add(PasteButton);

        UndoButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        UndoButton.setText("Undo");
        UndoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoButtonActionPerformed(evt);
            }
        });
        EditMenu.add(UndoButton);
        UndoButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (editManager.canRedo()) {
                    editManager.redo();
                }
            }
        });

        MenuBar.add(EditMenu);

        jMenu2.setText("Format");

        BoldButton.setText("Bold");
        BoldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoldButtonActionPerformed(evt);
            }
        });
        jMenu2.add(BoldButton);

        UnderlineButton.setText("Underline");
        UnderlineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnderlineButtonActionPerformed(evt);
            }
        });
        jMenu2.add(UnderlineButton);

        ItalicButton.setText("Italic");
        ItalicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItalicButtonActionPerformed(evt);
            }
        });
        jMenu2.add(ItalicButton);

        MenuBar.add(jMenu2);

        ColorChooser.setText("Color scheme");
        ColorChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColorChooserActionPerformed(evt);
            }
        });

        BGColor.setText("BackGround");
        BGColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGColorActionPerformed(evt);
            }
        });
        ColorChooser.add(BGColor);

        LetterColor.setText("Letter");
        LetterColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LetterColorActionPerformed(evt);
            }
        });
        ColorChooser.add(LetterColor);

        PanelColor.setText("Panel");
        PanelColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PanelColorActionPerformed(evt);
            }
        });
        ColorChooser.add(PanelColor);

        MenuBar.add(ColorChooser);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void CopyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopyButtonActionPerformed
        textArea.copy();
    }//GEN-LAST:event_CopyButtonActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        
        /* Creamos area de texto en blanco */
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBounds(52, 76, 360, 156);
                
        /* Añadimos una barra de scroll */
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(52, 76, 360, 156);
        Panel.add(scroll);
    }//GEN-LAST:event_NewButtonActionPerformed

    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed
               
        /* if( textArea.isEnabled() == true ){
            textArea = new JTextArea();
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setBounds(52, 76, 360, 156);

            JScrollPane scroll = new JScrollPane(textArea);
            scroll.setBounds(52, 76, 360, 156);
            Panel.add(scroll);
        } */
              
        //Creamos el objeto JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        
        //Indicamos que podemos seleccionar varios ficheros
        fileChooser.setMultiSelectionEnabled(true);
                
        //Creamos el filtro
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
        fileChooser.setFileFilter(filtro);
        
        if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            
            File[] ficheros = fileChooser.getSelectedFiles();
            
            for(int i = 0; i < ficheros.length; ++i){
                try(BufferedReader br = new BufferedReader(new FileReader(ficheros[i]))){
                    
                    for (String linea; (linea = br.readLine()) != null;)
                        textArea.append(linea + "\n");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al intentar abiri el fichero " + ficheros[i].getName());
                }
                JOptionPane.showMessageDialog(null, "Fichero " + ficheros[i].getName() + " abierto correctamente");
            }
            
        }
    }//GEN-LAST:event_OpenButtonActionPerformed

    /*private class UndoActionListener implements ActionListener {
        private String type;
        public UndoActionListener(String type) {
            this.type = type;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
            switch (type) {
                case "UNDO":
                    if (! undoMgr__.canUndo()) {
			textArea.requestFocusInWindow();
                        return; // no edits to undo
                    }	
                    undoMgr__.undo();
                    break;
		case "REDO":
                    if (! undoMgr__.canRedo()) {
                        textArea.requestFocusInWindow();
			return; // no edits to redo
                    }
                    undoMgr__.redo();
		}
	textArea.requestFocusInWindow();
	}
    }*/
	
    private void EditMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMenuActionPerformed
    }//GEN-LAST:event_EditMenuActionPerformed

    private void CutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutButtonActionPerformed
        textArea.cut();
    }//GEN-LAST:event_CutButtonActionPerformed

    private void PasteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasteButtonActionPerformed
        textArea.paste();
    }//GEN-LAST:event_PasteButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            File fichero = fileChooser.getSelectedFile();
            try (FileWriter f = new FileWriter(fichero);){
                RTFEditorKit kit = new RTFEditorKit();
                Document doc = textArea.getDocument();
                kit.write(f, doc, doc.getStartPosition().getOffset(), doc.getLength());
                //f.write(textArea.getText() + "\n");
            } catch (IOException ex) {
                Logger.getLogger(GUIExample.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Se han producido errores al intentar guardar el fichero" + fichero.getName());
            } catch (BadLocationException ex) {
                Logger.getLogger(GUIExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        JOptionPane.showMessageDialog(null, "Fichero " + fichero.getName() + " guardado correctamente");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void ColorChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColorChooserActionPerformed
       string text = area.getText();
        //htmlLabel.setText("<html>" + text + "</html<")
 
    }//GEN-LAST:event_ColorChooserActionPerformed

    private void BGColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGColorActionPerformed
        
        JColorChooser ventanaDeColores=new JColorChooser();
        Color color = ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
        textArea.setBackground(color);
    }//GEN-LAST:event_BGColorActionPerformed

    private void LetterColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LetterColorActionPerformed
        JColorChooser ventanaDeColores=new JColorChooser();
        Color color = ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
        textArea.setForeground(color);
    }//GEN-LAST:event_LetterColorActionPerformed

    private void PanelColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PanelColorActionPerformed
        JColorChooser ventanaDeColores=new JColorChooser();
        Color color = ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
        Panel.setBackground(color);
    }//GEN-LAST:event_PanelColorActionPerformed

    private void PrintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintButtonActionPerformed
        System.out.println(textArea.getText());
    }//GEN-LAST:event_PrintButtonActionPerformed

    private void UndoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoButtonActionPerformed
           
        /*if (editManager.canRedo()) {
            editManager.redo();
        }  */ 
        
    }//GEN-LAST:event_UndoButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        Frame JFrame;
            // create a dialog Box 
            JDialog d = new JDialog(this, "Warning"); 
  
            if( JOptionPane.showConfirmDialog(null, "Desea salir", "Warning!", JOptionPane.OK_CANCEL_OPTION)
                    == JOptionPane.OK_OPTION){
                this.dispose();
            }
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void AboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutButtonActionPerformed

        JDialog d = new JDialog(this, "About");

        JLabel l1 = new JLabel("Autor: Ruben Cherif Narvaez");
        JLabel l2 = new JLabel("Version: 3.1.2");
        ImageIcon image = new ImageIcon("/home/alumno/Escritorio/mapa.jpg"); //imports the image
        JLabel l3 = new JLabel(image);
        image.getIconHeight();
        image.getIconWidth();
        
        
        d.setLocationRelativeTo(null);
       
        /*.add(l1, BorderLayout); */
        d.add(l1, BorderLayout.NORTH);
        d.add(l2, BorderLayout.SOUTH);
        d.add(l3, BorderLayout.CENTER);
        
        // setsize of dialog 
        d.setSize(700, 700); 
  
        // set visibility of dialog 
        d.setVisible(true); 
        
    }//GEN-LAST:event_AboutButtonActionPerformed

    private void BoldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoldButtonActionPerformed
        textArea.setFont(new Font("Tahoma", Font.BOLD, 14));
    }//GEN-LAST:event_BoldButtonActionPerformed

    private void UnderlineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnderlineButtonActionPerformed

        Font font = textArea.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        textArea.setFont(font.deriveFont(attributes));
    }//GEN-LAST:event_UnderlineButtonActionPerformed

    private void ItalicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItalicButtonActionPerformed
        textArea.setFont(new Font("Tahoma", Font.ITALIC, 14));
    }//GEN-LAST:event_ItalicButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIExample().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutButton;
    private javax.swing.JMenuItem BGColor;
    private javax.swing.JMenuItem BoldButton;
    private javax.swing.JButton CloseButton;
    private javax.swing.JMenu ColorChooser;
    private javax.swing.JMenuItem CopyButton;
    private javax.swing.JMenuItem CutButton;
    private javax.swing.JMenu EditMenu;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem ItalicButton;
    private javax.swing.JMenuItem LetterColor;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem NewButton;
    private javax.swing.JMenuItem OpenButton;
    private javax.swing.JPanel Panel;
    private javax.swing.JMenuItem PanelColor;
    private javax.swing.JMenuItem PasteButton;
    private javax.swing.JMenuItem PrintButton;
    private javax.swing.JMenuItem SaveButton;
    private javax.swing.JMenuItem UnderlineButton;
    private javax.swing.JMenuItem UndoButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
