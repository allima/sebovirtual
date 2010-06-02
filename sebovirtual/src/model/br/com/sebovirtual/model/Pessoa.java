package br.com.sebovirtual.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "pessoa", catalog = "sebovirtual")
public class Pessoa implements java.io.Serializable {

	private int cpf;
	private String nome;
	private String email;
	private String senha;
	private String dicaSenha;
	private int status2;
	private int tipo;
	private Set<PessoaHasDadosBancarios> pessoaHasDadosBancarioses = new HashSet<PessoaHasDadosBancarios>(
			0);
	private Set<Vende> vendes = new HashSet<Vende>(0);
	private Set<Compra> compras = new HashSet<Compra>(0);
	private Set<PessoaHasTelefone> pessoaHasTelefones = new HashSet<PessoaHasTelefone>(
			0);
	private Set<PessoaHasCategoria> pessoaHasCategorias = new HashSet<PessoaHasCategoria>(
			0);
	private Set<PessoaHasEndereco> pessoaHasEnderecos = new HashSet<PessoaHasEndereco>(
			0);

	public Pessoa() {
	}

	public Pessoa(int cpf, String nome, String email, String senha,
			String dicaSenha, int status2, int tipo) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dicaSenha = dicaSenha;
		this.status2 = status2;
		this.tipo = tipo;
	}
	public Pessoa(int cpf, String nome, String email, String senha,
			String dicaSenha, int status2, int tipo,
			Set<PessoaHasDadosBancarios> pessoaHasDadosBancarioses,
			Set<Vende> vendes, Set<Compra> compras,
			Set<PessoaHasTelefone> pessoaHasTelefones,
			Set<PessoaHasCategoria> pessoaHasCategorias,
			Set<PessoaHasEndereco> pessoaHasEnderecos) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dicaSenha = dicaSenha;
		this.status2 = status2;
		this.tipo = tipo;
		this.pessoaHasDadosBancarioses = pessoaHasDadosBancarioses;
		this.vendes = vendes;
		this.compras = compras;
		this.pessoaHasTelefones = pessoaHasTelefones;
		this.pessoaHasCategorias = pessoaHasCategorias;
		this.pessoaHasEnderecos = pessoaHasEnderecos;
	}

	@Id
	@Column(name = "cpf", unique = true, nullable = false)
	@NotNull
	public int getCpf() {
		return this.cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Column(name = "nome", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "email", nullable = false)
	@NotNull
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "senha", nullable = false, length = 8)
	@NotNull
	@Length(max = 8)
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name = "dica_senha", nullable = false, length = 20)
	@NotNull
	@Length(max = 20)
	public String getDicaSenha() {
		return this.dicaSenha;
	}

	public void setDicaSenha(String dicaSenha) {
		this.dicaSenha = dicaSenha;
	}

	@Column(name = "status_2", nullable = false)
	@NotNull
	public int getStatus2() {
		return this.status2;
	}

	public void setStatus2(int status2) {
		this.status2 = status2;
	}

	@Column(name = "tipo", nullable = false)
	@NotNull
	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set<PessoaHasDadosBancarios> getPessoaHasDadosBancarioses() {
		return this.pessoaHasDadosBancarioses;
	}

	public void setPessoaHasDadosBancarioses(
			Set<PessoaHasDadosBancarios> pessoaHasDadosBancarioses) {
		this.pessoaHasDadosBancarioses = pessoaHasDadosBancarioses;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set<Vende> getVendes() {
		return this.vendes;
	}

	public void setVendes(Set<Vende> vendes) {
		this.vendes = vendes;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set<PessoaHasTelefone> getPessoaHasTelefones() {
		return this.pessoaHasTelefones;
	}

	public void setPessoaHasTelefones(Set<PessoaHasTelefone> pessoaHasTelefones) {
		this.pessoaHasTelefones = pessoaHasTelefones;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set<PessoaHasCategoria> getPessoaHasCategorias() {
		return this.pessoaHasCategorias;
	}

	public void setPessoaHasCategorias(
			Set<PessoaHasCategoria> pessoaHasCategorias) {
		this.pessoaHasCategorias = pessoaHasCategorias;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pessoa")
	public Set<PessoaHasEndereco> getPessoaHasEnderecos() {
		return this.pessoaHasEnderecos;
	}

	public void setPessoaHasEnderecos(Set<PessoaHasEndereco> pessoaHasEnderecos) {
		this.pessoaHasEnderecos = pessoaHasEnderecos;
	}

}
