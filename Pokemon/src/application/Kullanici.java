package application;

public class Kullanici extends Oyuncu {

    public Kullanici(int oyuncuID, String oyuncuAdi, int skor, String kartListesi) {
        super(oyuncuID, oyuncuAdi, skor, kartListesi);
    }
    
	@Override
	public void kartSec() {
		super.setSeciliPokemon(getOynananPokemonlar().get(super.secim));
	
	}
	public void setSecim(int secim) {
		super.secim = secim;
	}
}
