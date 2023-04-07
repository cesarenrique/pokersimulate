package com.poker.pokersimulate.modles.domains.basico;


import java.util.ArrayList;

public class Partida {

    private Ronda ronda;

    private Integer seguir;
    private Integer contador;
    private Integer debug;
    private String informe;
    public Partida() {
        contador=0;
        debug=0;
        informe="";
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Integer getDebug() {
        return debug;
    }

    public void setDebug(Integer debug) {
        this.debug = debug;
    }

    public Integer getSeguir() {
        return seguir;
    }

    public void setSeguir(Integer seguir) {
        this.seguir = seguir;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public void iterarRondas(Integer veces){
        for(int i=0;i<veces;i++){
            iterarRonda();
        }
    }
    public void iterarRonda(){
        ronda.clear();
        ronda.repartirCartasJugadores();
        ronda.repartirComunitarias();
        ronda.evaluarJugadores();
        todosIgualaron();
        ronda.generarGanadores();
        if(debug==1) informe+=generarInforme("Fin Ronda");
        contador++;
    }

    public void todosIgualaron(){
        ronda.getIgualadas().clear();
        ArrayList<Integer> igualo=new ArrayList<>();
        for(int i=0;i<ronda.getMesa().getTamanyo();i++){
            igualo.add(i);
        }
        ronda.getIgualadas().add(igualo);
    }

    public String generarInforme(String fase){
        String info="";
        if(debug==1) {
            StringBuilder sb = new StringBuilder();

            String barra = "------------------";
            sb.append(barra);
            sb.append(barra);
            sb.append(barra);
            sb.append("\n");
            sb.append(barra);
            sb.append(" iteracion ");
            sb.append(contador);
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

            info=sb.toString();
        }
        return info;
    }

}
