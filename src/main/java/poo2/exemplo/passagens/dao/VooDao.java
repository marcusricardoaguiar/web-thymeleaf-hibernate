package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Voo;

@Repository
@Transactional
public class VooDao extends EntityDao<Voo>{

}