package com.poker.pokersimulate.models.dao;

import com.poker.pokersimulate.models.entity.SegmentacionFormal;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("SegmentacionFormalDAOImpl")
public class SegmentacionFormalDAOImpl implements ISegmentacionFormalDAO {

    @Autowired
    private ISegmentacionFormalDAO segmentacionFormalDAO;

    @Transactional
    @Override
    public <S extends SegmentacionFormal> S save(S entity) {
        return segmentacionFormalDAO.save(entity);
    }

    @Transactional
    @Override
    public <S extends SegmentacionFormal> Iterable<S> saveAll(Iterable<S> entities) {
        return segmentacionFormalDAO.saveAll(entities);
    }

    @Transactional
    @Override
    public Optional<SegmentacionFormal> findById(Long aLong) {
        return segmentacionFormalDAO.findById(aLong);
    }

    @Transactional
    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public Iterable<SegmentacionFormal> findAll() {
        return segmentacionFormalDAO.findAll();
    }

    @Transactional
    @Override
    public Iterable<SegmentacionFormal> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Transactional
    @Override
    public long count() {
        return 0;
    }

    @Transactional
    @Override
    public void deleteById(Long aLong) {

    }

    @Transactional
    @Override
    public void delete(SegmentacionFormal entity) {

    }

    @Transactional
    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Transactional
    @Override
    public void deleteAll(Iterable<? extends SegmentacionFormal> entities) {

    }

    @Transactional
    @Override
    public void deleteAll() {
        segmentacionFormalDAO.deleteAll();
    }
}
