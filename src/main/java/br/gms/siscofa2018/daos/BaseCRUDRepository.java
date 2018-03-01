package br.gms.siscofa2018.daos;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseCRUDRepository<E> {
	
	@PersistenceContext
	protected EntityManager manager;

	public E incluir(E entidade) {
		manager.persist(entidade);
		return entidade;
	}

	public E alterar(E entidade) {
		manager.merge(entidade);
		return entidade;
	}

	public void excluir(E entidade) {
		manager.remove(entidade);
	}
	
	public List<E> list() {
		return manager.createQuery("select distinct(p) from "+ 
				getClazz().getSimpleName() + " p", 
				getClazz()).getResultList();
	}

	public E consultarPorId(Integer id) throws Exception {
		E e = (E) manager.find(getClazz(), id);
		if (e != null) {
			return e;
		}
		throw new Exception("Não existe objeto com esse id.");
	}

	@SuppressWarnings("unchecked")
	private Class<E> getClazz() {
		return (Class<E>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
