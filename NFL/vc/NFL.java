package NFL.vc;

import NFL.vc.*;
import NFL.model.*;
import java.io.*;

public class NFL {
  static Equipo[] equiposNFL = new Equipo[32]; //Cargados por default
  static Division[] divisionesNFL = new Division[8]; // Generados por default
  static Conferencia[] conferenciasNFL = new Conferencia[2]; // Generados por default
  static Equipo[] equipo = new Equipo[32]; //Equipos que se daran de alta
  static int contador = 0; // Para crear los equipos

  public static void main(String[] args){
    NFL.leerEquipos();
    NFL.leerEntrenadores();
    NFL.leerJugadores(); // Para agregar la nfl al sistema
    // Se abre la consola del sistema
    new NFL_frame().consola();
  }


  // Metodos de la Clase
  static void addEquipo(String n){
    try{
      equipo[contador] = new Equipo(n);
      contador++;
    } catch (Exception ex){
      System.out.println(ex.getMessage());
      }
  }

  static void leerJugadores(){
    try{
      FileReader reader = new FileReader("NFL\\JugadoresNFL.txt");
      BufferedReader in = new BufferedReader( reader );
      for(int i=0; i<94; i++){
        int numEquipo = Integer.parseInt(in.readLine());
        String nombre = in.readLine();
        String posicion = in.readLine();
        String alineacion = in.readLine();
        double puntosF = Double.parseDouble(in.readLine()) / 100;
        in.readLine(); // salto de línea
        new Jugador(nombre, posicion, alineacion, equiposNFL[numEquipo-1], puntosF);
      }
    }catch( FileNotFoundException e1 ) {
      System.err.println( "File not found ");
    } catch( IOException e2 ) {
      e2.printStackTrace();
    }
  }
  static void leerEntrenadores(){
    try{
      FileReader reader = new FileReader("NFL\\EntrenadoresNFL.txt");
      BufferedReader in = new BufferedReader( reader );
      for(int i=0; i<32; i++){
        String nombre = in.readLine();
        in.readLine(); // salto de línea
        new Entrenador(nombre, equiposNFL[i]);
      }
    }catch( FileNotFoundException e1 ) {
      System.err.println( "File not found ");
    } catch( IOException e2 ) {
      e2.printStackTrace();
    }
  }

  static void leerEquipos(){
    try{
      FileReader reader = new FileReader("NFL\\EquiposNFL.txt");
      BufferedReader in = new BufferedReader( reader );
      for(int i=0; i<32; i++){
        String nombre = in.readLine();
        in.readLine(); // salto de línea
        equiposNFL[i] = new Equipo(nombre);
      }
      for(int i=0; i<2; i++){ // Para crear diviiones
        int j=i*16;
        int k=i*4;
        divisionesNFL[k] = new Division("Este", equiposNFL[j], equiposNFL[j+1], equiposNFL[j+2], equiposNFL[j+3]);
        divisionesNFL[k+1] = new Division("Oeste", equiposNFL[j+4], equiposNFL[j+5], equiposNFL[j+6], equiposNFL[j+7]);
        divisionesNFL[k+2] = new Division("Norte", equiposNFL[j+8], equiposNFL[j+9], equiposNFL[j+10], equiposNFL[j+11]);
        divisionesNFL[k+3] = new Division("Sur", equiposNFL[j+12], equiposNFL[j+13], equiposNFL[j+14], equiposNFL[j+15]);
      }
      conferenciasNFL[0] = new Conferencia("Americana", divisionesNFL[0], divisionesNFL[1], divisionesNFL[2], divisionesNFL[3]);
      conferenciasNFL[1] = new Conferencia("Nacional", divisionesNFL[4], divisionesNFL[5], divisionesNFL[6], divisionesNFL[7]);
    }catch( FileNotFoundException e1 ) {
      System.err.println( "File not found ");
    } catch( IOException e2 ) {
      e2.printStackTrace();
    }
  }


}
