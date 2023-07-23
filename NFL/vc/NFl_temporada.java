package NFL.vc;

import NFL.model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NFl_temporada{
  // Componentes de la ventanta
  private JFrame f;
  private JPanel p;

  private JLabel l1;
  private JLabel l2;

  private JLabel l3;
  private JComboBox<String> cmb;

  private JLabel l4;
  private JTextField t1;

  private JButton v1;

  private JCheckBox cb1;

  private JButton b1;
  private JButton b2;

  private JLabel vacio1;
  private JLabel vacio2;
  private JLabel vacio3;
  private JLabel vacio4;

  private NFl_info infNFL = new NFl_info();

  //Constructor
  public NFl_temporada(){
    // campos de informacion
    f = new JFrame("Temporada NFL");
    f.setSize(500, 300);
    p = new JPanel();
    vacio1 = new JLabel("                                                                                                                                                  ");
    vacio2 = new JLabel("                                                                                                                                                  ");
    vacio3 = new JLabel("                                                                                                                                                  ");
    vacio4 = new JLabel("                                                                                                                                                  ");

    l1 = new JLabel("La temporada no se genera con los equipos dados de alta");
    l2 = new JLabel("Se genera con los equipos de la NFL");

    p.add(l1);
    p.add(l2);

    v1 = new JButton("Ver Equipos NFL");
    v1.addActionListener(new BotonVer());
    p.add(v1);
    p.add(vacio1);

    l3 = new JLabel("Para cada partido de la temporada: ");
    cmb = new JComboBox<String>();
    cmb.addItem("Ver simulacion");
    cmb.addItem("Ver solo el resultado");
    cmb.addItem("No ver nada");

    p.add(l3);
    p.add(cmb);
    p.add(vacio2);

    cb1 = new JCheckBox("Ver reporte de cada equipo al terminar", false);
    p.add(cb1);
    p.add(vacio4);

    l4 = new JLabel("Anio de la temporada:   ");
    t1 = new JTextField(4);
    p.add(l4);
    p.add(t1);
    p.add(vacio3);

    // botones de creacion/cancelacion
    b1 = new JButton("Simular Temporada");
    b1.addActionListener(new CrearHandler());
    p.add(b1); // Posicion 2, 0
    b2 = new JButton("Cancelar");
    b2.addActionListener(new CancelarHandler());
    p.add(b2); //Posicion 2, 1

    // Frame principal
    f.add(p);
    f.setResizable(false); // Para que no se pueda cambiar el tamaño
    f.setVisible(false);
  }
  //Aciones del sistema

  public void setVisible(){
    t1.setText("");
    f.setVisible(true);
  }

  //Clases privadas
  private class CrearHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
       try{
        if(Integer.parseInt(t1.getText()) < 1920 || Integer.parseInt(t1.getText()) > 2030){
          JOptionPane.showMessageDialog(null,"El anio debe ser un numero entre 1920 y 2030"); // Ventana de error
          t1.setText("");
        } else{
          int anio = Integer.parseInt(t1.getText());
          int m = cmb.getSelectedIndex();
          new Temporada(NFL.conferenciasNFL[0], NFL.conferenciasNFL[1], anio, m).generarReporte();
          if(cb1.isSelected()){
            System.out.println("Reportes de los equipos de la NFL al terminar la temporada: ");
            System.out.println(); //Linea vacia
            for(Equipo equipo: NFL.equiposNFL){
              equipo.generarReporte(null);
            }
          }
          f.setVisible(false);
        }
      } catch (NumberFormatException excepcion){
        JOptionPane.showMessageDialog(null,"El anio debe ser un numero");
        t1.setText("");
      }
    }
  }
  private class BotonVer implements ActionListener{
    public void actionPerformed(ActionEvent e){
      infNFL.setVisible();
    }
  }
  private class CancelarHandler implements ActionListener{
    public void actionPerformed(ActionEvent e){
      f.setVisible(false);
    }
  }
}
