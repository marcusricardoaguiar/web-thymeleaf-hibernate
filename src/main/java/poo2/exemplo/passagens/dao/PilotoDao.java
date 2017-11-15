package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Piloto;

@Repository
@Transactional
public class PilotoDao extends EntityDao<Piloto>{

}