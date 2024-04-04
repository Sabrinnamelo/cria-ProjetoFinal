package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Professora;

@Repository
public interface ProfessoraRepository extends JpaRepository<Professora,Integer> {

	 
}
