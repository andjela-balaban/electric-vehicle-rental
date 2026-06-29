package application;

import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import java.io.*;
import java.util.*;
import org.unibl.etf.prevoznasredstva.*;
import org.unibl.etf.util.Util;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class SimulationSceneController implements Initializable {
	
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
	
	@FXML
	private Button rezultatiPoslovanjaPrikazButton;
	@FXML
	private Button kvaroviPrikazButton;
	
	@FXML
	TextArea infoVozilo;

	
//	//pozicije za kretanje vozila
	@FXML
	private ImageView p0000;		// pozicija[0][0] u matrici
	@FXML
	private ImageView p0001;
	@FXML
	private ImageView p0002;
	@FXML
	private ImageView p0003;
	@FXML
	private ImageView p0004;
	@FXML
	private ImageView p0005;
	@FXML
	private ImageView p0006;
	@FXML
	private ImageView p0007;
	@FXML
	private ImageView p0008;
	@FXML
	private ImageView p0009;
	@FXML
	private ImageView p0010;
	@FXML
	private ImageView p0011;
	@FXML
	private ImageView p0012;
	@FXML
	private ImageView p0013;
	@FXML
	private ImageView p0014;
	@FXML
	private ImageView p0015;
	@FXML
	private ImageView p0016;
	@FXML
	private ImageView p0017;
	@FXML
	private ImageView p0018;
	@FXML
	private ImageView p0019;		// pozicija[0][19] u matrici
	@FXML
	private ImageView p0100;		// pozicija[1][0] u matrici
	@FXML
	private ImageView p0101;
	@FXML
	private ImageView p0102;
	@FXML
	private ImageView p0103;
	@FXML
	private ImageView p0104;
	@FXML
	private ImageView p0105;
	@FXML
	private ImageView p0106;
	@FXML
	private ImageView p0107;
	@FXML
	private ImageView p0108;
	@FXML
	private ImageView p0109;
	@FXML
	private ImageView p0110;
	@FXML
	private ImageView p0111;
	@FXML
	private ImageView p0112;
	@FXML
	private ImageView p0113;
	@FXML
	private ImageView p0114;
	@FXML
	private ImageView p0115;
	@FXML
	private ImageView p0116;
	@FXML
	private ImageView p0117;
	@FXML
	private ImageView p0118;
	@FXML
	private ImageView p0119;		// pozicija[1][19] u matrici
	@FXML
	private ImageView p0200;		// pozicija[2][0] u matrici
	@FXML
	private ImageView p0201;
	@FXML
	private ImageView p0202;
	@FXML
	private ImageView p0203;
	@FXML
	private ImageView p0204;
	@FXML
	private ImageView p0205;
	@FXML
	private ImageView p0206;
	@FXML
	private ImageView p0207;
	@FXML
	private ImageView p0208;
	@FXML
	private ImageView p0209;
	@FXML
	private ImageView p0210;
	@FXML
	private ImageView p0211;
	@FXML
	private ImageView p0212;
	@FXML
	private ImageView p0213;
	@FXML
	private ImageView p0214;
	@FXML
	private ImageView p0215;
	@FXML
	private ImageView p0216;
	@FXML
	private ImageView p0217;
	@FXML
	private ImageView p0218;
	@FXML
	private ImageView p0219;		// pozicija[2][19] u matrici
	@FXML
	private ImageView p0300;		// pozicija[3][0] u matrici
	@FXML
	private ImageView p0301;
	@FXML
	private ImageView p0302;
	@FXML
	private ImageView p0303;
	@FXML
	private ImageView p0304;
	@FXML
	private ImageView p0305;
	@FXML
	private ImageView p0306;
	@FXML
	private ImageView p0307;
	@FXML
	private ImageView p0308;
	@FXML
	private ImageView p0309;
	@FXML
	private ImageView p0310;
	@FXML
	private ImageView p0311;
	@FXML
	private ImageView p0312;
	@FXML
	private ImageView p0313;
	@FXML
	private ImageView p0314;
	@FXML
	private ImageView p0315;
	@FXML
	private ImageView p0316;
	@FXML
	private ImageView p0317;
	@FXML
	private ImageView p0318;
	@FXML
	private ImageView p0319;		// pozicija[3][19] u matrici
	@FXML
	private ImageView p0400;		// pozicija[4][0] u matrici
	@FXML
	private ImageView p0401;
	@FXML
	private ImageView p0402;
	@FXML
	private ImageView p0403;
	@FXML
	private ImageView p0404;
	@FXML
	private ImageView p0405;
	@FXML
	private ImageView p0406;
	@FXML
	private ImageView p0407;
	@FXML
	private ImageView p0408;
	@FXML
	private ImageView p0409;
	@FXML
	private ImageView p0410;
	@FXML
	private ImageView p0411;
	@FXML
	private ImageView p0412;
	@FXML
	private ImageView p0413;
	@FXML
	private ImageView p0414;
	@FXML
	private ImageView p0415;
	@FXML
	private ImageView p0416;
	@FXML
	private ImageView p0417;
	@FXML
	private ImageView p0418;
	@FXML
	private ImageView p0419;		// pozicija[4][19] u matrici
	@FXML
	private ImageView p0500;		// pozicija[5][0] u matrici
	@FXML
	private ImageView p0501;
	@FXML
	private ImageView p0502;
	@FXML
	private ImageView p0503;
	@FXML
	private ImageView p0504;
	@FXML
	private ImageView p0505;
	@FXML
	private ImageView p0506;
	@FXML
	private ImageView p0507;
	@FXML
	private ImageView p0508;
	@FXML
	private ImageView p0509;
	@FXML
	private ImageView p0510;
	@FXML
	private ImageView p0511;
	@FXML
	private ImageView p0512;
	@FXML
	private ImageView p0513;
	@FXML
	private ImageView p0514;
	@FXML
	private ImageView p0515;
	@FXML
	private ImageView p0516;
	@FXML
	private ImageView p0517;
	@FXML
	private ImageView p0518;
	@FXML
	private ImageView p0519;		// pozicija[5][19] u matrici
	@FXML
	private ImageView p0600;		// pozicija[6][0] u matrici
	@FXML
	private ImageView p0601;
	@FXML
	private ImageView p0602;
	@FXML
	private ImageView p0603;
	@FXML
	private ImageView p0604;
	@FXML
	private ImageView p0605;
	@FXML
	private ImageView p0606;
	@FXML
	private ImageView p0607;
	@FXML
	private ImageView p0608;
	@FXML
	private ImageView p0609;
	@FXML
	private ImageView p0610;
	@FXML
	private ImageView p0611;
	@FXML
	private ImageView p0612;
	@FXML
	private ImageView p0613;
	@FXML
	private ImageView p0614;
	@FXML
	private ImageView p0615;
	@FXML
	private ImageView p0616;
	@FXML
	private ImageView p0617;
	@FXML
	private ImageView p0618;
	@FXML
	private ImageView p0619;		// pozicija[6][19] u matrici
	@FXML
	private ImageView p0700;		// pozicija[7][0] u matrici
	@FXML
	private ImageView p0701;
	@FXML
	private ImageView p0702;
	@FXML
	private ImageView p0703;
	@FXML
	private ImageView p0704;
	@FXML
	private ImageView p0705;
	@FXML
	private ImageView p0706;
	@FXML
	private ImageView p0707;
	@FXML
	private ImageView p0708;
	@FXML
	private ImageView p0709;
	@FXML
	private ImageView p0710;
	@FXML
	private ImageView p0711;
	@FXML
	private ImageView p0712;
	@FXML
	private ImageView p0713;
	@FXML
	private ImageView p0714;
	@FXML
	private ImageView p0715;
	@FXML
	private ImageView p0716;
	@FXML
	private ImageView p0717;
	@FXML
	private ImageView p0718;
	@FXML
	private ImageView p0719;		// pozicija[7][19] u matrici
	@FXML
	private ImageView p0800;		// pozicija[0][0] u matrici
	@FXML
	private ImageView p0801;
	@FXML
	private ImageView p0802;
	@FXML
	private ImageView p0803;
	@FXML
	private ImageView p0804;
	@FXML
	private ImageView p0805;
	@FXML
	private ImageView p0806;
	@FXML
	private ImageView p0807;
	@FXML
	private ImageView p0808;
	@FXML
	private ImageView p0809;
	@FXML
	private ImageView p0810;
	@FXML
	private ImageView p0811;
	@FXML
	private ImageView p0812;
	@FXML
	private ImageView p0813;
	@FXML
	private ImageView p0814;
	@FXML
	private ImageView p0815;
	@FXML
	private ImageView p0816;
	@FXML
	private ImageView p0817;
	@FXML
	private ImageView p0818;
	@FXML
	private ImageView p0819;		// pozicija[8][19] u matrici
	@FXML
	private ImageView p0900;		// pozicija[9][0] u matrici
	@FXML
	private ImageView p0901;
	@FXML
	private ImageView p0902;
	@FXML
	private ImageView p0903;
	@FXML
	private ImageView p0904;
	@FXML
	private ImageView p0905;
	@FXML
	private ImageView p0906;
	@FXML
	private ImageView p0907;
	@FXML
	private ImageView p0908;
	@FXML
	private ImageView p0909;
	@FXML
	private ImageView p0910;
	@FXML
	private ImageView p0911;
	@FXML
	private ImageView p0912;
	@FXML
	private ImageView p0913;
	@FXML
	private ImageView p0914;
	@FXML
	private ImageView p0915;
	@FXML
	private ImageView p0916;
	@FXML
	private ImageView p0917;
	@FXML
	private ImageView p0918;
	@FXML
	private ImageView p0919;		// pozicija[9][19] u matrici
	@FXML
	private ImageView p1000;		// pozicija[10][0] u matrici
	@FXML
	private ImageView p1001;
	@FXML
	private ImageView p1002;
	@FXML
	private ImageView p1003;
	@FXML
	private ImageView p1004;
	@FXML
	private ImageView p1005;
	@FXML
	private ImageView p1006;
	@FXML
	private ImageView p1007;
	@FXML
	private ImageView p1008;
	@FXML
	private ImageView p1009;
	@FXML
	private ImageView p1010;
	@FXML
	private ImageView p1011;
	@FXML
	private ImageView p1012;
	@FXML
	private ImageView p1013;
	@FXML
	private ImageView p1014;
	@FXML
	private ImageView p1015;
	@FXML
	private ImageView p1016;
	@FXML
	private ImageView p1017;
	@FXML
	private ImageView p1018;
	@FXML
	private ImageView p1019;		// pozicija[10][19] u matrici
	@FXML
	private ImageView p1100;		// pozicija[11][0] u matrici
	@FXML
	private ImageView p1101;
	@FXML
	private ImageView p1102;
	@FXML
	private ImageView p1103;
	@FXML
	private ImageView p1104;
	@FXML
	private ImageView p1105;
	@FXML
	private ImageView p1106;
	@FXML
	private ImageView p1107;
	@FXML
	private ImageView p1108;
	@FXML
	private ImageView p1109;
	@FXML
	private ImageView p1110;
	@FXML
	private ImageView p1111;
	@FXML
	private ImageView p1112;
	@FXML
	private ImageView p1113;
	@FXML
	private ImageView p1114;
	@FXML
	private ImageView p1115;
	@FXML
	private ImageView p1116;
	@FXML
	private ImageView p1117;
	@FXML
	private ImageView p1118;
	@FXML
	private ImageView p1119;		// pozicija[11][19] u matrici
	@FXML
	private ImageView p1200;		// pozicija[12][0] u matrici
	@FXML
	private ImageView p1201;
	@FXML
	private ImageView p1202;
	@FXML
	private ImageView p1203;
	@FXML
	private ImageView p1204;
	@FXML
	private ImageView p1205;
	@FXML
	private ImageView p1206;
	@FXML
	private ImageView p1207;
	@FXML
	private ImageView p1208;
	@FXML
	private ImageView p1209;
	@FXML
	private ImageView p1210;
	@FXML
	private ImageView p1211;
	@FXML
	private ImageView p1212;
	@FXML
	private ImageView p1213;
	@FXML
	private ImageView p1214;
	@FXML
	private ImageView p1215;
	@FXML
	private ImageView p1216;
	@FXML
	private ImageView p1217;
	@FXML
	private ImageView p1218;
	@FXML
	private ImageView p1219;		// pozicija[12][19] u matrici
	@FXML
	private ImageView p1300;		// pozicija[13][0] u matrici
	@FXML
	private ImageView p1301;
	@FXML
	private ImageView p1302;
	@FXML
	private ImageView p1303;
	@FXML
	private ImageView p1304;
	@FXML
	private ImageView p1305;
	@FXML
	private ImageView p1306;
	@FXML
	private ImageView p1307;
	@FXML
	private ImageView p1308;
	@FXML
	private ImageView p1309;
	@FXML
	private ImageView p1310;
	@FXML
	private ImageView p1311;
	@FXML
	private ImageView p1312;
	@FXML
	private ImageView p1313;
	@FXML
	private ImageView p1314;
	@FXML
	private ImageView p1315;
	@FXML
	private ImageView p1316;
	@FXML
	private ImageView p1317;
	@FXML
	private ImageView p1318;
	@FXML
	private ImageView p1319;		// pozicija[13][19] u matrici
	@FXML
	private ImageView p1400;		// pozicija[14][0] u matrici
	@FXML
	private ImageView p1401;
	@FXML
	private ImageView p1402;
	@FXML
	private ImageView p1403;
	@FXML
	private ImageView p1404;
	@FXML
	private ImageView p1405;
	@FXML
	private ImageView p1406;
	@FXML
	private ImageView p1407;
	@FXML
	private ImageView p1408;
	@FXML
	private ImageView p1409;
	@FXML
	private ImageView p1410;
	@FXML
	private ImageView p1411;
	@FXML
	private ImageView p1412;
	@FXML
	private ImageView p1413;
	@FXML
	private ImageView p1414;
	@FXML
	private ImageView p1415;
	@FXML
	private ImageView p1416;
	@FXML
	private ImageView p1417;
	@FXML
	private ImageView p1418;
	@FXML
	private ImageView p1419;		// pozicija[14][19] u matrici
	@FXML
	private ImageView p1500;		// pozicija[15][0] u matrici
	@FXML
	private ImageView p1501;
	@FXML
	private ImageView p1502;
	@FXML
	private ImageView p1503;
	@FXML
	private ImageView p1504;
	@FXML
	private ImageView p1505;
	@FXML
	private ImageView p1506;
	@FXML
	private ImageView p1507;
	@FXML
	private ImageView p1508;
	@FXML
	private ImageView p1509;
	@FXML
	private ImageView p1510;
	@FXML
	private ImageView p1511;
	@FXML
	private ImageView p1512;
	@FXML
	private ImageView p1513;
	@FXML
	private ImageView p1514;
	@FXML
	private ImageView p1515;
	@FXML
	private ImageView p1516;
	@FXML
	private ImageView p1517;
	@FXML
	private ImageView p1518;
	@FXML
	private ImageView p1519;		// pozicija[15][19] u matrici
	@FXML
	private ImageView p1600;		// pozicija[16][0] u matrici
	@FXML
	private ImageView p1601;
	@FXML
	private ImageView p1602;
	@FXML
	private ImageView p1603;
	@FXML
	private ImageView p1604;
	@FXML
	private ImageView p1605;
	@FXML
	private ImageView p1606;
	@FXML
	private ImageView p1607;
	@FXML
	private ImageView p1608;
	@FXML
	private ImageView p1609;
	@FXML
	private ImageView p1610;
	@FXML
	private ImageView p1611;
	@FXML
	private ImageView p1612;
	@FXML
	private ImageView p1613;
	@FXML
	private ImageView p1614;
	@FXML
	private ImageView p1615;
	@FXML
	private ImageView p1616;
	@FXML
	private ImageView p1617;
	@FXML
	private ImageView p1618;
	@FXML
	private ImageView p1619;		// pozicija[16][19] u matrici
	@FXML
	private ImageView p1700;		// pozicija[17][0] u matrici
	@FXML
	private ImageView p1701;
	@FXML
	private ImageView p1702;
	@FXML
	private ImageView p1703;
	@FXML
	private ImageView p1704;
	@FXML
	private ImageView p1705;
	@FXML
	private ImageView p1706;
	@FXML
	private ImageView p1707;
	@FXML
	private ImageView p1708;
	@FXML
	private ImageView p1709;
	@FXML
	private ImageView p1710;
	@FXML
	private ImageView p1711;
	@FXML
	private ImageView p1712;
	@FXML
	private ImageView p1713;
	@FXML
	private ImageView p1714;
	@FXML
	private ImageView p1715;
	@FXML
	private ImageView p1716;
	@FXML
	private ImageView p1717;
	@FXML
	private ImageView p1718;
	@FXML
	private ImageView p1719;		// pozicija[17][19] u matrici
	@FXML
	private ImageView p1800;		// pozicija[18][0] u matrici
	@FXML
	private ImageView p1801;
	@FXML
	private ImageView p1802;
	@FXML
	private ImageView p1803;
	@FXML
	private ImageView p1804;
	@FXML
	private ImageView p1805;
	@FXML
	private ImageView p1806;
	@FXML
	private ImageView p1807;
	@FXML
	private ImageView p1808;
	@FXML
	private ImageView p1809;
	@FXML
	private ImageView p1810;
	@FXML
	private ImageView p1811;
	@FXML
	private ImageView p1812;
	@FXML
	private ImageView p1813;
	@FXML
	private ImageView p1814;
	@FXML
	private ImageView p1815;
	@FXML
	private ImageView p1816;
	@FXML
	private ImageView p1817;
	@FXML
	private ImageView p1818;
	@FXML
	private ImageView p1819;		// pozicija[18][19] u matrici
	@FXML
	private ImageView p1900;		// pozicija[19][0] u matrici
	@FXML
	private ImageView p1901;
	@FXML
	private ImageView p1902;
	@FXML
	private ImageView p1903;
	@FXML
	private ImageView p1904;
	@FXML
	private ImageView p1905;
	@FXML
	private ImageView p1906;
	@FXML
	private ImageView p1907;
	@FXML
	private ImageView p1908;
	@FXML
	private ImageView p1909;
	@FXML
	private ImageView p1910;
	@FXML
	private ImageView p1911;
	@FXML
	private ImageView p1912;
	@FXML
	private ImageView p1913;
	@FXML
	private ImageView p1914;
	@FXML
	private ImageView p1915;
	@FXML
	private ImageView p1916;
	@FXML
	private ImageView p1917;
	@FXML
	private ImageView p1918;
	@FXML
	private ImageView p1919;		// pozicija[19][19] u matrici
	


	@FXML
	private void kvaroviPrikazButtonClick(ActionEvent e)  {
		Parent root;
	    try {
	    	root = FXMLLoader.load(getClass().getResource("ScenePrikazKvarova.fxml"));
	    	Stage stage = new Stage();
	    	stage.setTitle("Prikaz kvarova");
	    	stage.setScene(new Scene(root, 680, 400));
	    	stage.show();
	    	System.out.println("Scenes switched - scena kvarovi");	    	
	    }catch(IOException exc) {
	    	exc.printStackTrace();
		}
	   
	}
	
	@FXML
	private void prevoznaSredstvaPrikazButtonClick(ActionEvent e) {
		Parent root;
		try {
	    	root = FXMLLoader.load(getClass().getResource("ScenePrikazPrevoznihSredstava.fxml"));
	    	Stage stage = new Stage();
	    	stage.setTitle("Prikaz prevoznih sredstava");
	    	stage.setScene(new Scene(root, 750, 450));
	    	stage.show();
	   
	    	System.out.println("Scenes switched - scena prikaz prevoznih sredstava");
		}catch(IOException exc) {
			exc.printStackTrace();
		}
	}
	
	@FXML
	private void rezultatiPoslovanjaPrikazButtonClick(ActionEvent e)  {
		Parent root;
	    try {
	    	root = FXMLLoader.load(getClass().getResource("ScenePrikazRezultataPoslovanja.fxml"));
	    	Stage stage = new Stage();
	    	stage.setTitle("Prikaz rezultata poslovanja");
	    	stage.setScene(new Scene(root, 750, 450));
	    	stage.show();
	    	System.out.println("Scenes switched - scena rezultati poslovanja");	    	
	    }catch(IOException exc) {
	    	exc.printStackTrace();
		}
	   
	}
	
	
//	metode za ispis informacija na labelu sa strane
//	----------------------------------------------------------------------------------------------------
	@FXML
	private void prikazPozicije0000(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0001(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0002(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0003(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0004(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0005(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0006(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0007(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0008(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0009(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0010(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0011(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0012(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0013(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0014(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0015(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0016(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0017(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0018(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0019(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[0][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0100(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0101(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0102(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0103(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0104(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0105(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0106(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0107(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0108(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0109(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0110(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0111(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0112(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0113(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0114(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0115(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0116(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0117(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0118(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0119(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[1][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0200(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0201(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0202(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0203(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0204(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0205(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0206(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0207(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0208(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0209(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0210(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0211(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0212(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0213(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0214(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0215(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0216(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0217(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0218(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0219(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[2][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0300(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0301(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0302(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0303(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0304(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0305(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0306(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0307(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0308(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0309(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0310(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0311(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0312(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0313(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0314(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0315(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0316(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0317(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0318(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0319(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[3][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0400(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0401(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0402(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0403(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0404(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0405(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0406(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0407(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0408(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0409(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0410(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0411(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0412(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0413(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0414(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0415(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0416(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0417(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0418(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0419(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[4][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0500(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0501(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0502(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0503(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0504(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0505(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0506(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0507(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0508(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0509(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0510(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0511(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0512(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0513(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0514(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0515(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0516(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0517(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0518(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0519(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[5][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0600(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0601(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0602(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0603(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0604(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0605(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0606(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0607(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0608(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0609(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0610(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0611(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0612(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0613(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0614(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0615(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0616(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0617(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0618(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0619(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[6][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0700(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0701(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0702(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0703(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0704(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0705(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0706(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0707(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0708(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0709(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0710(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0711(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0712(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0713(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0714(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0715(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0716(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0717(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0718(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0719(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[7][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0800(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0801(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0802(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0803(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0804(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0805(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0806(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0807(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0808(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0809(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0810(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0811(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0812(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0813(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0814(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0815(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0816(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0817(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0818(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0819(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[8][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0900(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0901(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0902(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0903(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0904(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0905(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0906(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0907(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0908(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0909(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0910(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0911(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0912(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0913(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0914(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0915(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0916(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0917(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0918(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije0919(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[9][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1000(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1001(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1002(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1003(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1004(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1005(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1006(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1007(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1008(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1009(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1010(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1011(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1012(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1013(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1014(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1015(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1016(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1017(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1018(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1019(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[10][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1100(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1101(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1102(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1103(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1104(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1105(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1106(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1107(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1108(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1109(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1110(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1111(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1112(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1113(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1114(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1115(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1116(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1117(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1118(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1119(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[11][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1200(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1201(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1202(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1203(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1204(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1205(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1206(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1207(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1208(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1209(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1210(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1211(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1212(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1213(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1214(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1215(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1216(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1217(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1218(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1219(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[12][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1300(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1301(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1302(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1303(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1304(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1305(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1306(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1307(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1308(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1309(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1310(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1311(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1312(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1313(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1314(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1315(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1316(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1317(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1318(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1319(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[13][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1400(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1401(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1402(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1403(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1404(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1405(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1406(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1407(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1408(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1409(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1410(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1411(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1412(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1413(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1414(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1415(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1416(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1417(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1418(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1419(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[14][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1500(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1501(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1502(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1503(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1504(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1505(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1506(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1507(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1508(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1509(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1510(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1511(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1512(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1513(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1514(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}

	
	@FXML
	private void prikazPozicije1515(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1516(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1517(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1518(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1519(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[15][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1600(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1601(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1602(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1603(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1604(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1605(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1606(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1607(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1608(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1609(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1610(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1611(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1612(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1613(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1614(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1615(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1616(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1617(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1618(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1619(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[16][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1700(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1701(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1702(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1703(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1704(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1705(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1706(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1707(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1708(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1709(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1710(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1711(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1712(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1713(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1714(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1715(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1716(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1717(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1718(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1719(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[17][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1800(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1801(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1802(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1803(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1804(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1805(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1806(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1807(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1808(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1809(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1810(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1811(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1812(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1813(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1814(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1815(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1816(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1817(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1818(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1819(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[18][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1900(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][0];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1901(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][1];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1902(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][2];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1903(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][3];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1904(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][4];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1905(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][5];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1906(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][6];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1907(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][7];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1908(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][8];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1909(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][9];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1910(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][10];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1911(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][11];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1912(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][12];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1913(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][13];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1914(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][14];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1915(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][15];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1916(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][16];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1917(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][17];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1918(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][18];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}


	@FXML
	private void prikazPozicije1919(MouseEvent e) {
	    PrevoznoSredstvo ps = (PrevoznoSredstvo) IzvrsavacSimulacije.kompanija.getMapa()[19][19];
	    if (ps != null) {
	        infoVozilo.setText(ps.voziloInfo());
	    }
	}
//	----------------------------------------------------------------------------------------------------
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		Platform.runLater(() -> {
    		rezultatiPoslovanjaPrikazButton.setDisable(true);
    		kvaroviPrikazButton.setDisable(true);
    	});
		
		List<ImageView> pozicije = new ArrayList<>();
		pozicije.add(p0000);
        pozicije.add(p0001);
        pozicije.add(p0002);
        pozicije.add(p0003);
        pozicije.add(p0004);
        pozicije.add(p0005);
        pozicije.add(p0006);
        pozicije.add(p0007);
        pozicije.add(p0008);
        pozicije.add(p0009);
        pozicije.add(p0010);
        pozicije.add(p0011);
        pozicije.add(p0012);
        pozicije.add(p0013);
        pozicije.add(p0014);
        pozicije.add(p0015);
        pozicije.add(p0016);
        pozicije.add(p0017);
        pozicije.add(p0018);
        pozicije.add(p0019);
        pozicije.add(p0100);
        pozicije.add(p0101);
        pozicije.add(p0102);
        pozicije.add(p0103);
        pozicije.add(p0104);
        pozicije.add(p0105);
        pozicije.add(p0106);
        pozicije.add(p0107);
        pozicije.add(p0108);
        pozicije.add(p0109);
        pozicije.add(p0110);
        pozicije.add(p0111);
        pozicije.add(p0112);
        pozicije.add(p0113);
        pozicije.add(p0114);
        pozicije.add(p0115);
        pozicije.add(p0116);
        pozicije.add(p0117);
        pozicije.add(p0118);
        pozicije.add(p0119);
        pozicije.add(p0200);
        pozicije.add(p0201);
        pozicije.add(p0202);
        pozicije.add(p0203);
        pozicije.add(p0204);
        pozicije.add(p0205);
        pozicije.add(p0206);
        pozicije.add(p0207);
        pozicije.add(p0208);
        pozicije.add(p0209);
        pozicije.add(p0210);
        pozicije.add(p0211);
        pozicije.add(p0212);
        pozicije.add(p0213);
        pozicije.add(p0214);
        pozicije.add(p0215);
        pozicije.add(p0216);
        pozicije.add(p0217);
        pozicije.add(p0218);
        pozicije.add(p0219);
        pozicije.add(p0300);
        pozicije.add(p0301);
        pozicije.add(p0302);
        pozicije.add(p0303);
        pozicije.add(p0304);
        pozicije.add(p0305);
        pozicije.add(p0306);
        pozicije.add(p0307);
        pozicije.add(p0308);
        pozicije.add(p0309);
        pozicije.add(p0310);
        pozicije.add(p0311);
        pozicije.add(p0312);
        pozicije.add(p0313);
        pozicije.add(p0314);
        pozicije.add(p0315);
        pozicije.add(p0316);
        pozicije.add(p0317);
        pozicije.add(p0318);
        pozicije.add(p0319);
        pozicije.add(p0400);
        pozicije.add(p0401);
        pozicije.add(p0402);
        pozicije.add(p0403);
        pozicije.add(p0404);
        pozicije.add(p0405);
        pozicije.add(p0406);
        pozicije.add(p0407);
        pozicije.add(p0408);
        pozicije.add(p0409);
        pozicije.add(p0410);
        pozicije.add(p0411);
        pozicije.add(p0412);
        pozicije.add(p0413);
        pozicije.add(p0414);
        pozicije.add(p0415);
        pozicije.add(p0416);
        pozicije.add(p0417);
        pozicije.add(p0418);
        pozicije.add(p0419);
        pozicije.add(p0500);
        pozicije.add(p0501);
        pozicije.add(p0502);
        pozicije.add(p0503);
        pozicije.add(p0504);
        pozicije.add(p0505);
        pozicije.add(p0506);
        pozicije.add(p0507);
        pozicije.add(p0508);
        pozicije.add(p0509);
        pozicije.add(p0510);
        pozicije.add(p0511);
        pozicije.add(p0512);
        pozicije.add(p0513);
        pozicije.add(p0514);
        pozicije.add(p0515);
        pozicije.add(p0516);
        pozicije.add(p0517);
        pozicije.add(p0518);
        pozicije.add(p0519);
        pozicije.add(p0600);
        pozicije.add(p0601);
        pozicije.add(p0602);
        pozicije.add(p0603);
        pozicije.add(p0604);
        pozicije.add(p0605);
        pozicije.add(p0606);
        pozicije.add(p0607);
        pozicije.add(p0608);
        pozicije.add(p0609);
        pozicije.add(p0610);
        pozicije.add(p0611);
        pozicije.add(p0612);
        pozicije.add(p0613);
        pozicije.add(p0614);
        pozicije.add(p0615);
        pozicije.add(p0616);
        pozicije.add(p0617);
        pozicije.add(p0618);
        pozicije.add(p0619);
        pozicije.add(p0700);
        pozicije.add(p0701);
        pozicije.add(p0702);
        pozicije.add(p0703);
        pozicije.add(p0704);
        pozicije.add(p0705);
        pozicije.add(p0706);
        pozicije.add(p0707);
        pozicije.add(p0708);
        pozicije.add(p0709);
        pozicije.add(p0710);
        pozicije.add(p0711);
        pozicije.add(p0712);
        pozicije.add(p0713);
        pozicije.add(p0714);
        pozicije.add(p0715);
        pozicije.add(p0716);
        pozicije.add(p0717);
        pozicije.add(p0718);
        pozicije.add(p0719);
        pozicije.add(p0800);
        pozicije.add(p0801);
        pozicije.add(p0802);
        pozicije.add(p0803);
        pozicije.add(p0804);
        pozicije.add(p0805);
        pozicije.add(p0806);
        pozicije.add(p0807);
        pozicije.add(p0808);
        pozicije.add(p0809);
        pozicije.add(p0810);
        pozicije.add(p0811);
        pozicije.add(p0812);
        pozicije.add(p0813);
        pozicije.add(p0814);
        pozicije.add(p0815);
        pozicije.add(p0816);
        pozicije.add(p0817);
        pozicije.add(p0818);
        pozicije.add(p0819);
        pozicije.add(p0900);
        pozicije.add(p0901);
        pozicije.add(p0902);
        pozicije.add(p0903);
        pozicije.add(p0904);
        pozicije.add(p0905);
        pozicije.add(p0906);
        pozicije.add(p0907);
        pozicije.add(p0908);
        pozicije.add(p0909);
        pozicije.add(p0910);
        pozicije.add(p0911);
        pozicije.add(p0912);
        pozicije.add(p0913);
        pozicije.add(p0914);
        pozicije.add(p0915);
        pozicije.add(p0916);
        pozicije.add(p0917);
        pozicije.add(p0918);
        pozicije.add(p0919);
        pozicije.add(p1000);
        pozicije.add(p1001);
        pozicije.add(p1002);
        pozicije.add(p1003);
        pozicije.add(p1004);
        pozicije.add(p1005);
        pozicije.add(p1006);
        pozicije.add(p1007);
        pozicije.add(p1008);
        pozicije.add(p1009);
        pozicije.add(p1010);
        pozicije.add(p1011);
        pozicije.add(p1012);
        pozicije.add(p1013);
        pozicije.add(p1014);
        pozicije.add(p1015);
        pozicije.add(p1016);
        pozicije.add(p1017);
        pozicije.add(p1018);
        pozicije.add(p1019);
        pozicije.add(p1100);
        pozicije.add(p1101);
        pozicije.add(p1102);
        pozicije.add(p1103);
        pozicije.add(p1104);
        pozicije.add(p1105);
        pozicije.add(p1106);
        pozicije.add(p1107);
        pozicije.add(p1108);
        pozicije.add(p1109);
        pozicije.add(p1110);
        pozicije.add(p1111);
        pozicije.add(p1112);
        pozicije.add(p1113);
        pozicije.add(p1114);
        pozicije.add(p1115);
        pozicije.add(p1116);
        pozicije.add(p1117);
        pozicije.add(p1118);
        pozicije.add(p1119);
        pozicije.add(p1200);
        pozicije.add(p1201);
        pozicije.add(p1202);
        pozicije.add(p1203);
        pozicije.add(p1204);
        pozicije.add(p1205);
        pozicije.add(p1206);
        pozicije.add(p1207);
        pozicije.add(p1208);
        pozicije.add(p1209);
        pozicije.add(p1210);
        pozicije.add(p1211);
        pozicije.add(p1212);
        pozicije.add(p1213);
        pozicije.add(p1214);
        pozicije.add(p1215);
        pozicije.add(p1216);
        pozicije.add(p1217);
        pozicije.add(p1218);
        pozicije.add(p1219);
        pozicije.add(p1300);
        pozicije.add(p1301);
        pozicije.add(p1302);
        pozicije.add(p1303);
        pozicije.add(p1304);
        pozicije.add(p1305);
        pozicije.add(p1306);
        pozicije.add(p1307);
        pozicije.add(p1308);
        pozicije.add(p1309);
        pozicije.add(p1310);
        pozicije.add(p1311);
        pozicije.add(p1312);
        pozicije.add(p1313);
        pozicije.add(p1314);
        pozicije.add(p1315);
        pozicije.add(p1316);
        pozicije.add(p1317);
        pozicije.add(p1318);
        pozicije.add(p1319);
        pozicije.add(p1400);
        pozicije.add(p1401);
        pozicije.add(p1402);
        pozicije.add(p1403);
        pozicije.add(p1404);
        pozicije.add(p1405);
        pozicije.add(p1406);
        pozicije.add(p1407);
        pozicije.add(p1408);
        pozicije.add(p1409);
        pozicije.add(p1410);
        pozicije.add(p1411);
        pozicije.add(p1412);
        pozicije.add(p1413);
        pozicije.add(p1414);
        pozicije.add(p1415);
        pozicije.add(p1416);
        pozicije.add(p1417);
        pozicije.add(p1418);
        pozicije.add(p1419);
        pozicije.add(p1500);
        pozicije.add(p1501);
        pozicije.add(p1502);
        pozicije.add(p1503);
        pozicije.add(p1504);
        pozicije.add(p1505);
        pozicije.add(p1506);
        pozicije.add(p1507);
        pozicije.add(p1508);
        pozicije.add(p1509);
        pozicije.add(p1510);
        pozicije.add(p1511);
        pozicije.add(p1512);
        pozicije.add(p1513);
        pozicije.add(p1514);
        pozicije.add(p1515);
        pozicije.add(p1516);
        pozicije.add(p1517);
        pozicije.add(p1518);
        pozicije.add(p1519);
        pozicije.add(p1600);
        pozicije.add(p1601);
        pozicije.add(p1602);
        pozicije.add(p1603);
        pozicije.add(p1604);
        pozicije.add(p1605);
        pozicije.add(p1606);
        pozicije.add(p1607);
        pozicije.add(p1608);
        pozicije.add(p1609);
        pozicije.add(p1610);
        pozicije.add(p1611);
        pozicije.add(p1612);
        pozicije.add(p1613);
        pozicije.add(p1614);
        pozicije.add(p1615);
        pozicije.add(p1616);
        pozicije.add(p1617);
        pozicije.add(p1618);
        pozicije.add(p1619);
        pozicije.add(p1700);
        pozicije.add(p1701);
        pozicije.add(p1702);
        pozicije.add(p1703);
        pozicije.add(p1704);
        pozicije.add(p1705);
        pozicije.add(p1706);
        pozicije.add(p1707);
        pozicije.add(p1708);
        pozicije.add(p1709);
        pozicije.add(p1710);
        pozicije.add(p1711);
        pozicije.add(p1712);
        pozicije.add(p1713);
        pozicije.add(p1714);
        pozicije.add(p1715);
        pozicije.add(p1716);
        pozicije.add(p1717);
        pozicije.add(p1718);
        pozicije.add(p1719);
        pozicije.add(p1800);
        pozicije.add(p1801);
        pozicije.add(p1802);
        pozicije.add(p1803);
        pozicije.add(p1804);
        pozicije.add(p1805);
        pozicije.add(p1806);
        pozicije.add(p1807);
        pozicije.add(p1808);
        pozicije.add(p1809);
        pozicije.add(p1810);
        pozicije.add(p1811);
        pozicije.add(p1812);
        pozicije.add(p1813);
        pozicije.add(p1814);
        pozicije.add(p1815);
        pozicije.add(p1816);
        pozicije.add(p1817);
        pozicije.add(p1818);
        pozicije.add(p1819);
        pozicije.add(p1900);
        pozicije.add(p1901);
        pozicije.add(p1902);
        pozicije.add(p1903);
        pozicije.add(p1904);
        pozicije.add(p1905);
        pozicije.add(p1906);
        pozicije.add(p1907);
        pozicije.add(p1908);
        pozicije.add(p1909);
        pozicije.add(p1910);
        pozicije.add(p1911);
        pozicije.add(p1912);
        pozicije.add(p1913);
        pozicije.add(p1914);
        pozicije.add(p1915);
        pozicije.add(p1916);
        pozicije.add(p1917);
        pozicije.add(p1918);
        pozicije.add(p1919);
		Object mapa[][] = IzvrsavacSimulacije.kompanija.getMapa();
		
		
//		---------------------- azuriranje staze ----------------------
		for(int z = 0; z < 20; z++) {
			int i = z;
			Thread tPozicije = new Thread(() -> {
				while(true) {
						for(int j = 0; j < 20; j++) {
							int k = i * 20 + j;
							if(mapa[i][j] instanceof ElektricniAutomobil) {
								Platform.runLater(() -> {
									pozicije.get(k).setImage(slikaAuto);
								});
							}
							else if(mapa[i][j] instanceof ElektricniBicikl) {
								Platform.runLater(() -> {
									pozicije.get(k).setImage(slikaBiciklo);
								});
							}
							else if(mapa[i][j] instanceof ElektricniTrotinet) {
								Platform.runLater(() -> {
									pozicije.get(k).setImage(slikaTrotinet);
								});
							}
							else {
								Platform.runLater(() -> {
									pozicije.get(k).setCache(false);
									pozicije.get(k).setImage(null);
								});
							}
						}
					
					try {
						Thread.sleep(50);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			tPozicije.setDaemon(true);
			tPozicije.start();
		}


		
		
		// ---------------------- azuriranje datuma i vremena ----------------------	
		DateTimeFormatter formatterDatum = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateTimeFormatter formatterVrijeme = DateTimeFormatter.ofPattern("HH:mm");

        Thread tDatum = new Thread(() -> {
        	LocalDateTime prethodnoVrijeme = null;
            while (true) {
                LocalDateTime datumVrijeme = IzvrsavacSimulacije.kompanija.getTrenutniDatumVrijeme();
                while(datumVrijeme != null) {
                	String formatiraniDatum = datumVrijeme.toLocalDate().format(formatterDatum);
                	String formatiranoVrijeme = datumVrijeme.toLocalTime().format(formatterVrijeme);
                	if(!datumVrijeme.equals(prethodnoVrijeme)) {
                		Platform.runLater(() -> {
                			datum.setText(formatiraniDatum);
                			vrijeme.setText(formatiranoVrijeme);
                		});
                	}
                	prethodnoVrijeme = datumVrijeme;
                	datumVrijeme = IzvrsavacSimulacije.kompanija.getTrenutniDatumVrijeme();
                }
                try {
                	Thread.sleep(500); 
                } catch (InterruptedException e) {
                	e.printStackTrace();
                }
            }
        });
        tDatum.setDaemon(true);
        tDatum.start();

        
        
        Thread tPrikazDugmadi = new Thread(() ->  {
        	while(IzvrsavacSimulacije.kompanija.getDaLiJeKrajSimulacije() == false) {
        		try {
        			Thread.sleep(50);
        		}catch(InterruptedException e) {
        			e.printStackTrace();
        		}
        	}
        	Platform.runLater(() -> {
        		rezultatiPoslovanjaPrikazButton.setDisable(false);
        		kvaroviPrikazButton.setDisable(false);
        	});
        });
        tPrikazDugmadi.setDaemon(true);
        tPrikazDugmadi.start();
	
	

//	
	}
	
}
