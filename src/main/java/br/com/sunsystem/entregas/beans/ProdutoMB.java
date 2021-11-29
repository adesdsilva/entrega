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

import br.com.sunsystem.entregas.controllers.ProdutoController;
import br.com.sunsystem.entregas.model.Produto;

@Service
@Named(value = "produtoMB")
@ViewScoped
public class ProdutoMB {
	
	@Autowired
	private ProdutoController controller;

	private List<Produto> produtos = new ArrayList<>();

	private Produto produto;
	
	private Produto novoProduto;


//	@PostConstruct
//	public List<Produto> listarTodos() {
//		produtos = controller.listar();
//		return produtos;
//	}
	
	public ProdutoMB() {
		this.novoProduto = new Produto();
	}
	
	@GetMapping
	public List<Produto> findAll() {
		produtos = controller.listar();
		return produtos;
	}

	@PostMapping
	public Produto inserir(@Valid @RequestBody Produto obj) {
		//System.out.println("nome:" + obj.getNome());
		this.controller.incluir(obj);
		return obj;
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		controller.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping
	public String alterar(@RequestBody Produto obj) {
		this.controller.alterar(obj);
		return "lista-produtos.xhtml";
	}

	public Integer getTamanhoDaLista() {
		return produtos.size();
	}

	public void setTamanhoDaLista(Integer size) {
		// Método criado para ser utilizado pelo primefaces
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Produto getNovoProduto() {
		return novoProduto;
	}

	public void setNovoProduto(Produto novoProduto) {
		this.novoProduto = novoProduto;
	}

	public void openNew() {
        this.novoProduto = new Produto();
    }
}
