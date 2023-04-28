package it.prova.raccoltafilm.service;

import java.util.List;

import it.prova.raccoltafilm.dao.FilmDAO;
import it.prova.raccoltafilm.model.Film;

public interface FilmService {

	List<Film> listAllElements() throws Exception;

	Film caricaSingoloElemento(Long id) throws Exception;

	Film caricaSingoloElementoEager(Long id) throws Exception;

	void aggiorna(Film filmInstance) throws Exception;

	void inserisciNuovo(Film filmInstance) throws Exception;

	void rimuovi(Long idFilmToRemove) throws Exception;

	List<Film> findByExample(Film example) throws Exception;

	// per injection
	void setFilmDAO(FilmDAO filmDAO);
}
