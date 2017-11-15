package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Cliente;

@Repository
@Transactional
public class ClienteDao extends EntityDao<Cliente>{

}