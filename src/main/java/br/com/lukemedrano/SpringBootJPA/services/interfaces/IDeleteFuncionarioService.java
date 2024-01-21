package br.com.lukemedrano.SpringBootJPA.services.interfaces;

import org.springframework.http.ResponseEntity;

public interface IDeleteFuncionarioService {
	ResponseEntity<?> removerFuncionario(String id);
}