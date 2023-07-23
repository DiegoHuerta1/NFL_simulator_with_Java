package NFL.vc;

import NFL.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NFl_partido{
  // Componentes de la ventanta
  private JFrame f;
  private JPanel p;

  private JLabel l1;
  private JLabel l2;
  private JLabel l3; // Para crear espacio
  private JLabel l4; // Para crear espacio

  private JComboBox<String> t1;
  private JComboBox<String> t2;

  private JButton b1;
  private JButton b2;

  //Constructor
  public NFl_partido(){
    // campos de informacion
    f = new JFrame("Simular Partido");
    p = new JPanel();
    p.setLayout(new GridLayout(4, 2));
    p.setPreferredSize(new Dimension(4*100, 100));

    l1 = new JLabel("Equipo Local");
    l2 = new JLabel("Equipo Visitante");
    l3 = new JLabel("  "); //Para crear espacio
    l4 = new JLabel("  "); // Para crear espacio

    t1 = new JComboBox<String>();
    t2 = new JComboBox<String>();

    p.add(l1); //Posicion 0, 0
    p.add(l2); //Posicion 0, 1
    p.add(t1); //Posicion 1, 0
    p.add(t2); //Posicion 1, 1
    p.add(l3); //Posicion 2, 0
    p.add(l4); //Posicion 2, 1

    // botones de creacion/cancelacion
    b1 = new JButton("Simular");
    b1.addActionListener(new CrearHandler());
    p.add(b1); // Posicion 3, 0
    b2 = new JButton("Cancelar");
    b2.addActionListener(new CancelarHandler());
    p.add(b2); //Posicion 3, 1

    // Frame principal
    f.add(p);
    f.pack();
    f.setResizable(false); // Para que no se pueda cambiar el tamaño
    f.setVisible(false);
  }
  //Aciones del sistema

  public void setVisible(){
    f.setVisible(true);
    t1.removeAllItems(); // Se vacia el comboBox
    t2.removeAllItems(); // Se vacia el comboBox
    for(Equipo e: NFL.equipo){ // Se llenan los comboBox
      if(e != null){ // Los equipos dados de alta
        t1.addItem(e.getNombre());
        t2.addItem(e.getNombre());
      }
    }
    if(t1.getItemCount() >= 1){
      t1.setSelectedIndex(0);
    }
    if(t2.getItemCount() >= 1){
        t2.setSelectedIndex(t2.getItemCount()-1);
    }
  }

  //Clases privadas
  private class CrearHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      int ind1 = t1.getSelectedIndex();
      int ind2 = t2.getSelectedIndex();
      if(ind1 == ind2){ // 1 equipo 2 veces
        JOptionPane.showMessageDialog(null,"Partido Invalido"); // Ventana de error
      } else{ // 2 equipos
        if(!NFL.equipo[ind1].puedeJugar()){
          JOptionPane.showMessageDialog(null, NFL.equipo[ind1].getNombre() + " no tiene los jugadores necesarios para jugar"); // Ventana de error
        }
        if(!NFL.equipo[ind2].puedeJugar()){
          JOptionPane.showMessageDialog(null, NFL.equipo[ind2].getNombre() + " no tiene los jugadores necesarios para jugar"); // Ventana de error
        }
        if(NFL.equipo[ind1].puedeJugar() && NFL.equipo[ind2].puedeJugar()){
          new Partido (NFL.equipo[ind1], NFL.equipo[ind2]).generarReporte();
          f.setVisible(false);
        }
      }
    }
  }

  private class CancelarHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      f.setVisible(false);
    }
  }
}
