package Pokemons;

import application.Pokemon;

public class Pikachu extends Pokemon {
	private int hasarPuani;

	public Pikachu(int pokemonID, String pokemonAdi, String pokemonTip,int hasarPuani) {
		super(pokemonID, pokemonAdi, pokemonTip,"/Icons/Pikachu.jpg","/Icons/Pikachu_secili.jpg");
		this.hasarPuani=hasarPuani;
		// TODO Auto-generated constructor stub
	}
	
	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}

	public boolean kartKullanildiMi() {
		return false;
		
	}
	@Override
	public int hasarPuaniGoster() {
		return this.hasarPuani;
	}
}
