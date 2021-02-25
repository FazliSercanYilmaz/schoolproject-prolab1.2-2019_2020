package Pokemons;

import application.Pokemon;

public class Jigglypuff extends Pokemon {
	private int hasarPuani;

	public Jigglypuff(int pokemonID, String pokemonAdi, String pokemonTip,int hasarPuani) {
		super(pokemonID, pokemonAdi, pokemonTip,"/Icons/Jigglypuff.jpg","/Icons/Jigglypuff_secili.jpg");
		this.hasarPuani=hasarPuani;
		// TODO Auto-generated constructor stub
	}
	
	public int getHasarPuani() {
		return hasarPuani;
	}

	public void setHasarPuani(int hasarPuani) {
		this.hasarPuani = hasarPuani;
	}
	@Override
	public int hasarPuaniGoster() {
		return this.hasarPuani;
	}
	public boolean kartKullanildiMi() {
		return false;
		
	}

}
