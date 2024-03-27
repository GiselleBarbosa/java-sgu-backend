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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
@Tag(name = "Funcionario Controller", description = "Endpoints para gerenciar funcionários")
public class FuncionarioController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping("/funcionarios")
    @Operation(summary = "Cadastrar um novo funcionário", description = "Este endpoint permite cadastrar um novo funcionário no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar funcionário: Verifique os dados fornecidos")
    })
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

    @GetMapping("/funcionarios")
    @Operation(summary = "Listar todos os funcionários", description = "Este endpoint retorna uma lista de todos os funcionários cadastrados no sistema.")
    public FuncionarioResponse listarTodosFuncionarios() {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        if (funcionarios.isEmpty()) {
            throw new ResourceNotFoundException("Falha ao retornar a lista de funcionários: A Lista está vazia ou não existe");
        }
        String mensagem = "Lista de funcionários recuperada com sucesso!";
        return new FuncionarioResponse(mensagem, funcionarios);
    }

    @GetMapping("/funcionarios/{id}")
    @Operation(summary = "Listar um funcionário por ID", description = "Este endpoint retorna um funcionário específico com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado funcionário com o ID fornecido")
    })
    public ResponseEntity<FuncionarioResponse> listaFuncionarioPorID(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionário com id:" + id));

        String mensagem = "Funcionário encontrado com sucesso!";
        List<Funcionario> funcionariosEncontrados = Collections.singletonList(funcionario);

        return ResponseEntity.ok(new FuncionarioResponse(mensagem, funcionariosEncontrados));
    }

    @PutMapping("/funcionarios/{id}")
    @Operation(summary = "Atualizar um funcionário", description = "Este endpoint permite atualizar as informações de um funcionário existente no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado funcionário com o ID fornecido")
    })
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

    @DeleteMapping("/funcionarios/{id}")
    @Operation(summary = "Remover um funcionário", description = "Este endpoint permite remover um funcionário do sistema com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não encontrado funcionário com o ID fornecido")
    })
    public ResponseEntity<FuncionarioResponse> removeFuncionario(@PathVariable Long id) {
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não encontrado funcionário com id: " + id));

        funcionarioRepository.delete(funcionario);

        String mensagem = "Funcionário removido com sucesso!";
        List<Funcionario> funcionariosRemovidos = Collections.singletonList(funcionario);
        return ResponseEntity.ok(new FuncionarioResponse(mensagem, funcionariosRemovidos));
    }
}
