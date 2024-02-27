package gisellebarbosa.com.sgu.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<FuncionarioResponse> cadastraFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioRepository.save(funcionario);
        if (funcionarioSalvo.getId() != null) {
            String mensagem = "Funcionário cadastrado com sucesso!";
            List<Funcionario> funcionariosSalvos = Collections.singletonList(funcionarioSalvo);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new FuncionarioResponse(mensagem, funcionariosSalvos));
        } else {
            throw new ResourceNotFoundException("Falha ao cadastrar funcionário: Verifique os dados fornecidos.");
        }
    }

    // lista todos funcionarios
    @GetMapping("/funcionarios")
    public FuncionarioResponse listarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        if (funcionarios.isEmpty()) {
            throw new ResourceNotFoundException("Falha ao retornar a lista de funcionários: A Lista está vazia ou não existe");
        }
        String mensagem = "Lista de funcionários recuperada com sucesso!";
        return new FuncionarioResponse(mensagem, funcionarios);
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
        funcionario.setSenha(funcionarioDetalhes.getSenha());
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
