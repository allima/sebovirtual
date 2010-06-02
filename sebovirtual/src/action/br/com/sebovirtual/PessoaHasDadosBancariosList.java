package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("pessoaHasDadosBancariosList")
public class PessoaHasDadosBancariosList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private PessoaHasDadosBancarios pessoaHasDadosBancarios;

	public PessoaHasDadosBancariosList() {
		pessoaHasDadosBancarios = new PessoaHasDadosBancarios();
		pessoaHasDadosBancarios.setId(new PessoaHasDadosBancariosId());
	}

	@Override
	public String getEjbql() {
		return "select pessoaHasDadosBancarios from PessoaHasDadosBancarios pessoaHasDadosBancarios";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public PessoaHasDadosBancarios getPessoaHasDadosBancarios() {
		return pessoaHasDadosBancarios;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
