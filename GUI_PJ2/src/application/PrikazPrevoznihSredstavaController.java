package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import org.unibl.etf.prevoznasredstva.*;
import org.unibl.etf.util.Util;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrikazPrevoznihSredstavaController implements Initializable {

	@FXML
	ListView<ElektricniAutomobil> listViewAuta;
	@FXML
	ListView<ElektricniBicikl> listViewBicikla;
	@FXML
	ListView<ElektricniTrotinet> listViewTrotineti;
	@FXML
	TextArea infoVozilo;
	@FXML
	ImageView slikaVozila;
	
	Map<String, PrevoznoSredstvo> vozila = IzvrsavacSimulacije.kompanija.getPrevoznaSredstva();
	PrevoznoSredstvo trenutnoVozilo;
	{
		try {
			slikaAuto = new Image(new FileInputStream(Util.buildPath("../GUI_PJ2/projektni_slike/AUTO/auto.png")));
			slikaBiciklo = new Image(new FileInputStream(Util.buildPath("../GUI_PJ2/projektni_slike/BICIKL/biciklo.png")));
			slikaTrotinet = new Image(new FileInputStream(Util.buildPath("../GUI_PJ2/projektni_slike/TROTINET/trotinet.png")));	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Label datum;
	@FXML
	private Label vrijeme;
	private Image slikaAuto;
	private Image slikaBiciklo;
	private Image slikaTrotinet;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Thread tPrikazVozila = new Thread(() -> {
			
			Platform.runLater(() -> {
				for(Map.Entry<String, PrevoznoSredstvo> e : vozila.entrySet()) {
					if(e.getValue() instanceof ElektricniAutomobil) {
						ElektricniAutomobil auto = (ElektricniAutomobil) e.getValue();
						listViewAuta.getItems().add(auto);
					}
					else if(e.getValue() instanceof ElektricniBicikl) {
						ElektricniBicikl bicikl = (ElektricniBicikl) e.getValue();
						listViewBicikla.getItems().add(bicikl);
					}
					else {
						ElektricniTrotinet trotinet = (ElektricniTrotinet) e.getValue();
						listViewTrotineti.getItems().add(trotinet);
					}
				}	
			});
			
			while(true) {
				Platform.runLater(() -> {
					listViewAuta.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
						
						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							trenutnoVozilo = listViewAuta.getSelectionModel().getSelectedItem();
							if(trenutnoVozilo != null) {
								infoVozilo.setText(trenutnoVozilo.voziloInfo());
								slikaVozila.setImage(slikaAuto);
							}
						}
						
					});
				});
				
				Platform.runLater(() -> {
					listViewBicikla.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
						
						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							trenutnoVozilo = listViewBicikla.getSelectionModel().getSelectedItem();
							if(trenutnoVozilo != null) {
								infoVozilo.setText(trenutnoVozilo.voziloInfo());
								slikaVozila.setImage(slikaBiciklo);
							}
						}

						
					});
				});
				
				
				Platform.runLater(() -> {
					listViewTrotineti.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
						
						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							trenutnoVozilo = listViewTrotineti.getSelectionModel().getSelectedItem();
							if(trenutnoVozilo != null) {
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
		tPrikazVozila.setDaemon(true);
		tPrikazVozila.start();
		
		
	}


}
