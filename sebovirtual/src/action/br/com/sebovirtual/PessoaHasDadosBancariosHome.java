package br.com.sebovirtual;

import br.com.sebovirtual.model.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("pessoaHasDadosBancariosHome")
public class PessoaHasDadosBancariosHome
		extends
			EntityHome<PessoaHasDadosBancarios> {

	@In(create = true)
	DadosBancariosHome dadosBancariosHome;
	@In(create = true)
	PessoaHome pessoaHome;

	public void setPessoaHasDadosBancariosId(PessoaHasDadosBancariosId id) {
		setId(id);
	}

	public PessoaHasDadosBancariosId getPessoaHasDadosBancariosId() {
		return (PessoaHasDadosBancariosId) getId();
	}

	public PessoaHasDadosBancariosHome() {
		setPessoaHasDadosBancariosId(new PessoaHasDadosBancariosId());
	}

	@Override
	public boolean isIdDefined() {
		if (getPessoaHasDadosBancariosId().getDadosBancariosIdDadosBancarios() == 0)
			return false;
		if (getPessoaHasDadosBancariosId().getPessoaCpf() == 0)
			return false;

		return true;
	}

	@Override
	protected PessoaHasDadosBancarios createInstance() {
		PessoaHasDadosBancarios pessoaHasDadosBancarios = new PessoaHasDadosBancarios();
		pessoaHasDadosBancarios.setId(new PessoaHasDadosBancariosId());
		return pessoaHasDadosBancarios;
	}

	public void wire() {
		getInstance();
		DadosBancarios dadosBancarios = dadosBancariosHome.getDefinedInstance();
		if (dadosBancarios != null) {
			getInstance().setDadosBancarios(dadosBancarios);
		}
		Pessoa pessoa = pessoaHome.getDefinedInstance();
		if (pessoa != null) {
			getInstance().setPessoa(pessoa);
		}
	}

	public boolean isWired() {
		if (getInstance().getDadosBancarios() == null)
			return false;
		if (getInstance().getPessoa() == null)
			return false;
		return true;
	}

	public PessoaHasDadosBancarios getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
