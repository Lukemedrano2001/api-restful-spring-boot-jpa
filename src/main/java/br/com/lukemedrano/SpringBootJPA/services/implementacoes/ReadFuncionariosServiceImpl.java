package br.com.lukemedrano.SpringBootJPA.services.implementacoes;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.Funcionario;
import br.com.lukemedrano.SpringBootJPA.excecoes.GlobalExceptionHandler;
import br.com.lukemedrano.SpringBootJPA.repositorios.IFuncionarioRepositorio;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.IReadFuncionariosService;

@Service
public class ReadFuncionariosServiceImpl implements IReadFuncionariosService {
	@Autowired
	private IFuncionarioRepositorio funcionarioRepositorio;
	
	
	@Override
	public ResponseEntity<?> obterTodosFuncionarios() {
		try {
			Iterable<Funcionario> todosFuncionarios = funcionarioRepositorio.findAll();
			
			Iterator<Funcionario> iterator = todosFuncionarios.iterator();
			 
			if(iterator.hasNext()) {
				return ResponseEntity.ok(todosFuncionarios);
			} else {
				return GlobalExceptionHandler.handleNotFound();
			}
		} catch(Exception error) {
			return GlobalExceptionHandler.handleInternalServerError();
		}
	}

	
	@Override
	public ResponseEntity<?> obterFuncionarioPorId(String id) {
		try {
			Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findById(id);
			
			if(optionalFuncionario.isPresent()) {
				Funcionario funcionario = optionalFuncionario.get();
				return ResponseEntity.ok(funcionario);
			} else {
				return GlobalExceptionHandler.handleNotFound();
			}
		} catch(Error error) {
			return GlobalExceptionHandler.handleInternalServerError();
		}
	}


	@Override
	public ResponseEntity<?> obterFuncionariosPorNome(String parteNome) {
		try {
			Iterable<Funcionario> funcionarios = funcionarioRepositorio.findByNomeContainingIgnoreCase(parteNome);
			
			Iterator<Funcionario> iterator = funcionarios.iterator();
			 
			if(iterator.hasNext()) {
				return ResponseEntity.ok(funcionarios);
			} else {
				return GlobalExceptionHandler.handleNotFound();
			}
		} catch(Exception error) {
			return GlobalExceptionHandler.handleInternalServerError();
		}
	}


	@Override
	public ResponseEntity<?> obterFuncionariosPorPaginacao(int numero, int limite) {
		try {
			if(limite >= 5) {
				limite = 5;
			}
			
			Pageable page = PageRequest.of(numero, limite);
			Iterable<Funcionario> funcionarios = funcionarioRepositorio.findAll(page);
			
			Iterator<Funcionario> iterator = funcionarios.iterator();
			 
			if(iterator.hasNext()) {
				return ResponseEntity.ok(funcionarios);
			} else {
				return GlobalExceptionHandler.handleNotFound();
			}
		} catch(Exception error) {
			return GlobalExceptionHandler.handleInternalServerError();
		}
	}
}
