/*
 * A Classe Main.java deve dar as op��es de chamadas do m�todo ip ou do m�todo 
 * ping com JOptionPane e, dependendo da escolha, instanciar a Classe 
 * RedesController.java e chamar o m�todo escolhido. A op��o de finalizar a apli_
 * ca��o tamb�m deve estar dispon�vel.
 * */

package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redes = new RedesController();
		
		int opc=0;
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog("Qual m�todo voc�"
            		+ " gostaria de chamar?"
                    + "\n------------------------------------------------------"
                    + "\n1 - M�todo IP"
                    + "\n2 - M�todo PING"
                    + "\n9 - Finalizar a aplica��o"));
            switch(opc){
                case 1: System.out.print("\n\nRedes com endere�o IPv4:\n");
                		redes.ip();
                        break;
                case 2: System.out.print("\n\nTempo m�dio de ping � igual a ");
                		redes.ping();
                        break;
                case 9: System.out.print("\n\nAplica��o Finalizada!");
                        break;
                default: JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        }
        while(opc != 9);
		
		

	}

}
