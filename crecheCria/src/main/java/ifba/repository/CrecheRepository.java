package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Creche;

@Repository
public interface CrecheRepository extends JpaRepository<Creche,Integer> {

	 
}
