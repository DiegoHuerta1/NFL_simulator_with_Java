package NFL.model;

public class Accion{
  //Atributos
  private String tipo =null;  // {"pases", "anotar"}
  private int valor;
  // Para implementar la asociacion
  private Partido partido = null;
  private Jugador jugador = null;

  // Constructor
  public Accion(String t, int v, Partido p, Jugador j) throws Exception{
    if( v >= 0 ){
      tipo = t;
      valor = v;
      partido = p;
      jugador = j;
      j.addAccion(this); //para que el jugador tenga la Accion
      p.addAccion(this); //para que el partido tenga la accion
      p.addJugador(j); // Para que el partido tenga al jugador
    }else{
      throw new Exception("El valor de una accion no puede ser menor a 0");
    }
  }

  //Metodos
   public String getTipo(){ return tipo;}

  public int getValor(){ return valor;}

  public Partido getPartido(){ return partido;}

  public Jugador getJugador(){ return jugador;}

}
