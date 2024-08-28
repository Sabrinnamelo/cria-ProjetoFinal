package ifba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ifba.model.Professora;
import ifba.model.Responsavel;
import ifba.service.ResponsavelService;
import ifba.repository.ResponsavelRepository;

@RestController
@RequestMapping("responsavel")
public class ResponsavelController {
	
	@Autowired
	private ResponsavelService serviceResponsavel;

    @Autowired
    private ResponsavelRepository responsavelRepository;

	
	@PostMapping 
	public Responsavel add(@RequestBody Responsavel responsavel) {
		return responsavelRepository.save(responsavel);
	}
	
	
	@GetMapping
	public List<Responsavel> listAll() { 
		return serviceResponsavel.listar();
	}
	
	@GetMapping("/{id}")
	public Optional<Responsavel> LocalizarPorId( @PathVariable int id) { 
		return serviceResponsavel.localizarPorId(id);
	}
	
	@PutMapping
	public Responsavel atualizar(@RequestBody Responsavel responsavel) {
		return serviceResponsavel.atualizar(responsavel);
	}
	
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceResponsavel.deletarPorId(id);
	}
}
