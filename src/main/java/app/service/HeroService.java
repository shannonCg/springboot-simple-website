package app.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.error.exception.PathIdNotFoundException;
import app.model.entity.Hero;
import app.model.to.HeroTO;
import app.model.vo.HeroVO;
import app.repository.HeroRepository;

@Service
public class HeroService {
    
    @Autowired
    private HeroRepository dao;

    public void add(HeroVO vo){
        Hero entity = new Hero();
        saveByVO(entity, vo);
    }

    public void update(Integer id, HeroVO vo){
        Hero entity = _getById(id);
        saveByVO(entity, vo);
    }

    private void saveByVO(Hero entity, HeroVO vo){
        entity.setHeroName(vo.getName());
        dao.save(entity);
    }

    public void deleteById(Integer id){
        Hero entity = _getById(id);
        dao.delete(entity);
    }
    
    public HeroTO getById(Integer id){
        Hero entity = _getById(id);
        return HeroTO.convertFrom(entity);
    }
    
    private Hero _getById(Integer id){
        return dao.findById(id)
                    .orElseThrow(() -> new PathIdNotFoundException("id", String.valueOf(id)));
    }
    
    public List<HeroTO> getAlls(){
        return StreamSupport.stream(dao.findAll().spliterator(), false)
                            .map(e -> HeroTO.convertFrom(e))
                            .collect(Collectors.toList());
    }
}
