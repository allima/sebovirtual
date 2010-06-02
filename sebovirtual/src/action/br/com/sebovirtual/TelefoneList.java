package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("telefoneList")
public class TelefoneList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private Telefone telefone = new Telefone();

	@Override
	public String getEjbql() {
		return "select telefone from Telefone telefone";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
