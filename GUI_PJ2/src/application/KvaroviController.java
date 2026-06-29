package application;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import org.unibl.etf.kompanija.Iznajmljivanje;
import org.unibl.etf.prevoznasredstva.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class KvaroviController implements Initializable {
	
	@FXML
	ListView<PrevoznoSredstvo> listView;
	@FXML
	TextArea infoVozilo;
	
	private Map<String, PrevoznoSredstvo> prevoznaSredstva = new HashMap<>(); 
	List<Iznajmljivanje> iznajmljivanja = IzvrsavacSimulacije.kompanija.getIznajmljivanja();
	PrevoznoSredstvo trenutnoVozilo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		Thread tKvarovi = new Thread(() -> {
			Platform.runLater(() -> {
				for(Iznajmljivanje i : iznajmljivanja) {
					if(prevoznaSredstva.putIfAbsent(i.getIdPrevoznogSredstva(), i.getPrevoznoSredstvo()) == null) {
						if(i.isKvar()) {
							listView.getItems().add(i.getPrevoznoSredstvo());						
						}
					}
				}
				
			});
			
			while(true) {
				Platform.runLater(() -> {
					listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
						
						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							trenutnoVozilo = listView.getSelectionModel().getSelectedItem();
							if(trenutnoVozilo != null) {
								String opis = null;
								for(Iznajmljivanje i : iznajmljivanja) {
									if(i.getPrevoznoSredstvo().equals(trenutnoVozilo)) {
										opis = i.getOpisKvara();
										break;
									}
								}
//								infoVozilo.setText(iznajmljivanja.get(iznajmljivanja.indexOf(trenutnoVozilo)).getOpisKvara());
								infoVozilo.setText(trenutnoVozilo.voziloInfo() + "\n\n- Opis kvara:\n" + opis);								
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
		tKvarovi.setDaemon(true);
		tKvarovi.start();
	}
	
	@FXML
	private void prikazNajveciGubiciButtonClick(ActionEvent e)  {
		Parent root;
	    try {
	    	root = FXMLLoader.load(getClass().getResource("ScenePrikazNajveciGubici.fxml"));
	    	Stage stage = new Stage();
	    	stage.setTitle("Prikaz vozila sa najvecim gubicima");
	    	stage.setScene(new Scene(root, 480, 380));
	    	stage.show();
	    	System.out.println("Scenes switched - scena prikaz vozila sa najvecim gubicima");	    	
	    }catch(IOException exc) {
	    	exc.printStackTrace();
		}
	   
	}
}