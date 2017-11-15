package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Passagem;

@Repository
@Transactional
public class PassagemDao extends EntityDao<Passagem>{

}