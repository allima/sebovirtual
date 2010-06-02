package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("vendeHome")
public class VendeHome extends EntityHome<Vende> {

	@In(create = true)
	ObraHome obraHome;
	@In(create = true)
	PessoaHome pessoaHome;

	public void setVendeId(VendeId id) {
		setId(id);
	}

	public VendeId getVendeId() {
		return (VendeId) getId();
	}

	public VendeHome() {
		setVendeId(new VendeId());
	}

	@Override
	public boolean isIdDefined() {
		if (getVendeId().getObraIsbn() == 0)
			return false;
		if (getVendeId().getPessoaCpf() == 0)
			return false;

		return true;
	}

	@Override
	protected Vende createInstance() {
		Vende vende = new Vende();
		vende.setId(new VendeId());
		return vende;
	}

	public void wire() {
		getInstance();
		Obra obra = obraHome.getDefinedInstance();
		if (obra != null) {
			getInstance().setObra(obra);
		}
		Pessoa pessoa = pessoaHome.getDefinedInstance();
		if (pessoa != null) {
			getInstance().setPessoa(pessoa);
		}
	}

	public boolean isWired() {
		if (getInstance().getObra() == null)
			return false;
		if (getInstance().getPessoa() == null)
			return false;
		return true;
	}

	public Vende getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Cesta> getCestas() {
		return getInstance() == null ? null : new ArrayList<Cesta>(
				getInstance().getCestas());
	}

}
