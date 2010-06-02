package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("pessoaList")
public class PessoaList extends EntityQuery {

	private static final String[] RESTRICTIONS = {
			"lower(pessoa.dicaSenha) like concat(lower(#{pessoaList.pessoa.dicaSenha}),'%')",
			"lower(pessoa.email) like concat(lower(#{pessoaList.pessoa.email}),'%')",
			"lower(pessoa.nome) like concat(lower(#{pessoaList.pessoa.nome}),'%')",
			"lower(pessoa.senha) like concat(lower(#{pessoaList.pessoa.senha}),'%')",};

	private Pessoa pessoa = new Pessoa();

	@Override
	public String getEjbql() {
		return "select pessoa from Pessoa pessoa";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
