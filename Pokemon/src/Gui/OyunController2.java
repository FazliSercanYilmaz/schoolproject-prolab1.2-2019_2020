package Gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import Pokemons.*;
import application.Bilgisayar;
import application.Kullanici;
import application.Main;
import application.Oyuncu;
import application.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
public class OyunController2 implements Initializable {
	
	List<Oyuncu> oyuncular;
	List<Pokemon> pokemonlar;
	int [] kullanilmis_Kartlar = new int[] {0,0,0};
	static int bitis=2;
	ImageView[] player1_foto;
	ImageView[] player2_foto;
    @FXML
    private Label oyun_bitti;
	@FXML
    private Button baslat;
 
    @FXML
    private ImageView player1_2;

    @FXML
    private ImageView player1_3;

    @FXML
    private ImageView player1_1;

    @FXML
    private ImageView player2_3;

    @FXML
    private ImageView player2_2;

    @FXML
    private ImageView player2_1;

    @FXML
    private ImageView player2_V;

    @FXML
    private ImageView player1_V;
    @FXML
    private ImageView kart_koyulanYer;

    @FXML
    private Label Kart_sayisi;

    @FXML
    private Button Computer_KartSec;

    @FXML
    private Label kazanan;

    @FXML
    private Label skorlar;

    @FXML
    private Label player_2;

    @FXML
    private Label player_1;
    @FXML
    private Label skorlar2;
    @FXML
    void Computer_KartSec(ActionEvent event) {
     	((Bilgisayar)oyuncular.get(0)).kartSec();
    	player1_V.setImage(oyuncular.get(0).getSeciliPokemon().getImage());
    	player1_foto[oyuncular.get(0).getSecim()].setImage(null);
    	baslat.setVisible(true);
    	kart_koyulanYer.setVisible(false);
    	Computer_KartSec.setVisible(false);
    	player2_V.setImage(null);
    }
    

    @FXML
    void oyunubaslat(ActionEvent event) {
    	oyuncular.get(1).kartSec();
    	player2_V.setImage(oyuncular.get(1).getSeciliPokemon().getImage());
    	 oyuncular.get(0).getOynananPokemonlar().remove(oyuncular.get(0).getSecim());
    	  	oyuncular.get(1).getOynananPokemonlar().remove(oyuncular.get(1).getSecim());
    	  	 skortablosu();
   	if(Main.Oyunmodu == 1) {
   		Computer_KartSec.setVisible(true);
   	}
   	baslat.setVisible(false);
    	PhotoRemoverPlayer1();
    	PhotoRemoverPlayer2();
    	oyuncular.get(0).SecimRemover();
    	if(oyuncular.get(0).getOynananPokemonlar().size()==0) {
    		oyun_bitti.setVisible(true);
    		if(oyuncular.get(0).getSkor()>oyuncular.get(1).getSkor())
    			oyun_bitti.setText("Oyun Bitti.. \n Kazanan: "+oyuncular.get(0).getOyuncuAdi());
    			if(oyuncular.get(0).getSkor()<oyuncular.get(1).getSkor())
    				oyun_bitti.setText("Oyun Bitti.. \n Kazanan: "+oyuncular.get(1).getOyuncuAdi());
    				if(oyuncular.get(0).getSkor()==oyuncular.get(1).getSkor())
    					oyun_bitti.setText("Oyun Bitti.. \n Berabere");
    	}
    }

    @FXML
    void player1_1Clicked(MouseEvent event) {
    	if(Main.Oyunmodu==2 ) {
    		player2_V.setImage(null);
    		((Kullanici)oyuncular.get(0)).setSecim(0);
    		ClickedIllusion(0);
    		kart_koyulanYer.setVisible(true);
    	}
    }

    @FXML
    void player1_2Clicked(MouseEvent event) {
    	if(Main.Oyunmodu==2) {
    		player2_V.setImage(null);
    		((Kullanici)oyuncular.get(0)).setSecim(1);
    		ClickedIllusion(1);
    		kart_koyulanYer.setVisible(true);
    	}
    }

    @FXML
    void player1_3Clicked(MouseEvent event) {
    	if(Main.Oyunmodu==2) {
    		player2_V.setImage(null);
    		((Kullanici)oyuncular.get(0)).setSecim(2);
    		ClickedIllusion(2);
    		kart_koyulanYer.setVisible(true);
    	}
    }
    @FXML
    void Kartkoy(MouseEvent event) {
 	    if(Main.Oyunmodu==2) {
 		   (oyuncular.get(0)).kartSec();
 		   player1_V.setImage(((Pokemon)oyuncular.get(0).getSeciliPokemon()).getImage());
 		  player1_foto[oyuncular.get(0).getSecim()].setImage(null);
 		   baslat.setVisible(true);
 		  kart_koyulanYer.setVisible(false);
 	   }
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		player1_foto = new ImageView[3];
		player2_foto = new ImageView[3];
		player1_foto[0]=player1_1;
		player1_foto[1]=player1_2;
		player1_foto[2]=player1_3;
		player2_foto[0]=player2_1;
		player2_foto[1]=player2_2;
		player2_foto[2]=player2_3;
		oyuncular = Main.oyuncular;
		pokemonlar = Main.pokemonlar;
		photoChooser();
		skorlar.setText(oyuncular.get(0).getOyuncuAdi()+"\n skoru : "+oyuncular.get(0).getSkor());
	   	skorlar2.setText(oyuncular.get(1).getOyuncuAdi()+"\n skoru : "+oyuncular.get(1).getSkor());
		player_1.setText(oyuncular.get(0).getOyuncuAdi());
		player_2.setText(oyuncular.get(1).getOyuncuAdi());
		Kart_sayisi.setText( "Toplam Kart sayisi" +0);
		if(Main.Oyunmodu==1) {
			Computer_KartSec.setVisible(true);
		}
	}
	public void photoChooser() {
	 	player1_1.setImage(oyuncular.get(0).getOynananPokemonlar().get(0).getImage());
    	player1_2.setImage(oyuncular.get(0).getOynananPokemonlar().get(1).getImage());
    	player1_3.setImage(oyuncular.get(0).getOynananPokemonlar().get(2).getImage());
    	player2_1.setImage(oyuncular.get(1).getOynananPokemonlar().get(0).getImage());
    	player2_2.setImage(oyuncular.get(1).getOynananPokemonlar().get(1).getImage());
    	player2_3.setImage(oyuncular.get(1).getOynananPokemonlar().get(2).getImage());
    }
	public void ClickedIllusion(int secim) {
		player1_V.setImage(null);
	if(secim==0) {
		
		player1_1.setImage(oyuncular.get(0).getOynananPokemonlar().get(0).getImage_secili());
		for(int i =0;i<oyuncular.get(0).getOynananPokemonlar().size();i++) {
			if(i==0)continue;
			player1_foto[i].setImage(oyuncular.get(0).getOynananPokemonlar().get(i).getImage());
		}
	}
	
	else if(secim==1) {
		
		player1_2.setImage(oyuncular.get(0).getOynananPokemonlar().get(1).getImage_secili());
		for(int i =0;i<oyuncular.get(0).getOynananPokemonlar().size();i++) {
			if(i==1)continue;
			player1_foto[i].setImage(oyuncular.get(0).getOynananPokemonlar().get(i).getImage());
		}
	}
	else if(secim==2) {
		player1_3.setImage(oyuncular.get(0).getOynananPokemonlar().get(2).getImage_secili());
		for(int i =0;i<oyuncular.get(0).getOynananPokemonlar().size();i++) {
			if(i==2)continue;
			player1_foto[i].setImage(oyuncular.get(0).getOynananPokemonlar().get(i).getImage());
		}
	}
	baslat.setVisible(false);
	}
	public void PhotoRemoverPlayer1() {
		for(int i=0;i<oyuncular.get(0).getOynananPokemonlar().size();i++) {
			player1_foto[i].setImage(oyuncular.get(0).getOynananPokemonlar().get(i).getImage());
		}
		player1_foto[oyuncular.get(0).getOynananPokemonlar().size()].setVisible(false);
	}
	public void PhotoRemoverPlayer2() {
		for(int i=0;i<oyuncular.get(1).getOynananPokemonlar().size();i++) {
			player2_foto[i].setImage(oyuncular.get(1).getOynananPokemonlar().get(i).getImage());
		}
		player2_foto[oyuncular.get(1).getOynananPokemonlar().size()].setVisible(false);
	}
	public void skortablosu() {
		if(oyuncular.get(0).getSeciliPokemon().hasarPuaniGoster()>oyuncular.get(1).getSeciliPokemon().hasarPuaniGoster()) {
	   		kazanan.setText("Raund'i kazanan  :"+ oyuncular.get(0).getOyuncuAdi());
	   		oyuncular.get(0).setSkor((oyuncular.get(0).getSkor())+5);
	   	}
	   	else if(oyuncular.get(1).getSeciliPokemon().hasarPuaniGoster()>oyuncular.get(0).getSeciliPokemon().hasarPuaniGoster()) {
	   		kazanan.setText("Raund'i kazanan  :"+oyuncular.get(1).getOyuncuAdi());
	   		oyuncular.get(1).setSkor((oyuncular.get(1).getSkor())+5);
	   	}
	   	else {
	   		kazanan.setText("Raund'i kazanan : esit");
	   	}
	   	skorlar.setText(oyuncular.get(0).getOyuncuAdi()+"\n skoru : "+oyuncular.get(0).getSkor());
	   	skorlar2.setText(oyuncular.get(1).getOyuncuAdi()+"\n skoru : "+oyuncular.get(1).getSkor());
	}
}