package br.com.sunsystem.entregas.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sunsystem.entregas.controllers.EntregaNewController;
import br.com.sunsystem.entregas.model.EntregaNew;
import br.com.sunsystem.entregas.model.Produto;

@Service
@Named(value = "entregaNewMB")
@ViewScoped
public class EntregaNewMB {

	@Autowired
	private EntregaNewController controller;

	private List<EntregaNew> entregaNews = new ArrayList<>();

	private EntregaNew entregaNew;
	
	private EntregaNew novoEntregaNew;


//	@PostConstruct
//	public List<EntregaNew> listarTodos() {
//		entregaNews = controller.listar();
//		return entregaNews;
//	}
	
	public EntregaNewMB() {
		this.novoEntregaNew = new EntregaNew();
	}
	
	@GetMapping
	public List<EntregaNew> findAll() {
		entregaNews = controller.listar();
		return entregaNews;
	}

	@PostMapping
	public String inserir(@Valid @RequestBody EntregaNew obj) {
		this.controller.incluir(obj);
		return "lista-entregaNews.xhtml";
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		controller.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public String alterar(@RequestBody EntregaNew obj) {
		this.controller.alterar(obj);
		return "lista-entregaNews.xhtml";
	}

	public Integer getTamanhoDaLista() {
		return entregaNews.size();
	}

	public void setTamanhoDaLista(Integer size) {
		// Método criado para ser utilizado pelo primefaces
	}

	public List<EntregaNew> getEntregaNews() {
		return entregaNews;
	}

	public void setEntregaNews(List<EntregaNew> entregaNews) {
		this.entregaNews = entregaNews;
	}

	public EntregaNew getEntregaNew() {
		return entregaNew;
	}

	public void setEntregaNew(EntregaNew entregaNew) {
		this.entregaNew = entregaNew;
	}
	
	public EntregaNew getNovoEntregaNew() {
		return novoEntregaNew;
	}

	public void setNovoEntregaNew(EntregaNew novoEntregaNew) {
		this.novoEntregaNew = novoEntregaNew;
	}

	public void openNew() {
        this.novoEntregaNew = new EntregaNew();
    }
	
	public void setarCamposProduto(Produto p) {
		this.novoEntregaNew.getProduto().setIdProduto(p.getIdProduto());
		this.novoEntregaNew.getProduto().setNome(p.getNome());
		this.novoEntregaNew.getProduto().setPeso(p.getPeso());
		this.novoEntregaNew.getProduto().setValor(p.getValor());
		this.novoEntregaNew.getProduto().setVolume(p.getVolume());
	}
}
