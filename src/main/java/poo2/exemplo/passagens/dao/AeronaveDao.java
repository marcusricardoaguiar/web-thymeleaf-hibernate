package poo2.exemplo.passagens.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Aeronave;

@Repository
@Transactional
public class AeronaveDao extends EntityDao<Aeronave>{

	@SuppressWarnings("unchecked")
	public List<Aeronave> getByName(String nome) {
		return super.getSession()
				.createQuery("from Aeronave a "
					+ "left join fetch a.empresa emp "
					+ "where a.nome like :nome")
				.setParameter("nome", "%" + nome + "%").list();
	}
}