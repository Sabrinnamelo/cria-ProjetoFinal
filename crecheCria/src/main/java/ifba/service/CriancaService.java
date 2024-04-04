package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Crianca;
import ifba.repository.CriancaRepository;

@Service
public class CriancaService {

	@Autowired
	private CriancaRepository repository;
	
	public Crianca inserir(Crianca crianca ) {
		return repository.save(crianca);
	}
	public List<Crianca> listar( ) {
		return repository.findAll();
	}
	public Optional<Crianca> localizarPorId(int id){
		return repository.findById(id);
	}
	public Crianca atualizar (Crianca crianca) {
		return repository.save(crianca);
	}
	public void deletarPorId(int id) {
		repository.deleteById(id);
	}
}
