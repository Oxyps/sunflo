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
    RenderizarView tela= new RenderizarView();;
    private Cliente cliente;
    private ClienteDAO clienteDAO;
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date nascimento;
    
    @FXML
    private Button back;
    
    @FXML
    private Label cadclilbl;

    @FXML
    private Button cadclibttn;
    
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
        
    	if(	!txtFieldNome.getText().isEmpty() &&
            !txtFieldCpf.getText().isEmpty() &&
            !txtFieldEndereco.getText().isEmpty() &&
            datePickerNascimento.getValue() != null
    	) {
            
            cliente= new Cliente(txtFieldCpf.getText(),
            		txtFieldNome.getText(),
            		txtFieldEndereco.getText(),
            		Date.valueOf(datePickerNascimento.getValue())
            );
            if(!txtFieldEmail.getText().isEmpty())
            	cliente.setEmail(txtFieldEmail.getText());
            if(!txtFieldTelefone.getText().isEmpty())
            	cliente.setEmail(txtFieldTelefone.getText());
        
	        if(dadosValidos(cliente)) {
	            clienteDAO= new ClienteDAO();
	            try {
	            	clienteDAO.inserir(cliente);
	            	
	            	tela.criarMensagemConfirmation("Cliente cadastrado no sistema!");
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
        if(cliente.getEmail() != null) {
        	if(!ValidarDados.validaTamanho(cliente.getEmail(), 0, 60))
        		errorMessage+= "Erro no email.\n";
        }
        if(cliente.getTelefone() != null) {
        	if(!ValidarDados.validaTamanho(cliente.getTelefone(), 0, 11))
        		errorMessage+= "Erro no telefone.\n";
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
