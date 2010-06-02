package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("obraList")
public class ObraList extends EntityQuery {

	private static final String[] RESTRICTIONS = {"lower(obra.titulo) like concat(lower(#{obraList.obra.titulo}),'%')",};

	private Obra obra = new Obra();

	@Override
	public String getEjbql() {
		return "select obra from Obra obra";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Obra getObra() {
		return obra;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
