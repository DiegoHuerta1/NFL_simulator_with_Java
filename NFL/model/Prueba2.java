public class Prueba2{
  public static void main(String[] args){
    try{
      // Creacion de los 32 equipos de la NFL
      Equipo equipo1 =  new Equipo("Buffalo Bills");
      Equipo equipo2 =  new Equipo("Miami Dolphina");
      Equipo equipo3 =  new Equipo("New England Patriots");
      Equipo equipo4 =  new Equipo("New York Jets");
      Equipo equipo5 =  new Equipo("Denver Broncos");
      Equipo equipo6 =  new Equipo("Kansas City Chiefs");
      Equipo equipo7 =  new Equipo("Las Vegas Raiders");
      Equipo equipo8 =  new Equipo("Los Angeles Chargers");
      Equipo equipo9 =  new Equipo("Baltimore Ravens");
      Equipo equipo10 =  new Equipo("Cincinnati Bengals");
      Equipo equipo11 =  new Equipo("Cleveland Browns");
      Equipo equipo12 =  new Equipo("Pittsburgh Steelers");
      Equipo equipo13 =  new Equipo("Houston Texans");
      Equipo equipo14 =  new Equipo("Indianapolis Colts");
      Equipo equipo15 =  new Equipo("Jacksonville Jaguars");
      Equipo equipo16 =  new Equipo("Tennessee Titans");
      Equipo equipo17 =  new Equipo("Dallas Cowboys");
      Equipo equipo18 =  new Equipo("New York Giants");
      Equipo equipo19 =  new Equipo("Philadelphia Eagles");
      Equipo equipo20 =  new Equipo("Washington");
      Equipo equipo21 =  new Equipo("Arizona Cardinals");
      Equipo equipo22 =  new Equipo("Los Angeles Rams");
      Equipo equipo23 =  new Equipo("San Francisco 49ers");
      Equipo equipo24 =  new Equipo("Seattle Seahawks");
      Equipo equipo25 =  new Equipo("Chicago Bears");
      Equipo equipo26 =  new Equipo("Detroit Lions");
      Equipo equipo27 =  new Equipo("Green Bay Packers");
      Equipo equipo28 =  new Equipo("Minnesota Vikings");
      Equipo equipo29 =  new Equipo("Atlanta Falcons");
      Equipo equipo30 =  new Equipo("Carolina Panthers");
      Equipo equipo31 =  new Equipo("New Orleans Saints");
      Equipo equipo32 =  new Equipo("Tampa Bay Buccaneers");
      // Jugadores de equipos:
      // 3 jugadores por equipo (algunos solo tienen 2)
      new Jugador("Josh Allen",  "Mariscal", "Titular", equipo1, 0.68);
      new Jugador("Jake Fromm",  "Mariscal", "Reserva", equipo1, 0.65);
      new Jugador("Stefon Diggs",  "Receptor", "Titular", equipo1, 0.78);
      new Jugador("Tua Tagovailoa",  "Mariscal", "Titular", equipo2, 0.74);
      new Jugador("Jake Rudock",  "Mariscal", "Reserva", equipo2, 0.63);
      new Jugador("DeVante Parker",  "Receptor", "Titular", equipo2, 0.69);
      new Jugador("Cam Newton",  "Mariscal", "Titular", equipo3, 0.77);
      new Jugador("Jarrett Stidham",  "Mariscal", "Reserva", equipo3, 0.69);
      new Jugador("N'Keal Harry",  "Receptor", "Titular", equipo3, 0.76);
      new Jugador("James Morgan",  "Mariscal", "Titular", equipo4, 0.64);
      new Jugador("Mike White",  "Mariscal", "Reserva", equipo4, 0.63);
      new Jugador("Jamison Crowder",  "Receptor", "Titular", equipo4, 0.78);
      new Jugador("Drew Lock",  "Mariscal", "Titular", equipo5, 0.78);
      new Jugador("Brett Rypien",  "Mariscal", "Reserva", equipo5, 0.65);
      new Jugador("Jerry Jeudy",  "Receptor", "Titular", equipo5, 0.76);
      new Jugador("Patrick Mahomes",  "Mariscal", "Titular", equipo6, 0.88);
      new Jugador("Chad Henne",  "Mariscal", "Reserva", equipo6, 0.68);
      new Jugador("Tyreek Hill",  "Receptor", "Titular", equipo6, 0.75);
      new Jugador("Derek Carr",  "Mariscal", "Titular", equipo7, 0.78);
      new Jugador("Marcus Mariota",  "Mariscal", "Reserva", equipo7, 0.73);
      new Jugador("Henry Ruggs III",  "Receptor", "Titular", equipo7, 0.75);
      new Jugador("Justin Herbert",  "Mariscal", "Titular", equipo8, 0.71);
      new Jugador("Easton Stick",  "Mariscal", "Reserva", equipo8, 0.69);
      new Jugador("Keenan Allen",  "Receptor", "Titular", equipo8, 0.71);
      new Jugador("Lamar Jackson",  "Mariscal", "Titular", equipo9, 0.74);
      new Jugador("Trace McSorley",  "Mariscal", "Reserva", equipo9, 0.66);
      new Jugador("Marquise Brown",  "Receptor", "Titular", equipo9, 0.77);
      new Jugador("Joe Burrow",  "Mariscal", "Titular", equipo10, 0.77);
      new Jugador("Brandon Allen",  "Mariscal", "Reserva", equipo10, 0.60); 
      new Jugador("Tyler Boyd",  "Receptor", "Titular", equipo10, 0.68);
      new Jugador("Baker Mayfield",  "Mariscal", "Titular", equipo11, 0.78);
      new Jugador("Case Keenum",  "Mariscal", "Reserva", equipo11, 0.72);
      new Jugador("Odell Beckham",  "Receptor", "Titular", equipo11, 0.72);
      new Jugador("Roethlisberger",  "Mariscal", "Titular", equipo12, 0.81);
      new Jugador("Mason Rudolph",  "Mariscal", "Reserva", equipo12, 0.69);
      new Jugador("Smith-Schuster",  "Receptor", "Titular", equipo12, 0.80);
      new Jugador("Deshaun Watson",  "Mariscal", "Titular", equipo13, 0.70);
      new Jugador("Ryan Finley",  "Mariscal", "Reserva", equipo13, 0.66);
      new Jugador("Brandin Cooks",  "Receptor", "Titular", equipo13, 0.69);
      new Jugador("Carson Wentz",  "Mariscal", "Titular", equipo14, 0.79);
      new Jugador("Jacob Eason",  "Mariscal", "Reserva", equipo14, 0.66);
      new Jugador("T.Y. Hilton",  "Receptor", "Titular", equipo14, 0.70);
      new Jugador("Gardner Minshew",  "Mariscal", "Titular", equipo15, 0.75);
      new Jugador("Jake Luton",  "Mariscal", "Reserva", equipo15, 0.63);
      new Jugador("DJ Chark Jr",  "Receptor", "Titular", equipo15, 0.79);
      new Jugador("Ryan Tannehill",  "Mariscal", "Titular", equipo16, 0.68);
      new Jugador("Logan Woodside",  "Mariscal", "Reserva", equipo16, 0.62);
      new Jugador("A.J. Brown",  "Receptor", "Titular", equipo16, 0.79);
      new Jugador("Ben DiNucci",  "Mariscal", "Titular", equipo17, 0.63);
      new Jugador("Dak Prescott",  "Mariscal", "Reserva", equipo17, 0.70);
      new Jugador("Amari Cooper",  "Receptor", "Titular", equipo17, 0.72);
      new Jugador("Daniel Jones",  "Mariscal", "Titular", equipo18, 0.75);
      new Jugador("Cooper Rush",  "Mariscal", "Reserva", equipo18, 0.64);
      new Jugador("Sterling Shepard",  "Receptor", "Titular", equipo18, 0.78);
      new Jugador("Jalen Hurts",  "Mariscal", "Titular", equipo19, 0.68);
      new Jugador("Corey Clement",  "Mariscal", "Reserva", equipo19, 0.76);
      new Jugador("Jalen Reagor",  "Receptor", "Titular", equipo19, 0.73);
      new Jugador("Kyle Allen",  "Mariscal", "Titular", equipo20, 0.70);
      new Jugador("Ryan Fitzpatrick",  "Mariscal", "Reserva", equipo20, 0.76);
      new Jugador("Terry McLaurin",  "Receptor", "Titular", equipo20, 0.79);
      new Jugador("Brett Hundley",  "Mariscal", "Titular", equipo21, 0.70);
      new Jugador("Kyler Murray",  "Mariscal", "Reserva", equipo21, 0.78);
      new Jugador("DeAndre Hopkins",  "Receptor", "Titular", equipo21, 0.75);
      new Jugador("Matthew Stafford",  "Mariscal", "Titular", equipo22, 0.68);
      new Jugador("Devlin Hodges",  "Mariscal", "Reserva", equipo22, 0.68);
      new Jugador("Robert Woods",  "Receptor", "Titular", equipo22, 0.70);
      new Jugador("Jimmy Garoppolo",  "Mariscal", "Titular", equipo23, 0.68);
      new Jugador("Nate Sudfeld",  "Mariscal", "Reserva", equipo23, 0.67);
      new Jugador("Deebo Samuel",  "Receptor", "Titular", equipo23, 0.78);
      new Jugador("Russell Wilson",  "Mariscal", "Titular", equipo24, 0.75);
      new Jugador("Danny Etling",  "Mariscal", "Reserva", equipo24, 0.63);
      new Jugador("DK Metcalf",  "Receptor", "Titular", equipo24, 0.76);
      new Jugador("Andy Dalton",  "Mariscal", "Titular", equipo25, 0.75);
      new Jugador("Nick Foles",  "Mariscal", "Reserva", equipo25, 0.74);
      new Jugador("Allen Robinson",  "Receptor", "Titular", equipo25, 0.71);
      new Jugador("Jared Goff",  "Mariscal", "Titular", equipo26, 0.77);
      new Jugador("Tim Boyle",  "Mariscal", "Reserva", equipo26, 0.68);
      new Jugador("Geronimo Allison",  "Receptor", "Titular", equipo26, 0.71);
      new Jugador("Aaron Rodgers",  "Mariscal", "Titular", equipo27, 0.71);
      new Jugador("Jordan Love",  "Mariscal", "Reserva", equipo27, 0.69);
      new Jugador("Davante Adams",  "Receptor", "Titular", equipo27, 0.74);
      new Jugador("Kirk Cousins",  "Mariscal", "Titular", equipo28, 0.68);
      new Jugador("Nate Stanley",  "Mariscal", "Reserva", equipo28, 0.62);
      new Jugador("Adam Thielen",  "Receptor", "Titular", equipo28, 0.71);
      new Jugador("Matt Ryan",  "Mariscal", "Titular", equipo29, 0.69);
      // Atlanta Falcons no tiene mariscal de reserva
      new Jugador("Julio Jones",  "Receptor", "Titular", equipo29, 0.74);
      new Jugador("Teddy Bridgewater",  "Mariscal", "Titular", equipo30, 0.68);
      new Jugador("Will Grier",  "Mariscal", "Reserva", equipo30, 0.69);
      new Jugador("Robby Anderson",  "Receptor", "Titular", equipo30, 0.68);
      new Jugador("Jameis Winston",  "Mariscal", "Titular", equipo31, 0.77);
      new Jugador("Taysom Hill",  "Mariscal", "Reserva", equipo31, 0.71);
      new Jugador("Michael Thomas",  "Receptor", "Titular", equipo31, 0.76);
      new Jugador("Tom Brady",  "Mariscal", "Titular", equipo32, 0.84);
      // Tampa Bay no tiene mariscal de reserva
      new Jugador("Mike Evans",  "Receptor", "Titular", equipo32, 0.85);
      // Las 8 divisiones
      Division div1 = new Division("Este", equipo1, equipo2, equipo3, equipo4);
      Division div2 = new Division("Oeste", equipo5, equipo6, equipo7, equipo8);
      Division div3 = new Division("Norte", equipo9, equipo10, equipo11, equipo12);
      Division div4 = new Division("Sur", equipo13, equipo14, equipo15, equipo16);
      Division div5 = new Division("Este", equipo17, equipo18, equipo19, equipo20);
      Division div6 = new Division("Oeste", equipo21, equipo22, equipo23, equipo24);
      Division div7 = new Division("Norte", equipo25, equipo26, equipo27, equipo28);
      Division div8 = new Division("Sur", equipo29, equipo30, equipo31, equipo32);
      // Las 2 conferencias
      Conferencia conf1 = new Conferencia("Americana", div1, div2, div3, div4);
      Conferencia conf2 = new Conferencia("Nacional", div5, div6, div7, div8);
      //Temporada con los 32 equipos y simulacion
      Temporada temporada = new Temporada(conf1, conf2, 2021);
      //Reporte de la temporada
      temporada.generarReporte();
      // Reportes de 1 equipos
      equipo6.generarReporte(null);
    } catch (Exception e){
      System.out.println(e.getMessage());
      }
  }
}
