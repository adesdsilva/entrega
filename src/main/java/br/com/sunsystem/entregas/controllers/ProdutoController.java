package br.com.sunsystem.entregas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sunsystem.entregas.model.Produto;
import br.com.sunsystem.entregas.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
    private ProdutoRepository produtoRepositorio;

    public List<Produto> listar() {
        return produtoRepositorio.findAll();
    }

    public Produto incluir(Produto produto) {
    	return produtoRepositorio.save(produto);
    }

    public Produto alterar(Produto produto){
//    	Produto p = buscarPorId(id);
//    	p.setNome(produto.getNome());
//    	p.setPeso(produto.getPeso());
//    	p.setValor(produto.getValor());
//    	p.setVolume(produto.getVolume());
    	return produtoRepositorio.save(produto);
    }

    private Produto buscarPorId(Long id) {	
		return produtoRepositorio.getById(id);
	}

	public void deletar(Long id){
    	produtoRepositorio.deleteById(id);;
    }

    public Produto ler(Long id){
        return buscarPorId(id);
    }

}
