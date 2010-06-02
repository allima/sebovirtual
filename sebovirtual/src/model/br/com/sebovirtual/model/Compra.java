package br.com.sebovirtual.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "compra", catalog = "sebovirtual")
public class Compra implements java.io.Serializable {

	private Integer idCompra;
	private Pessoa pessoa;
	private Date dataCompra;
	private Set<Cesta> cestas = new HashSet<Cesta>(0);

	public Compra() {
	}

	public Compra(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Compra(Pessoa pessoa, Date dataCompra, Set<Cesta> cestas) {
		this.pessoa = pessoa;
		this.dataCompra = dataCompra;
		this.cestas = cestas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCompra", unique = true, nullable = false)
	public Integer getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Pessoa_cpf", nullable = false)
	@NotNull
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "data_compra", length = 10)
	public Date getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "compra")
	public Set<Cesta> getCestas() {
		return this.cestas;
	}

	public void setCestas(Set<Cesta> cestas) {
		this.cestas = cestas;
	}

}
