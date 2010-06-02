package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.List;
import java.util.Arrays;

@Name("editoraList")
public class EditoraList extends EntityQuery {

	private static final String[] RESTRICTIONS = {"lower(editora.nome) like concat(lower(#{editoraList.editora.nome}),'%')",};

	private Editora editora = new Editora();

	@Override
	public String getEjbql() {
		return "select editora from Editora editora";
	}

	@Override
	public Integer getMaxResults() {
		return 25;
	}

	public Editora getEditora() {
		return editora;
	}

	@Override
	public List<String> getRestrictions() {
		return Arrays.asList(RESTRICTIONS);
	}

}
