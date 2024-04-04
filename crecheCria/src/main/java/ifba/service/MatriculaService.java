package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Matricula;
import ifba.repository.MatriculaRepository;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repository;
	
	public Matricula inserir(Matricula matricula ) {
		return repository.save(matricula);
	}
	public List<Matricula> listar( ) {
		return repository.findAll();
	}
	public Optional<Matricula> localizarPorId(int id){
		return repository.findById(id);
	}
	public Matricula atualizar (Matricula matricula) {
		return repository.save(matricula);
	}
	public void deletarPorId(int id) {
		repository.deleteById(id);
	}
}
