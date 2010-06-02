package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("telefoneHome")
public class TelefoneHome extends EntityHome<Telefone> {

	public void setTelefoneIdTelefone(Integer id) {
		setId(id);
	}

	public Integer getTelefoneIdTelefone() {
		return (Integer) getId();
	}

	@Override
	protected Telefone createInstance() {
		Telefone telefone = new Telefone();
		return telefone;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Telefone getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PessoaHasTelefone> getPessoaHasTelefones() {
		return getInstance() == null ? null : new ArrayList<PessoaHasTelefone>(
				getInstance().getPessoaHasTelefones());
	}

}
