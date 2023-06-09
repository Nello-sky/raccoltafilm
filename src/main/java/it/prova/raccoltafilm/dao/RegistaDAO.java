package it.prova.raccoltafilm.dao;

import java.util.List;

import it.prova.raccoltafilm.model.Regista;

public interface RegistaDAO extends IBaseDAO<Regista> {

	List<Regista> findByExample(Regista example) throws Exception;

	Regista findByIdEager(Long idRegista) throws Exception;
}
