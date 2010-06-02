package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("autorList")
public class AutorList extends EntityQuery {

	private static final String[] RESTRICTIONS = {"lower(autor.nome) like concat(lower(#{autorList.autor.nome}),'%')",};

	private Autor autor = new Autor();

	@Override
	public String getEjbql() {
		return "select autor from Autor autor";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Autor getAutor() {
		return autor;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
