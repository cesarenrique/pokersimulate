package com.poker.pokersimulate.models.service.basedatos;

import com.poker.pokersimulate.models.dao.ISegmentacionFormalDAO;
import com.poker.pokersimulate.models.data.PreFlopEData;
import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import com.poker.pokersimulate.modles.domains.basico.Carta;
import com.poker.pokersimulate.modles.domains.basico.Pareja;
import com.poker.pokersimulate.modles.domains.jerarquia.PreflopE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioSegmentacionFormal {
    @Autowired
    @Qualifier("SegmentacionFormalDAOImpl")
    private ISegmentacionFormalDAO segmentacionFormalDAO;

    public ArrayList<PreFlopEData> presentarLista() {
        Iterable<SegmentacionFormal> segmentacionFormals = segmentacionFormalDAO.findAll();

        ArrayList<PreFlopEData> preFlopEDatas = new ArrayList<>();
        for (SegmentacionFormal formal : segmentacionFormals) {
            PreFlopEData preFlopEData = new PreFlopEData();
            Pareja pareja = new Pareja();
            pareja.getCartas().add(new Carta(formal.getNumero1(), formal.getPalo1()));
            pareja.getCartas().add(new Carta(formal.getNumero2(), formal.getPalo2()));
            preFlopEData.setPareja(pareja);
            preFlopEData.setPorcentaje(formal.getPorcentaje());
            preFlopEData.setId(formal.getId());
            preFlopEDatas.add(preFlopEData);
        }

        return preFlopEDatas;
    }

    public void guardadatos(ArrayList<PreflopE> preflopES){
        segmentacionFormalDAO.deleteAll();
        for(PreflopE preflopE:preflopES){
            SegmentacionFormal seg=new SegmentacionFormal();
            seg.setNumero1(preflopE.getPareja().getCartas().get(0).getNumero());
            seg.setNumero2(preflopE.getPareja().getCartas().get(1).getNumero());
            seg.setPalo1(preflopE.getPareja().getCartas().get(0).getPalo());
            seg.setPalo2(preflopE.getPareja().getCartas().get(1).getPalo());
            seg.setPorcentaje(preflopE.getEstadistica().getGano());
            segmentacionFormalDAO.save(seg);
        }
    }

    public ArrayList<SegmentacionFormal> listaSegmentada() {
        Iterable<SegmentacionFormal> segmentacionFormals = segmentacionFormalDAO.findAll();
        List<SegmentacionFormal> result=new ArrayList<>();
        segmentacionFormals.forEach(result::add);
        return (ArrayList<SegmentacionFormal>) result;
    }
}
