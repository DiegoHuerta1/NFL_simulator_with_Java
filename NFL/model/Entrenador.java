package NFL.model;

public class Entrenador {
  // Atributos
  private Equipo equipo = null; // Equipo al que entrena
  private String name = null;
  // Constructor
  public Entrenador(String n, Equipo e){
    if(n != null && e != null){ // Para cuidar los atributos
      name = n;
      equipo = e;
      e.setEntrenador(this); // Para asignarlo al equipo
    }else{
      
    }
  }
  // Metodos
  public String getNombre(){return name;}
  public Equipo getEquipo(){return equipo;}

}
