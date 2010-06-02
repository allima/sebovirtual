package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("categoriaList")
public class CategoriaList extends EntityQuery {

	private static final String[] RESTRICTIONS = {"lower(categoria.descricao) like concat(lower(#{categoriaList.categoria.descricao}),'%')",};

	private Categoria categoria = new Categoria();

	@Override
	public String getEjbql() {
		return "select categoria from Categoria categoria";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
