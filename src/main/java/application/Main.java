/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Erick
 */
public class Main extends Application {
    Tela tela;
    
    public static Stage MainMenu = new Stage();
    public static Stage CadastroCliente = new Stage();
    
    @Override
    public void start(Stage stage) throws IOException {
        tela= new Tela();
       tela.criarTela("/fxml/MainMenu.fxml", MainMenu);
    }
    
    public static void main(String[] args) {
        launch(args);        
    }
}
