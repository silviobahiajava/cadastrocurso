package cadastrocursos.model;

import java.util.List;
import jakarta.persistence.*;
import jakarta.persistence.JoinTable;

@Entity
@Table(name="curso")
public class Curso {

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "curso")
    private List<Modulo> modulos;

    @ManyToMany
    @JoinTable(name = "matricula",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
    
    
}
