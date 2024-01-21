package br.com.lukemedrano.SpringBootJPA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.CreateFuncionarioDTO;
import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.UpdateFuncionarioDTO;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.ICreateFuncionarioService;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.IDeleteFuncionarioService;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.IReadFuncionariosService;
import br.com.lukemedrano.SpringBootJPA.services.interfaces.IUpdateFuncionarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/funcionarios")
public class ControllerFuncionario {

	@Autowired
    private ICreateFuncionarioService createFuncionarioService;
	
	@Autowired
	private IReadFuncionariosService readFuncionariosService;
	
	@Autowired
	private IUpdateFuncionarioService updateFuncionarioService;
	
	@Autowired
	private IDeleteFuncionarioService deleteFuncionarioService;
	
	
	@PostMapping
	public ResponseEntity<?> novoFuncionario(
			@RequestBody @Valid CreateFuncionarioDTO dadosDTO, 
			UriComponentsBuilder uriBuilder, 
			BindingResult bindingResult
		) {
		
		return createFuncionarioService.criarFuncionario(dadosDTO, uriBuilder, bindingResult);
	}
	
	
	@GetMapping
	public ResponseEntity<?> obterTodos() {
		return readFuncionariosService.obterTodosFuncionarios();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> obterPorId(@PathVariable String id) {
		return readFuncionariosService.obterFuncionarioPorId(id);
	}
	
	
	@GetMapping("/nome/{parteNome}")
	public ResponseEntity<?> obterPorNome(@PathVariable String parteNome){
		return readFuncionariosService.obterFuncionariosPorNome(parteNome);
	}
	
	
	@GetMapping("/pagina/{numero}/{limite}")
	public ResponseEntity<?> obterPorPaginacao(
			@PathVariable int numero, 
			@PathVariable int limite
		){
		
		return readFuncionariosService.obterFuncionariosPorPaginacao(numero, limite);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarFuncionario(
			@PathVariable String id, 
			@RequestBody @Valid UpdateFuncionarioDTO dadosDTO, 
			BindingResult bindingResult
		) {

		return updateFuncionarioService.atualizarFuncionario(id, dadosDTO, bindingResult);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removerUsuario(@PathVariable String id){
		return deleteFuncionarioService.removerFuncionario(id);
	}
}