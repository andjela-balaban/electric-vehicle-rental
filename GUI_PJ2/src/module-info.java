module GUI_PJ2 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires PROJEKTNI_ZADATAK_2024;
	
	opens application to javafx.graphics, javafx.fxml;
}
