package ifba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifba.model.Saude;

@Repository
public interface SaudeRepository extends JpaRepository<Saude,Integer> {

	 
}
