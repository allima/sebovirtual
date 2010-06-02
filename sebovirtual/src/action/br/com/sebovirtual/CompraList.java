package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("compraList")
public class CompraList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private Compra compra = new Compra();

	@Override
	public String getEjbql() {
		return "select compra from Compra compra";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Compra getCompra() {
		return compra;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
