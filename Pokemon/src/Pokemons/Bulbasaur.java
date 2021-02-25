package Pokemons;

import application.Pokemon;

public class Bulbasaur extends Pokemon {
	private int hasarPuani;

	public Bulbasaur(int pokemonID, String pokemonAdi, String pokemonTip,int hasarPuani) {
		super(pokemonID, pokemonAdi, pokemonTip,"/Icons/Bulbasaur.jpg","/Icons/Bulbasaur_secili.jpg");
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
		// TODO Auto-generated method stub
		return this.hasarPuani;
	}

}

