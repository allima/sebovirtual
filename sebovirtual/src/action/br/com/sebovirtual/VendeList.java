package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("vendeList")
public class VendeList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private Vende vende;

	public VendeList() {
		vende = new Vende();
		vende.setId(new VendeId());
	}

	@Override
	public String getEjbql() {
		return "select vende from Vende vende";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Vende getVende() {
		return vende;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
