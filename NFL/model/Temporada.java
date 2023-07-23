package NFL.model;

public class Temporada{
  // Artibutos
  private int numPartidos = 0; //Partidos que se simularan
  private Conferencia c1; // Una de sus conferenicas
  private Conferencia c2; // La otra conferenicas
  private int anio; // Año en el que se lleva a cabo

  //Constructor
  public Temporada (Conferencia conf1, Conferencia conf2, int a, int m) {
    if(a>=1920 && a<=2030){
      anio = a; // Se asigna el año de la temporada
      c1 = conf1; // Se asigna la conferencia
      c2 = conf2; // Se asigna la conferencia
      simular(m);
    }
  }
  // Metodos:
  // Metodo principal de simulacion
  private void simular(int m){
    //Primero se reinician los marcadores
    for(Division d: c1.getDivisiones()){
      for(Equipo e: d.getEquipos()){
          e.iniciarTemporada();
      }
    }
    for(Division d: c2.getDivisiones()){
      for(Equipo e: d.getEquipos()){
          e.iniciarTemporada();
      }
    }
    if(m == 0){ // Ver simulacion de cada partido
      System.out.println("PARTIDOS TEMPORADA " + anio + ":");
      System.out.println();
      // Partidos interdivisionales
      // Primero cada Equipo juega 6 partidos contra sus compañeros de division
      for(Division d: c1.getDivisiones()){
        juegosEntreEllos0(d);
      }
      for(Division d: c2.getDivisiones()){
        juegosEntreEllos0(d);
      }
      // Despues cada equipo juega contra los 4 de otra division de su misma conferencia
      juegosEntre2Divisiones0(c1.getDivisiones()[0], c1.getDivisiones()[1]);
      juegosEntre2Divisiones0(c1.getDivisiones()[2], c1.getDivisiones()[3]);
      juegosEntre2Divisiones0(c2.getDivisiones()[0], c2.getDivisiones()[1]);
      juegosEntre2Divisiones0(c2.getDivisiones()[2], c2.getDivisiones()[3]);
      // Despues cada equipo juega contra los 4 equipos de una division de la otra conferencias
      juegosEntre2Divisiones0(c1.getDivisiones()[0], c2.getDivisiones()[0]);
      juegosEntre2Divisiones0(c1.getDivisiones()[1], c2.getDivisiones()[1]);
      juegosEntre2Divisiones0(c1.getDivisiones()[2], c2.getDivisiones()[2]);
      juegosEntre2Divisiones0(c1.getDivisiones()[3], c2.getDivisiones()[3]);
      // Por ultimo, cada equipo juega contra equipos de las otras 2 divisiones de su conferencia
      juegosMismaConferencia0(c1);
      juegosMismaConferencia0(c2);
    } else if(m == 1){ // Ver solo el resultado
      System.out.println("RESULTADOS PARTIDOS TEMPORADA " + anio + ":");
      System.out.println();
      // Partidos interdivisionales
      // Primero cada Equipo juega 6 partidos contra sus compañeros de division
      for(Division d: c1.getDivisiones()){
        juegosEntreEllos1(d);
      }
      for(Division d: c2.getDivisiones()){
        juegosEntreEllos1(d);
      }
      // Despues cada equipo juega contra los 4 de otra division de su misma conferencia
      juegosEntre2Divisiones1(c1.getDivisiones()[0], c1.getDivisiones()[1]);
      juegosEntre2Divisiones1(c1.getDivisiones()[2], c1.getDivisiones()[3]);
      juegosEntre2Divisiones1(c2.getDivisiones()[0], c2.getDivisiones()[1]);
      juegosEntre2Divisiones1(c2.getDivisiones()[2], c2.getDivisiones()[3]);
      // Despues cada equipo juega contra los 4 equipos de una division de la otra conferencias
      juegosEntre2Divisiones1(c1.getDivisiones()[0], c2.getDivisiones()[0]);
      juegosEntre2Divisiones1(c1.getDivisiones()[1], c2.getDivisiones()[1]);
      juegosEntre2Divisiones1(c1.getDivisiones()[2], c2.getDivisiones()[2]);
      juegosEntre2Divisiones1(c1.getDivisiones()[3], c2.getDivisiones()[3]);
      // Por ultimo, cada equipo juega contra equipos de las otras 2 divisiones de su conferencia
      juegosMismaConferencia1(c1);
      juegosMismaConferencia1(c2);
    } else if(m == 2){ // no ver el partido
      // Partidos interdivisionales
      // Primero cada Equipo juega 6 partidos contra sus compañeros de division
      for(Division d: c1.getDivisiones()){
        juegosEntreEllos2(d);
      }
      for(Division d: c2.getDivisiones()){
        juegosEntreEllos2(d);
      }
      // Despues cada equipo juega contra los 4 de otra division de su misma conferencia
      juegosEntre2Divisiones2(c1.getDivisiones()[0], c1.getDivisiones()[1]);
      juegosEntre2Divisiones2(c1.getDivisiones()[2], c1.getDivisiones()[3]);
      juegosEntre2Divisiones2(c2.getDivisiones()[0], c2.getDivisiones()[1]);
      juegosEntre2Divisiones2(c2.getDivisiones()[2], c2.getDivisiones()[3]);
      // Despues cada equipo juega contra los 4 equipos de una division de la otra conferencias
      juegosEntre2Divisiones2(c1.getDivisiones()[0], c2.getDivisiones()[0]);
      juegosEntre2Divisiones2(c1.getDivisiones()[1], c2.getDivisiones()[1]);
      juegosEntre2Divisiones2(c1.getDivisiones()[2], c2.getDivisiones()[2]);
      juegosEntre2Divisiones2(c1.getDivisiones()[3], c2.getDivisiones()[3]);
      // Por ultimo, cada equipo juega contra equipos de las otras 2 divisiones de su conferencia
      juegosMismaConferencia2(c1);
      juegosMismaConferencia2(c2);
    }
  }

  //Metodos para pdoer llevar a cabo la simulacion
  public void juegosMismaConferencia0(Conferencia c){
      for(int i=0; i<2; i++){
        for(int j=0; j<4; j++){
          new Partido(c.getDivisiones()[i].getEquipos()[j], c.getDivisiones()[2].getEquipos()[j]).generarReporte();
          new Partido(c.getDivisiones()[i].getEquipos()[j], c.getDivisiones()[3].getEquipos()[j]).generarReporte();
          numPartidos+=2;
        }
      }
  }
  public void juegosEntre2Divisiones0(Division d1, Division d2){
    // Simula los juegos de "una division contra otra"
      for(int i=0; i<4; i++){
        for(int j= 0; j<4; j++){
          new Partido(d1.getEquipos()[i], d2.getEquipos()[j]).generarReporte();
          numPartidos++;
        }
      }
  }
  public void juegosEntreEllos0(Division d){
    // Simula los juegos interdivisionales
      for(int i=0; i<3; i++){
        for(int j= i+1; j<4 ; j++){
            new Partido(d.getEquipos()[i], d.getEquipos()[j]).generarReporte();
            new Partido(d.getEquipos()[j], d.getEquipos()[i]).generarReporte();
            numPartidos += 2;
        }
      }
  }

  public void juegosMismaConferencia1(Conferencia c){
      for(int i=0; i<2; i++){
        for(int j=0; j<4; j++){
          new Partido(c.getDivisiones()[i].getEquipos()[j], c.getDivisiones()[2].getEquipos()[j]).generarReporteP();
          new Partido(c.getDivisiones()[i].getEquipos()[j], c.getDivisiones()[3].getEquipos()[j]).generarReporteP();
          numPartidos+=2;
        }
      }
  }
  public void juegosEntre2Divisiones1(Division d1, Division d2){
    // Simula los juegos de "una division contra otra"
      for(int i=0; i<4; i++){
        for(int j= 0; j<4; j++){
          new Partido(d1.getEquipos()[i], d2.getEquipos()[j]).generarReporteP();
          numPartidos++;
        }
      }
  }
  public void juegosEntreEllos1(Division d){
    // Simula los juegos interdivisionales
      for(int i=0; i<3; i++){
        for(int j= i+1; j<4 ; j++){
            new Partido(d.getEquipos()[i], d.getEquipos()[j]).generarReporteP();
            new Partido(d.getEquipos()[j], d.getEquipos()[i]).generarReporteP();
            numPartidos += 2;
        }
      }
  }

  public void juegosMismaConferencia2(Conferencia c){
      for(int i=0; i<2; i++){
        for(int j=0; j<4; j++){
          new Partido(c.getDivisiones()[i].getEquipos()[j], c.getDivisiones()[2].getEquipos()[j]);
          new Partido(c.getDivisiones()[i].getEquipos()[j], c.getDivisiones()[3].getEquipos()[j]);
          numPartidos+=2;
        }
      }
  }
  public void juegosEntre2Divisiones2(Division d1, Division d2){
    // Simula los juegos de "una division contra otra"
      for(int i=0; i<4; i++){
        for(int j= 0; j<4; j++){
          new Partido(d1.getEquipos()[i], d2.getEquipos()[j]);
          numPartidos++;
        }
      }
  }
  public void juegosEntreEllos2(Division d){
    // Simula los juegos interdivisionales
      for(int i=0; i<3; i++){
        for(int j= i+1; j<4 ; j++){
            new Partido(d.getEquipos()[i], d.getEquipos()[j]);
            new Partido(d.getEquipos()[j], d.getEquipos()[i]);
            numPartidos += 2;
        }
      }
  }

  public void generarReporte(){ // todos los equipos con sus puntos anotados, ordenados
    System.out.println();
    System.out.println("RESULTADOS DE LA TEMPORADA " + anio);
    System.out.println();
    for(int i=0; i<4; i++){ // reporte de las divisiones de la conferencia 1
      System.out.println("Division " + c1.getDivisiones()[i].getNombre() +
                        " de la conferencia " + c1.getNombre());
     generarReporteOrdenado(c1.getDivisiones()[i]);
     System.out.println(); // linea vacia
    }

    for(int i=0; i<4; i++){ // reporte de las divisiones de la conferencia 2
      System.out.println("Division " + c2.getDivisiones()[i].getNombre() +
                        " de la conferencia " + c2.getNombre());
      generarReporteOrdenado(c2.getDivisiones()[i]);
      System.out.println(); // linea vacia
    }
  }

  //Metodo para generar el reporte de temporada
  public void generarReporteOrdenado(Division d){
    System.out.println(String.format("%25s%5s%5s%5s%5s", "Equipo",
                      "G", "P", "E", "PF"));
    // Array para generar el reporte de forma ordenada
    Equipo [] equiposOrdenados = new Equipo[4];
    Equipo a;
    for(int i=0; i<4; i++){ // Primero esta desordenado
      equiposOrdenados[i] = d.getEquipos()[i];
    }
    for(int i=0; i<4;i++){ //Ordenar el nuevo array
      for(int j=0; j<3; j++){
        if(equiposOrdenados[j+1].esMayorA(equiposOrdenados[j])){
          a = equiposOrdenados[j];
          equiposOrdenados[j] = equiposOrdenados[j+1];
          equiposOrdenados[j+1] = a;
        }
      }
    }
    for(Equipo e: equiposOrdenados){
      System.out.println(String.format("%25s%5s%5s%5s%5s", e.getNombre(),
      e.getPartidosGanados(), e.getPartidoPerdidos(), e.getPartidosEmpatados(),
                          e.getPuntosTotales()));
    }
  }
  public int getAnio(){return anio;}
}
