package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("pessoaHasCategoriaList")
public class PessoaHasCategoriaList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private PessoaHasCategoria pessoaHasCategoria;

	public PessoaHasCategoriaList() {
		pessoaHasCategoria = new PessoaHasCategoria();
		pessoaHasCategoria.setId(new PessoaHasCategoriaId());
	}

	@Override
	public String getEjbql() {
		return "select pessoaHasCategoria from PessoaHasCategoria pessoaHasCategoria";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public PessoaHasCategoria getPessoaHasCategoria() {
		return pessoaHasCategoria;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
