package Classes;

public class DadosBancarios {
	
	private String titular;
	private double saldo;
	private double limite;
	private int numeroConta;
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public String toString() {
		return "DadosBancarios [titular=" + titular + ", saldo=" + saldo + ", limite=" + limite + ", numeroConta="
				+ numeroConta + "]";
	}
	
	public DadosBancarios(String nome, double salario,double lim,int conta) {
		this.titular=nome;
		this.saldo=salario;
		this.limite=lim;
		this.numeroConta=conta;		
	}
	
	
	
	public DadosBancarios(double novoSaldo) {
		this.saldo=novoSaldo;		
	}
	
	public DadosBancarios() {
		// TODO Auto-generated constructor stub
	}
	public double SaldoAtual() {			
		return saldo;		
	}
	
	

}
