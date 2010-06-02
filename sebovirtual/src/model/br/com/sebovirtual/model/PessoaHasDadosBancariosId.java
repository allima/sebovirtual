package br.com.sebovirtual.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.NotNull;

@Embeddable
public class PessoaHasDadosBancariosId implements java.io.Serializable {

	private int pessoaCpf;
	private int dadosBancariosIdDadosBancarios;

	public PessoaHasDadosBancariosId() {
	}

	public PessoaHasDadosBancariosId(int pessoaCpf,
			int dadosBancariosIdDadosBancarios) {
		this.pessoaCpf = pessoaCpf;
		this.dadosBancariosIdDadosBancarios = dadosBancariosIdDadosBancarios;
	}

	@Column(name = "Pessoa_cpf", nullable = false)
	@NotNull
	public int getPessoaCpf() {
		return this.pessoaCpf;
	}

	public void setPessoaCpf(int pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}

	@Column(name = "Dados_Bancarios_idDados_Bancarios", nullable = false)
	@NotNull
	public int getDadosBancariosIdDadosBancarios() {
		return this.dadosBancariosIdDadosBancarios;
	}

	public void setDadosBancariosIdDadosBancarios(
			int dadosBancariosIdDadosBancarios) {
		this.dadosBancariosIdDadosBancarios = dadosBancariosIdDadosBancarios;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PessoaHasDadosBancariosId))
			return false;
		PessoaHasDadosBancariosId castOther = (PessoaHasDadosBancariosId) other;

		return (this.getPessoaCpf() == castOther.getPessoaCpf())
				&& (this.getDadosBancariosIdDadosBancarios() == castOther
						.getDadosBancariosIdDadosBancarios());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPessoaCpf();
		result = 37 * result + this.getDadosBancariosIdDadosBancarios();
		return result;
	}

}
