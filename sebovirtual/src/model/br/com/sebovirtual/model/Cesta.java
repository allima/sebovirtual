package br.com.sebovirtual.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "cesta", catalog = "sebovirtual")
public class Cesta implements java.io.Serializable {

	private CestaId id;
	private Compra compra;
	private Vende vende;

	public Cesta() {
	}

	public Cesta(CestaId id, Compra compra, Vende vende) {
		this.id = id;
		this.compra = compra;
		this.vende = vende;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "compraIdCompra", column = @Column(name = "Compra_idCompra", nullable = false)),
			@AttributeOverride(name = "vendeObraIsbn", column = @Column(name = "Vende_Obra_ISBN", nullable = false)),
			@AttributeOverride(name = "vendePessoaCpf", column = @Column(name = "Vende_Pessoa_cpf", nullable = false))})
	@NotNull
	public CestaId getId() {
		return this.id;
	}

	public void setId(CestaId id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Compra_idCompra", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "Vende_Pessoa_cpf", referencedColumnName = "Pessoa_cpf", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "Vende_Obra_ISBN", referencedColumnName = "Obra_ISBN", nullable = false, insertable = false, updatable = false)})
	@NotNull
	public Vende getVende() {
		return this.vende;
	}

	public void setVende(Vende vende) {
		this.vende = vende;
	}

}
