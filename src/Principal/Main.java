package Principal;

import java.util.Scanner;
// Presentado Por: Andres Leonardo Camargo Cortes
// ID. 701919
public class Main {
    public static void main(String[] args) {
        Partida mesa = new Partida();
        Partida jug1 = new Partida();
        Partida jug2 = new Partida();


        int opc;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Piedra Papel Tijera !!");
            System.out.println("1. Jugar");
            System.out.println("2. Ver Ganador");
            System.out.println("3. Reiniciar");
            System.out.println("4. SALIR");
            opc = teclado.nextInt();
            switch (opc){
                case 1:
                    /*System.out.println("Cuantas partidas jugar");
                    int prt = teclado.nextInt();*/
                    jug1.iniciarJuego(3);
                    jug2.iniciarJuego(3);
                    System.out.println("Presiona 2 para ver el Ganador");
                    /*System.out.println("Jugador 1: "+jug1.getJugadaConvertida());
                    System.out.println("Jugador 2: "+jug2.getJugadaConvertida());*/
                    break;
                case 2:
                    mesa.validarGanador(jug1,jug2);
                    System.out.println("Jugador 1: "+jug1.getJugadaConvertida());
                    System.out.println("Jugador 2: "+jug2.getJugadaConvertida());
                    if (jug1.getTurno() != 0 || jug2.getTurno() != 0 ){
                        if (jug1.isEsGanador()){
                            System.out.println("El Jugador 1 Gana con "+jug1.getPuntos()+" puntos");
                        }
                        if (jug2.isEsGanador()){
                            System.out.println("El Jugador 2 Gana con "+jug2.getPuntos()+" puntos");
                        }
                        if ((jug1.isEsGanador() == false) && (jug2.isEsGanador() == false)) {
                            System.out.println("Salio empate, Ver ganador de nuevo");
                            jug1.iniciarJuego(1);
                            jug2.iniciarJuego(1);
                        }
                    }else {
                        System.out.println("Presiona 1 para Jugar");
                    }
                    break;
                case 3:
                    jug1.limpiarJugadas();
                    jug2.limpiarJugadas();
                    break;
            }
        }while (opc < 4);
    }
}