package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.entity.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer>{
    
}
