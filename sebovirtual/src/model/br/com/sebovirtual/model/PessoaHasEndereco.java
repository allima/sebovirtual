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
@Table(name = "pessoa_has_endereco", catalog = "sebovirtual")
public class PessoaHasEndereco implements java.io.Serializable {

	private PessoaHasEnderecoId id;
	private Pessoa pessoa;
	private Endereco endereco;

	public PessoaHasEndereco() {
	}

	public PessoaHasEndereco(PessoaHasEnderecoId id, Pessoa pessoa,
			Endereco endereco) {
		this.id = id;
		this.pessoa = pessoa;
		this.endereco = endereco;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "pessoaCpf", column = @Column(name = "Pessoa_cpf", nullable = false)),
			@AttributeOverride(name = "enderecoIdEndereco", column = @Column(name = "Endereco_idEndereco", nullable = false))})
	@NotNull
	public PessoaHasEnderecoId getId() {
		return this.id;
	}

	public void setId(PessoaHasEnderecoId id) {
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
	@JoinColumn(name = "Endereco_idEndereco", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
