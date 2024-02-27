package gisellebarbosa.com.sgu.controller;

import java.util.List;

import gisellebarbosa.com.sgu.model.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioResponse {
    private String mensagem;
    private List<Funcionario> funcionarios;
}
