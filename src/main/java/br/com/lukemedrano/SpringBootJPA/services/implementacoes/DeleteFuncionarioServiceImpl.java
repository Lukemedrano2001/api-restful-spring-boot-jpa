package br.com.lukemedrano.SpringBootJPA.services.implementacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.Funcionario;
import br.com.lukemedrano.SpringBootJPA.excecoes.GlobalExceptionHandler;
import br.com.lukemedrano.SpringBootJPA.repositorios.IFuncionarioRepositorio;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.IDeleteFuncionarioService;

@Service
public class DeleteFuncionarioServiceImpl implements IDeleteFuncionarioService {
	@Autowired
	private IFuncionarioRepositorio funcionarioRepositorio;
	
	@Override
	public ResponseEntity<?> removerFuncionario(String id) {
		try {
			Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findById(id);
			
			if(optionalFuncionario.isPresent()) {
				Funcionario funcionarioRemovido = optionalFuncionario.get();
				funcionarioRepositorio.delete(funcionarioRemovido);
				
				return ResponseEntity.ok().build();
			} else {
				return GlobalExceptionHandler.handleNotFound();
			}
		} catch(Exception error) {			
			return GlobalExceptionHandler.handleInternalServerError();
		}
	}
}