package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("pessoaHasTelefoneHome")
public class PessoaHasTelefoneHome extends EntityHome<PessoaHasTelefone> {

	@In(create = true)
	PessoaHome pessoaHome;
	@In(create = true)
	TelefoneHome telefoneHome;

	public void setPessoaHasTelefoneId(PessoaHasTelefoneId id) {
		setId(id);
	}

	public PessoaHasTelefoneId getPessoaHasTelefoneId() {
		return (PessoaHasTelefoneId) getId();
	}

	public PessoaHasTelefoneHome() {
		setPessoaHasTelefoneId(new PessoaHasTelefoneId());
	}

	@Override
	public boolean isIdDefined() {
		if (getPessoaHasTelefoneId().getPessoaCpf() == 0)
			return false;
		if (getPessoaHasTelefoneId().getTelefoneIdTelefone() == 0)
			return false;

		return true;
	}

	@Override
	protected PessoaHasTelefone createInstance() {
		PessoaHasTelefone pessoaHasTelefone = new PessoaHasTelefone();
		pessoaHasTelefone.setId(new PessoaHasTelefoneId());
		return pessoaHasTelefone;
	}

	public void wire() {
		getInstance();
		Pessoa pessoa = pessoaHome.getDefinedInstance();
		if (pessoa != null) {
			getInstance().setPessoa(pessoa);
		}
		Telefone telefone = telefoneHome.getDefinedInstance();
		if (telefone != null) {
			getInstance().setTelefone(telefone);
		}
	}

	public boolean isWired() {
		if (getInstance().getPessoa() == null)
			return false;
		if (getInstance().getTelefone() == null)
			return false;
		return true;
	}

	public PessoaHasTelefone getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
