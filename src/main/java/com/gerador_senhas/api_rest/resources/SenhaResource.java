package com.gerador_senhas.api_rest.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerador_senhas.api_rest.respository.SenhaRepository;
import com.gerador_senhas.models.Senha;

@RestController
@RequestMapping(value = "/api")
public class SenhaResource {

	@Autowired
	SenhaRepository senhaRepository;

	@GetMapping("/senhas")
	public List<Senha> listaSenhas() {
		return senhaRepository.findAll();
	}

	@GetMapping("/senha")
	public String listaSenhaAtual() {
		Senha senhaClass = senhaRepository.findBySituacao("ATENDENDO");
		
		if(senhaClass == null) {
			return "";
		}
		
		return senhaClass.getSenhaFromatada();
	}

	@PostMapping("/proximaSenha")
	public Senha proximaSenha() {
		List<Senha> proximasSenhas = senhaRepository.findProximaSenha();

		Senha senhaAtual = senhaRepository.findBySituacao("ATENDENDO");

		if (senhaAtual != null) {
			senhaRepository.delete(senhaAtual);
		}

		if (proximasSenhas.isEmpty()) {
			return null;
		}

		Senha proximaSenha = proximasSenhas.get(0);
		proximaSenha.setSituacao("ATENDENDO");
		
		senhaRepository.save(proximaSenha);

		return proximaSenha;
	}

	@PostMapping("/gerarSenha")
	public Senha gerarNovaSenha(@RequestBody Senha senha) {
		Date dataGeracao = new Date();
		senha.setSituacao("ESPERA");

		senha.setData_geracao(dataGeracao);
		return senhaRepository.save(senha);
	}

	@DeleteMapping("/senhas")
	public void zerarSenhas() {
		senhaRepository.deleteAll();
	}

	@PutMapping("/senhas")
	public Senha atualizarSenha(@RequestBody Senha senha) {
		return senhaRepository.save(senha);
	}
}
