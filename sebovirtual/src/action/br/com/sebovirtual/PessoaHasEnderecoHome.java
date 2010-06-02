package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("pessoaHasEnderecoHome")
public class PessoaHasEnderecoHome extends EntityHome<PessoaHasEndereco> {

	@In(create = true)
	EnderecoHome enderecoHome;
	@In(create = true)
	PessoaHome pessoaHome;

	public void setPessoaHasEnderecoId(PessoaHasEnderecoId id) {
		setId(id);
	}

	public PessoaHasEnderecoId getPessoaHasEnderecoId() {
		return (PessoaHasEnderecoId) getId();
	}

	public PessoaHasEnderecoHome() {
		setPessoaHasEnderecoId(new PessoaHasEnderecoId());
	}

	@Override
	public boolean isIdDefined() {
		if (getPessoaHasEnderecoId().getEnderecoIdEndereco() == 0)
			return false;
		if (getPessoaHasEnderecoId().getPessoaCpf() == 0)
			return false;

		return true;
	}

	@Override
	protected PessoaHasEndereco createInstance() {
		PessoaHasEndereco pessoaHasEndereco = new PessoaHasEndereco();
		pessoaHasEndereco.setId(new PessoaHasEnderecoId());
		return pessoaHasEndereco;
	}

	public void wire() {
		getInstance();
		Endereco endereco = enderecoHome.getDefinedInstance();
		if (endereco != null) {
			getInstance().setEndereco(endereco);
		}
		Pessoa pessoa = pessoaHome.getDefinedInstance();
		if (pessoa != null) {
			getInstance().setPessoa(pessoa);
		}
	}

	public boolean isWired() {
		if (getInstance().getEndereco() == null)
			return false;
		if (getInstance().getPessoa() == null)
			return false;
		return true;
	}

	public PessoaHasEndereco getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
