package poo2.exemplo.passagens.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Aeroporto;

@Repository
@Transactional
public class AeroportoDao extends EntityDao<Aeroporto>{

	@SuppressWarnings("unchecked")
	public List<Aeroporto> getByName(String nome) {
		return super.getSession()
				.createQuery("from Aeroporto a "
				+ "where a.nome like :nome")
				.setParameter("nome", "%" + nome + "%").list();
	}
}