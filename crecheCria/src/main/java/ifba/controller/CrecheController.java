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

import ifba.model.Creche;
import ifba.service.CrecheService;

@RestController
@RequestMapping("creche")
public class CrecheController {
	/*
	 *POST 		 save(Creche):creche 
	 *GET  		 listarAll (List<Creche>)
	 *GET  		 LocalizarPorId(id):Creche
	 *PUT 	     atualizar(creche):Creche
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private CrecheService serviceCreche;
	
	@PostMapping 
	public Creche add(@RequestBody Creche creche) {
		return serviceCreche.inserir(creche);
	}
	
	@GetMapping
	public List<Creche> listAll() { 
		return serviceCreche.listar();
	}
	@GetMapping("/{id}")
	public Optional<Creche> LocalizarPorId( @PathVariable int id) { 
		return serviceCreche.localizarPorId(id);
	}
	@PutMapping
	public Creche atualizar(@RequestBody Creche creche) {
		return serviceCreche.atualizar(creche);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceCreche.deletarPorId(id);
	}
}
