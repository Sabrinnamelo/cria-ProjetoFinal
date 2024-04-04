package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Professora;
import ifba.repository.ProfessoraRepository;

@Service
public class ProfessoraService {

	@Autowired
	private ProfessoraRepository repositoryEnd;
	
	public Professora inserir(Professora professora ) {
		return repositoryEnd.save(professora);
	}
	public List<Professora> listar( ) {
		return repositoryEnd.findAll();
	}
	public Optional<Professora> localizarPorId(int id){
		return repositoryEnd.findById(id);
	}
	public Professora atualizar (Professora professora) {
		return repositoryEnd.save(professora);
	}
	public void deletarPorId(int id) {
		repositoryEnd.deleteById(id);
	}
}
