package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("cestaHome")
public class CestaHome extends EntityHome<Cesta> {

	@In(create = true)
	CompraHome compraHome;
	@In(create = true)
	VendeHome vendeHome;

	public void setCestaId(CestaId id) {
		setId(id);
	}

	public CestaId getCestaId() {
		return (CestaId) getId();
	}

	public CestaHome() {
		setCestaId(new CestaId());
	}

	@Override
	public boolean isIdDefined() {
		if (getCestaId().getCompraIdCompra() == 0)
			return false;
		if (getCestaId().getVendeObraIsbn() == 0)
			return false;
		if (getCestaId().getVendePessoaCpf() == 0)
			return false;

		return true;
	}

	@Override
	protected Cesta createInstance() {
		Cesta cesta = new Cesta();
		cesta.setId(new CestaId());
		return cesta;
	}

	public void wire() {
		getInstance();
		Compra compra = compraHome.getDefinedInstance();
		if (compra != null) {
			getInstance().setCompra(compra);
		}
		Vende vende = vendeHome.getDefinedInstance();
		if (vende != null) {
			getInstance().setVende(vende);
		}
	}

	public boolean isWired() {
		if (getInstance().getCompra() == null)
			return false;
		if (getInstance().getVende() == null)
			return false;
		return true;
	}

	public Cesta getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
