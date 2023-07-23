package NFL.model;

import java.util.Set;
import java.util.HashSet;  // librerias de operaciones con set

public class Jugador{
  //Atributos
  private String nombre = null; // Nombre del jugador
  private String posicion = null; //{"mariscal, ..."}
  private String alineacion = null; //{"titular", "reserva"}
  private int numero = 0; // numero en el Equipo
  private int puntosAnotados = 0; //Los puntos que anota en partidos
  private float puntosFuerza = 0.75f; // valor por default
  private Equipo equipo = null; // Equipo al que pertenece
  private Set<Accion> hace = new HashSet<Accion>(); //Conjunto de acciones
  //constructor
  public Jugador(String n, String p, String a, Equipo e, double pf){
    if(0 < pf && pf <= 1){
      nombre = n;
      posicion = p;
      alineacion = a;
      equipo = e;
      puntosFuerza = (float) (pf);
      e.addJugador(this);  //Para agregar el jugador al equipo
      numero = e.getContador(); //Para asignar su numero
    }else{
    }
  }
  // con sobrecarga por si no se pasan los puntos de fuerza
  public Jugador(String n, String p, String a, Equipo e){
      nombre = n;
      posicion = p;
      alineacion = a;
      equipo = e;
      e.addJugador(this);  //Para agregar el jugador al equipo
      numero = e.getContador(); //Para asignar su numero
  }

  //Metodos
  public String getNombre(){ return nombre;}

  public String getPosicion(){return posicion;}

  public Equipo getEquipo(){return equipo;}

  public String getAlineacion () {return alineacion;}

  public float getPuntosFuerza(){ return puntosFuerza;}

  public Equipo juega(){ return equipo;}

  public Set<Accion> hace(){ return hace;}

  public int getPuntos(){ return puntosAnotados;}

  public void addAccion(Accion a){
    if(a!= null){
      hace.add(a);
    }
  }

  public void generarReporte(Partido p){
    int np = 0; // sera el numero de pases
    int ny = 0; // sera el numero de yardas
    puntosAnotados = 0; // los puntos obtenidos a travez de anotaciones
    if(p == null){ // si no se pasan parametros, como al generar reporte de equipo
      for(Accion a: hace){ // se cuentan las yardas, putnos y pases de todos los partidos
        if(a.getTipo().equals("pases")){ // las acciones de pases
          np++; // porque cada accion es un pase
          ny += a.getValor(); // se busca el valor de esa accion
        } else if (a.getTipo().equals("anotacion")){ // las acciones de anotaciones
          puntosAnotados += a.getValor(); // se busca el valor de esa accion
        }
      }
    } else{ // por si se pasa algun partido por parametro
      for(Accion a: hace){ // primero se busca en todas las acciones
        if(a.getPartido().equals(p)){ // para solo contar las acciones de ese partido
          if(a.getTipo().equals("pases")){ // las acciones de pases
            np++; // porque cada accion es un pase
            ny += a.getValor(); // se busca el valor de esa accion
          } else if (a.getTipo().equals("anotacion")){ // las acciones de anotaciones
            puntosAnotados += a.getValor(); // se busca el valor de esa accion
          }
        }
      }
    }
    System.out.println(String.format("%15s%3s%4s%10s%8s%5s%7s",
    nombre , numero , puntosAnotados ,posicion
                      , alineacion , np ,  ny));
  }
}
