package gisellebarbosa.com.sgu.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "funcionarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cpf", name = "uk_cpf"),
        @UniqueConstraint(columnNames = "email", name = "uk_email")
})
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf", unique = true, nullable = false) // Restrição única para o CPF
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email", unique = true, nullable = false) // Restrição única para o e-mail
    private String email;

    @Column(name = "salario")
    private double salario;

    @Column(name = "senha")
    private String senha;

    @Column(name = "em_atividade")
    private boolean emAtividade;

    @Column(name = "departamento_id")
    private Long departamentoId;
}