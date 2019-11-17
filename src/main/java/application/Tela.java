/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author milen
 */
public class Tela {
    public void criarTela(String caminhoTela, Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(caminhoTela)); 
        Scene scene = new Scene(root, 1366, 700);
        
        stage.setScene(scene);
        stage.setTitle("Sunfl�");
	stage.getIcons().add(new Image("/imagens/Ativo 12.png"));
        stage.setResizable(false);
        
        stage.show();
    }
}
