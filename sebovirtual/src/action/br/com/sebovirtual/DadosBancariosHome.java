package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("dadosBancariosHome")
public class DadosBancariosHome extends EntityHome<DadosBancarios> {

	public void setDadosBancariosIdDadosBancarios(Integer id) {
		setId(id);
	}

	public Integer getDadosBancariosIdDadosBancarios() {
		return (Integer) getId();
	}

	@Override
	protected DadosBancarios createInstance() {
		DadosBancarios dadosBancarios = new DadosBancarios();
		return dadosBancarios;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public DadosBancarios getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PessoaHasDadosBancarios> getPessoaHasDadosBancarioses() {
		return getInstance() == null
				? null
				: new ArrayList<PessoaHasDadosBancarios>(getInstance()
						.getPessoaHasDadosBancarioses());
	}

}
