package controller;

import application.Main;
import utils.RenderizarView;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.Cliente;
import modeldao.ClienteDAO;
import utils.ValidarDados;

public class CadastrarClienteController {
    RenderizarView tela;
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date nascimento;
    
    @FXML
    private TextField txtFieldNome;

    @FXML
    private TextField txtFieldCpf;

    @FXML
    private TextField txtFieldEndereco;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFieldTelefone;

    @FXML
    private DatePicker datePickerNascimento;

    public void onActionBack() throws IOException {
        tela= new RenderizarView();
        tela.criarTela("/view/MenuView.fxml", Main.MenuView);
        Main.CadastrarClienteView.close();
    }
    
    public void onActionCadastrarCliente() {
        nome= txtFieldNome.getText();
        cpf= txtFieldCpf.getText();
        endereco= txtFieldEndereco.getText();
        email= txtFieldEmail.getText();
        telefone= txtFieldTelefone.getText();
        nascimento= Date.valueOf(datePickerNascimento.getValue());
        
        if(validarDados()) {
            cliente= new Cliente(cpf, nome, telefone, endereco, email, nascimento);

            clienteDAO= new ClienteDAO();
            try {
            	clienteDAO.inserir(cliente);
            	
            	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Sucesso");
                alert.setHeaderText("Cliente cadastrado no sistema!");
                alert.show();
            } catch(SQLException ex) {
            	Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro inesperado ocorreu!");
                alert.setHeaderText("Algum erro ocorreu no Banco de Dados.. chame o desenvolvedor!");
                alert.show();
                
                ex.printStackTrace();
            }
        }
    }
    
    public boolean validarDados() {
    	String errorMessage= "";
    	
        if(!ValidarDados.validaTamanho(nome, 60)) {
        	errorMessage+= "Nome muito comprido.\n";
        }
        if(!ValidarDados.validaCpf(cpf)) {
        	errorMessage+= "CPF inválido.\n";
        }
        if(!ValidarDados.validaTamanho(endereco, 80)) {
        	errorMessage+= "Endereço muito comprido.\n";
        }
        if(!ValidarDados.validaTamanho(email, 60)) {
        	errorMessage+= "E-mail muito comprido.\n";
        }
        if(!ValidarDados.validaTamanho(telefone, 11)) {
        	errorMessage+= "Telefone muito comprido.\n";
        }
        if(nascimento == null) {
        	errorMessage+= "Data de nascimento não inserida.";
        }
        if (errorMessage.length() == 0) {
            return true;
        }
        
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro no cadastro do cliente");
        alert.setHeaderText("Campos inválidos, por favor, corrija...");
        alert.setContentText(errorMessage);
        alert.show();
        
        return false;
    }
}
