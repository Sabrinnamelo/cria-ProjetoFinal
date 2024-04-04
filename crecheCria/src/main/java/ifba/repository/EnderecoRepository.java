package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {

	 
}
