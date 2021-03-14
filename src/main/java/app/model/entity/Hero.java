package app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hero")
public class Hero {
    
    @Id
    @Column(name="hero_id")
    private Integer heroId;

    @Column(name="hero_name", length = 10, nullable = false)
    private String heroName;

    public Integer getHeroId() {
        return heroId;
    }

    public void setHeroId(Integer heroId) {
        this.heroId = heroId;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
    
}
