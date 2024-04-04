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

import ifba.model.Saude;
import ifba.service.SaudeService;

@RestController
@RequestMapping("saude")
public class SaudeController {
	/*
	 *POST 		 save(Saude):saude 
	 *GET  		 listarAll (List<Saude>)
	 *GET  		 LocalizarPorId(id):Saude
	 *PUT 	     atualizar(saude):Saude
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private SaudeService serviceSaude;
	
	@PostMapping 
	public Saude add(@RequestBody Saude saude) {
		return serviceSaude.inserir(saude);
	}
	
	@GetMapping
	public List<Saude> listAll() { 
		return serviceSaude.listar();
	}
	@GetMapping("/{id}")
	public Optional<Saude> LocalizarPorId( @PathVariable int id) { 
		return serviceSaude.localizarPorId(id);
	}
	@PutMapping
	public Saude atualizar(@RequestBody Saude saude) {
		return serviceSaude.atualizar(saude);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceSaude.deletarPorId(id);
	}
}
