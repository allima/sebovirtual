package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("pessoaHome")
public class PessoaHome extends EntityHome<Pessoa> {

	public void setPessoaCpf(Integer id) {
		setId(id);
	}

	public Integer getPessoaCpf() {
		return (Integer) getId();
	}

	@Override
	protected Pessoa createInstance() {
		Pessoa pessoa = new Pessoa();
		return pessoa;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Pessoa getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Compra> getCompras() {
		return getInstance() == null ? null : new ArrayList<Compra>(
				getInstance().getCompras());
	}
	public List<PessoaHasCategoria> getPessoaHasCategorias() {
		return getInstance() == null
				? null
				: new ArrayList<PessoaHasCategoria>(getInstance()
						.getPessoaHasCategorias());
	}
	public List<PessoaHasDadosBancarios> getPessoaHasDadosBancarioses() {
		return getInstance() == null
				? null
				: new ArrayList<PessoaHasDadosBancarios>(getInstance()
						.getPessoaHasDadosBancarioses());
	}
	public List<PessoaHasEndereco> getPessoaHasEnderecos() {
		return getInstance() == null ? null : new ArrayList<PessoaHasEndereco>(
				getInstance().getPessoaHasEnderecos());
	}
	public List<PessoaHasTelefone> getPessoaHasTelefones() {
		return getInstance() == null ? null : new ArrayList<PessoaHasTelefone>(
				getInstance().getPessoaHasTelefones());
	}
	public List<Vende> getVendes() {
		return getInstance() == null ? null : new ArrayList<Vende>(
				getInstance().getVendes());
	}

}
