package br.com.lukemedrano.SpringBootJPA.services.interfaces;

import org.springframework.http.ResponseEntity;

public interface IReadFuncionariosService {
	ResponseEntity<?> obterTodosFuncionarios();
	ResponseEntity<?> obterFuncionarioPorId(String id);
	ResponseEntity<?> obterFuncionariosPorNome(String parteNome);
	ResponseEntity<?> obterFuncionariosPorPaginacao(int numero, int limite);
}