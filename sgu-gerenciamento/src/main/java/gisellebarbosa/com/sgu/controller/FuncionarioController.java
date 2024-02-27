package gisellebarbosa.com.sgu.controller;

import java.util.Collections;
import java.util.List;

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
    public ResponseEntity<FuncionarioResponse> listaFuncionarioPorID(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionário com id:" + id));

        String mensagem = "Funcionário encontrado com sucesso!";
        List<Funcionario> funcionariosEncontrados = Collections.singletonList(funcionario);

        return ResponseEntity.ok(new FuncionarioResponse(mensagem, funcionariosEncontrados));
    }


    // atualiza funcionarios
    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponse> atualizaFuncionario(
            @PathVariable Long id,
            @RequestBody Funcionario funcionarioDetalhes) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionário com id: " + id));

        funcionario.setNome(funcionarioDetalhes.getNome());
        funcionario.setCpf(funcionarioDetalhes.getCpf());
        funcionario.setDataNascimento(funcionarioDetalhes.getDataNascimento());
        funcionario.setTelefone(funcionarioDetalhes.getTelefone());
        funcionario.setEmail(funcionarioDetalhes.getEmail());
        funcionario.setSalario(funcionarioDetalhes.getSalario());
        funcionario.setSenha(funcionarioDetalhes.getSenha());
        funcionario.setEmAtividade(funcionarioDetalhes.isEmAtividade());
        funcionario.setDepartamentoId(funcionarioDetalhes.getDepartamentoId());

        Funcionario funcionarioAtualizado = funcionarioRepository.save(funcionario);

        String mensagem = "Funcionário atualizado com sucesso!";
        List<Funcionario> funcionariosAtualizados = Collections.singletonList(funcionarioAtualizado);
        return ResponseEntity.ok(new FuncionarioResponse(mensagem, funcionariosAtualizados));
    }

    // remove funcionarios
    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioResponse> removeFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionário com id: " + id));

        funcionarioRepository.delete(funcionario);

        String mensagem = "Funcionário removido com sucesso!";
        List<Funcionario> funcionariosRemovidos = Collections.singletonList(funcionario);
        return ResponseEntity.ok(new FuncionarioResponse(mensagem, funcionariosRemovidos));
    }
}