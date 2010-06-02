package br.com.sebovirtual.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "pessoa_has_categoria", catalog = "sebovirtual")
public class PessoaHasCategoria implements java.io.Serializable {

	private PessoaHasCategoriaId id;
	private Pessoa pessoa;
	private Categoria categoria;

	public PessoaHasCategoria() {
	}

	public PessoaHasCategoria(PessoaHasCategoriaId id, Pessoa pessoa,
			Categoria categoria) {
		this.id = id;
		this.pessoa = pessoa;
		this.categoria = categoria;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "pessoaCpf", column = @Column(name = "Pessoa_cpf", nullable = false)),
			@AttributeOverride(name = "categoriaIdCategoria", column = @Column(name = "Categoria_idCategoria", nullable = false))})
	@NotNull
	public PessoaHasCategoriaId getId() {
		return this.id;
	}

	public void setId(PessoaHasCategoriaId id) {
		this.id = id;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Categoria_idCategoria", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
