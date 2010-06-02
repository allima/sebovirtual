package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("pessoaHasEnderecoList")
public class PessoaHasEnderecoList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private PessoaHasEndereco pessoaHasEndereco;

	public PessoaHasEnderecoList() {
		pessoaHasEndereco = new PessoaHasEndereco();
		pessoaHasEndereco.setId(new PessoaHasEnderecoId());
	}

	@Override
	public String getEjbql() {
		return "select pessoaHasEndereco from PessoaHasEndereco pessoaHasEndereco";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public PessoaHasEndereco getPessoaHasEndereco() {
		return pessoaHasEndereco;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
