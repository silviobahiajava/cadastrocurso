package cadastrocursos.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

import lombok.EqualsAndHashCode;

@Entity
@Table(name="pagamento")
public class Pagamento {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private BigDecimal valor;

    @OneToOne
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
    
}
