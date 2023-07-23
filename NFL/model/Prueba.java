public class Prueba{
  public static void main(String[] args){
    try{
      //Equipos
      Equipo equipo1 =  new Equipo("Buffalo Bills");
      Equipo equipo2 = new Equipo("Chicago Bears");
      //Jugadores
      new Jugador("Josh Allen",  "Mariscal", "Titular", equipo1, 0.68);
      new Jugador("Jake Fromm", "Mariscal", "Reserva", equipo1, 0.65);
      new Jugador("Stefon Diggs", "Receptor", "Titular", equipo1, 0.78);
      new Jugador("Andy Dalton", "Mariscal", "Titular", equipo2, 0.75);
      new Jugador("Nick Foles", "Mariscal", "Reserva", equipo2,0.74);
      new Jugador("Allen Robinson", "Receptor", "Titular", equipo2, 0.71);
      // Entenador de los Buffalo Bills
      new Entrenador("Sean McDermott", equipo1);
      //Simulacion de los partidos
      new Partido(equipo1, equipo2).generarReporte();
      new Partido(equipo2, equipo1).generarReporte();
      // reporte de los 2 equipos
      equipo1.generarReporte(null);
      equipo2.generarReporte(null);

    } catch (Exception e){
      System.out.println(e.getMessage());
      }
  }
}
