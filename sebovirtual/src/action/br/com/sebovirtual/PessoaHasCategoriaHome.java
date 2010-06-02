package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("pessoaHasCategoriaHome")
public class PessoaHasCategoriaHome extends EntityHome<PessoaHasCategoria> {

	@In(create = true)
	CategoriaHome categoriaHome;
	@In(create = true)
	PessoaHome pessoaHome;

	public void setPessoaHasCategoriaId(PessoaHasCategoriaId id) {
		setId(id);
	}

	public PessoaHasCategoriaId getPessoaHasCategoriaId() {
		return (PessoaHasCategoriaId) getId();
	}

	public PessoaHasCategoriaHome() {
		setPessoaHasCategoriaId(new PessoaHasCategoriaId());
	}

	@Override
	public boolean isIdDefined() {
		if (getPessoaHasCategoriaId().getCategoriaIdCategoria() == 0)
			return false;
		if (getPessoaHasCategoriaId().getPessoaCpf() == 0)
			return false;

		return true;
	}

	@Override
	protected PessoaHasCategoria createInstance() {
		PessoaHasCategoria pessoaHasCategoria = new PessoaHasCategoria();
		pessoaHasCategoria.setId(new PessoaHasCategoriaId());
		return pessoaHasCategoria;
	}

	public void wire() {
		getInstance();
		Categoria categoria = categoriaHome.getDefinedInstance();
		if (categoria != null) {
			getInstance().setCategoria(categoria);
		}
		Pessoa pessoa = pessoaHome.getDefinedInstance();
		if (pessoa != null) {
			getInstance().setPessoa(pessoa);
		}
	}

	public boolean isWired() {
		if (getInstance().getCategoria() == null)
			return false;
		if (getInstance().getPessoa() == null)
			return false;
		return true;
	}

	public PessoaHasCategoria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
