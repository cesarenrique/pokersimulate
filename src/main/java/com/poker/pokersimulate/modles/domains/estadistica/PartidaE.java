package com.poker.pokersimulate.modles.domains.estadistica;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.basico.Partida;
import com.poker.pokersimulate.modles.domains.basico.Ronda;

import java.util.ArrayList;

public class PartidaE extends Partida {
    public PartidaE() {
        super();
    }

    @Override
    public void iterarRonda() {
        getRonda().clear();
        getRonda().repartirCartasJugadores();
        getRonda().repartirComunitarias();
        getRonda().evaluarJugadores();
        todosIgualaron();
        getRonda().generarGanadores();
        ejercerEstadistica();
        if(getDebug()==1) setInforme(getInforme()+generarInforme("Fin Ronda"));
        setContador(getContador()+1);
    }

    public void ejercerEstadistica(){
        if(getRonda().getRankings().size()>0 && getRonda().getRankings().get(0).getPosRankings().size()>0) {
            ArrayList<Ganador> ganadores = getRonda().getRankings().get(0).getPosRankings().get(0).getGanadores();
            for (Ganador ganador : ganadores) {
                ((RondaE) getRonda()).getEstadistica().ganoMasUno(ganador.getPosicion());
            }
            ((RondaE) getRonda()).getEstadistica().totalMasUno();
        }
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
            sb.append("Sin turnos");
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
                sb.append("fichas : sin fichas");
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
                    getRonda().getRankings().get(0).getPosRankings().size()>0) {
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

                sb.append("\n");
            }
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Estadistica: ");
            sb.append("\n");
            Estadistica estadistica = ((RondaE) getRonda()).getEstadistica();
            ArrayList<Integer> ganados = estadistica.getGanados();
            tam = ganados.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("Ganado ");
                sb.append(i);
                sb.append(": ");
                sb.append(ganados.get(i));
                sb.append("\n");
            }
            info=sb.toString();
        }
        return info;
    }

}
