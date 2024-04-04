package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula,Integer> {

	 
}
