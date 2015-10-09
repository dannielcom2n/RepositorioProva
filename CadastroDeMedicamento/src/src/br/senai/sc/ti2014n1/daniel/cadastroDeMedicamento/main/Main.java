package src.br.senai.sc.ti2014n1.daniel.cadastroDeMedicamento.main;

import src.br.senai.sc.ti2014n1.daniel.cadastroDeMedicamento.dao.Dao;

public class Main {

	public static void main(String[] args) {
		conectar();

	}
	
	
	public static void conectar(){
		
		Dao dao = new Dao();{
			
		};
		dao.getConnection();
		
	}

}
