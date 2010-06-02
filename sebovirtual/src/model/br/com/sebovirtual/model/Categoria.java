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
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "categoria", catalog = "sebovirtual")
public class Categoria implements java.io.Serializable {

	private Integer idCategoria;
	private String descricao;
	private Set<Obra> obras = new HashSet<Obra>(0);
	private Set<PessoaHasCategoria> pessoaHasCategorias = new HashSet<PessoaHasCategoria>(
			0);

	public Categoria() {
	}

	public Categoria(String descricao) {
		this.descricao = descricao;
	}
	public Categoria(String descricao, Set<Obra> obras,
			Set<PessoaHasCategoria> pessoaHasCategorias) {
		this.descricao = descricao;
		this.obras = obras;
		this.pessoaHasCategorias = pessoaHasCategorias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCategoria", unique = true, nullable = false)
	public Integer getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "Descricao", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<Obra> getObras() {
		return this.obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<PessoaHasCategoria> getPessoaHasCategorias() {
		return this.pessoaHasCategorias;
	}

	public void setPessoaHasCategorias(
			Set<PessoaHasCategoria> pessoaHasCategorias) {
		this.pessoaHasCategorias = pessoaHasCategorias;
	}

}
