package application;

import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import org.unibl.etf.kompanija.Iznajmljivanje;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class RezultatiPoslovanjaController implements Initializable {

	@FXML
	ListView<String> listViewDnevni; //LocalDate
	@FXML
	TextArea sumarniIzvjestajText;
	@FXML
	TextArea dnevniIzvjestajText;
	
	List<Iznajmljivanje> iznajmljivanja = IzvrsavacSimulacije.kompanija.getIznajmljivanja();
//	LocalDate izabraniDatum;	//LocalDate
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
//		System.out.println("======================================");
		Thread tIzvjestaji = new Thread(() -> {
			Platform.runLater(() -> {
				LocalDate trenutniDatum = null, prethodniDatum = null;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
				for(Iznajmljivanje i : iznajmljivanja) {
					trenutniDatum = i.getDatum().toLocalDate();
					String formatiraniDatum = trenutniDatum.format(formatter);
					if(!trenutniDatum.equals(prethodniDatum)) {	// novi je datum
						listViewDnevni.getItems().add(formatiraniDatum);
					}
					prethodniDatum = trenutniDatum;
				}
				
			});
			while(true) {
				Platform.runLater(() -> {
					listViewDnevni.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Object>() {
						
						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							String datumStr = listViewDnevni.getSelectionModel().getSelectedItem(); 
							LocalDate izabraniDatum = LocalDate.of(Integer.valueOf(datumStr.split("[.]")[2]), Integer.valueOf(datumStr.split("[.]")[1]), Integer.valueOf(datumStr.split("[.]")[0])) ;
							if(izabraniDatum != null) {
								dnevniIzvjestajText.setText(IzvrsavacSimulacije.kompanija.dnevniIzvjestaj(izabraniDatum));
							}
							
						}
						
					});
				});
				
				Platform.runLater(() -> {
					sumarniIzvjestajText.setText(IzvrsavacSimulacije.kompanija.sumarniIzvjestaj());
				});
				
				try {
					Thread.sleep(50);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		tIzvjestaji.setDaemon(true);
		tIzvjestaji.start();
		
		
	}

}
