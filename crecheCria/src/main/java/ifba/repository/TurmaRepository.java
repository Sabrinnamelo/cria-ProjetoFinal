package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma,Integer> {

	 
}
