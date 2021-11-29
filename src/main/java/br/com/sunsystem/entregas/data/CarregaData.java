package br.com.sunsystem.entregas.data;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.sunsystem.entregas.model.Produto;
import br.com.sunsystem.entregas.repositories.ProdutoRepository;

@Component
public class CarregaData {

    @Value("${habilitar.carregar.massa.dados}")
    private boolean podeCarregarDados;
    
    @Autowired
    private ProdutoRepository produtoRepositorio;
    
    @PostConstruct
    public void loadData() {

        if (podeCarregarDados) {
            for(int x = 0; x < 10; x++) {
            	produtoRepositorio.save(new Produto((long) x, "Produto" + x, 1.5 + x, "5", 1.0 + x));
            }
        }
    }
}
