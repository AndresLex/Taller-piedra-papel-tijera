package Principal;

import java.util.ArrayList;
import java.util.Random;

public class Partida {
    private int valorJugada;
    private int turno;
    private ArrayList<String> jugadaConvertida;
    private boolean esGanador;
    private int puntos;

    public Partida() {
        this.jugadaConvertida = new ArrayList<>();
        this.turno = 0;
    }

    public int getValorJugada() {
        return valorJugada;
    }

    public void setValorJugada(int valorJugada) {
        this.valorJugada = valorJugada;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public ArrayList<String> getJugadaConvertida() {
        return jugadaConvertida;
    }

    public void setJugadaConvertida(ArrayList<String> jugadaConvertida) {
        this.jugadaConvertida = jugadaConvertida;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public boolean isEsGanador() {
        return esGanador;
    }

    public void setEsGanador(boolean esGanador) {
        this.esGanador = esGanador;
    }

    public void iniciarJuego(int partidas) {
        for (int i = 1; i <= partidas; i++){
            jugar();
        }
    }

    public void jugar() {
        Random numRan = new Random();
        this.valorJugada = numRan.nextInt(3) + 1;
        this.turno += 1;
        if (valorJugada == 1){
            this.jugadaConvertida.add("Piedra");
        } else if (valorJugada == 2) {
            this.jugadaConvertida.add("Papel");
        }else {
            this.jugadaConvertida.add("Tijera");
        }
    }

    public void validarGanador(Partida jugador1, Partida jugador2) {
        ArrayList<String> listJug1 = jugador1.getJugadaConvertida();
        ArrayList<String> listJug2 = jugador2.getJugadaConvertida();
        for (int i = 0; i < listJug1.size(); i++){
            if (listJug1.get(i) == listJug2.get(i)){
                jugador1.puntos += 0;
                jugador2.puntos += 0;
            } else if (listJug1.get(i) == "Piedra" && listJug2.get(i) == "Papel"){
                jugador2.puntos += 1;
            } else if (listJug1.get(i) == "Papel" && listJug2.get(i) == "Piedra") {
                jugador1.puntos += 1;
            } else if (listJug1.get(i) == "Piedra" && listJug2.get(i) == "Tijera") {
                jugador1.puntos += 1;
            } else if (listJug1.get(i) == "Tijera" && listJug2.get(i) == "Piedra") {
                jugador2.puntos += 1;
            } else if (listJug1.get(i) == "Papel" && listJug2.get(i) == "Tijera") {
                jugador2.puntos += 1;
            } else if (listJug1.get(i) == "Tijera" && listJug2.get(i) == "Papel") {
                jugador1.puntos += 1;
            }
        }
        if (jugador1.puntos > jugador2.puntos) {
            jugador1.esGanador = true;
        } else if (jugador1.puntos < jugador2.puntos){
            jugador2.esGanador = true;
        } else {
            jugador1.esGanador = false;
            jugador2.esGanador = false;
        }

        /*if (jugador1.puntos == jugador2.puntos){
            jugador1.jugar();
            jugador2.jugar();
        } else if (jugador1.puntos > jugador2.puntos) {
            jugador1.esGanador = true;
        }else {
            jugador2.esGanador = true;
        }*/
    }
    
    public void limpiarJugadas() {
        this.jugadaConvertida.clear();
        this.turno = 0;
        this.puntos = 0;
        this.esGanador = false;
    }    
}
