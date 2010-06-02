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
@Table(name = "pessoa_has_dados_bancarios", catalog = "sebovirtual")
public class PessoaHasDadosBancarios implements java.io.Serializable {

	private PessoaHasDadosBancariosId id;
	private DadosBancarios dadosBancarios;
	private Pessoa pessoa;

	public PessoaHasDadosBancarios() {
	}

	public PessoaHasDadosBancarios(PessoaHasDadosBancariosId id,
			DadosBancarios dadosBancarios, Pessoa pessoa) {
		this.id = id;
		this.dadosBancarios = dadosBancarios;
		this.pessoa = pessoa;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "pessoaCpf", column = @Column(name = "Pessoa_cpf", nullable = false)),
			@AttributeOverride(name = "dadosBancariosIdDadosBancarios", column = @Column(name = "Dados_Bancarios_idDados_Bancarios", nullable = false))})
	@NotNull
	public PessoaHasDadosBancariosId getId() {
		return this.id;
	}

	public void setId(PessoaHasDadosBancariosId id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Dados_Bancarios_idDados_Bancarios", nullable = false, insertable = false, updatable = false)
	@NotNull
	public DadosBancarios getDadosBancarios() {
		return this.dadosBancarios;
	}

	public void setDadosBancarios(DadosBancarios dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
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
