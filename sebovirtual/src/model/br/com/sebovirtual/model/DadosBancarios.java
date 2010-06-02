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
@Table(name = "dados_bancarios", catalog = "sebovirtual")
public class DadosBancarios implements java.io.Serializable {

	private Integer idDadosBancarios;
	private int banco;
	private int agencia;
	private int contacorente;
	private Set<PessoaHasDadosBancarios> pessoaHasDadosBancarioses = new HashSet<PessoaHasDadosBancarios>(
			0);

	public DadosBancarios() {
	}

	public DadosBancarios(int banco, int agencia, int contacorente) {
		this.banco = banco;
		this.agencia = agencia;
		this.contacorente = contacorente;
	}
	public DadosBancarios(int banco, int agencia, int contacorente,
			Set<PessoaHasDadosBancarios> pessoaHasDadosBancarioses) {
		this.banco = banco;
		this.agencia = agencia;
		this.contacorente = contacorente;
		this.pessoaHasDadosBancarioses = pessoaHasDadosBancarioses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idDados_Bancarios", unique = true, nullable = false)
	public Integer getIdDadosBancarios() {
		return this.idDadosBancarios;
	}

	public void setIdDadosBancarios(Integer idDadosBancarios) {
		this.idDadosBancarios = idDadosBancarios;
	}

	@Column(name = "banco", nullable = false)
	@NotNull
	public int getBanco() {
		return this.banco;
	}

	public void setBanco(int banco) {
		this.banco = banco;
	}

	@Column(name = "agencia", nullable = false)
	@NotNull
	public int getAgencia() {
		return this.agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	@Column(name = "contacorente", nullable = false)
	@NotNull
	public int getContacorente() {
		return this.contacorente;
	}

	public void setContacorente(int contacorente) {
		this.contacorente = contacorente;
	}
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dadosBancarios")
	public Set<PessoaHasDadosBancarios> getPessoaHasDadosBancarioses() {
		return this.pessoaHasDadosBancarioses;
	}

	public void setPessoaHasDadosBancarioses(
			Set<PessoaHasDadosBancarios> pessoaHasDadosBancarioses) {
		this.pessoaHasDadosBancarioses = pessoaHasDadosBancarioses;
	}

}
