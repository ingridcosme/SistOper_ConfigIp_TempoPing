/*
 * A Classe Main.java deve dar as opções de chamadas do método ip ou do método 
 * ping com JOptionPane e, dependendo da escolha, instanciar a Classe 
 * RedesController.java e chamar o método escolhido. A opção de finalizar a apli_
 * cação também deve estar disponível.
 * */

package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redes = new RedesController();
		
		int opc=0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Qual método você"
            		+ " gostaria de chamar?"
                    + "\n------------------------------------------------------"
                    + "\n1 - Método IP"
                    + "\n2 - Método PING"
                    + "\n9 - Finalizar a aplicação"));
            switch(opc){
                case 1: System.out.print("\n\nRedes com endereço IPv4:\n");
                		redes.ip();
                        break;
                case 2: System.out.print("\n\nTempo médio de ping é igual a ");
                		redes.ping();
                        break;
                case 9: System.out.print("\n\nAplicação Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        while(opc != 9);
		
		

	}

}
