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

import ifba.model.Endereco;
import ifba.service.EnderecoService;

@RestController
@RequestMapping("endereco")
public class EnderecoController {
	/*
	 *POST 		 save(Endereco):endereco 
	 *GET  		 listarAll (List<Endereco>)
	 *GET  		 LocalizarPorId(id):Endereco
	 *PUT 	     atualizar(endereco):Endereco
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private EnderecoService serviceEndereco;
	
	@PostMapping 
	public Endereco add(@RequestBody Endereco endereco) {
		return serviceEndereco.inserir(endereco);
	}
	
	@GetMapping
	public List<Endereco> listAll() { 
		return serviceEndereco.listar();
	}
	@GetMapping("/{id}")
	public Optional<Endereco> LocalizarPorId( @PathVariable int id) { 
		return serviceEndereco.localizarPorId(id);
	}
	@PutMapping
	public Endereco atualizar(@RequestBody Endereco endereco) {
		return serviceEndereco.atualizar(endereco);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceEndereco.deletarPorId(id);
	}
}
