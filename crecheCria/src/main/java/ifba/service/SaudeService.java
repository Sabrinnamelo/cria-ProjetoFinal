package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Saude;
import ifba.repository.SaudeRepository;

@Service
public class SaudeService {

	@Autowired
	private SaudeRepository repositoryEnd;
	
	public Saude inserir(Saude saude ) {
		return repositoryEnd.save(saude);
	}
	public List<Saude> listar( ) {
		return repositoryEnd.findAll();
	}
	public Optional<Saude> localizarPorId(int id){
		return repositoryEnd.findById(id);
	}
	public Saude atualizar (Saude saude) {
		return repositoryEnd.save(saude);
	}
	public void deletarPorId(int id) {
		repositoryEnd.deleteById(id);
	}
}
