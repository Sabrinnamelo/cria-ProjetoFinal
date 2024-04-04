package ifba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifba.model.ResponsavelRetirada;
import ifba.repository.ResponsavelRetiradaRepository;

@Service
public class ResponsavelRetiradaService {

	@Autowired
	private ResponsavelRetiradaRepository repository;
	
	public ResponsavelRetirada inserir(ResponsavelRetirada responsavelRetirada ) {
		return repository.save(responsavelRetirada);
	}
	public List<ResponsavelRetirada> listar( ) {
		return repository.findAll();
	}
	public Optional<ResponsavelRetirada> localizarPorId(int id){
		return repository.findById(id);
	}
	public ResponsavelRetirada atualizar (ResponsavelRetirada responsavelRetirada) {
		return repository.save(responsavelRetirada);
	}
	public void deletarPorId(int id) {
		repository.deleteById(id);
	}
}
