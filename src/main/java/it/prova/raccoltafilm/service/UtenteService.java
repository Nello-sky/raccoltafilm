package it.prova.raccoltafilm.service;

import java.util.List;

import it.prova.raccoltafilm.dao.UtenteDAO;
import it.prova.raccoltafilm.model.Ruolo;
import it.prova.raccoltafilm.model.Utente;

public interface UtenteService {

	List<Utente> listAll() throws Exception;

	Utente caricaSingoloElemento(Long id) throws Exception;

	void aggiorna(Utente utenteInstance) throws Exception;

	void inserisciNuovo(Utente utenteInstance) throws Exception;

	void rimuovi(Long idUtenteToRemove) throws Exception;

	void aggiungiRuolo(Utente utenteEsistente, Ruolo ruoloInstance) throws Exception;

	Utente findByUsernameAndPassword(String username, String password) throws Exception;

	Utente accedi(String username, String password) throws Exception;

	List<Utente> findByExample(Utente example) throws Exception;
	
	List<Utente> findByExampleEager(Utente example) throws Exception;
	
	Utente caricaSingoloEager(Long idUtente)throws Exception;

	// per injection
	void setUtenteDAO(UtenteDAO utenteDAO);

}
