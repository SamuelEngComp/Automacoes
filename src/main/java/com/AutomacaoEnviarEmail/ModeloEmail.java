package com.AutomacaoEnviarEmail;

public class ModeloEmail {

	public static void main(String[] args) {
		EnviarEmail teste = new EnviarEmail();
		teste.setDestino("samuellima810@gmail.com", "samuellima810@gmail.com", "Teste de email", "Esta mensagem eh um teste");
		teste.run();
	}
}
