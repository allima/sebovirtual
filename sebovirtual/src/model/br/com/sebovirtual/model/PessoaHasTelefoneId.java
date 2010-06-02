package br.com.sebovirtual.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.NotNull;

@Embeddable
public class PessoaHasTelefoneId implements java.io.Serializable {

	private int pessoaCpf;
	private int telefoneIdTelefone;

	public PessoaHasTelefoneId() {
	}

	public PessoaHasTelefoneId(int pessoaCpf, int telefoneIdTelefone) {
		this.pessoaCpf = pessoaCpf;
		this.telefoneIdTelefone = telefoneIdTelefone;
	}

	@Column(name = "Pessoa_cpf", nullable = false)
	@NotNull
	public int getPessoaCpf() {
		return this.pessoaCpf;
	}

	public void setPessoaCpf(int pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}

	@Column(name = "Telefone_idTelefone", nullable = false)
	@NotNull
	public int getTelefoneIdTelefone() {
		return this.telefoneIdTelefone;
	}

	public void setTelefoneIdTelefone(int telefoneIdTelefone) {
		this.telefoneIdTelefone = telefoneIdTelefone;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PessoaHasTelefoneId))
			return false;
		PessoaHasTelefoneId castOther = (PessoaHasTelefoneId) other;

		return (this.getPessoaCpf() == castOther.getPessoaCpf())
				&& (this.getTelefoneIdTelefone() == castOther
						.getTelefoneIdTelefone());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPessoaCpf();
		result = 37 * result + this.getTelefoneIdTelefone();
		return result;
	}

}
