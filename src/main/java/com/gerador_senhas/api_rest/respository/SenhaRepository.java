package com.gerador_senhas.api_rest.respository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gerador_senhas.models.Senha;

public interface SenhaRepository extends JpaRepository<Senha, Long> {
	
	Senha findById(long id);
	
	Senha findBySituacao(String situacao);
	
	@Query("SELECT S from Senha as S where situacao = 'ESPERA' ORDER BY tipo DESC, data_geracao ASC")
	List<Senha>findProximaSenha();
	
	@Modifying
	@Query(
			value="truncate TABLE Senha RESTART IDENTITY",
			nativeQuery=true
			)
	void zerarSenhas();
}
