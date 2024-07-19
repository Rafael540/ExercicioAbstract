package entities;

public class PessoaJuridica extends Cliente {

	private Double numeroFuncionarios;
	
	
	public PessoaJuridica() {
		super();
	}
	

	public PessoaJuridica(String nome, Double rendaAnual, Double numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}



	public Double getNumeroFuncionarios() {
		return numeroFuncionarios;
	}



	public void setNumeroFuncionarios(Double numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}



	@Override
	public double imposto() {
		if(getNumeroFuncionarios()  > 10) {
			return getRendaAnual() * 0.14;
		}else {
			return getRendaAnual() * 0.16;
		}
	
	}
	
	
	
	
}
