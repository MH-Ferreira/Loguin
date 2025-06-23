package br.applogin.login.repository;

import br.applogin.login.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM usuario WHERE email = :email AND senha = :senha", nativeQuery = true)
    public Usuario login(@Param("email") String email, @Param("senha") String senha);
    
    Usuario findByEmail(String email);
}