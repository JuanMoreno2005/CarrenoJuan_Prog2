package co.edu.unbosque.CarrenoJuan_Prog2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.CarrenoJuan_Prog2.model.Investigador;

public interface InvestigadorRepository extends CrudRepository<Investigador, Integer>{
	
	public List<Investigador> findAll();
	public Optional<Investigador> findById(Integer id);
	
}
