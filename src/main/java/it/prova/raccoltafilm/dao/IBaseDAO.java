package it.prova.raccoltafilm.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public interface IBaseDAO<T> {

	List<T> list() throws Exception;

	Optional<T> findOne(Long id) throws Exception;

	void update(T input) throws Exception;

	void insert(T input) throws Exception;

	void delete(T input) throws Exception;

	// questo mi serve per l'injection
	void setEntityManager(EntityManager entityManager);

}
