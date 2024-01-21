package br.com.lukemedrano.SpringBootJPA.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lukemedrano.SpringBootJPA.dominio.funcionario.Funcionario;

public interface IFuncionarioRepositorio extends JpaRepository<Funcionario, String> {
	
	@Query("SELECT CASE WHEN COUNT(func) > 0 THEN true ELSE false END FROM Funcionario func WHERE func.email = :email")
    boolean existsByEmail(@Param("email") String email);
	
	
	@Query("SELECT func FROM Funcionario func WHERE LOWER(func.nome) LIKE %:parteNome%")
	public Iterable<Funcionario> findByNomeContainingIgnoreCase(String parteNome);
}