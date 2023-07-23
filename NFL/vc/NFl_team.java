package NFL.vc;

import NFL.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NFl_team{
  // Componentes de la ventanta
  private JFrame f;
  private JPanel p;

  private JLabel l1;

  private JTextField t1;

  private JButton b1;
  private JButton b2;

  private NFL_frame nflF; //El frame principal
  //Constructor
  public NFl_team(NFL_frame nflF1){
    nflF = nflF1;
    // campos de informacion
    f = new JFrame("Datos del Equipo");
    p = new JPanel();
    p.setLayout(new GridLayout(2, 2));

    l1 = new JLabel("Nombre: ");

    t1 = new JTextField(20);

    p.add(l1); //Posicion 0, 0
    p.add(t1); //Posicion 0, 1

    // botones de creacion/cancelacion
    b1 = new JButton("Crear");
    b1.addActionListener(new CrearHandler());
    t1.addActionListener(new CrearHandler()); // Para el enter
    p.add(b1); // Posicion 2, 0
    b2 = new JButton("Cancelar");
    b2.addActionListener(new CancelarHandler());
    p.add(b2); //Posicion 2, 1

    // Frame principal
    f.add(p);
    f.pack();
    f.setResizable(false); // Para que no se pueda cambiar el tamaño
    f.setVisible(false);
  }
  //Aciones del sistema

  public void setVisible(){
    t1.setText(""); // Para vaciar el texto
    f.setVisible(true);
  }

  //Clases privadas
  private class CrearHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(t1.getText().replaceAll(" ", "").length() == 0){ // nombre invalido
        JOptionPane.showMessageDialog(null,"Nombre de equipo invalido"); // Ventana de error
        t1.setText(""); // Para vaciar el texto
      } else{ // Nombre valido
        String str = t1.getText(); // Se pondra la primera en mayuscula
        String nombre = str.substring(0, 1).toUpperCase() + str.substring(1);
        NFL.addEquipo(nombre);
        nflF.unEquipo();
        f.setVisible(false);
      }
    }
  }

  private class CancelarHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      f.setVisible(false);
    }
  }
}
