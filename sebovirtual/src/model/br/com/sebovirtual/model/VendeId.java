package br.com.sebovirtual.model;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.NotNull;

@Embeddable
public class VendeId implements java.io.Serializable {

	private int pessoaCpf;
	private int obraIsbn;

	public VendeId() {
	}

	public VendeId(int pessoaCpf, int obraIsbn) {
		this.pessoaCpf = pessoaCpf;
		this.obraIsbn = obraIsbn;
	}

	@Column(name = "Pessoa_cpf", nullable = false)
	@NotNull
	public int getPessoaCpf() {
		return this.pessoaCpf;
	}

	public void setPessoaCpf(int pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}

	@Column(name = "Obra_ISBN", nullable = false)
	@NotNull
	public int getObraIsbn() {
		return this.obraIsbn;
	}

	public void setObraIsbn(int obraIsbn) {
		this.obraIsbn = obraIsbn;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VendeId))
			return false;
		VendeId castOther = (VendeId) other;

		return (this.getPessoaCpf() == castOther.getPessoaCpf())
				&& (this.getObraIsbn() == castOther.getObraIsbn());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPessoaCpf();
		result = 37 * result + this.getObraIsbn();
		return result;
	}

}
