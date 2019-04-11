/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa.p3;
 
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author User
 */
public class ExampleGUI {
   private JTextArea text;
   private Action[] textActions = { new DefaultEditorKit.CutAction(),
         new DefaultEditorKit.CopyAction(), new DefaultEditorKit.PasteAction(), };

   public ExampleGUI(String title, String info) {
      JMenu menu = new JMenu("Edit");
      for (Action textAction : textActions) {
         menu.add(new JMenuItem(textAction));
      }
      JMenuBar menuBar = new JMenuBar();
      menuBar.add(menu);

      JFrame f = new JFrame(title);
      f.setJMenuBar(menuBar);

      Container c = f.getContentPane();

      text = new JTextArea(info, 20, 50);

      JScrollPane sp = new JScrollPane(text);
      c.add(sp);

      // f.setBounds(100,200, 500, 400 );
      f.pack();
      f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
   }

   public static void main(String[] args) {
      new ExampleGUI("Title", "This is info text");
   }
}