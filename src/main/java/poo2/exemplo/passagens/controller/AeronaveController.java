package poo2.exemplo.passagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poo2.exemplo.passagens.dao.AeronaveDao;
import poo2.exemplo.passagens.dao.EmpresaDao;
import poo2.exemplo.passagens.model.Aeronave;
import poo2.exemplo.passagens.model.Empresa;

@Controller
public class AeronaveController {
	
	@Autowired
	private AeronaveDao aeronaveDao;
	
	@Autowired
	private EmpresaDao empresaDao;

	@GetMapping("/novoaeronave")
    public String novoaeronave(Model model) {
    	model.addAttribute("aeronave", new Aeronave());
    	
    	List<Empresa> empresas = empresaDao.getAll(Empresa.class);
    	model.addAttribute("empresas", empresas);
        return "aeronaves/novoaeronave";
    }
    
    @PostMapping("/salvaraeronave")
    public String salvaraeronave(
    		@RequestParam(value="id") long id,
    		@ModelAttribute Aeronave aeronave, 
    		Model model) {
    	if(id != 0) {
    		aeronave.setId(id);
    		aeronave.setEmpresa(empresaDao.getById(Empresa.class, aeronave.getEmpresa().getId()));
    		aeronaveDao.update(aeronave);
    		model.addAttribute("message", 
    			"Aeronave alterado com sucesso!");
    	} else {
    		aeronave.setEmpresa(empresaDao.getById(Empresa.class, aeronave.getEmpresa().getId()));
    		aeronaveDao.create(aeronave);
    		model.addAttribute("message", 
    			"Aeronave criado com sucesso!");
    	}
        return "aeronaves/novoaeronave";
    }
    
    @GetMapping("/listaraeronaves")
    public String listaraeronaves(
    		@RequestParam(value="nome", defaultValue="") String nome,
    		Model model) {
    	List<Aeronave> aeronaves = aeronaveDao.getAll(Aeronave.class);
    	if(!nome.equals(""))
    		aeronaves = aeronaveDao.getByName(nome);
    	model.addAttribute("aeronaves", aeronaves);
    	model.addAttribute("aeronavePesquisa", new Aeronave());
        return "aeronaves/listaraeronaves";
    }
    
    @GetMapping("/editaraeronave")
    public String editaraeronave(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Aeronave aeronave = aeronaveDao.getById(Aeronave.class, id);
    	model.addAttribute("aeronave", aeronave);
    	
    	List<Empresa> empresas = empresaDao.getAll(Empresa.class);
    	model.addAttribute("empresas", empresas);
        return "aeronaves/novoaeronave";
    }
    
    @GetMapping("/removeraeronave")
    public String removeraeronave(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Aeronave aeronave = aeronaveDao.getById(Aeronave.class, id);
    	if(aeronave != null)
    		aeronaveDao.delete(aeronave);
    	model.addAttribute("message", 
    			"Aeronave removido com sucesso!");
    	List<Aeronave> aeronaves = aeronaveDao.getAll(Aeronave.class);
    	model.addAttribute("aeronaves", aeronaves);
    	model.addAttribute("aeronavePesquisa", new Aeronave());
    	return "aeronaves/listaraeronaves";
    }
}
