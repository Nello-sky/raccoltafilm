package it.prova.raccoltafilm.dao;

import it.prova.raccoltafilm.model.Ruolo;

public interface RuoloDAO extends IBaseDAO<Ruolo> {

	Ruolo findByDescrizioneAndCodice(String descrizione, String codice) throws Exception;

}
