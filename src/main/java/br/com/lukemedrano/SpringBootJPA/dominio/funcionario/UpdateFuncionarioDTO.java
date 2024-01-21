package br.com.lukemedrano.SpringBootJPA.dominio.funcionario;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateFuncionarioDTO(
		String id,
		
		@NotBlank
		String nome,
		
		@NotNull
		LocalDate dataNascimento,
		
		@NotBlank
		@Pattern(regexp = "^[a-zA-Z0-9!#$%¨&*_+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
		String email,
		
		@NotBlank
		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%¨&*()_+]).{8,}$")
		String senha,
		
		@Min(0)
		@NotNull
		Integer salarioEmCentavos,
		
		@NotBlank
		@Pattern(regexp = "^(Masculino|Feminino)$")
		String sexo
	) {
}