package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("enderecoList")
public class EnderecoList extends EntityQuery {

	private static final String[] RESTRICTIONS = {
			"lower(endereco.bairro) like concat(lower(#{enderecoList.endereco.bairro}),'%')",
			"lower(endereco.cidade) like concat(lower(#{enderecoList.endereco.cidade}),'%')",
			"lower(endereco.complemento) like concat(lower(#{enderecoList.endereco.complemento}),'%')",
			"lower(endereco.estado) like concat(lower(#{enderecoList.endereco.estado}),'%')",
			"lower(endereco.logradouro) like concat(lower(#{enderecoList.endereco.logradouro}),'%')",};

	private Endereco endereco = new Endereco();

	@Override
	public String getEjbql() {
		return "select endereco from Endereco endereco";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
