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
@Table(name = "pessoa_has_telefone", catalog = "sebovirtual")
public class PessoaHasTelefone implements java.io.Serializable {

	private PessoaHasTelefoneId id;
	private Telefone telefone;
	private Pessoa pessoa;

	public PessoaHasTelefone() {
	}

	public PessoaHasTelefone(PessoaHasTelefoneId id, Telefone telefone,
			Pessoa pessoa) {
		this.id = id;
		this.telefone = telefone;
		this.pessoa = pessoa;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "pessoaCpf", column = @Column(name = "Pessoa_cpf", nullable = false)),
			@AttributeOverride(name = "telefoneIdTelefone", column = @Column(name = "Telefone_idTelefone", nullable = false))})
	@NotNull
	public PessoaHasTelefoneId getId() {
		return this.id;
	}

	public void setId(PessoaHasTelefoneId id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Telefone_idTelefone", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
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

}
