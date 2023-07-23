package NFL.vc;

import NFL.model.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class NFL_frame implements ActionListener{
  // Componentes de la ventana
  private JFrame f;
  private JMenuBar mb;
  private JMenu m1;
  private JMenu m2;
  private JMenu m3;

  private JPanel p;
  private JTextArea t;
  private JScrollPane s;

  private JMenuItem ms2;
  private JMenuItem ms3;
  private JMenuItem ms4;

  private JMenuItem mj1;
  private JMenuItem mj2;
  private JMenuItem mj3;
  private JMenuItem mr1;

  private NFl_player j = new NFl_player();
  private NFl_coach coach = new NFl_coach();
  private NFl_team jt = new NFl_team(this);
  private NFl_partido jp = new NFl_partido();
  private NFl_temporada jtm = new NFl_temporada();

  private int numEquipos = 0; //Equipos dados de alta

  private Equipo[] equiposOrdenados = new Equipo[32];
  // Definicion de la consola

  public void consola (){
    // barra de menus
    f = new JFrame("NFL");
    mb = new JMenuBar();
    m1 = new JMenu("Simular");
    m2 = new JMenu("Dar de Alta");
    m3 = new JMenu("Reportes");
    mb.add(m1);
    mb.add(m2);
    mb.add(m3);
    f.setJMenuBar(mb);
    mb.setFocusTraversalKeysEnabled(true);

    // area de texto
    p = new JPanel();
    p.setBorder(new TitledBorder(new EtchedBorder(), ""));
    t = new JTextArea(20, 100);
    t.setEditable(false);  // no setEditable
    s = new JScrollPane(t);
    s.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    p.add(s);
    f.add(p);
    PrintStream outStream = new PrintStream( new TextAreaOutputStream(t));
    t.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));

    System.setOut( outStream );
    System.setErr( outStream );

    // menu simulacion
    ms4 = new JMenuItem("Temporada NFL");
    ms4.addActionListener(this);
    m1.addSeparator();
    m1.add(ms4);
    ms3 = new JMenuItem("Salir");
    ms3.addActionListener(this);
    m1.addSeparator();
    m1.add(ms3);
    ms2 = new JMenuItem("Seleccionar Equipos");
    ms2.setActionCommand("Cualquier partido");
    ms2.addActionListener(this);
    if(NFL.equipo[1] != null){ //Si hay por lo menos 2 equipos
      m1.add(ms2, 0);
    }
    // Menu de dar de alta
    mj2 = new JMenuItem("Equipo");
    mj2.addActionListener(this);
    m2.add(mj2);

    mj1 = new JMenuItem("Jugador");
    mj1.addActionListener(this);
    m2.add(mj1);
    if(NFL.equipo[0] == null){ //no hay por lo menos un equipo
      mj1.setEnabled(false);
    }

    mj3 = new JMenuItem("Entrenador");
    mj3.addActionListener(this);
    m2.add(mj3);
    if(NFL.equipo[0] == null){ //no hay por lo menos un equipo
      mj3.setEnabled(false);
    }

    //Menu reportes
    mr1 = new JMenuItem("Reporte general");
    mr1.addActionListener(this);
    m3.add(mr1);
    if(NFL.equipo[0] == null){ //no hay por lo menos un equipo
      mr1.setEnabled(false);
    }

    // frame principal
    f.addWindowListener(new CloseHandler());
    f.pack();
    f.setResizable(false);
    f.setVisible(true);
  }
  //Acciones del sistema
  public void unEquipo(){
    numEquipos++;
    if(numEquipos == 1){
      mj1.setEnabled(true);
      mr1.setEnabled(true);
      mj3.setEnabled(true);
    }
    if(numEquipos == 2){
      this.addPartidos(0, 1, 0);
      this.addPartidos(1, 0, 1);
    }
    if(numEquipos == 3){
      this.addPartidos(0, 2, 2);
      this.addPartidos(2, 0, 3);
      this.addPartidos(1, 2, 4);
      this.addPartidos(2, 1, 5);
    }
    if(numEquipos == 4){
      this.addPartidos(0, 3, 6);
      this.addPartidos(3, 0, 7);
      this.addPartidos(1, 3, 8);
      this.addPartidos(3, 1, 9);
      this.addPartidos(2, 3, 10);
      this.addPartidos(3, 2, 11);
    }
    if(numEquipos == 5){
      m1.add(ms2, 12); // Para poder generar cualquier partido
    }
  }
  public void addPartidos(int x, int y, int z){
    JMenuItem item = new JMenuItem(NFL.equipo[x].getNombre() + " vs " + NFL.equipo[y].getNombre());
    item.setActionCommand("" + x + y);
    item.addActionListener(this);
    m1.add(item, z);
  }
  public void actionPerformed(ActionEvent e){
     if(e.getActionCommand().equals("Jugador")){

      j.setVisible();

    } else if(e.getActionCommand().equals("Equipo")){

      jt.setVisible();

    }else if(e.getActionCommand().equals("Entrenador")){

      coach.setVisible();

    } else if(e.getActionCommand().equals("Reporte general")){

      //Reporte de todos los equipos
      int x;
      for( x=0; x<32; x++){
        if(NFL.equipo[x] == null){
          break;
        }
        equiposOrdenados[x] = NFL.equipo[x];
      }
      quickSort( equiposOrdenados, 0, x-1 );
      for(int y=x-1; y>=0; y--){
        equiposOrdenados[y].generarReporte(null);
      }

    } else if(e.getActionCommand().equals("Cualquier partido")) {

      jp.setVisible();

    } else if(e.getActionCommand().equals("Temporada NFL")){

      jtm.setVisible();

    } else if(e.getActionCommand().equals("Salir")){

      System.exit(0);

    } else if(Integer.parseInt(e.getActionCommand()) >= 0){
      String str = e.getActionCommand();
      int e1 = Integer.parseInt(str.substring(0, 1));
      int e2 = Integer.parseInt(str.substring(1, 2));
      int x = Integer.parseInt(e.getActionCommand());
      if(!NFL.equipo[e1].puedeJugar()){
        JOptionPane.showMessageDialog(null, NFL.equipo[e1].getNombre() + " no tiene los jugadores necesarios para jugar"); // Ventana de error
      }
      if(!NFL.equipo[e2].puedeJugar()){
        JOptionPane.showMessageDialog(null, NFL.equipo[e2].getNombre() + " no tiene los jugadores necesarios para jugar"); // Ventana de error
      }
      if(NFL.equipo[e1].puedeJugar() && NFL.equipo[e2].puedeJugar()){
        new Partido (NFL.equipo[e1], NFL.equipo[e2]).generarReporte();
      }
    }
  }

  // Clases utilizadas por la ventana principal
  private class CloseHandler extends WindowAdapter{
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
  }

  public class TextAreaOutputStream extends OutputStream {
        private javax.swing.JTextArea t;
        public TextAreaOutputStream( JTextArea textArea ) {
            this.t = textArea;
        }
        public void write( int b ) throws IOException {
            t.append( String.valueOf( ( char )b ) );
            //t.setCaretPosition(t.getDocument().getLength());
        }

        public void write(char[] cbuf, int off, int len) throws IOException {
            t.append(new String(cbuf, off, len));
            t.setCaretPosition(t.getDocument().getLength());
        }
    }

  public static void quickSort( Equipo[] array, int left, int right ) {

		int index = partition( array, left, right );

		if( left < index - 1 )
			quickSort( array, left, index-1 );

		if( index < right )
			quickSort( array, index, right );
	}

	// particion

	private static int partition( Equipo[] array, int left, int right ) {

		int i = left, j = right;
		Equipo pivot = array[ (left + right) / 2 ];

		while( i <= j ) {

			while( pivot.esMayorA(array[i]) ) i ++;
			while( array[j].esMayorA(pivot) ) j --;

			if( i <= j ) swap( array, i ++, j -- );
		}

		return i;
	}
  // intercambio de valores

 	private static void swap( Equipo[] array, int i, int j ) {

		Equipo tmp = array[ i ];
		array[ i ] = array[ j ];
		array[ j ] = tmp;
	}
}
