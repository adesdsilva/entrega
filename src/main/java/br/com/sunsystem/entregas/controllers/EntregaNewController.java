package br.com.sunsystem.entregas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sunsystem.entregas.model.EntregaNew;
import br.com.sunsystem.entregas.repositories.EntregaNewRepository;

@RestController
@RequestMapping("/entregaNew")
public class EntregaNewController {

	@Autowired
    private EntregaNewRepository entregaNewRepository;

    public List<EntregaNew> listar() {
        return entregaNewRepository.findAll();
    }

    public EntregaNew incluir(EntregaNew entregaNew) {
    	return entregaNewRepository.save(entregaNew);
    }

    public EntregaNew alterar(EntregaNew entregaNew){
    	return entregaNewRepository.save(entregaNew);
    }

    private EntregaNew buscarPorId(Long id) {	
		return entregaNewRepository.getById(id);
	}

	public void deletar(Long id){
    	entregaNewRepository.deleteById(id);;
    }

    public EntregaNew ler(Long id){
        return buscarPorId(id);
    }
}
