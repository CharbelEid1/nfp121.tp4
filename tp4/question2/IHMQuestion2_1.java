package question2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IHMQuestion2_1 extends JFrame {

    private JButton boutonA = new JButton("A");
    private JButton boutonB = new JButton("B");
    private JButton boutonC = new JButton("C");

    private TextArea contenu = new TextArea(30, 80);

    private JButtonObserver jbo1, jbo2, jbo3;
 
    public IHMQuestion2_1() {
        super("IHM Question2_1");
        JPanel enHaut = new JPanel();
        enHaut.add(boutonA);
        enHaut.add(boutonB);
        enHaut.add(boutonC);
        setLayout(new BorderLayout(5, 5));
        add("North", enHaut);
        add("Center", contenu); // contenu sera transmis aux observateurs, voir
                                // la description des constructeurs
        enHaut.setBackground(Color.blue);
        setLocation(100,100);
        pack();show();

        jbo1 = new JButtonObserver("Observateur jbo1: clic du bouton ", contenu);
        jbo2 = new JButtonObserver("Observateur jbo2: clic du bouton ", contenu);
        jbo3 = new JButtonObserver("Observateur jbo3: clic du bouton ", contenu);
        
        // le bouton A a 3 observateurs jbo1, jbo2 et jbo3
        
        boutonA.addActionListener(jbo1);
        boutonA.addActionListener(jbo2);
        boutonA.addActionListener(jbo3);
        boutonA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                contenu.setText("");
            }
        });
        // le bouton B a 2 observateurs jbo1 et jbo2
        
        boutonB.addActionListener(jbo1);
        boutonB.addActionListener(jbo2);
        boutonB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                contenu.setText("");
            }
        });
        // le bouton C a 1 observateur jbo1
        
        boutonC.addActionListener(jbo1);
        boutonC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                contenu.setText("");
            }
        });
    }
    
    public static void main(String[] args){
        new IHMQuestion2_1();
    }

}
