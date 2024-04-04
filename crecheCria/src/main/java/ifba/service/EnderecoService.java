package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Endereco;
import ifba.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositoryEnd;
	
	public Endereco inserir(Endereco endereco ) {
		return repositoryEnd.save(endereco);
	}
	public List<Endereco> listar( ) {
		return repositoryEnd.findAll();
	}
	public Optional<Endereco> localizarPorId(int id){
		return repositoryEnd.findById(id);
	}
	public Endereco atualizar (Endereco endereco) {
		return repositoryEnd.save(endereco);
	}
	public void deletarPorId(int id) {
		repositoryEnd.deleteById(id);
	}
}
