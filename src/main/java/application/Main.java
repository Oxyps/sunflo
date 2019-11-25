/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import utils.RenderizarView;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author Erick
 */
public class Main extends Application {
    RenderizarView tela;
    
    public static Stage LoginView = new Stage();
    public static Stage MenuView = new Stage();
    public static Stage CadastrarClienteView = new Stage();
    public static Stage ConsultarClienteView = new Stage();
    public static Stage AlterarClienteView = new Stage();
    public static Stage CadastrarProdutoView = new Stage();
    public static Stage ConsultarProdutoView = new Stage();
    public static Stage AlterarProdutoView = new Stage();
    public static Stage CadastrarFuncionarioView = new Stage();
    public static Stage ConsultarFuncionarioView = new Stage();
    public static Stage AlterarFuncionarioView = new Stage();
    
    
    @Override
    public void start(Stage stage) throws IOException {
       tela= new RenderizarView();
       tela.criarTela("/view/MenuView.fxml", MenuView);
//       tela.criarTela("/view/LoginView.fxml", LoginView);
    }
    
    public static void main(String[] args) {
        launch(args);        
    }
}
