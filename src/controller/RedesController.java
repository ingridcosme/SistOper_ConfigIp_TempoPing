/*
 * A classe RedesController.java deve ter 3 métodos.
 * 1) O primeiro, chamado os, que identifica e retorna o nome do Sistema Opera_
 * cional (Fazê-lo privado)
 * 2) O segundo, chamado ip, que verifica o Sistema Operacional e, de acordo com
 * o S.O., faz a chamada de configuração de IP.
 * A leitura do processo chamado deve verificar cada linha e, imprimir, apenas, 
 * o nome do adaptador de rede e o IPv4, portanto, adaptadores sem IPv4 não de_
 * vem ser mostrados
 * 3) O terceiro, chamado ping, que verifica o Sistema Operacional e, de acordo 
 * com o S.O., faz a chamada de ping em IPv4 com 10 iterações.
 * A leitura do processo chamado deve verificar as linhas de saída e exibir, ape_
 * nas, o tempo médio do ping.
 * */

package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	private String os() {
		//Retorna o Sistema Operacional que está em execução na máquina
		String os = System.getProperty("os.name");
		return os;
	}
 	
	public void ip() {
		String sistema = os();  //Recebe o sistema em execução
		Process p = null;
		
		if(sistema.contains("Windows")) {  //Se Windows
			try {
				p = Runtime.getRuntime().exec("ipconfig");  //Recebe dados do processo
				
				InputStream fluxo = p.getInputStream();  //Transformando os dados em um fluxo de bits
				InputStreamReader leitor = new InputStreamReader(fluxo);  //Lê o fluxo e converte para string
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();  //Recebe a primeira linha do buffer
				String adaptador = "";  //Recebe a linha com o nome da Rede
							
				while(linha != null) {  //Percorre todo o buffer				
					if(linha.contains("Adaptador")) {
						adaptador = linha;
					} else {
						if(linha.contains("IPv4")) {
							String [] ipv4 = linha.split(":");  //Recebe a linha com o IPv4
							System.out.println(adaptador + ipv4[1]);
						}
					}
					linha = buffer.readLine();
				}	
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch(Exception e) {
				e.printStackTrace();  //Caso ocorra algum erro, vamos mostrá-lo
			}
		
		} else if(sistema.contains("Linux")) {  //Se Linux
			try {
				p = Runtime.getRuntime().exec("ifconfig");  //Recebe dados do processo
				
				InputStream fluxo = p.getInputStream();  //Transformando os dados em um fluxo de bits
				InputStreamReader leitor = new InputStreamReader(fluxo);  //Lê o fluxo e converte para string
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();  //Recebe a primeira linha do buffer  
				String [] adaptador = null;
				
				while(linha != null) {  //Percorre todo o buffer				
					if(linha.contains("flag")) {
						adaptador = linha.split(":");  //Recebe a linha com o nome da Rede
					} else {
						if(linha.contains("inet")) {  
							String [] ipv4 = linha.split(" ");  //Recebe a linha com o IPv4
							System.out.println(adaptador[0] + ipv4[1]);
						}
					}
					linha = buffer.readLine();
				}	
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch(Exception e) {
				e.printStackTrace();  //Caso ocorra algum erro, vamos mostrá-lo
			}
		
		} else {
			System.out.println("Sistema operacional não encontrado");
		}
			
	}
	
	public void ping() {
		String sistema = os();  //Recebe o sistema em execução
		Process p = null;
		
		if(sistema.contains("Windows")) {  //Se Windows
			try {
				p = Runtime.getRuntime().exec("PING -4 -n 10 www.google.com.br");  //Recebe dados do processo
				
				InputStream fluxo = p.getInputStream();  //Transformando os dados em um fluxo de bits
				InputStreamReader leitor = new InputStreamReader(fluxo);  //Lê o fluxo e converte para string
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();  //Recebe a primeira linha do buffer
				String [] tMedio = null;  //Recebe a linha o tempo médio do ping
							
				while(linha != null) {  //Percorre todo o buffer			
					if(linha.contains("dia =")) {
						tMedio = linha.split("=");
						System.out.println(tMedio[3]);
					}
					linha = buffer.readLine();
				}	
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch(Exception e) {
				e.printStackTrace();  //Caso ocorra algum erro, vamos mostrá-lo
			}
		
		} else if(sistema.contains("Linux")) {  //Se Linux
			try {
				p = Runtime.getRuntime().exec("PING -4 -c 10 www.google.com.br");  //Recebe dados do processo
				
				InputStream fluxo = p.getInputStream();  //Transformando os dados em um fluxo de bits
				InputStreamReader leitor = new InputStreamReader(fluxo);  //Lê o fluxo e converte para string
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();  //Recebe a primeira linha do buffer
				String [] tMedio = null;  //Recebe a linha o tempo médio do ping
							
				while(linha != null) {  //Percorre todo o buffer				
					if(linha.contains("avg")) {
						tMedio = linha.split("/");
						System.out.println(tMedio[4]);
					}
					linha = buffer.readLine();
				}	
				
				buffer.close();
				leitor.close();
				fluxo.close();
				
			} catch(Exception e) {
				e.printStackTrace();  //Caso ocorra algum erro, vamos mostrá-lo
			}
		
		} else {
			System.out.println("Sistema operacional não encontrado");
		}
		
	}
	
}
