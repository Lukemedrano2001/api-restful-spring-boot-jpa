package br.com.lukemedrano.SpringBootJPA.services.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.UpdateFuncionarioDTO;

public interface IUpdateFuncionarioService {
	ResponseEntity<?> atualizarFuncionario(String id, UpdateFuncionarioDTO dadosDTO, BindingResult bindingResult);
}