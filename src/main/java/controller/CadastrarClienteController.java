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
    RenderizarView tela= new RenderizarView();
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
        
    	if(	nome != null &&
    		cpf != null &&
    		endereco != null &&
    		nascimento != null
    	) {
            cliente= new Cliente(cpf, nome, telefone, endereco, email, nascimento);
        
	        if(dadosValidos(cliente)) {
	            clienteDAO= new ClienteDAO();
	            try {
	            	clienteDAO.inserir(cliente);
	            	
	            	tela.criarMensagemSuccess("Cliente cadastrado no sistema!");
	            } catch(SQLException ex) {
	            	tela.criarMensagemError(ex.getMessage());
	            }
	        }
    	} else {
    		tela.criarMensagemError("Por favor, preencha os campos em branco!");
    	}
    }
    
    public boolean dadosValidos(Cliente cliente) {
    	String errorMessage= "";
    	
        if(!ValidarDados.validaTamanho(cliente.getNome(), 0, 60)) {
        	errorMessage+= "Nome muito comprido.\n";
        }
        if(!ValidarDados.validaCpf(cliente.getCpf())) {
        	errorMessage+= "CPF inválido.\n";
        }
        if(!ValidarDados.validaTamanho(cliente.getEndereco(), 0, 80)) {
        	errorMessage+= "Erro no endereço. Por favor, corrija.\n";
        }
        if(cliente.getNascimento() == null) {
        	errorMessage+= "Data de nascimento não inserida.";
        }
        if (errorMessage.length() == 0) {
            return true;
        }
        
        tela.criarMensagemError(errorMessage);
        
        return false;
    }
}
