package it.prova.raccoltafilm.service;

import java.util.List;

import it.prova.raccoltafilm.dao.RuoloDAO;
import it.prova.raccoltafilm.model.Ruolo;

public interface RuoloService {

	List<Ruolo> listAll() throws Exception;

	Ruolo caricaSingoloElemento(Long id) throws Exception;

	void aggiorna(Ruolo ruoloInstance) throws Exception;

	void inserisciNuovo(Ruolo ruoloInstance) throws Exception;

	void rimuovi(Ruolo ruoloInstance) throws Exception;

	Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) throws Exception;

	// per injection
	void setRuoloDAO(RuoloDAO ruoloDAO);
}
