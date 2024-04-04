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

import ifba.model.ResponsavelRetirada;
import ifba.service.ResponsavelRetiradaService;

@RestController
@RequestMapping("responsavelRetirada")
public class ResponsavelRetiradaController {
	/*
	 *POST 		 save(ResponsavelRetirada):responsavelRetirada 
	 *GET  		 listarAll (List<ResponsavelRetirada>)
	 *GET  		 LocalizarPorId(id):ResponsavelRetirada
	 *PUT 	     atualizar(responsavelRetirada):ResponsavelRetirada
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private ResponsavelRetiradaService serviceResponsavelRetirada;
	
	@PostMapping 
	public ResponsavelRetirada add(@RequestBody ResponsavelRetirada responsavelRetirada) {
		return serviceResponsavelRetirada.inserir(responsavelRetirada);
	}
	
	@GetMapping
	public List<ResponsavelRetirada> listAll() { 
		return serviceResponsavelRetirada.listar();
	}
	@GetMapping("/{id}")
	public Optional<ResponsavelRetirada> LocalizarPorId( @PathVariable int id) { 
		return serviceResponsavelRetirada.localizarPorId(id);
	}
	@PutMapping
	public ResponsavelRetirada atualizar(@RequestBody ResponsavelRetirada responsavelRetirada) {
		return serviceResponsavelRetirada.atualizar(responsavelRetirada);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceResponsavelRetirada.deletarPorId(id);
	}
}
