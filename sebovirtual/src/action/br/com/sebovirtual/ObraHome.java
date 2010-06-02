package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("obraHome")
public class ObraHome extends EntityHome<Obra> {

	@In(create = true)
	AutorHome autorHome;
	@In(create = true)
	CategoriaHome categoriaHome;
	@In(create = true)
	EditoraHome editoraHome;

	public void setObraIsbn(Integer id) {
		setId(id);
	}

	public Integer getObraIsbn() {
		return (Integer) getId();
	}

	@Override
	protected Obra createInstance() {
		Obra obra = new Obra();
		return obra;
	}

	public void wire() {
		getInstance();
		Autor autor = autorHome.getDefinedInstance();
		if (autor != null) {
			getInstance().setAutor(autor);
		}
		Categoria categoria = categoriaHome.getDefinedInstance();
		if (categoria != null) {
			getInstance().setCategoria(categoria);
		}
		Editora editora = editoraHome.getDefinedInstance();
		if (editora != null) {
			getInstance().setEditora(editora);
		}
	}

	public boolean isWired() {
		if (getInstance().getAutor() == null)
			return false;
		if (getInstance().getCategoria() == null)
			return false;
		if (getInstance().getEditora() == null)
			return false;
		return true;
	}

	public Obra getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Vende> getVendes() {
		return getInstance() == null ? null : new ArrayList<Vende>(
				getInstance().getVendes());
	}

}
