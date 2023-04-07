package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.turno.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.basico.JugadorNormal;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.EstadisticaA;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.PartidaEAllPreflopS;
import com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico.RondaEPreflop;

import java.util.ArrayList;

public class PartidaEAllPreflopST extends PartidaEAllPreflopS {
    private Integer turnoPrincipal;
    private Integer turnoPreflop;
    private Integer turnoPrincipalAnterior;
    private Integer ultimo;
    public PartidaEAllPreflopST() {
        super();
        turnoPreflop=0;
        turnoPrincipal=0;
        turnoPrincipalAnterior=1;
    }

    public Integer getUltimo() {
        return ultimo;
    }

    public void setUltimo(Integer ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getTurnoPrincipalAnterior() {
        return turnoPrincipalAnterior;
    }

    public void setTurnoPrincipalAnterior(Integer turnoPrincipalAnterior) {
        this.turnoPrincipalAnterior = turnoPrincipalAnterior;
    }

    public Integer getTurnoPrincipal() {
        return turnoPrincipal;
    }

    public void setTurnoPrincipal(Integer turnoPrincipal) {
        this.turnoPrincipal = turnoPrincipal;
    }

    public Integer getTurnoPreflop() {
        return turnoPreflop;
    }

    public void setTurnoPreflop(Integer turnoPreflop) {
        this.turnoPreflop = turnoPreflop;
    }

    public void cambiarTurnoPreflop(){
        turnoPreflop++;
        if(turnoPreflop.equals(getRonda().getMesa().getTamanyo())){
            turnoPreflop=0;
        }
    }

    public void cambiarTurnoPrincipal(){
        turnoPrincipalAnterior=turnoPrincipal;
        turnoPrincipal++;
        if(turnoPrincipal.equals(getRonda().getMesa().getTamanyo())){
            turnoPrincipal=0;
        }
    }

    @Override
    public void hacerApuestas(){
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
        cambiarTurnoPrincipal();
        turnoPreflop=turnoPrincipal;
        ultimo=turnoPrincipal;

        do {
            if (getRankingPreflopEuristicas().get(turnoPreflop).getEuristicas().get(0).dentroEuristica(asientos.get(turnoPreflop).getPareja())) {
                Integer allin = ((AsientoConFichas) asientos.get(turnoPreflop)).getFichas();
                ((RondaEPreflop) getRonda()).apuesta(asientos.get(turnoPreflop).getPosicion(), allin);
                ((RondaEPreflop) getRonda()).getSigue().set(turnoPreflop, 1);
            }
            cambiarTurnoPreflop();
        }while(!turnoPreflop.equals(ultimo));
        Integer intencionSeguir=((RondaEPreflop)getRonda()).intencionSeguir();
        if(intencionSeguir==0){
            ((RondaEPreflop) getRonda()).getSigue().set(turnoPreflop, 1);
        }
    }

    public void marcarQuienSiguePreflop(){
        for(int i=0;i<getRonda().getMesa().getTamanyo();i++) {
            if( ((RondaEPreflop) getRonda()).getSigue().get(i)==1) {
                Integer estAnt = ((EstadisticaA) ((RondaEPreflop) getRonda()).getEstadistica()).getPreflopSeguir().get(i);
                estAnt++;
                ((EstadisticaA) ((RondaEPreflop) getRonda()).getEstadistica()).getPreflopSeguir().set(i, estAnt);
            }
        }
    }

    @Override
    public void partidaPreflop() {
        super.partidaPreflop();
        marcarQuienSiguePreflop();
    }

    @Override
    public String generarInforme(String fase){
        String s="";
        if(getDebug()==1 || getDebug()==2) {
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
            ArrayList<Integer> apuestas = ((RondaEPreflop) getRonda()).getApuestas();
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
            ArrayList<Integer> bote = ((RondaEPreflop) getRonda()).getBotePrincipal();
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
            EstadisticaA estadisticaAB2 = (EstadisticaA) ((RondaEPreflop) getRonda()).getEstadistica();
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
            s+=sb.toString();
        }
        return s;
    }
}
