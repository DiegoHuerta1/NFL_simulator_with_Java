package NFL.model;

import java.util.Set;
import java.util.HashSet;  // librerias de operaciones con set

public class Partido{
  //Atributos
  private String estadio = null; //Estadio donde se juega
  //Para implementar la asociacion
  private Equipo local = null;
  private Equipo visitante = null;
  private Set<Accion> tiene = new HashSet<Accion>();
  private Set<Jugador> jugadores = new HashSet<Jugador>();
  //Para delimitar el marcador
  private int puntosLocal = 0;
  private int puntosVisitante = 0;

  // Constructor y metodo setPartido
  //por si se pasa estadio
  public Partido (String e, Equipo l, Equipo v)throws Exception{ //uso de excepciones
      if(v!= null && l!= null){
        estadio = e;
        local = l;
        visitante = v;
        simulacion();    //para que todos los partidos se simulen automaticamente
      }else{
        throw new Exception ("Datos invalidos del partido"); //lanza la excepcion
      }
  }
  //por si no se pasa estadio
  public Partido ( Equipo l, Equipo v){ //uso de excepciones
      if(v!= null && l!= null){
        local = l;
        visitante = v;
        simulacion();    //para que todos los partidos se simulen automaticamente
      }
  }

  //Metodos
  public String getStadio(){ return estadio;}
  public void addJugador(Jugador j){ // metodo aplicado en las acciones
      jugadores.add(j);
  }
  public void addAccion (Accion a){
    if(a!= null){
      tiene.add(a);
    }
  }
  public Set<Accion> tiene(){ return tiene;}

  public Equipo local(){ return local;}

  public Equipo visita(){ return visitante;}

  public Set<Jugador> confornta(){return jugadores;}

  public void simulacion (){ // se ejecuta al crear el partido
    local.simularLances(this);
    visitante.simularLances(this);
    for(Accion  a: tiene){
      if(a.getJugador().getEquipo().equals(local) && a.getTipo().equals("anotacion")){
        puntosLocal += a.getValor();  // buscar los puntos anotados por el local
      }
      if(a.getJugador().getEquipo().equals(visitante) && a.getTipo().equals("anotacion")){
        puntosVisitante += a.getValor();  // buscar los puntos anotados por el visitante
      }
    }
    if(puntosLocal > puntosVisitante){ // Que el partido local gana
      local.addPartidoGanado();
      visitante.addPartidoPerdido();
    } else if(puntosVisitante > puntosLocal){ // Que el partido visitante gana
      local.addPartidoPerdido();
      visitante.addPartidoGanado();
    } else { // Empate
      local.addPartidoEmpatado();
      visitante.addPartidoEmpatado();
    }
    try{ // Pasa los puntos a los equipos respectivamente
      local.sumarPuntos(puntosLocal); // Pasa los puntos al equipo local
      visitante.sumarPuntos(puntosVisitante); // Pasa los puntos al equipo visitante
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  public void generarReporte(){
    System.out.println("Partido de " + local.getNombre() + " contra " +
                        visitante.getNombre() + ". Resultado: " +
                        puntosLocal + " - " + puntosVisitante);
    System.out.println(String.format("%25s%15s%3s%4s%10s%8s%5s%7s", "",
                     "Nombre", "  #", "P",
                     " Posicion", "", " #", "Yardas"));
    for(Jugador j: jugadores){ // Primero muestra los locales
      if(j.getEquipo().equals(local)){
        System.out.print(String.format("%25s", "  " + j.getEquipo().getNombre() +": "));
        j.generarReporte(this); //generar el reporte del jugador
      }
    } for(Jugador j: jugadores){ // Despues muestra los visitanes
      if(j.getEquipo().equals(visitante)){
       System.out.print(String.format("%25s", "  " + j.getEquipo().getNombre() +": "));
       j.generarReporte(this); //generar el reporte del jugador
     }
    }
    System.out.println();
  }
  public void generarReporteP(){ // para unicamente mostrar el resultado del partido
    System.out.println("Partido de " + local.getNombre() + " contra " +
                        visitante.getNombre() + ". Resultado: " +
                        puntosLocal + " - " + puntosVisitante);
    System.out.println();
    System.out.println();
  }
}
