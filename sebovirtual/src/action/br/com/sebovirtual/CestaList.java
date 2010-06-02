package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("cestaList")
public class CestaList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private Cesta cesta;

	public CestaList() {
		cesta = new Cesta();
		cesta.setId(new CestaId());
	}

	@Override
	public String getEjbql() {
		return "select cesta from Cesta cesta";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Cesta getCesta() {
		return cesta;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
