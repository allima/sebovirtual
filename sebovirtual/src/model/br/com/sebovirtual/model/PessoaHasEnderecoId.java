package br.com.sebovirtual.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.NotNull;

@Embeddable
public class PessoaHasEnderecoId implements java.io.Serializable {

	private int pessoaCpf;
	private int enderecoIdEndereco;

	public PessoaHasEnderecoId() {
	}

	public PessoaHasEnderecoId(int pessoaCpf, int enderecoIdEndereco) {
		this.pessoaCpf = pessoaCpf;
		this.enderecoIdEndereco = enderecoIdEndereco;
	}

	@Column(name = "Pessoa_cpf", nullable = false)
	@NotNull
	public int getPessoaCpf() {
		return this.pessoaCpf;
	}

	public void setPessoaCpf(int pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}

	@Column(name = "Endereco_idEndereco", nullable = false)
	@NotNull
	public int getEnderecoIdEndereco() {
		return this.enderecoIdEndereco;
	}

	public void setEnderecoIdEndereco(int enderecoIdEndereco) {
		this.enderecoIdEndereco = enderecoIdEndereco;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PessoaHasEnderecoId))
			return false;
		PessoaHasEnderecoId castOther = (PessoaHasEnderecoId) other;

		return (this.getPessoaCpf() == castOther.getPessoaCpf())
				&& (this.getEnderecoIdEndereco() == castOther
						.getEnderecoIdEndereco());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPessoaCpf();
		result = 37 * result + this.getEnderecoIdEndereco();
		return result;
	}

}
