package poo2.exemplo.passagens.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import poo2.exemplo.passagens.model.Empresa;

@Repository
@Transactional
public class EmpresaDao extends EntityDao<Empresa>{

}