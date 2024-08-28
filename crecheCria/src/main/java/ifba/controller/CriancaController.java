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

import ifba.model.Crianca;
import ifba.model.ResponsavelRetirada;
import ifba.service.CriancaService;

@RestController
@RequestMapping("crianca")
public class CriancaController {
	/*
	 *POST 		 save(Crianca):crianca 
	 *GET  		 listarAll (List<Crianca>)
	 *GET  		 LocalizarPorId(id):Crianca
	 *PUT 	     atualizar(crianca):Crianca
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private CriancaService serviceCrianca;
	
	@PostMapping 
	public Crianca add(@RequestBody Crianca crianca) {
		return serviceCrianca.inserir(crianca);
	}
	
	@GetMapping
	public List<Crianca> listAll() { 
		return serviceCrianca.listar();
	}
	@GetMapping("/{id}")
	public Optional<Crianca> LocalizarPorId( @PathVariable int id) { 
		return serviceCrianca.localizarPorId(id);
	}
	@PutMapping
	public Crianca atualizar(@RequestBody Crianca crianca) {
		return serviceCrianca.atualizar(crianca);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceCrianca.deletarPorId(id);
	}
	@PutMapping("/responsavel/{id}")
	public Crianca addResponsavelR(@RequestBody ResponsavelRetirada responsavelR , @PathVariable int id) {
		Crianca crianca = serviceCrianca.localizarPorId(id).get();
		crianca.addResponsavelRetirada(responsavelR);
		return serviceCrianca.atualizar(crianca); 
	}
}
