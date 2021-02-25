package application;

import javafx.scene.image.Image;

public abstract class Pokemon {
	private int pokemonID;
	private String pokemonAdi;
	private String pokemonTip; 
	private Image image;
	private Image image_secili;
	public Pokemon(int pokemonID, String pokemonAdi, String pokemonTip,String image,String image_secili) {
		this.setImage(new Image(image));
		this.setImage_secili(new Image(image_secili));
		this.pokemonID = pokemonID;
		this.pokemonAdi = pokemonAdi;
		this.pokemonTip = pokemonTip;
	}
	public int getPokemonID() {
		return pokemonID;
	}
	public void setPokemonID(int pokemonID) {
		this.pokemonID = pokemonID;
	}
	public String getPokemonAdi() {
		return pokemonAdi;
	}
	public void setPokemonAdi(String pokemonAdi) {
		this.pokemonAdi = pokemonAdi;
	}
	public String getPokemonTip() {
		return pokemonTip;
	}
	public void setPokemonTip(String pokemonTip) {
		this.pokemonTip = pokemonTip;
	}
	
	public abstract int hasarPuaniGoster();
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Image getImage_secili() {
		return image_secili;
	}
	public void setImage_secili(Image image_secili) {
		this.image_secili = image_secili;
	}

}