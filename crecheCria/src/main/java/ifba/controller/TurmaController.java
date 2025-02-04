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

import ifba.model.Turma;
import ifba.service.TurmaService;

@RestController
@RequestMapping("turma")
public class TurmaController {
	/*
	 *POST 		 save(Turma):turma 
	 *GET  		 listarAll (List<Turma>)
	 *GET  		 LocalizarPorId(id):Turma
	 *PUT 	     atualizar(turma):Turma
	 *DELETE 	 delete(int):void
	 */

	@Autowired
	private TurmaService serviceTurma;
	
	@PostMapping 
	public Turma add(@RequestBody Turma turma) {
		return serviceTurma.inserir(turma);
	}
	
	@GetMapping
	public List<Turma> listAll() { 
		return serviceTurma.listar();
	}
	@GetMapping("/{id}")
	public Optional<Turma> LocalizarPorId( @PathVariable int id) { 
		return serviceTurma.localizarPorId(id);
	}
	@PutMapping
	public Turma atualizar(@RequestBody Turma turma) {
		return serviceTurma.atualizar(turma);
	}
	@DeleteMapping("/{id}")
	public void delete( @PathVariable int id) { 
		 serviceTurma.deletarPorId(id);
	}
}
