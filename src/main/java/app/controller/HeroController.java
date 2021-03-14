package app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.to.HeroTO;
import app.model.vo.HeroVO;
import app.service.HeroService;

@RestController
@RequestMapping("heroes")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {
    
    @Autowired
    private HeroService service;

    @PostMapping()
	public HeroTO create(@Valid @RequestBody HeroVO vo)  {
        return service.add(vo);
	}

    @PutMapping("{id}")
    public void update(@PathVariable("id") Integer id, @Valid @RequestBody HeroVO vo) {
		service.update(id, vo);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}

	@GetMapping("{id}")
	public HeroTO getById(@PathVariable("id") Integer id){
		return service.getById(id);
	}

	@GetMapping
	public List<HeroTO> getAlls() {
        return service.getAlls();
	}

	@GetMapping("search")
	public List<HeroTO> findByName(@RequestParam("name") String name){
		return service.findByName(name);
	}
}
