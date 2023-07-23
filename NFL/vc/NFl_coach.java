package NFL.vc;

import NFL.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NFl_coach{
  // Componentes de la ventanta
  private JFrame f;
  private JPanel p;

  private JLabel l1;
  private JLabel l4;

  private JTextField t1;
  private JComboBox<String> t4;

  private JButton b1;
  private JButton b2;

  //Constructor
  public NFl_coach(){
    // campos de informacion
    f = new JFrame("Datos del Entrenador");
    p = new JPanel();
    p.setLayout(new GridLayout(3, 2));

    l1 = new JLabel("Nombre: ");
    l4 = new JLabel("Equipo: ");

    t1 = new JTextField(20);
    t4 = new JComboBox<String>();

    p.add(l1); //Posicion 0, 0
    p.add(t1); //Posicion 0, 1
    p.add(l4); //Posicion 1, 0
    p.add(t4); //Posicion 1, 1

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
    t4.removeAllItems(); // Se vacia el comboBox
    //Agregar los equipos al comboBox
    for(Equipo e: NFL.equipo){
      if(e != null){ // Los equipos dados de alta
        if(e.getEntrenador() == null){ // Los que no tengan entrenador
            t4.addItem(e.getNombre()); // Se agregan
        }
      }
    }
    f.setVisible(true);
  }

  //Clases privadas
  private class CrearHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(t1.getText().replaceAll(" ", "").length() == 0){ // nombre invalido
        JOptionPane.showMessageDialog(null,"Nombre de entrenador invalido"); // Ventana de error
        t1.setText(""); // Para vaciar el texto
      } else{ // Nombre valido
        String str = t1.getText(); // Se pondra la primera en mayuscula
        String nombre = str.substring(0, 1).toUpperCase() + str.substring(1);
        int indE = t4.getSelectedIndex();
        String equipoSeleccion = t4.getItemAt(indE);
        for(Equipo equipo: NFL.equipo){
            if(equipo != null){ // Los equipos dados de alta
              if(equipo.getNombre().equals(equipoSeleccion)){
                try{ // por el manejo de excepciones
                  new Entrenador(nombre, equipo); // lo da de alta
                }catch (Exception ex){
                  System.out.println(ex.getMessage());
                }
              }
            }
        }
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
