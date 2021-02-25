package Pokemons;

import application.Pokemon;

public class Squirtle extends Pokemon {
	private int hasarPuani;
 
	public Squirtle(int pokemonID, String pokemonAdi, String pokemonTip,int hasarPuani) {
		super(pokemonID, pokemonAdi, pokemonTip,"/Icons/Squirtle.jpg","/Icons/Squirtle_secili.jpg");
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
