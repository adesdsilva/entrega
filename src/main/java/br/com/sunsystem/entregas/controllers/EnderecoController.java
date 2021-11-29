package br.com.sunsystem.entregas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sunsystem.entregas.model.Endereco;
import br.com.sunsystem.entregas.repositories.EnderecoRepository;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepositorio;

	public List<Endereco> listar() {
		return enderecoRepositorio.findAll();
	}

	public Endereco incluir(Endereco endereco) {
		return enderecoRepositorio.save(endereco);
	}

	public Endereco alterar(Long id, Endereco endereco) {
		Endereco e = buscarPorId(id);
		e.setCep(endereco.getCep());
		e.setLogradouro(endereco.getLogradouro());
		e.setNumero(endereco.getNumero());
		e.setBairro(endereco.getBairro());
		e.setComplemento(endereco.getComplemento());
		e.setCidade(endereco.getCidade());
		e.setUf(endereco.getUf());
		return enderecoRepositorio.save(endereco);
	}

	public Endereco buscarPorId(Long id) {
		return enderecoRepositorio.getById(id);
	}

	public void deletar(Long id) {
		enderecoRepositorio.deleteById(id);
		;
	}

	public Optional<Endereco> ler(Long id) {
		return enderecoRepositorio.findById(id);
	}
}
