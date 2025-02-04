package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Turma;
import ifba.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repositoryT;
	
	public Turma inserir(Turma turma ) {
		return repositoryT.save(turma);
	}
	public List<Turma> listar( ) {
		return repositoryT.findAll();
	}
	public Optional<Turma> localizarPorId(int id){
		return repositoryT.findById(id);
	}
	public Turma atualizar (Turma turma) {
		return repositoryT.save(turma);
	}
	public void deletarPorId(int id) {
		repositoryT.deleteById(id);
	}
}
