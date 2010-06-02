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
@Table(name = "editora", catalog = "sebovirtual")
public class Editora implements java.io.Serializable {

	private Integer idEditora;
	private String nome;
	private Set<Obra> obras = new HashSet<Obra>(0);

	public Editora() {
	}

	public Editora(String nome) {
		this.nome = nome;
	}
	public Editora(String nome, Set<Obra> obras) {
		this.nome = nome;
		this.obras = obras;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEditora", unique = true, nullable = false)
	public Integer getIdEditora() {
		return this.idEditora;
	}

	public void setIdEditora(Integer idEditora) {
		this.idEditora = idEditora;
	}

	@Column(name = "Nome", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "editora")
	public Set<Obra> getObras() {
		return this.obras;
	}

	public void setObras(Set<Obra> obras) {
		this.obras = obras;
	}

}
