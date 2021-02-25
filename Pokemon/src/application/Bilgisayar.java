package application;

import java.util.Random;

public class Bilgisayar extends Oyuncu {

    public Bilgisayar(int oyuncuID, String oyuncuAdi, int skor, String kartListesi) {
        super(oyuncuID, oyuncuAdi, skor, kartListesi);
    }

	@Override
	public void kartSec() {
	    setSecim();
            super.setSeciliPokemon(getOynananPokemonlar().get(super.secim));
	}
	private void setSecim() {
		super.secim=getRandomNumberInts(0, getOynananPokemonlar().size()-1);
	} 
	 private int getRandomNumberInts(int min, int max){
	        Random random = new Random();
	        return random.ints(min,(max+1)).findFirst().getAsInt();
	    }
}
