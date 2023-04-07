package com.poker.pokersimulate.modles.domains.dinero.preflop.EuUnificado.basico;

import com.poker.pokersimulate.modles.domains.basico.Asiento;
import com.poker.pokersimulate.modles.domains.basico.Ganador;
import com.poker.pokersimulate.modles.domains.dinero.basico.AsientoConFichas;
import com.poker.pokersimulate.modles.domains.dinero.basico.JugadorNormal;
import com.poker.pokersimulate.modles.domains.dinero.basico.PartidaEConDinero;
import com.poker.pokersimulate.modles.domains.dinero.basico.RondaEConDinero;
import com.poker.pokersimulate.modles.domains.estadistica.RondaE;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;

public class PartidaEAllPreflopS extends PartidaEConDinero {


    private ArrayList<EuristicaPreflopLinealExpand> euristicas;
    public PartidaEAllPreflopS() {
        super();
    }


    public ArrayList<EuristicaPreflopLinealExpand> getEuristicas() {
        return euristicas;
    }

    public void setEuristicas(ArrayList<EuristicaPreflopLinealExpand> euristicas) {
        this.euristicas = euristicas;
    }

    @Override
    public void iterarRonda() {
        Integer check1=preCheck();
        setSeguir(0);
        getRonda().clear();
        partidaPreflop();
        if (getSeguir()==1) {
            partidaPostflop();
        }else{
            terminarPartidaEnPreflop();
        }
        Integer check2=preCheck();
        opcionRecompraFichas();
        if(getDebug()==1){
            setInforme(getInforme()+generarInforme("Fin Ronda"));
        }else if(getDebug()==2 && !check1.equals(check2)){
            setInforme(getInforme()+"\nAlerta: Se esperaba "+check1+" se obtuvo: "+check2+"\n");
            setInforme(getInforme()+generarInforme("Fin Ronda"));
        }
        setContador(getContador()+1);

    }

    public void partidaPreflop() {
        getRonda().repartirCartasJugadores();
        hacerApuestas();
        ((RondaEConDinero)getRonda()).simplificarBote();
        evaluarSiPasanPostflop();
    }

    public void evaluarSiPasanPostflop(){

        Integer intensionSeguir=((RondaEConDinero) getRonda()).intencionSeguir();
        if(intensionSeguir>1) {
            setSeguir(1);
        }else if(intensionSeguir==1){
            setSeguir(0);
        }else{
            setSeguir(0);
        }
    }



    public void hacerApuestas(){
        ArrayList<Asiento> asientos = getRonda().getMesa().getAsientos();
        int tam=asientos.size();
        for(int i=0;i<tam;i++){

           if(euristicas.get(i).dentroEuristica(asientos.get(i).getPareja())) {
                Integer allin = ((AsientoConFichas) asientos.get(i)).getFichas();
                ((RondaEPreflop)getRonda()).apuestaPreFlop(asientos.get(i).getPosicion(), allin);
                ((RondaEPreflop)getRonda()).getSigue().set(i,1);
                Integer estAnt= ((EstadisticaA)((RondaEPreflop) getRonda()).getEstadistica()).getPreflopSeguir().get(i);
                estAnt++;
                ((EstadisticaA)((RondaEPreflop) getRonda()).getEstadistica()).getPreflopSeguir().set(i,estAnt);
           }
        }
    }




    public void terminarPartidaEnPreflop() {

        ((RondaEPreflop) getRonda()).generarGanadoresPreflop();
        ((RondaEPreflop) getRonda()).repartirRecompensa();
        ejercerEstadisticaPreflop();
        ejercerEstadistica();

    }

    public void opcionRecompraFichas(){

        for(Asiento asiento:getRonda().getMesa().getAsientos()){
            Integer total=((AsientoConFichas) asiento).getFichas();
            if(total<=0) {
                ((RondaEConDinero) getRonda()).compraFichas(asiento.getPosicion(), 100, 200);
            }
        }

    }

    public void partidaPostflop(){
        getRonda().repartirComunitarias();
        getRonda().evaluarJugadores();
        getRonda().generarGanadores();
        ((RondaEConDinero) getRonda()).repartirRecompensa();
        ejercerEstadisticaPostflop();
        ejercerEstadistica();
        ((RondaEConDinero)getRonda()).limpiarMesa();
        ((RondaEConDinero) getRonda()).limpiarSigue();
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
        ((RondaEPreflop)getRonda()).getEstadistica().generarPorcentaje();
    }

    public void ejercerEstadisticaPreflop(){
        if(getRonda().getRankings().size()>0 && getRonda().getRankings().get(0).getPosRankings().size()>0) {
            ArrayList<Ganador> ganadores = getRonda().getRankings().get(0).getPosRankings().get(0).getGanadores();
            for (Ganador ganador : ganadores) {
                ((EstadisticaA) ((RondaE) getRonda()).getEstadistica()).ganadosPreflopMasUno(ganador.getPosicion());
            }
        }
    }

    public void ejercerEstadisticaPostflop(){
        if(getRonda().getRankings().size()>0 && getRonda().getRankings().get(0).getPosRankings().size()>0) {
            ArrayList<Ganador> ganadores = getRonda().getRankings().get(0).getPosRankings().get(0).getGanadores();
            for (Ganador ganador : ganadores) {
                ((EstadisticaA) ((RondaE) getRonda()).getEstadistica()).ganadosPostflopMasUno(ganador.getPosicion());
            }
        }
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
            sb.append("Empezo: Sin Turnos ");
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
            EstadisticaA estadistica = (EstadisticaA) ((RondaEPreflop) getRonda()).getEstadistica();
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
            ArrayList<Integer> preflopSeguir = estadistica.getPreflopSeguir();
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
            sb.append(estadistica.getTotal());
            sb.append("\n");
            s+=sb.toString();
        }
        return s;
    }
}
