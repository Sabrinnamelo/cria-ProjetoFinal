package ifba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifba.model.Turma;
import ifba.service.TurmaService;

@RestController
@RequestMapping("turma")
public class TurmaController {

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
}
