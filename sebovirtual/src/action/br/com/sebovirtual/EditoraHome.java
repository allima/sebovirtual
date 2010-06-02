package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("editoraHome")
public class EditoraHome extends EntityHome<Editora> {

	public void setEditoraIdEditora(Integer id) {
		setId(id);
	}

	public Integer getEditoraIdEditora() {
		return (Integer) getId();
	}

	@Override
	protected Editora createInstance() {
		Editora editora = new Editora();
		return editora;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Editora getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Obra> getObras() {
		return getInstance() == null ? null : new ArrayList<Obra>(getInstance()
				.getObras());
	}

}
