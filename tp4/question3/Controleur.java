package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;
/**
 * D�crivez votre classe Controleur ici.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");
        
        add.setEnabled(false);
        sub.setEnabled(false);
        mul.setEnabled(false);
        div.setEnabled(false);
        
        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est � remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new PushListener());
        boutons.add(add);   add.addActionListener(new AddListener());
        boutons.add(sub);   sub.addActionListener(new SubListener());
        boutons.add(mul);   mul.addActionListener(new MulListener());
        boutons.add(div);   div.addActionListener(new DivListener());
        boutons.add(clear); clear.addActionListener(new ClearListener());
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
        donnee.setText("");
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }
        
    class PushListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            int val = 0;
            try{
                val = operande();
                pile.empiler(val);
            }
            catch(NumberFormatException nfe){
                return;
            }
            catch(PilePleineException ppe){
                return;
            }
            toggleButtons();
            donnee.setText("");
        }
    }
    
    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()+pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            toggleButtons();
        }
    }
    
    class SubListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()-pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            toggleButtons();
        }
    
        
    }
    
    class MulListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()*pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            toggleButtons();
        }
    
        
    }
    
    class DivListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.empiler(pile.depiler()/pile.depiler());
            }
            catch(PilePleineException ppe){
                return;
            }
            catch(PileVideException pve){
                return;
            }
            catch(ArithmeticException ae){
                return;
            }
            toggleButtons();
        }
    
        
    }
    
    class ClearListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                pile.reset();
            }catch(PileVideException pve){
                return;
            }
        } 
    }
    public void toggleButtons() //active ou desactive les boutons des operateurs selon la taille de la pile
    {
        if(pile.taille() > 1)
        {
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
        else
        {
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        }
        donnee.requestFocus();
    }
}