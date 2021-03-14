package app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.model.entity.Hero;

public interface HeroRepository extends CrudRepository<Hero, Integer>{
    List<Hero> findByHeroNameContainingIgnoreCase(String heroName);
}
