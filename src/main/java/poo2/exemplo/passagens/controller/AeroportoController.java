package poo2.exemplo.passagens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import poo2.exemplo.passagens.dao.AeroportoDao;
import poo2.exemplo.passagens.model.Aeroporto;

@Controller
public class AeroportoController {
	
	@Autowired
	private AeroportoDao aeroportoDao;

	@GetMapping("/novoaeroporto")
    public String novoaeroporto(Model model) {
    	model.addAttribute("aeroporto", new Aeroporto());
        return "aeroportos/novoaeroporto";
    }
    
    @PostMapping("/salvaraeroporto")
    public String salvaraeroporto(
    		@RequestParam(value="id") long id,
    		@ModelAttribute Aeroporto aeroporto, 
    		Model model) {
    	if(id != 0) {
    		aeroporto.setId(id);
    		aeroportoDao.update(aeroporto);
    		model.addAttribute("message", 
    			"Aeroporto alterado com sucesso!");
    	} else {
    		aeroportoDao.create(aeroporto);
    		model.addAttribute("message", 
    			"Aeroporto criado com sucesso!");
    	}
        return "aeroportos/novoaeroporto";
    }
    
    @GetMapping("/listaraeroportos")
    public String listaraeroportos(
    		@RequestParam(value="nome", defaultValue="") String nome,
    		Model model) {
    	List<Aeroporto> aeroportos = aeroportoDao.getAll(Aeroporto.class);
    	if(!nome.equals(""))
    		aeroportos = aeroportoDao.getByName(nome);
    	model.addAttribute("aeroportos", aeroportos);
    	model.addAttribute("aeroportoPesquisa", new Aeroporto());
        return "aeroportos/listaraeroportos";
    }
    
    @GetMapping("/editaraeroporto")
    public String editaraeroporto(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Aeroporto aeroporto = aeroportoDao.getById(Aeroporto.class, id);
    	model.addAttribute("aeroporto", aeroporto);
        return "aeroportos/novoaeroporto";
    }
    
    @GetMapping("/removeraeroporto")
    public String removeraeroporto(
    		@RequestParam(value="id") long id,
    		Model model) {
    	Aeroporto aeroporto = aeroportoDao.getById(Aeroporto.class, id);
    	if(aeroporto != null)
    		aeroportoDao.delete(aeroporto);
    	model.addAttribute("message", 
    			"Aeroporto removido com sucesso!");
    	List<Aeroporto> aeroportos = aeroportoDao.getAll(Aeroporto.class);
    	model.addAttribute("aeroportos", aeroportos);
    	model.addAttribute("aeroportoPesquisa", new Aeroporto());
    	return "aeroportos/listaraeroportos";
    }
}
