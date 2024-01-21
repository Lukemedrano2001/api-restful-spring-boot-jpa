package br.com.lukemedrano.SpringBootJPA.services.implementacoes;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.CreateFuncionarioDTO;
import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.Funcionario;
import br.com.lukemedrano.SpringBootJPA.excecoes.GlobalExceptionHandler;
import br.com.lukemedrano.SpringBootJPA.repositorios.IFuncionarioRepositorio;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.ICreateFuncionarioService;

@Service
public class CreateFuncionarioServiceImpl implements ICreateFuncionarioService {
	@Autowired
	private IFuncionarioRepositorio funcionarioRepositorio;

	@Override
	public ResponseEntity<?> criarFuncionario(CreateFuncionarioDTO dadosDTO, UriComponentsBuilder uriBuilder, BindingResult bindingResult) {
	    if(bindingResult.hasErrors()) {
	    	return GlobalExceptionHandler.handleBadRequest();
	    }
		
		try {
	        Funcionario novoFuncionario = new Funcionario(dadosDTO);
	        
	        if (funcionarioRepositorio.existsByEmail(novoFuncionario.getEmail())) {
	        	return ResponseEntity.badRequest().build();
	        }

	        funcionarioRepositorio.save(novoFuncionario);

	        UriComponents uriComponents = uriBuilder.path("/api/funcionarios/{id}").buildAndExpand(novoFuncionario.getId());
	        URI uri = uriComponents.toUri();
	        
	        return ResponseEntity.created(uri).build();
	    } catch (Exception error) {
	    	return GlobalExceptionHandler.handleInternalServerError();
	    }
	}
}