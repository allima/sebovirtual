package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("dadosBancariosList")
public class DadosBancariosList extends EntityQuery {

	private static final String[] RESTRICTIONS = {};

	private DadosBancarios dadosBancarios = new DadosBancarios();

	@Override
	public String getEjbql() {
		return "select dadosBancarios from DadosBancarios dadosBancarios";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public DadosBancarios getDadosBancarios() {
		return dadosBancarios;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
