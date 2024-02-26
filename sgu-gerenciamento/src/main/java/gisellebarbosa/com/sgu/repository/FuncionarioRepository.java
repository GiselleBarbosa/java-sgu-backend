package gisellebarbosa.com.sgu.repository;

import gisellebarbosa.com.sgu.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}