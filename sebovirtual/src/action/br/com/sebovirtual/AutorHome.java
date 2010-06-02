package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("autorHome")
public class AutorHome extends EntityHome<Autor> {

	public void setAutorIdAutor(Integer id) {
		setId(id);
	}

	public Integer getAutorIdAutor() {
		return (Integer) getId();
	}

	@Override
	protected Autor createInstance() {
		Autor autor = new Autor();
		return autor;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Autor getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Obra> getObras() {
		return getInstance() == null ? null : new ArrayList<Obra>(getInstance()
				.getObras());
	}

}
