package NFL.vc;

import NFL.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NFl_info{
  // Componentes de la ventanta
  private JFrame f;
  private JPanel p;

  private JPanel p1;
  private JPanel p2;
  private JPanel p3;

  //Constructor
  public NFl_info(){
    // campos de informacion
    f = new JFrame("Equipos NFL");
    p = new JPanel();
    p.setLayout(new FlowLayout());


    p1 = new JPanel();
    p2 = new JPanel();
    p3 = new JPanel();

    p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
    p2.setLayout(new BoxLayout(p2,BoxLayout.Y_AXIS));

    //LLenar p1
    p1.add(new JLabel("Conferencia " + NFL.conferenciasNFL[0].getNombre()));
    for(Division e: NFL.conferenciasNFL[0].getDivisiones()){
      p1.add(new JLabel("     "));
      p1.add(new JLabel(e.getNombre()));
      for(Equipo eq: e.getEquipos()){
        p1.add(new JLabel("\t" + eq.getNombre()));
      }
    }
    //LLenar p2
    p2.add(new JLabel("Conferencia " + NFL.conferenciasNFL[1].getNombre()));
    for(Division e: NFL.conferenciasNFL[1].getDivisiones()){
      p2.add(new JLabel("     "));
      p2.add(new JLabel(e.getNombre()));
      for(Equipo eq: e.getEquipos()){
        p2.add(new JLabel("\t" + eq.getNombre()));
      }
    }
    // Frame principal
    p3.add(new JLabel("  "));
    p.add(p1);
    p.add(p3);
    p.add(p2);
    f.add(p);
    f.pack();
    f.setResizable(false); // Para que no se pueda cambiar el tamaño
    f.setVisible(false);
  }
  //Aciones del sistema

  public void setVisible(){
    f.setVisible(true);
  }

  private class CancelarHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      f.setVisible(false);
    }
  }
}
