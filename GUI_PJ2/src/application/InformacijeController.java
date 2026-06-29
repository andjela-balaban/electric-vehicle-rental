package application;

import java.net.URL;
import java.util.ResourceBundle;
import org.unibl.etf.prevoznasredstva.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
//import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;

public class InformacijeController implements Initializable {

	@FXML
	ListView<ElektricniAutomobil> listViewAuta;
	@FXML
	ListView<ElektricniBicikl> listViewBicikla;
	@FXML
	ListView<ElektricniTrotinet> listViewTrotineti;
	@FXML
	TextArea infoVozilo;
	
	static PrevoznoSredstvo trenutnoVozilo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Thread tRedVozila = new Thread(() -> {
			Platform.runLater(() -> {
				infoVozilo.setText(trenutnoVozilo.toString());
			});
			try {
				Thread.sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

			
		});
		tRedVozila.setDaemon(true);
		tRedVozila.start();
	}

}
