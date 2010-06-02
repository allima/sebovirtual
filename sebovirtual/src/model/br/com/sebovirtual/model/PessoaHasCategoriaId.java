package br.com.sebovirtual.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.NotNull;

@Embeddable
public class PessoaHasCategoriaId implements java.io.Serializable {

	private int pessoaCpf;
	private int categoriaIdCategoria;

	public PessoaHasCategoriaId() {
	}

	public PessoaHasCategoriaId(int pessoaCpf, int categoriaIdCategoria) {
		this.pessoaCpf = pessoaCpf;
		this.categoriaIdCategoria = categoriaIdCategoria;
	}

	@Column(name = "Pessoa_cpf", nullable = false)
	@NotNull
	public int getPessoaCpf() {
		return this.pessoaCpf;
	}

	public void setPessoaCpf(int pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}

	@Column(name = "Categoria_idCategoria", nullable = false)
	@NotNull
	public int getCategoriaIdCategoria() {
		return this.categoriaIdCategoria;
	}

	public void setCategoriaIdCategoria(int categoriaIdCategoria) {
		this.categoriaIdCategoria = categoriaIdCategoria;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PessoaHasCategoriaId))
			return false;
		PessoaHasCategoriaId castOther = (PessoaHasCategoriaId) other;

		return (this.getPessoaCpf() == castOther.getPessoaCpf())
				&& (this.getCategoriaIdCategoria() == castOther
						.getCategoriaIdCategoria());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPessoaCpf();
		result = 37 * result + this.getCategoriaIdCategoria();
		return result;
	}

}
