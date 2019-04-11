/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaGuiExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Ruben
 */
public class Ejercicio2 {


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        /*Component Setup*/
        JFrame window = new JFrame("Java Tutorial: UndoManager");
        final JTextArea area_1 = new JTextArea();
        JMenuItem redoEdit = new JMenuItem("Redo");
        JMenuItem undoEdit = new JMenuItem("Undo");
        JButton undoB = new JButton("Undo2");
        undoB.setBounds(43, 70, 89, 23);
       
        final JScrollPane scroll = new JScrollPane(area_1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        UndoManager editManager = new UndoManager();

        /*Component Functions*/
        area_1.setLineWrap(true);
        area_1.setWrapStyleWord(true);
        
        area_1.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        editManager.addEdit(e.getEdit());
                    }
                }
        );
        
        area_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    if (editManager.canRedo()) {
                        redoEdit.setEnabled(true);
                    } else {
                        redoEdit.setEnabled(false);
                    }
                    if (editManager.canUndo()) {
                        undoEdit.setEnabled(true);
                    } else {
                        undoEdit.setEnabled(false);
                    }
                    JPopupMenu popup = new JPopupMenu();
                    popup.add(undoEdit);
                    popup.add(redoEdit);
                    popup.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        
        undoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (editManager.canRedo()) {
                    editManager.redo();
                }
            }
        });

        redoEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (editManager.canRedo()) {
                    editManager.redo();
                }
            }
        });

        undoEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (editManager.canUndo()) {
                    editManager.undo();
                }
            }
        });
        window.add(undoB);
        window.add(area_1);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
}
    
