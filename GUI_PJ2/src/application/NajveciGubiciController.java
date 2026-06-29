package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import org.unibl.etf.prevoznasredstva.ElektricniAutomobil;
import org.unibl.etf.prevoznasredstva.ElektricniBicikl;
import org.unibl.etf.prevoznasredstva.ElektricniTrotinet;
import org.unibl.etf.prevoznasredstva.PrevoznoSredstvo;
import org.unibl.etf.util.Util;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NajveciGubiciController implements Initializable {
	
	@FXML
	ListView<PrevoznoSredstvo> listView;
	@FXML
	TextArea infoVozilo;
	
	PrevoznoSredstvo trenutnoVozilo;
	
	@FXML
	ImageView slikaVozila;
	private Image slikaAuto;
	private Image slikaBiciklo;
	private Image slikaTrotinet;
	
	{
		try {
			slikaAuto = new Image(new FileInputStream(Util.buildPath("../GUI_PJ2/projektni_slike/AUTO/auto.png")));
			slikaBiciklo = new Image(new FileInputStream(Util.buildPath("../GUI_PJ2/projektni_slike/BICIKL/biciklo.png")));
			slikaTrotinet = new Image(new FileInputStream(Util.buildPath("../GUI_PJ2/projektni_slike/TROTINET/trotinet.png")));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Thread tNajveciGubici = new Thread(() -> {
			
			Platform.runLater(() -> {
				try {
					for(Map.Entry<String, PrevoznoSredstvo> e : IzvrsavacSimulacije.kompanija.deserijalizujNajveceGubitke().entrySet()) {
						if(e.getValue() != null)
							listView.getItems().add(e.getValue());
						
					}
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}	
			});
			
			while(true) {
				Platform.runLater(() -> {
					listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
						
						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							trenutnoVozilo = listView.getSelectionModel().getSelectedItem();
							if(trenutnoVozilo != null && trenutnoVozilo instanceof ElektricniAutomobil) {
								infoVozilo.setText(trenutnoVozilo.voziloInfo());
								slikaVozila.setImage(slikaAuto);
							}
							else if(trenutnoVozilo != null && trenutnoVozilo instanceof ElektricniBicikl) {
								infoVozilo.setText(trenutnoVozilo.voziloInfo());
								slikaVozila.setImage(slikaBiciklo);
							}
							else if(trenutnoVozilo != null && trenutnoVozilo instanceof ElektricniTrotinet) {
								infoVozilo.setText(trenutnoVozilo.voziloInfo());
								slikaVozila.setImage(slikaTrotinet);
							}
						}
						
					});
				});

				
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		tNajveciGubici.setDaemon(true);
		tNajveciGubici.start();
		
	}

}
