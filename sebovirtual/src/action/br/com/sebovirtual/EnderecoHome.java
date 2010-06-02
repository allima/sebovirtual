package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("enderecoHome")
public class EnderecoHome extends EntityHome<Endereco> {

	public void setEnderecoIdEndereco(Integer id) {
		setId(id);
	}

	public Integer getEnderecoIdEndereco() {
		return (Integer) getId();
	}

	@Override
	protected Endereco createInstance() {
		Endereco endereco = new Endereco();
		return endereco;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Endereco getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PessoaHasEndereco> getPessoaHasEnderecos() {
		return getInstance() == null ? null : new ArrayList<PessoaHasEndereco>(
				getInstance().getPessoaHasEnderecos());
	}

}
