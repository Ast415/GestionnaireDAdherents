package com.btssio.projet1.classe;

public class Program {
	public static void main(String[]args) {
		Adherent Adh1 = new Adherent(
				"BORIES",
				"Bastien",
				"Homme",
				"29/01/2002",
				"Castres",
				"Bastien",
				"Toulouse",
				"118 route de narbone",
				31400,
				"Fr",
				"0781878897",
				"0000000000",
				"Epee",
				"Escrime",
				"Droitier");
		System.out.println(Adh1.getCp());
		Adh1.SePresenter();
	}

}
