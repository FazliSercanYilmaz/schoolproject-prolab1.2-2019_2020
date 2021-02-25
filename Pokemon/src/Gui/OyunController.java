package Gui;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
public class OyunController implements Initializable {
	List<Oyuncu> oyuncular;
	List<Pokemon> pokemonlar;
	@FXML
    private Button baslat;
	@FXML
    private ImageView kart_koyulanYer;
	 @FXML
	    private Label koruma;
	 ImageView[] player1_foto;
		ImageView[] player2_foto;
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
    private Button Kart_Dagit;


    @FXML
    private Label Kart_sayisi;

    @FXML
    private Button Computer_KartSec;

    @FXML
    private Label kazanan;

    @FXML
    private Button kart_Cek;

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
    }

    @FXML
    void KartDagit(ActionEvent event) {
    	int temp;
    	for(int j=0;j<2;j++) {
    for(int i=0;i<3;i++) {
    	temp =getRandomNumberInts(0,pokemonlar.size()-1);
    	oyuncular.get(j).getOynananPokemonlar().add(pokemonlar.get(temp));
    	pokemonlar.remove(temp);
    	
    }}
    	if(Main.Oyunmodu==1) {
    		Computer_KartSec.setVisible(true);
    	}
    	photoChooser();
    	Kart_Dagit.setVisible(false);
    	Kart_sayisi.setText( "Toplam Kart sayisi" + pokemonlar.size());
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

    @FXML
    void kartCek(ActionEvent event) throws IOException {
    	int temp;
    	for(int j=0;j<2;j++) {
    	temp =getRandomNumberInts(0,pokemonlar.size()-1);
    	oyuncular.get(j).getOynananPokemonlar().add(pokemonlar.get(temp));
    	pokemonlar.remove(temp);
    	koruma.setVisible(false);
    	player1_V.setImage(null);
    	player2_V.setImage(null);
    	if(Main.Oyunmodu ==1) {
    		Computer_KartSec.setVisible(true);
    	}
    	kart_koyulanYer.setVisible(true);
    }
    photoChooser();
    Kart_sayisi.setText( "Toplam Kart sayisi" + pokemonlar.size());
    if(Main.Oyunmodu==1) {
    	Computer_KartSec.setVisible(true);
    	}
    kart_Cek.setVisible(false);
    if(pokemonlar.size()==0) {
    Parent yeni = FXMLLoader.load(getClass().getResource("Oyun2.fxml"));
	Scene yeniOyun = new Scene(yeni);
		Stage  window = (Stage)(((Node) event.getSource()).getScene().getWindow());
		window.setScene(yeniOyun);
		window.show();}
    }

    @FXML
    void oyunubaslat(ActionEvent event) {
    	koruma.setVisible(true);
    	oyuncular.get(1).kartSec();
    	player2_V.setImage(oyuncular.get(1).getSeciliPokemon().getImage()) ;
   	  	player2_foto[oyuncular.get(1).getSecim()].setImage(null);
  	 oyuncular.get(0).getOynananPokemonlar().remove(oyuncular.get(0).getSecim());
  	oyuncular.get(1).getOynananPokemonlar().remove(oyuncular.get(1).getSecim());
	   skortablosu();
   	kart_Cek.setVisible(true);
   	baslat.setVisible(false);
    }

    @FXML
    void player1_1Clicked(MouseEvent event) {
    	if(Main.Oyunmodu==2) {
    		((Kullanici)oyuncular.get(0)).setSecim(0);
    		ClickedIllusion(0);
    		kart_koyulanYer.setVisible(true);
    	}
    }

    @FXML
    void player1_2Clicked(MouseEvent event) {
    	if(Main.Oyunmodu==2) {
    		((Kullanici)oyuncular.get(0)).setSecim(1);
    		ClickedIllusion(1);
    		kart_koyulanYer.setVisible(true);
    	}
    }

    @FXML
    void player1_3Clicked(MouseEvent event) {
    	if(Main.Oyunmodu==2) {
    		((Kullanici)oyuncular.get(0)).setSecim(2);
    		ClickedIllusion(2);
    		kart_koyulanYer.setVisible(true);
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		oyuncular = Main.oyuncular;
		pokemonlar = Main.pokemonlar;
		kartBuilder(); 
		if(Main.Oyunmodu==1) {
			oyuncular.add(new Bilgisayar(0, "Bilgisayar-1", 0, "ozel"));
			oyuncular.add(new Bilgisayar(0, "Bilgisayar-2", 0, "ozel2"));
		
		}
		else if(Main.Oyunmodu==2) {
			oyuncular.add(new Kullanici(1, "Kullanici", 0, "ozel"));
			oyuncular.add(new Bilgisayar(0, "Bilgisayar", 0, "ozel2"));
		}
		Kart_sayisi.setText( "Toplam Kart sayisi" + pokemonlar.size());
		player_1.setText(oyuncular.get(0).getOyuncuAdi());
		player_2.setText(oyuncular.get(1).getOyuncuAdi());
		player1_foto = new ImageView[3];
		player2_foto = new ImageView[3];
		player1_foto[0]=player1_1;
		player1_foto[1]=player1_2;
		player1_foto[2]=player1_3;
		player2_foto[0]=player2_1;
		player2_foto[1]=player2_2;
		player2_foto[2]=player2_3;
	}
	public void kartBuilder() {
		pokemonlar.add(new Pikachu(0, "Pikachu", "Elektrik", 40));
		pokemonlar.add(new Bulbasaur(1, "Bulbasaur", "Cim", 50));
		pokemonlar.add(new Charmander(2, "Charmander", "Ates", 60));
		pokemonlar.add(new Squirtle(3, "Squirtle", "Su", 30));
		pokemonlar.add(new Zubat(4, "Zubat", "Hava", 50));
		pokemonlar.add(new Snorlax(6, "Snorlax", "Normal", 30));
		pokemonlar.add(new Butterfree(7, "Butterfree", "Hava", 10));
		pokemonlar.add(new Psyduck(5, "Psyduck", "Su", 20));
		pokemonlar.add(new Jigglypuff(8, "Jigglypuff", "Ses", 70));
		pokemonlar.add(new Meowth(9, "Meowth", "Normal", 40));
		
	}
	public int getRandomNumberInts(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }
	public void photoChooser() {
    		for(int i=0;i<3;i++) {
    			player1_foto[i].setImage(oyuncular.get(0).getOynananPokemonlar().get(i).getImage());
    			player2_foto[i].setImage(oyuncular.get(1).getOynananPokemonlar().get(i).getImage());
    		}
    }
	public void ClickedIllusion(int secim) {
			player1_1.setVisible(true);
			player1_2.setVisible(true);
			player1_3.setVisible(true);
			player1_V.setImage(null);
		if(secim==0) {
			
			player1_1.setImage(oyuncular.get(0).getOynananPokemonlar().get(0).getImage_secili());
			player1_2.setImage(oyuncular.get(0).getOynananPokemonlar().get(1).getImage());
			player1_3.setImage(oyuncular.get(0).getOynananPokemonlar().get(2).getImage());
		}
		
		else if(secim==1) {
			
			player1_2.setImage(oyuncular.get(0).getOynananPokemonlar().get(1).getImage_secili());
			player1_1.setImage(oyuncular.get(0).getOynananPokemonlar().get(0).getImage());
			player1_3.setImage(oyuncular.get(0).getOynananPokemonlar().get(2).getImage());
		}
		else if(secim==2) {
			player1_3.setImage(oyuncular.get(0).getOynananPokemonlar().get(2).getImage_secili());
			player1_1.setImage(oyuncular.get(0).getOynananPokemonlar().get(0).getImage());
			player1_2.setImage(oyuncular.get(0).getOynananPokemonlar().get(1).getImage());
		}
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