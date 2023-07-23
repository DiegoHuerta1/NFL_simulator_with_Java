package NFL.model;

import java.util.Set;
import java.util.HashSet;  // librerias de operaciones con set

public class Conferencia{
  //Atributos
  private String name = null; //  {Americana, Nacional}
  private Division[] divisiones = new Division[4]; // Divisiones (4)
  //constructor
  //Se deben pasar sus 4 divisiones por parametro
  public Conferencia (String n, Division d1, Division d2, Division d3, Division d4){
    name = n;
    try{
      setDivision(d1, 1);
      setDivision(d2, 2);
      setDivision(d3, 3);
      setDivision(d4, 4);
    }
    catch(Exception e){
      System.out.println(e.getMessage());
      }
  }
  // Metodos
  public void setDivision(Division d, int n) throws Exception{
    if(d != null){                  //Para proteger el atributo
      divisiones[n-1] = d;  // Asigna la division en el array de divisiones
      d.setConferenica(this); // para que la division la tenga de conferencia
    } else{
      throw new Exception ("Conferencia invalida");
    }
  }
  public Division[] getDivisiones(){
    return divisiones;
  }
  public String getNombre(){
    return name;
  }
  public void generarReporte(){
    System.out.println("Conferencia "  + name);
    System.out.println("Divisiones de la conferencia:");
      for (Division d: divisiones){
        System.out.println("\t" + d.getNombre());
      }
    System.out.println();
  }
}
