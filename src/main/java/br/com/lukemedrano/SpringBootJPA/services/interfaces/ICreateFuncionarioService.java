package br.com.lukemedrano.SpringBootJPA.services.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.CreateFuncionarioDTO;

public interface ICreateFuncionarioService {
	ResponseEntity<?> criarFuncionario(CreateFuncionarioDTO dadosDTO, UriComponentsBuilder uriBuilder, BindingResult bindingResult);
}