package NFL.vc;

import NFL.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NFl_player{
  // Componentes de la ventanta
  private JFrame f;
  private JPanel p;

  private JLabel l1;
  private JLabel l2;
  private JLabel l3;
  private JLabel l4;

  private JTextField t1;
  private JTextField t2;
  private JTextField t3;
  private JComboBox<String> t4;

  private JButton b1;
  private JButton b2;

  //Constructor
  public NFl_player(){
    // campos de informacion
    f = new JFrame("Datos del Jugador");
    p = new JPanel();
    p.setLayout(new GridLayout(5, 2));

    l1 = new JLabel("Nombre: ");
    l2 = new JLabel("Posicion: ");
    l3 = new JLabel("Alineacion: ");
    l4 = new JLabel("Equipo: ");

    t1 = new JTextField(20);
    t2 = new JTextField(20);
    t3 = new JTextField(20);
    t4 = new JComboBox<String>();

    p.add(l1); //Posicion 0, 0
    p.add(t1); //Posicion 0, 1
    p.add(l2); //Posicion 1, 0
    p.add(t2); //Posicion 1, 1
    p.add(l3); //Posicion 2, 0
    p.add(t3); //Posicion 2, 1
    p.add(l4); //Posicion 3, 0
    p.add(t4); //Posicion 3, 1

    // botones de creacion/cancelacion
    b1 = new JButton("Crear");
    b1.addActionListener(new CrearHandler());
    p.add(b1); // Posicion 4, 0
    b2 = new JButton("Cancelar");
    b2.addActionListener(new CancelarHandler());
    p.add(b2); //Posicion 4, 1

    // Frame principal
    f.add(p);
    f.pack();
    f.setResizable(false); // Para que no se pueda cambiar el tamaño
    f.setVisible(false);
  }
  //Aciones del sistema

  public void setVisible(){
    t1.setText(""); // Para vaciar el texto
    t2.setText(""); // Para vaciar el texto
    t3.setText(""); // Para vaciar el texto
    t4.removeAllItems(); // Se vacia el comboBox
    //Agregar los equipos al comboBox
    for(Equipo e: NFL.equipo){
      if(e != null){ // Los equipos dados de alta
          t4.addItem(e.getNombre()); // Se agregan
      }
    }
    f.setVisible(true);
  }

  //Clases privadas
  private class CrearHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      String nombre = null;
      String posicion = null;
      String alineacion = null;
      if(t1.getText().replaceAll(" ", "").length() == 0){ // nombre invalido
        JOptionPane.showMessageDialog(null,"Nombre invalido"); // Ventana de error
        t1.setText(""); // Para vaciar el texto
      } else{
        String str1 = t1.getText(); // Se pondra la primera en mayuscula
        nombre = str1.substring(0, 1).toUpperCase() + str1.substring(1);
      }
      if(t2.getText().replaceAll(" ", "").length() == 0){ // nombre invalido
        JOptionPane.showMessageDialog(null,"Posicion invalida"); // Ventana de error
        t2.setText(""); // Para vaciar el texto
      } else{
        String str2 = t2.getText().toLowerCase(); // Se pondra la primera en mayuscula
        posicion = str2.substring(0, 1).toUpperCase() + str2.substring(1);
      }
      if(t3.getText().replaceAll(" ", "").length() == 0){ // nombre invalido
        JOptionPane.showMessageDialog(null,"Alineacion invalida"); // Ventana de error
        t3.setText(""); // Para vaciar el texto
      }else{
        String str3 = t3.getText().toLowerCase(); // Se pondra la primera en mayuscula
        alineacion = str3.substring(0, 1).toUpperCase() + str3.substring(1);
      }
      int indE = t4.getSelectedIndex();
      if(nombre != null && posicion != null && alineacion != null){ // todo correcto
        new Jugador(nombre, posicion, alineacion, NFL.equipo[indE]);
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
