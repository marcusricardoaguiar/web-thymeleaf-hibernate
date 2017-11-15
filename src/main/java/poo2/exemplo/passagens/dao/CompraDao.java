package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Compra;

@Repository
@Transactional
public class CompraDao extends EntityDao<Compra>{

}