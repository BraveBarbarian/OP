package Taschenrechner;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;


/**
 *
 * Description
 *
 * @version 1.3 from 05.03.2024
 * @Lars Rippert 
 */

public class Taschenrechner extends JFrame {
  // start attributes
  private JLabel jLabel1 = new JLabel();
  private JButton b7 = new JButton();
  private JButton b8 = new JButton();
  private JButton b9 = new JButton();
  private JButton bGeteilt = new JButton();
  private JButton b4 = new JButton();
  private JButton b5 = new JButton();
  private JButton b6 = new JButton();
  private JButton bMal = new JButton();
  private JButton b1 = new JButton();
  private JButton b2 = new JButton();
  private JButton b3 = new JButton();
  private JButton bMinus = new JButton();
  private JButton bCE1 = new JButton();
  private JButton b0 = new JButton();
  private JButton bKomma = new JButton();
  private JButton bPlus = new JButton();
  private JTextField jTextField1 = new JTextField();
  private JButton bIstGleich = new JButton();
  int check;
  double zahl1;
  double ergebnis;
  String operation;
  JButton a;
  boolean erg = false;
  private JButton bBackspace = new JButton();
  private JButton bHelp1 = new JButton();
  // end attributes
  
  
  public Taschenrechner() { 
    // Frame init
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 340; 
    int frameHeight = 564;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Taschenrechner");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // start components
    
    jLabel1.setBounds(0, 0, 325, 64);
    jLabel1.setText("");
    cp.add(jLabel1);
    b7.setBounds(0, 110, 80, 80);
    b7.setText("7");
    b7.setMargin(new Insets(2, 2, 2, 2));
    b7.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b7);
    b8.setBounds(82, 110, 80, 80);
    b8.setText("8");
    b8.setMargin(new Insets(2, 2, 2, 2));
    b8.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b8);
    b9.setBounds(164, 110, 80, 80);
    b9.setText("9");
    b9.setMargin(new Insets(2, 2, 2, 2));
    b9.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b9);
    bGeteilt.setBounds(246, 110, 82, 80);
    bGeteilt.setText(":");
    bGeteilt.setMargin(new Insets(2, 2, 2, 2));
    bGeteilt.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        rechenOperation(evt);
      }
    });
    cp.add(bGeteilt);
    b4.setBounds(0, 192, 80, 80);
    b5.setBounds(82, 192, 80, 80);
    b6.setBounds(164, 192, 80, 80);
    bMal.setBounds(246, 192, 80, 80);
    b4.setText("4");
    b4.setMargin(new Insets(2, 2, 2, 2));
    b4.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b4);
    b5.setText("5");
    b5.setMargin(new Insets(2, 2, 2, 2));
    b5.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b5);
    b6.setText("6");
    b6.setMargin(new Insets(2, 2, 2, 2));
    b6.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b6);
    bMal.setText("*");
    bMal.setMargin(new Insets(2, 2, 2, 2));
    bMal.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        rechenOperation(evt);
      }
    });
    cp.add(bMal);
    b1.setBounds(0, 274, 80, 80);
    b2.setBounds(82, 274, 80, 80);
    b3.setBounds(164, 274, 80, 80);
    bMinus.setBounds(246, 274, 80, 80);
    b1.setText("1");
    b1.setMargin(new Insets(2, 2, 2, 2));
    b1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b1);
    b2.setText("2");
    b2.setMargin(new Insets(2, 2, 2, 2));
    b2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b2);
    b3.setText("3");
    b3.setMargin(new Insets(2, 2, 2, 2));
    b3.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b3);
    bMinus.setText("-");
    bMinus.setMargin(new Insets(2, 2, 2, 2));
    bMinus.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        rechenOperation(evt);
      }
    });
    cp.add(bMinus);
    bCE1.setBounds(0, 356, 80, 80);
    b0.setBounds(82, 356, 80, 80);
    bKomma.setBounds(164, 356, 80, 80);
    bPlus.setBounds(246, 356, 80, 80);
    bCE1.setText("CE");
    bCE1.setMargin(new Insets(2, 2, 2, 2));
    bCE1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bCE1_ActionPerformed(evt);
      }
    });
    cp.add(bCE1);
    b0.setText("0");
    b0.setMargin(new Insets(2, 2, 2, 2));
    b0.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        numberButton(evt);
      }
    });
    cp.add(b0);
    bKomma.setText(",");
    bKomma.setMargin(new Insets(2, 2, 2, 2));
    bKomma.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bKomma_ActionPerformed(evt);
      }
    });
    cp.add(bKomma);
    bPlus.setText("+");
    bPlus.setMargin(new Insets(2, 2, 2, 2));
    bPlus.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        rechenOperation(evt);
      }
    });
    cp.add(bPlus);
    jTextField1.setBounds(0, 60, 325, 50);
    jTextField1.setFocusable(false);
    jTextField1.setEditable(false);
    jTextField1.setText("0");
    cp.add(jTextField1);
    bIstGleich.setBounds(0, 438, 80, 80);
    bIstGleich.setText("=");
    bIstGleich.setMargin(new Insets(2, 2, 2, 2));
    bIstGleich.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bIstGleich_ActionPerformed(evt);
      }
    });
    bIstGleich.setFocusable(true);
    cp.add(bIstGleich);
    bBackspace.setBounds(82, 438, 80, 80);
    
    bBackspace.setText("←");
    bBackspace.setMargin(new Insets(2, 2, 2, 2));
    bBackspace.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bBackspace_ActionPerformed(evt);
      }
    });
    cp.add(bBackspace);
    bHelp1.setBounds(164, 438, 162, 80);
    bHelp1.setText("Help");
    bHelp1.setMargin(new Insets(2, 2, 2, 2));
    bHelp1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        bHelp1_ActionPerformed(evt);
      }
    });
    cp.add(bHelp1);
    // end components
    setVisible(true);
    
    addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_0:
                case KeyEvent.VK_NUMPAD0:
                    numberButton(new ActionEvent(b0, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_1:
                case KeyEvent.VK_NUMPAD1:
                    numberButton(new ActionEvent(b1, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_2:
                case KeyEvent.VK_NUMPAD2:
                    numberButton(new ActionEvent(b2, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_3:
                case KeyEvent.VK_NUMPAD3:
                    numberButton(new ActionEvent(b3, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_4:
                case KeyEvent.VK_NUMPAD4:
                    numberButton(new ActionEvent(b4, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_5:
                case KeyEvent.VK_NUMPAD5:
                    numberButton(new ActionEvent(b5, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_6:
                case KeyEvent.VK_NUMPAD6:
                    numberButton(new ActionEvent(b6, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_7:
                case KeyEvent.VK_NUMPAD7:
                    numberButton(new ActionEvent(b7, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_8:
                case KeyEvent.VK_NUMPAD8:
                    numberButton(new ActionEvent(b8, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_9:
                case KeyEvent.VK_NUMPAD9:
                    numberButton(new ActionEvent(b9, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_ADD:
                    rechenOperation(new ActionEvent(bPlus, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_SUBTRACT:
                    rechenOperation(new ActionEvent(bMinus, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_MULTIPLY:
                    rechenOperation(new ActionEvent(bMal, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_DIVIDE:  // Numpad "/"
                    rechenOperation(new ActionEvent(bGeteilt, ActionEvent.ACTION_PERFORMED, ":"));
                    break;
                case KeyEvent.VK_ENTER:
                    bIstGleich_ActionPerformed(new ActionEvent(bIstGleich, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_DECIMAL:
                case KeyEvent.VK_PERIOD:
                    bKomma_ActionPerformed(new ActionEvent(bKomma, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    bBackspace_ActionPerformed(new ActionEvent(bBackspace, ActionEvent.ACTION_PERFORMED, null));
                    break;
                case KeyEvent.VK_ESCAPE:
                    bCE1_ActionPerformed(new ActionEvent(bCE1, ActionEvent.ACTION_PERFORMED, null));
                    break;

            }
        }
    });
    setFocusable(true);
    requestFocusInWindow();
  } // end of public Taschenrechner

  
  // start methods
  public static void main(String[] args) {
    new Taschenrechner();
  }
  
  private String formatNumber(double zahl) {
    if (zahl == (long) zahl) {
        return String.format("%d", (long) zahl);
    } else {
        return String.format("%s", zahl);
    }
  }

  public void delete() {
    jTextField1.setText("0");
    jLabel1.setText("");
    check = 0;
    erg = false;
    }
                    
  public void zahlenAnhaengen(String z) {
    String text = jTextField1.getText();    
    if (text.equals("0") || erg) { 
      jTextField1.setText(z);
      if (erg) { 
        erg = false;
      }
    } else {
      jTextField1.setText(text + z);
    }
  }
  
  public void numberButton(ActionEvent evt) {
    JButton a = (JButton)evt.getSource();
    zahlenAnhaengen(a.getText());
    requestFocusInWindow();     
  }

public void rechenOperation(ActionEvent evt) {
    JButton pressedOperation = (JButton)evt.getSource();
    String newOperation = pressedOperation.getText();
    
    if (erg) {  
        jLabel1.setText(ergebnis + " " + newOperation);
    } else if (check == 1) {    
        bIstGleich_ActionPerformed(null); 
        jLabel1.setText(ergebnis + " " + newOperation); 
    } else { 
        zahl1 = Double.valueOf(jTextField1.getText());
        jLabel1.setText(zahl1 + " " + newOperation);
    }
    operation = newOperation; 
    jTextField1.setText("");
    check = 1;
    erg = false;
    requestFocusInWindow();
}
  
  public void bCE1_ActionPerformed(ActionEvent evt) {
    delete();
    requestFocusInWindow();
  } // easy
  public void bKomma_ActionPerformed(ActionEvent evt) {
    String a = jTextField1.getText();
    
    if (a.contains(".")) {
      return;
    } else {
      jTextField1.setText(a + ".");
        
      }
    requestFocusInWindow();
  } 

  
  public void bIstGleich_ActionPerformed(ActionEvent evt) {
    double zahl2 = Double.valueOf(jTextField1.getText());
    switch (operation) {
      case "+":
        ergebnis = zahl1 + zahl2;
        break;
      case "-":
        ergebnis = zahl1 - zahl2;
        break;
      case ":":
        if (zahl2 == 0) {
          jTextField1.setText("Error: Nicht definiert!"); 
          jLabel1.setText(""); // Optional: Löscht das jLabel
          return;
        } else {
          ergebnis = zahl1 / zahl2;
        }
        break;
      case "*":
        ergebnis = zahl1 * zahl2;
        break;
    }
    jTextField1.setText(String.valueOf(formatNumber(ergebnis)));
    jLabel1.setText(""); 
    zahl1 = ergebnis; 
    check = 0; 
    erg = true;
    requestFocusInWindow();
  }
  
  public void bBackspace_ActionPerformed(ActionEvent evt) {
    String vorher = jTextField1.getText();
    if (vorher.length() > 1) {
      jTextField1.setText(vorher.substring(0, vorher.length() - 1));
    } else {
      jTextField1.setText("0");
    }
    requestFocusInWindow();
  } // end of bBackspace_ActionPerformed

  public void bHelp1_ActionPerformed(ActionEvent evt) {

    
  } // end of bHelp1_ActionPerformed

  // end methods
} // end of class Taschenrechner