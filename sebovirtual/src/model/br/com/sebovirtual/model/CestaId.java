package br.com.sebovirtual.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.validator.NotNull;

@Embeddable
public class CestaId implements java.io.Serializable {

	private int compraIdCompra;
	private int vendeObraIsbn;
	private int vendePessoaCpf;

	public CestaId() {
	}

	public CestaId(int compraIdCompra, int vendeObraIsbn, int vendePessoaCpf) {
		this.compraIdCompra = compraIdCompra;
		this.vendeObraIsbn = vendeObraIsbn;
		this.vendePessoaCpf = vendePessoaCpf;
	}

	@Column(name = "Compra_idCompra", nullable = false)
	@NotNull
	public int getCompraIdCompra() {
		return this.compraIdCompra;
	}

	public void setCompraIdCompra(int compraIdCompra) {
		this.compraIdCompra = compraIdCompra;
	}

	@Column(name = "Vende_Obra_ISBN", nullable = false)
	@NotNull
	public int getVendeObraIsbn() {
		return this.vendeObraIsbn;
	}

	public void setVendeObraIsbn(int vendeObraIsbn) {
		this.vendeObraIsbn = vendeObraIsbn;
	}

	@Column(name = "Vende_Pessoa_cpf", nullable = false)
	@NotNull
	public int getVendePessoaCpf() {
		return this.vendePessoaCpf;
	}

	public void setVendePessoaCpf(int vendePessoaCpf) {
		this.vendePessoaCpf = vendePessoaCpf;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CestaId))
			return false;
		CestaId castOther = (CestaId) other;

		return (this.getCompraIdCompra() == castOther.getCompraIdCompra())
				&& (this.getVendeObraIsbn() == castOther.getVendeObraIsbn())
				&& (this.getVendePessoaCpf() == castOther.getVendePessoaCpf());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCompraIdCompra();
		result = 37 * result + this.getVendeObraIsbn();
		result = 37 * result + this.getVendePessoaCpf();
		return result;
	}

}
