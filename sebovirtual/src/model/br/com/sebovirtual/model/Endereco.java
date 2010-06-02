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
@Table(name = "endereco", catalog = "sebovirtual")
public class Endereco implements java.io.Serializable {

	private Integer idEndereco;
	private char tipo;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Set<PessoaHasEndereco> pessoaHasEnderecos = new HashSet<PessoaHasEndereco>(
			0);

	public Endereco() {
	}

	public Endereco(char tipo, String logradouro, int numero, String bairro,
			String cidade, String estado) {
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Endereco(char tipo, String logradouro, int numero,
			String complemento, String bairro, String cidade, String estado,
			Set<PessoaHasEndereco> pessoaHasEnderecos) {
		this.tipo = tipo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pessoaHasEnderecos = pessoaHasEnderecos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idEndereco", unique = true, nullable = false)
	public Integer getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	@Column(name = "tipo", nullable = false, length = 1)
	@NotNull
	public char getTipo() {
		return this.tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	@Column(name = "logradouro", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Column(name = "numero", nullable = false)
	@NotNull
	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Column(name = "complemento", length = 15)
	@Length(max = 15)
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Column(name = "bairro", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(name = "cidade", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(name = "estado", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "endereco")
	public Set<PessoaHasEndereco> getPessoaHasEnderecos() {
		return this.pessoaHasEnderecos;
	}

	public void setPessoaHasEnderecos(Set<PessoaHasEndereco> pessoaHasEnderecos) {
		this.pessoaHasEnderecos = pessoaHasEnderecos;
	}

}
