package com.poker.pokersimulate.modles.domains.dinero.preflop.jerarquiaDinero;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.dinero.basico.*;


import java.util.ArrayList;

public class PartidaEAllPreflop extends PartidaEConDinero {
    public PartidaEAllPreflop() {
        super();
    }

    @Override
    public void iterarRonda() {
        getRonda().clear();
        getRonda().repartirCartasJugadores();
        partidaPreflop();
        getRonda().repartirComunitarias();
        getRonda().evaluarJugadores();
        getRonda().generarGanadores();
        ((RondaEConDinero) getRonda()).repartirRecompensa();
        ejercerEstadistica();
        ((RondaEConDinero)getRonda()).limpiarMesa();
        ((RondaEConDinero) getRonda()).limpiarSigue();
        opcionRecompraFichas();
        if(getDebug()==1) setInforme(getInforme()+generarInforme("Fin Ronda"));
        setContador(getContador()+1);

    }

    public void partidaPreflop() {
        hacerApuestas();
        ((RondaEConDinero)getRonda()).simplificarBote();
        for(int i=0;i<((RondaEConDinero)getRonda()).getSigue().size();i++){
            ((RondaEConDinero)getRonda()).getSigue().set(i,1);
        }
    }

    public void hacerApuestas(){
        for(Asiento asiento:getRonda().getMesa().getAsientos()){
            Integer allin=((AsientoConFichas) asiento).getFichas();
            ((RondaEConDinero) getRonda()).apuestaPreFlop(asiento.getPosicion(),allin);
        }
    }

    public void opcionRecompraFichas(){

        for(Asiento asiento:getRonda().getMesa().getAsientos()){
            Integer total=((AsientoConFichas) asiento).getFichas();
            if(total<=0) {
                ((RondaEConDinero) getRonda()).compraFichas(asiento.getPosicion(), 100, 200);
            }
        }

    }

    public void finalizarPartida(){

        for(Asiento asiento: getRonda().getMesa().getAsientos()){
            Integer acumuladas=((AsientoConFichas) asiento).getFichas();
            acumuladas*=2;
            Integer saldoActual=((JugadorNormal)asiento.getJugador()).getSaldo();
            saldoActual+=acumuladas;
            ((JugadorNormal)asiento.getJugador()).setSaldo(saldoActual);
        }
        ejercerEstadisticaFinalizar();
    }

    @Override
    public String generarInforme(String fase){
        String info="";
        if(getDebug()==1) {
            StringBuilder sb = new StringBuilder();

            String barra = "------------------";
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append(barra);
            sb.append(" iteracion ");
            sb.append(getContador());
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Partida");
            sb.append("\n");
            sb.append("Empezo: Sin turnos ");
            sb.append("\n");
            sb.append("Fase: ");
            sb.append(fase);
            sb.append("\n");
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Ronda:");

            sb.append("\n");
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append(getRonda().getBaraja().mostrar());
            sb.append("\n");
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");

            sb.append("Comuninitarias:");
            sb.append(getRonda().getComunitarias().mostrar());
            sb.append("\n");
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Mesa");
            sb.append("\n");
            sb.append("Tamaño:");
            sb.append(getRonda().getMesa().getTamanyo());
            sb.append("\n");
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Asientos:");
            sb.append("\n");
            ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
            String espacios = "      ";
            int tam = asientos.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append(barra);
                sb.append("asiento");
                sb.append(asientos.get(i).getPosicion());
                sb.append(barra);
                sb.append("\n");
                sb.append(espacios);
                sb.append("Pareja: ");
                sb.append(asientos.get(i).getPareja().mostrar());
                sb.append("\n");
                sb.append(espacios);
                sb.append("jerarquia :");
                if (asientos.get(i).getRango().size() > 0) sb.append(asientos.get(i).getRango().get(0).mostrar());
                sb.append("\n");
                sb.append(espacios);
                sb.append("fichas :");
                sb.append(((AsientoConFichas) asientos.get(i)).getFichas());
                sb.append("\n");

            }
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Apuestas:");
            sb.append("\n");
            ArrayList<Integer> apuestas = ((RondaEConDinero) getRonda()).getApuestas();
            tam = apuestas.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("posicion ");
                sb.append(i);
                sb.append(": ");
                sb.append(apuestas.get(i));
                sb.append("\n");

            }
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Bote:");
            sb.append("\n");
            ArrayList<Integer> bote = ((RondaEConDinero) getRonda()).getBotePrincipal();
            tam = bote.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("bote ");
                sb.append(i);
                sb.append(": ");
                sb.append(bote.get(i));
                sb.append("\n");
            }

            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Ganadores: ");
            sb.append("\n");
            ArrayList<Ganador> ganadores = new ArrayList<>();
            if(getRonda().getRankings().size()>0 &&
                    getRonda().getRankings().get(0).getPosRankings().size()>0){
                ganadores=getRonda().getRankings().get(0).getPosRankings().get(0).getGanadores();
            }
            tam = ganadores.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("Ganador ");
                sb.append(ganadores.get(i).getPosicion());
                sb.append(": ");
                if (ganadores.get(i).getJerarquia5() != null) sb.append(ganadores.get(i).getJerarquia5().mostrar());
                sb.append("\n");
                if (ganadores.get(i).getJerarquia5() != null) {
                    sb.append(espacios);
                    sb.append(ganadores.get(i).getJerarquia5().mostrarFrase());
                    sb.append("\n");
                }
            }
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Jugadores: ");
            sb.append("\n");
            tam = asientos.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("Jugador ");
                sb.append(asientos.get(i).getJugador().getPosicion());
                sb.append(": ");
                sb.append(((JugadorNormal) asientos.get(i).getJugador()).getSaldo());
                sb.append("\n");
            }
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Estadistica: ");
            sb.append("\n");
            EstadisticaA estadisticaA = (EstadisticaA) ((RondaEConDinero) getRonda()).getEstadistica();
            ArrayList<Integer> ganados = estadisticaA.getGanados();
            tam = ganados.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("Ganado ");
                sb.append(i);
                sb.append(": ");
                sb.append(ganados.get(i));
                sb.append("\n");
            }

            sb.append(espacios);
            sb.append("Total: ");
            sb.append(estadisticaA.getTotal());
            sb.append("\n");
            info+=sb.toString();
        }
        return info;
    }
}
