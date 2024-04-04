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

import ifba.model.Responsavel;
import ifba.service.ResponsavelService;

@RestController
@RequestMapping("responsavel")
public class ResponsavelController {
	/*
	 *POST 		 save(Responsavel):responsavel 
	 *GET  		 listarAll (List<Responsavel>)
	 *GET  		 LocalizarPorId(id):Responsavel
	 *PUT 	     atualizar(responsavel):Responsavel
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private ResponsavelService serviceResponsavel;
	
	@PostMapping 
	public Responsavel add(@RequestBody Responsavel responsavel) {
		return serviceResponsavel.inserir(responsavel);
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
