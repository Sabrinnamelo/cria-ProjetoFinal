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

import ifba.model.Matricula;
import ifba.service.MatriculaService;

@RestController
@RequestMapping("matricula")
public class MatriculaController {
	/*
	 *POST 		 save(Matricula):matricula 
	 *GET  		 listarAll (List<Matricula>)
	 *GET  		 LocalizarPorId(id):Matricula
	 *PUT 	     atualizar(matricula):Matricula
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private MatriculaService serviceMatricula;
	
	@PostMapping 
	public Matricula add(@RequestBody Matricula matricula) {
		return serviceMatricula.inserir(matricula);
	}
	
	@GetMapping
	public List<Matricula> listAll() { 
		return serviceMatricula.listar();
	}
	@GetMapping("/{id}")
	public Optional<Matricula> LocalizarPorId( @PathVariable int id) { 
		return serviceMatricula.localizarPorId(id);
	}
	@PutMapping
	public Matricula atualizar(@RequestBody Matricula matricula) {
		return serviceMatricula.atualizar(matricula);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceMatricula.deletarPorId(id);
	}
}
