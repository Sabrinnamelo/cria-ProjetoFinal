package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Crianca;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca,Integer> {

	 
}
