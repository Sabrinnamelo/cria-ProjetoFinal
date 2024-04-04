package ifba.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifba.model.Professora;
import ifba.service.ProfessoraService;

@RestController
@RequestMapping("professora")
public class ProfessoraController {
	/*
	 *POST 		 save(Professora):professora 
	 *GET  		 listarAll (List<Professora>)
	 *GET  		 LocalizarPorId(id):Professora
	 *PUT 	     atualizar(professora):Professora
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private ProfessoraService serviceProfessora;
	
	@PostMapping 
	public Professora add(@RequestBody Professora professora) {
		return serviceProfessora.inserir(professora);
	}
	
	@GetMapping
	public List<Professora> listAll() { 
		return serviceProfessora.listar();
	}
	@GetMapping("/{id}")
	public Optional<Professora> LocalizarPorId( @PathVariable int id) { 
		return serviceProfessora.localizarPorId(id);
	}
	@PutMapping
	public Professora atualizar(@RequestBody Professora professora) {
		return serviceProfessora.atualizar(professora);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceProfessora.deletarPorId(id);
	}
}
