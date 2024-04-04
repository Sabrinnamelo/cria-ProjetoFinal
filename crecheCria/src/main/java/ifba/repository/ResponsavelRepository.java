package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel,Integer> {

	 
}
