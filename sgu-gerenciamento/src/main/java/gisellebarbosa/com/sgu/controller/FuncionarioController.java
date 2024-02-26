package gisellebarbosa.com.sgu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gisellebarbosa.com.sgu.model.Funcionario;
import gisellebarbosa.com.sgu.repository.FuncionarioRepository;
import gisellebarbosa.com.sgu.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;


    // cadastra um novo funcionario
    @PostMapping("/funcionarios")
    public Funcionario cadastraFuncionario(@RequestBody Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    // lista todos funcionarios
    @GetMapping("/funcionarios")
    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    // lista funcionarios por ID
    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> listaFuncionarioPorID(
            @PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionado com id:" + id));
        return ResponseEntity.ok(funcionario);
    }

    // atualiza funcionarios
    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> atualizaFuncionario(
            @PathVariable Long id,
            @RequestBody Funcionario funcionarioDetalhes) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Não encontrado funcionado com id:" + id));

        funcionario.setNome(funcionarioDetalhes.getNome());
        funcionario.setCpf(funcionarioDetalhes.getCpf());
        funcionario.setDataNascimento(funcionarioDetalhes.getDataNascimento());
        funcionario.setTelefone(funcionarioDetalhes.getTelefone());
        funcionario.setEmail(funcionarioDetalhes.getEmail());
        funcionario.setSalario(funcionarioDetalhes.getSalario());
        funcionario.setPassword(funcionarioDetalhes.getPassword());
        funcionario.setEmAtividade(funcionarioDetalhes.isEmAtividade());
        funcionario.setDepartamentoId(funcionarioDetalhes.getDepartamentoId());

     final Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);
        return ResponseEntity.ok(funcionarioAtualizado);
    }

    // remove funcionarios
    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Map<String, Boolean>> removeFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionado com id:" + id));

        funcionarioRepository.delete(funcionario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
