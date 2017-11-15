package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Pagamento;

@Repository
@Transactional
public class PagamentoDao extends EntityDao<Pagamento>{

}