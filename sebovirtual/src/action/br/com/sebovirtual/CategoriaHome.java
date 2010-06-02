package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("categoriaHome")
public class CategoriaHome extends EntityHome<Categoria> {

	public void setCategoriaIdCategoria(Integer id) {
		setId(id);
	}

	public Integer getCategoriaIdCategoria() {
		return (Integer) getId();
	}

	@Override
	protected Categoria createInstance() {
		Categoria categoria = new Categoria();
		return categoria;
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Categoria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Obra> getObras() {
		return getInstance() == null ? null : new ArrayList<Obra>(getInstance()
				.getObras());
	}
	public List<PessoaHasCategoria> getPessoaHasCategorias() {
		return getInstance() == null
				? null
				: new ArrayList<PessoaHasCategoria>(getInstance()
						.getPessoaHasCategorias());
	}

}
