package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Creche;
import ifba.repository.CrecheRepository;

@Service
public class CrecheService {

	@Autowired
	private CrecheRepository repository;
	
	public Creche inserir(Creche creche ) {
		return repository.save(creche);
	}
	public List<Creche> listar( ) {
		return repository.findAll();
	}
	public Optional<Creche> localizarPorId(int id){
		return repository.findById(id);
	}
	public Creche atualizar (Creche creche) {
		return repository.save(creche);
	}
	public void deletarPorId(int id) {
		repository.deleteById(id);
	}
}
