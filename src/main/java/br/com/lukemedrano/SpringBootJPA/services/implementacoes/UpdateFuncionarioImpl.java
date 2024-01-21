package br.com.lukemedrano.SpringBootJPA.services.implementacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.Funcionario;
import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.UpdateFuncionarioDTO;
import br.com.lukemedrano.SpringBootJPA.excecoes.GlobalExceptionHandler;
import br.com.lukemedrano.SpringBootJPA.repositorios.IFuncionarioRepositorio;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.IUpdateFuncionarioService;

@Service
public class UpdateFuncionarioImpl implements IUpdateFuncionarioService {
	@Autowired
	private IFuncionarioRepositorio funcionarioRepositorio;
	
	@Override
	public ResponseEntity<?> atualizarFuncionario(String id, UpdateFuncionarioDTO dadosDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return GlobalExceptionHandler.handleBadRequest();
	    }
		
		try {
			Optional<Funcionario> optionalFuncionario = funcionarioRepositorio.findById(id);

		    if (optionalFuncionario.isPresent()) {
		        Funcionario funcionarioAtualizado = optionalFuncionario.get();

		        funcionarioAtualizado.setDataNascimento(dadosDTO.dataNascimento());
		        funcionarioAtualizado.setEmail(dadosDTO.email());
		        funcionarioAtualizado.setSenha(dadosDTO.senha());
		        funcionarioAtualizado.setNome(dadosDTO.nome());
		        funcionarioAtualizado.setSalarioEmCentavos(dadosDTO.salarioEmCentavos());
		        funcionarioAtualizado.setSexo(dadosDTO.sexo());
		        
		        funcionarioRepositorio.save(funcionarioAtualizado);
		        return ResponseEntity.ok().build();
		    } else {
		    	return GlobalExceptionHandler.handleNotFound();
		    }

		} catch(Exception error) {
			return GlobalExceptionHandler.handleInternalServerError();
		}
	}
}