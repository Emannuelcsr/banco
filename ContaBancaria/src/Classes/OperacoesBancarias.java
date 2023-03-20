package Classes;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class OperacoesBancarias {

	List<DadosBancarios> novoCliente = new ArrayList<DadosBancarios>();	
	
	public void menu() {		
		
		double valor =0.0;
		boolean sair = false;
		while(!sair) {
		
		String[]opcoes = {"Realizar novo cadastro","Ver Saldo","Depositar","Sacar","Transferir","Sair"};	
		
		int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
		
		double novoSaldo = 0.0;	
		switch(escolha) {
		
		case 0:
			DadosBancarios Cliente = new DadosBancarios();
			
						
			String titular = JOptionPane.showInputDialog("Nome: ");
			double saldo = Double.parseDouble(JOptionPane.showInputDialog("Saldo: "));
			int  numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));		
			
			for (DadosBancarios cliente :novoCliente) {
			    if (cliente.getNumeroConta() == numeroConta) {
			    	JOptionPane.showMessageDialog(null, "Numero da conta ja preenchida para outro cliente!");
			    	menu();
			    }	
				}		
					Cliente.setTitular(titular);
					Cliente.setSaldo(saldo);
					Cliente.setNumeroConta(numeroConta);
			
			novoCliente.add(Cliente);	
		break;
		case 1:
			String nomeClienteSaldo = JOptionPane.showInputDialog("Nome:");
			int intClienteConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));			
			
			for (DadosBancarios cliente : novoCliente) {				
				if(cliente.getTitular().equalsIgnoreCase(nomeClienteSaldo) && cliente.getNumeroConta() == intClienteConta) {
				JOptionPane.showMessageDialog(null, "Saldo: "+cliente.getSaldo());
			}		
			}
			break;
		
		case 2:			
			nomeClienteSaldo = JOptionPane.showInputDialog("Nome:");
			intClienteConta= Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));
			
			for (DadosBancarios cliente : novoCliente) {			
				if(cliente.getTitular().equalsIgnoreCase(nomeClienteSaldo) && cliente.getNumeroConta() == intClienteConta) {	
				double deposito = Double.parseDouble(JOptionPane.showInputDialog("Valor do depósito: "));					
					novoSaldo=deposito+cliente.getSaldo();
					cliente.setSaldo(novoSaldo);									
			}	
			}
			break;
		case 3:
			nomeClienteSaldo = JOptionPane.showInputDialog("Nome:");
			intClienteConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));
			for(DadosBancarios cliente : novoCliente) {
				if(cliente.getTitular().equalsIgnoreCase(nomeClienteSaldo) && cliente.getNumeroConta() == intClienteConta) {
				double sacar = Double.parseDouble(JOptionPane.showInputDialog("Valor do Saque:"));
				if(sacar<=cliente.getSaldo()) {
					JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
					novoSaldo=cliente.getSaldo()-sacar;	
					cliente.setSaldo(novoSaldo);
				}else {
					JOptionPane.showMessageDialog(null, "Valor maximo possivel de saque: R$"+cliente.getSaldo());					
				}								
			}	
			}
			break;			
		/*
		case 4:
			valor =0.0;
			nomeClienteSaldo = JOptionPane.showInputDialog("Nome:");
			intClienteConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));	
			
			for(DadosBancarios cliente: novoCliente) {
				if(cliente.getTitular().equalsIgnoreCase(nomeClienteSaldo) && cliente.getNumeroConta() == intClienteConta) {

				String nomeClienteTransferencia = JOptionPane.showInputDialog("Nome de quem vai receber: ");
				int contaClienteTranferencia = Integer.parseInt(JOptionPane.showInputDialog("Conta de quem vai receber: "));
				for(DadosBancarios clienteDestino: novoCliente) {
					
				
				if(cliente.getTitular().equalsIgnoreCase(nomeClienteTransferencia) && cliente.getNumeroConta()==contaClienteTranferencia) {
					valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia:"));
					int continuar = JOptionPane.showConfirmDialog(null, "Deseja realmente trasnferir R$"+valor+ " para "+nomeClienteTransferencia+ "?");
					if(continuar == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Tranferencia realizada com sucesso");
					}
				}
				}
				novoSaldo= cliente.getSaldo()- valor;
				cliente.setSaldo(novoSaldo);				
			}	
			}
		break;
		*/
		case 4:
		    nomeClienteSaldo = JOptionPane.showInputDialog("Nome:");
		    intClienteConta = Integer.parseInt(JOptionPane.showInputDialog("Numero da conta: "));    
		    
		    for(DadosBancarios cliente: novoCliente) {
		        if(cliente.getTitular().equalsIgnoreCase(nomeClienteSaldo) && cliente.getNumeroConta() == intClienteConta) {
		            String nomeClienteTransferencia = JOptionPane.showInputDialog("Nome de quem vai receber: ");
		            int contaClienteTranferencia = Integer.parseInt(JOptionPane.showInputDialog("Conta de quem vai receber: "));
		            
		            for(DadosBancarios clienteDestino: novoCliente) {
		                if(clienteDestino.getTitular().equalsIgnoreCase(nomeClienteTransferencia) && clienteDestino.getNumeroConta() == contaClienteTranferencia) {
		                    valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferencia:"));
		                    int continuar = JOptionPane.showConfirmDialog(null, "Deseja realmente transferir R$"+valor+ " para "+nomeClienteTransferencia+ "?");
		                    if(continuar == JOptionPane.YES_OPTION) {
		                        novoSaldo = cliente.getSaldo()- valor;
		                        cliente.setSaldo(novoSaldo);
		                        double novoSaldoDestino= clienteDestino.getSaldo()+ valor;
		                        clienteDestino.setSaldo(novoSaldoDestino);
		                        JOptionPane.showMessageDialog(null, "Transferencia realizada com sucesso");
		                    }
		                }
		            }
		        }                   
		    }
		break;
		case 5:
			JOptionPane.showMessageDialog(null, "FIM");
			sair=true;		
}
}
}
}

