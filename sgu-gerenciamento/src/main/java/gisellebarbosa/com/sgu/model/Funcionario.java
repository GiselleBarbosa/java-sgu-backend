package gisellebarbosa.com.sgu.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "salario")
    private double salario;

    @Column(name = "password")
    private String password;

    @Column(name = "em_atividade")
    private boolean emAtividade;

    @Column(name = "departamento_id")
    private Long departamentoId;

}
