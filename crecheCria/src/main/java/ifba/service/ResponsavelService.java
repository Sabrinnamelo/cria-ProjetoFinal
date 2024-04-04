package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.Responsavel;
import ifba.repository.ResponsavelRepository;

@Service
public class ResponsavelService {

	@Autowired
	private ResponsavelRepository repository;
	
	public Responsavel inserir(Responsavel responsavel ) {
		return repository.save(responsavel);
	}
	public List<Responsavel> listar( ) {
		return repository.findAll();
	}
	public Optional<Responsavel> localizarPorId(int id){
		return repository.findById(id);
	}
	public Responsavel atualizar (Responsavel responsavel) {
		return repository.save(responsavel);
	}
	public void deletarPorId(int id) {
		repository.deleteById(id);
	}
}
