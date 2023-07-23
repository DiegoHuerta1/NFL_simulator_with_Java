package NFL.model;

import java.util.Set;
import java.util.HashSet;  // librerias de operaciones con set

public class Equipo{
  //Atributos
  private String nombre = null; // nombre del Equipo
    //Para implementar la asociacion:
  private Set<Jugador> jugadores = new HashSet<Jugador>();
  private int contador = 0; //par asignar el numero a los jugadores
  private Division division = null; // se asigna automaticamente
  private Entrenador coach = null; //Entrenador del equipo
  //Atributos para el reporte de temporada:
  private int puntosTotales = 0; // La suma de todas sus anotaciones
  private int partidosGanados = 0; // Los partido que gana
  private int partidosPerdidos = 0; // Los partidos que pierde
  private int partidosEmpatados = 0; // Los partidos que empatan
  // Constructor y metodo setNombre
  public Equipo (String n){    //uso de excepciones
    if(n != null){                     //Para proteger el atributo
      nombre = n;
    } else{
    }
  }

  //Metodos
  public void setDivision(Division d){
    division = d;
  }
  public String getNombre (){ return nombre;}
  public void addJugador(Jugador j){
    if(j!= null){ //Para proteger el atributo
      jugadores.add(j);
    }else{
      System.out.println("Jugador invalido");
    }
  }
  public void setEntrenador(Entrenador e){
    coach = e;
  }
  private Jugador findMariscal(String a){
   for (Jugador j: jugadores){ // busca el jugador con esa alineacion
     if(a.equals(j.getAlineacion()) && j.getPosicion().equals("Mariscal")){
       return j;
     }
   }
   for (Jugador j : jugadores){ // si no encuentra, regresa el otro
     if(j.getPosicion().equals("Mariscal")){
       return j;
     }
   }
   return null; // si no encuentra no regresa nada nada
   }

  public void simularLances(Partido p){
    String posicion;  // la pocicion del marsical que hara los pases
    if(Math.random()<= 0.8){
      posicion = "Titular"; // Selecciona al titular un 80% de las veces
    } else{
      posicion = "Reserva"; // Selecciona al reserva un 20% de las veces
    }
    int passingNumber =(int) (Math.random()*60+21);  //Para que el numero este entre 20 y 80
    //para que la fuerza del marsiscal influya en el numero de pases:
    passingNumber = (int) (passingNumber * findMariscal(posicion).getPuntosFuerza());
    int numberYards = 0;                // EL numero de yardas por cada pase
    for (int y = 0; y < passingNumber; y++){
      numberYards = (int) (Math.random()*45+6); // para que sea entre 5 y 50
      // Se pasa la inf de la simulacion por medio de una accion
      try{
        new Accion("pases", numberYards, p, findMariscal(posicion));
      } catch (Exception e){
        System.out.println(e.getMessage());
      }
    }
    simluarAnotaciones(p, passingNumber);
  }

  public void simluarAnotaciones(Partido p, int pases){
    int intentos = Math.round(pases * 0.15f);  // el numero de intentos depende de los pases hechos, 0.15
    for(int i=0; i<intentos; i++){ // Cada intento es una oportunidad de anotar
      if((Math.random()+findReceptor().getPuntosFuerza())>= 1.3){ //1.3
        try{
          new Accion ("anotacion", 6, p, findReceptor()); // un touchdown
          int puntoExtra = Math.round(Math.round(Math.random()*2));
          // Despues de el touchdown se puede hacer una anotacion extra de valor 1 o 2
          if(puntoExtra>0){ // Si el valor de punto extra es mayor a 0, se logro el punto extra
            new Accion ("anotacion", puntoExtra, p, findReceptor());
          }
        } catch (Exception e){
          System.out.println(e.getMessage());
        }
      }
    }
  }
  public Jugador findReceptor(){
    String a; // Alineacion del receptor, por si hay reserva
    if(Math.random()<= 0.8){
      a = "Titular"; // Selecciona al titular un 80% de las veces
    } else{
      a = "Reserva"; // Selecciona al reserva un 20% de las veces
    }
    for (Jugador j: jugadores){ // busca el jugador con esa alineacion
      if(a.equals(j.getAlineacion()) && j.getPosicion().equals("Receptor")){
        return j;
      }
    }
    for (Jugador j : jugadores){ // si no encuentra, regresa el otro
      if(j.getPosicion().equals("Receptor")){
        return j;
      }
    } return findMariscal("Titular"); // Si no encuentra, regresa al mariscal
  }

  public void sumarPuntos(int p) throws Exception{
    if(p>= 0){
      puntosTotales += p;
    }else{
      {
        throw new Exception("El valor de los puntos debe ser mayor o igual a 0");
      }
    }
  }

  public void generarReporte(Partido p){
    int puntos = 0; //los puntos que anotaron los jugadores del equipo
    System.out.println("Reporte de " + getNombre() + ": " );
    if(division != null){ // Para asegurarse de que exista el valor
      System.out.println("Equipo de la Conferencia " + division.getConferencia().getNombre()
       + " del " + division.getNombre());
    }
    if(coach != null){ // Para asegurarse de que exista el valor
      System.out.println("Entrenador del equipo: " + coach.getNombre());
    }
    if(jugadores.isEmpty()){ // Para asegurarse de que existan jugadores
      System.out.println("\tEl equipo no tiene jugadores");
    } else{
      System.out.println("Jugadores:");
      System.out.println(String.format("%7s%15s%3s%4s%10s%8s%5s%7s", "",
   "Nombre", "#", "P",
   "Posicion", "", "#", "Yardas"));
      for(Jugador j: jugadores){
        System.out.print("       ");
        j.generarReporte(p);
        puntos += j.getPuntos();
      }
    }
    if(partidosGanados + partidosPerdidos + partidosEmpatados > 0){
        System.out.println("  En total el equipo anoto " + puntos + " puntos");
    }
    System.out.println();
    System.out.println();
  }

  public boolean puedeJugar(){
    if(this.findMariscal("Titular") == null){
      return false;
    } else{
      return true;
    }
  }
  public void addPartidoGanado(){
    partidosGanados++;
  }
  public void addPartidoPerdido(){
    partidosPerdidos++;
  }
  public void addPartidoEmpatado(){
    partidosEmpatados++;
  }
  public void iniciarTemporada(){
    partidosGanados = 0;
    partidosPerdidos = 0;
    partidosEmpatados = 0;
  }
  public boolean esMayorA(Equipo e){ // Para poder comparar equipos
    if(this.getPartidosGanados() < e.getPartidosGanados()){
      return false;
    } else if(this.getPartidosGanados() > e.getPartidosGanados()){
      return true;
    }else{ // En este caso los partidos ganados son iguales
      if(this.getPartidosEmpatados() < e.getPartidosEmpatados()){
        return false;
      } else if(this.getPartidosEmpatados() > e.getPartidosEmpatados()){
        return true;
      } else{ // En este caso los partido empatados son iguales
        if(this.getPuntosTotales() <= e.getPuntosTotales()){
          return false;
        }else{
          return true;
        }
      }
    }
  }
  public Set<Jugador> tiene(){ return jugadores;}
  public int getContador(){ return ++contador;}
  public Division getDivision(){ return division;}
  public int getPuntosTotales(){ return puntosTotales;}
  public int getPartidosGanados(){ return partidosGanados;}
  public int getPartidoPerdidos(){return partidosPerdidos;}
  public int getPartidosEmpatados(){return partidosEmpatados;}
  public Entrenador getEntrenador(){return coach;}
}
