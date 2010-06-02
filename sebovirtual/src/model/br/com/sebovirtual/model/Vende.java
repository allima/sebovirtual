package br.com.sebovirtual.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "vende", catalog = "sebovirtual")
public class Vende implements java.io.Serializable {

	private VendeId id;
	private Obra obra;
	private Pessoa pessoa;
	private Date dtInicial;
	private Date dtFinal;
	private float preco;
	private Set<Cesta> cestas = new HashSet<Cesta>(0);

	public Vende() {
	}

	public Vende(VendeId id, Obra obra, Pessoa pessoa, Date dtInicial,
			Date dtFinal, float preco) {
		this.id = id;
		this.obra = obra;
		this.pessoa = pessoa;
		this.dtInicial = dtInicial;
		this.dtFinal = dtFinal;
		this.preco = preco;
	}
	public Vende(VendeId id, Obra obra, Pessoa pessoa, Date dtInicial,
			Date dtFinal, float preco, Set<Cesta> cestas) {
		this.id = id;
		this.obra = obra;
		this.pessoa = pessoa;
		this.dtInicial = dtInicial;
		this.dtFinal = dtFinal;
		this.preco = preco;
		this.cestas = cestas;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "pessoaCpf", column = @Column(name = "Pessoa_cpf", nullable = false)),
			@AttributeOverride(name = "obraIsbn", column = @Column(name = "Obra_ISBN", nullable = false))})
	@NotNull
	public VendeId getId() {
		return this.id;
	}

	public void setId(VendeId id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Obra_ISBN", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Obra getObra() {
		return this.obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Pessoa_cpf", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "Dt_inicial", nullable = false, length = 10)
	@NotNull
	public Date getDtInicial() {
		return this.dtInicial;
	}

	public void setDtInicial(Date dtInicial) {
		this.dtInicial = dtInicial;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "Dt_final", nullable = false, length = 10)
	@NotNull
	public Date getDtFinal() {
		return this.dtFinal;
	}

	public void setDtFinal(Date dtFinal) {
		this.dtFinal = dtFinal;
	}

	@Column(name = "preco", nullable = false, precision = 12, scale = 0)
	@NotNull
	public float getPreco() {
		return this.preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "vende")
	public Set<Cesta> getCestas() {
		return this.cestas;
	}

	public void setCestas(Set<Cesta> cestas) {
		this.cestas = cestas;
	}

}
