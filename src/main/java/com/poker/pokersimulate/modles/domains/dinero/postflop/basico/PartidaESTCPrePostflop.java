package com.poker.pokersimulate.modles.domains.dinero.postflop.basico;

import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EuristicaPreflopLinealExpand;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.ciegas.PartidaEAllPreflopSTC;

import java.util.ArrayList;

public class PartidaESTCPrePostflop extends PartidaEAllPreflopSTC {


    private ArrayList<EuristicaPreflopLinealExpand> euristicas2;
    public PartidaESTCPrePostflop() {
        super();
        //setContador(0);
        //setDebug(1);

    }
/*

    public ArrayList<EuristicaPreflopLinealExpand> getEuristicas2() {
        return euristicas2;
    }

    public void setEuristicas2(ArrayList<EuristicaPreflopLinealExpand> euristicas2) {
        this.euristicas2 = euristicas2;
    }


    public void generarInforme2(String fase){
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
            sb.append("Empezo: posicion ");
            sb.append(getTurnoPrincipal());
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
            sb.append(getRonda().getBaraja().mostrarCartas());
            sb.append("\n");
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");

            sb.append("Comuninitarias:");
            sb.append(getRonda().getComunitarias().mostrarCartas());
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
                sb.append(asientos.get(i).getPareja().mostrarCartas());
                sb.append("\n");
                sb.append(espacios);
                sb.append("jerarquia :");
                if (asientos.get(i).getRango().size() > 0) sb.append(asientos.get(i).getRango().get(0).mostrar());
                sb.append("\n");
                sb.append(espacios);
                sb.append("fichas :");
                sb.append(((AsientosConFichas) asientos.get(i)).getFichas());
                sb.append("\n");

            }
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append("Datos Apuestas:");
            sb.append("\n");
            ArrayList<Integer> apuestas = ((RondaESPrePostflop) getRonda()).getApuestas();
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
            ArrayList<Integer> bote = ((RondaESPrePostflop) getRonda()).getBotePrincipal();
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
            if(getRonda().getRanking().getPosRankings().size()>0) ganadores=getRonda().getRanking().getPosRankings().get(0).getGanadores();
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
            EstadisticaAB estadisticaAB2 = (EstadisticaAB) ((RondaESPrePostflop) getRonda()).getEstadistica();
            ArrayList<Integer> ganados = estadisticaAB2.getGanados();
            tam = ganados.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("Ganado ");
                sb.append(i);
                sb.append(": ");
                sb.append(ganados.get(i));
                sb.append("\n");
            }
            ArrayList<Integer> preflopSeguir = estadisticaAB2.getPreflopSeguir();
            sb.append(espacios);
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            tam = preflopSeguir.size();
            for (int i = 0; i < tam; i++) {
                sb.append(espacios);
                sb.append("Seguir Preflop ");
                sb.append(i);
                sb.append(": ");
                sb.append(preflopSeguir.get(i));
                sb.append("\n");
            }
            sb.append(espacios);
            sb.append("Total: ");
            sb.append(estadisticaAB2.getTotal());
            sb.append("\n");
            System.out.println(sb.toString());
        }
    }

    @Override
    public void iterarRonda() {
        super.iterarRonda();
        generarInforme2("fin Ronda");
        setContador(getContador()+1);
    }

    @Override
    public Ronda partidaPreflop(Ronda ronda) {
        ronda= super.partidaPreflop(ronda);
        generarInforme2("Fase PreFlop Acabada");
        return ronda;
    }

    @Override
    public Ronda apuestaObligatoria(Ronda ronda) {
        ronda= super.apuestaObligatoria(ronda);
        generarInforme2("Fase Apuesta Obligatoria");
        return ronda;
    }

    @Override
    public Ronda rondaApuestasTerminada(Ronda ronda) {
        generarInforme2("Fase Apuestas Terminada");
        return super.rondaApuestasTerminada(ronda);
    }*/
}
