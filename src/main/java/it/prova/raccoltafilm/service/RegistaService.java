package it.prova.raccoltafilm.service;

import java.util.List;

import it.prova.raccoltafilm.dao.RegistaDAO;
import it.prova.raccoltafilm.model.Regista;

public interface RegistaService {

	List<Regista> listAllElements() throws Exception;

	Regista caricaSingoloElemento(Long id) throws Exception;

	Regista caricaSingoloElementoConFilms(Long id) throws Exception;

	void aggiorna(Regista registaInstance) throws Exception;

	void inserisciNuovo(Regista registaInstance) throws Exception;

	void rimuovi(Long idRegista) throws Exception;

	List<Regista> findByExample(Regista example) throws Exception;

	// per injection
	void setRegistaDAO(RegistaDAO registaDAO);

}
