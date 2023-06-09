package it.prova.raccoltafilm.dao;

import java.util.List;
import java.util.Optional;

import it.prova.raccoltafilm.model.Film;
import it.prova.raccoltafilm.model.Ruolo;
import it.prova.raccoltafilm.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	List<Utente> findAllByRuolo(Ruolo ruoloInput) throws Exception;

	Optional<Utente> findByUsernameAndPassword(String username, String password) throws Exception;

	Optional<Utente> login(String username, String password) throws Exception;

	List<Utente> findByExample(Utente example) throws Exception;
	
	List<Utente> findByExampleEager(Utente example) throws Exception;
	
	Optional<Utente> findOneEager(Long id) throws Exception;

}
