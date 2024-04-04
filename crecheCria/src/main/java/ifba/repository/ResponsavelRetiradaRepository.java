package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.ResponsavelRetirada;

@Repository
public interface ResponsavelRetiradaRepository extends JpaRepository<ResponsavelRetirada,Integer> {

	 
}
