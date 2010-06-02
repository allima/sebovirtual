package br.com.sebovirtual.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "obra", catalog = "sebovirtual")
public class Obra implements java.io.Serializable {

	private int isbn;
	private Editora editora;
	private Autor autor;
	private Categoria categoria;
	private String titulo;
	private int anoPublicacao;
	private Set<Vende> vendes = new HashSet<Vende>(0);

	public Obra() {
	}

	public Obra(int isbn, Editora editora, Autor autor, Categoria categoria,
			String titulo, int anoPublicacao) {
		this.isbn = isbn;
		this.editora = editora;
		this.autor = autor;
		this.categoria = categoria;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
	}
	public Obra(int isbn, Editora editora, Autor autor, Categoria categoria,
			String titulo, int anoPublicacao, Set<Vende> vendes) {
		this.isbn = isbn;
		this.editora = editora;
		this.autor = autor;
		this.categoria = categoria;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.vendes = vendes;
	}

	@Id
	@Column(name = "ISBN", unique = true, nullable = false)
	@NotNull
	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Editora_idEditora", nullable = false)
	@NotNull
	public Editora getEditora() {
		return this.editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Autor_idAutor", nullable = false)
	@NotNull
	public Autor getAutor() {
		return this.autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Categoria_idCategoria", nullable = false)
	@NotNull
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Column(name = "titulo", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "ano_publicacao", nullable = false)
	@NotNull
	public int getAnoPublicacao() {
		return this.anoPublicacao;
	}

	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "obra")
	public Set<Vende> getVendes() {
		return this.vendes;
	}

	public void setVendes(Set<Vende> vendes) {
		this.vendes = vendes;
	}

}
