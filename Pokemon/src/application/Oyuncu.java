package application;

import java.util.ArrayList;
import java.util.List;

public abstract class Oyuncu {
	private int oyuncuID;
	private String oyuncuAdi;
	private int skor;
	private List<Pokemon> oynananPokemonlar = new ArrayList<Pokemon>();
	private Pokemon SeciliPokemon;
        private String kartListesi;
       protected int secim=-1;
	public Oyuncu(int oyuncuID, String oyuncuAdi, int skor,String kartListesi) {
		this.oyuncuID = oyuncuID;
		this.oyuncuAdi = oyuncuAdi;
		this.skor = skor;
                this.kartListesi=kartListesi;
	}
	public int getOyuncuID() {
		return oyuncuID;
	}
	public void setOyuncuID(int oyuncuID) {
		this.oyuncuID = oyuncuID;
	}
	public String getOyuncuAdi() {
		return oyuncuAdi;
	}
	public void setOyuncuAdi(String oyuncuAdi) {
		this.oyuncuAdi = oyuncuAdi;
	}
	public int getSkor() {
		return skor;
	}
	public void setSkor(int skor) {
		this.skor = skor;
	}
        public String getKartListesi() {
		return kartListesi;
	}
	public void setKartListesi(String kartListesi) {
		this.kartListesi = kartListesi;
	}
	
	public abstract void kartSec();
	
	public void skorGoster() {
		
	}
	public int getSecim() {
		return secim;
	}
	public void SecimRemover() {
		secim = -1;
	}
	public List<Pokemon> getOynananPokemonlar() {
		return oynananPokemonlar;
	}
	public void setOynananPokemonlar(List<Pokemon> oynananPokemonlar) {
		this.oynananPokemonlar = oynananPokemonlar;
	}
	public Pokemon getSeciliPokemon() {
		return SeciliPokemon;
	}
	public void setSeciliPokemon(Pokemon seciliPokemon) {
		SeciliPokemon = seciliPokemon;
	}
	
}
