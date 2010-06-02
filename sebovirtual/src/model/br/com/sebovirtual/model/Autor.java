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
@Table(name = "autor", catalog = "sebovirtual")
public class Autor implements java.io.Serializable {

	private Integer idAutor;
	private String nome;
	private Set<Obra> obras = new HashSet<Obra>(0);

	public Autor() {
	}

	public Autor(String nome) {
		this.nome = nome;
	}
	public Autor(String nome, Set<Obra> obras) {
		this.nome = nome;
		this.obras = obras;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAutor", unique = true, nullable = false)
	public Integer getIdAutor() {
		return this.idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	@Column(name = "Nome", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "autor")
	public Set<Obra> getObras() {
		return this.obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}

}
