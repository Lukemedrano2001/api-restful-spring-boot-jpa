package br.com.lukemedrano.SpringBootJPA.dominio.funcionario;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String nome;
	
	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;
	
	private String email;
	
	private String senha;
	
	@Column(name = "salario_em_centavos")
	private Integer salarioEmCentavos;
	
	private String sexo;

	public Funcionario() {}
	
	public Funcionario(CreateFuncionarioDTO dadosDTO) {
		this.nome = dadosDTO.nome();
		this.dataNascimento = dadosDTO.dataNascimento();
		this.email = dadosDTO.email();
		this.senha = dadosDTO.senha();
		this.salarioEmCentavos = dadosDTO.salarioEmCentavos();
		this.sexo = dadosDTO.sexo();
	}
	
	public Funcionario(UpdateFuncionarioDTO dadosDTO) {
		this.nome = dadosDTO.nome();
		this.dataNascimento = dadosDTO.dataNascimento();
		this.email = dadosDTO.email();
		this.senha = dadosDTO.senha();
		this.salarioEmCentavos = dadosDTO.salarioEmCentavos();
		this.sexo = dadosDTO.sexo();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getSalarioEmCentavos() {
		return salarioEmCentavos;
	}

	public void setSalarioEmCentavos(Integer salario) {
		this.salarioEmCentavos = salario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;			
		} else if (objeto == null || getClass() != objeto.getClass()) {			
			return false;
		}
		
		Funcionario funcionario = (Funcionario) objeto;
		return Objects.equals(id, funcionario.id);
	}
}