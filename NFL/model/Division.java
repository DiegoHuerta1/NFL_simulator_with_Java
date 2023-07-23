package NFL.model;

import java.util.Set;
import java.util.HashSet;  // librerias de operaciones con set

public class Division{
  //Atributos
  private String name = null; //  {Norte, Sur, Este, Oeste}
  private Equipo[] equipos = new Equipo[4]; // Equipos (4)
  private Conferencia conferencia = null;
  //constructor
  //Se deben pasar sus 4 equipos por parametro
  public Division (String n, Equipo e1, Equipo e2, Equipo e3, Equipo e4){
    name = n;
    try{
      setEquipo(e1, 1);
      setEquipo(e2, 2);
      setEquipo(e3, 3);
      setEquipo(e4, 4);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      }
  }
  // Metodos
  public void setEquipo(Equipo e, int n) throws Exception{
    if(e != null){                    //Para proteger el atributo
      equipos[n-1] = e;              // Asigna el equipo
      e.setDivision(this);         // Para que el equipo reconozca la division
    } else{
      throw new Exception ("Equipo invalido");
    }
  }
  public Equipo[] getEquipos(){
    return equipos;
  }
  public String getNombre(){
    return name;
  }
  public Conferencia getConferencia(){
    return conferencia;
  }
  public void setConferenica(Conferencia c){
    conferencia = c;
  }
  public void generarReporte(){
    System.out.println("Division " + name + " de la conferencia " + conferencia.getNombre());
    System.out.println("Equipos de la division:");
    for (Equipo e: equipos){
      System.out.println("\t" + e.getNombre());
    }
    System.out.println();
  }
}
