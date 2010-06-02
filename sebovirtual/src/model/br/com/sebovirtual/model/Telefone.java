package br.com.sebovirtual.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "telefone", catalog = "sebovirtual")
public class Telefone implements java.io.Serializable {

	private Integer idTelefone;
	private int ddd;
	private int numero;
	private int tipo;
	private Set<PessoaHasTelefone> pessoaHasTelefones = new HashSet<PessoaHasTelefone>(
			0);

	public Telefone() {
	}

	public Telefone(int ddd, int numero, int tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	public Telefone(int ddd, int numero, int tipo,
			Set<PessoaHasTelefone> pessoaHasTelefones) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
		this.pessoaHasTelefones = pessoaHasTelefones;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idTelefone", unique = true, nullable = false)
	public Integer getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	@Column(name = "ddd", nullable = false)
	@NotNull
	public int getDdd() {
		return this.ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	@Column(name = "numero", nullable = false)
	@NotNull
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Column(name = "tipo", nullable = false)
	@NotNull
	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "telefone")
	public Set<PessoaHasTelefone> getPessoaHasTelefones() {
		return this.pessoaHasTelefones;
	}

	public void setPessoaHasTelefones(Set<PessoaHasTelefone> pessoaHasTelefones) {
		this.pessoaHasTelefones = pessoaHasTelefones;
	}

}
