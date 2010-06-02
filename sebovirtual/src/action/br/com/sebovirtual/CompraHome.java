package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("compraHome")
public class CompraHome extends EntityHome<Compra> {

	@In(create = true)
	PessoaHome pessoaHome;

	public void setCompraIdCompra(Integer id) {
		setId(id);
	}

	public Integer getCompraIdCompra() {
		return (Integer) getId();
	}

	@Override
	protected Compra createInstance() {
		Compra compra = new Compra();
		return compra;
	}

	public void wire() {
		getInstance();
		Pessoa pessoa = pessoaHome.getDefinedInstance();
		if (pessoa != null) {
			getInstance().setPessoa(pessoa);
		}
	}

	public boolean isWired() {
		if (getInstance().getPessoa() == null)
			return false;
		return true;
	}

	public Compra getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Cesta> getCestas() {
		return getInstance() == null ? null : new ArrayList<Cesta>(
				getInstance().getCestas());
	}

}
