package controller;

import application.Main;
import application.Tela;
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
import utils.ValidacaoDados;

public class CadClienteController {
    Tela tela;
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
    private ImageView backlogo;

    @FXML
    private TextField nomecadcli;

    @FXML
    private TextField cpfcadcli;

    @FXML
    private TextField endcadcli;

    @FXML
    private TextField mailcadcli;

    @FXML
    private Label cadclilbl;

    @FXML
    private Button cadclibttn;

    @FXML
    private TextField telcadcli;

    @FXML
    private DatePicker datacadcli;

    public void onActionBack() throws IOException {
        tela= new Tela();
        tela.criarTela("/fxml/MainMenu.fxml", Main.MainMenu);
        Main.CadastroCliente.close();
    }
    
    public void onActionCadastrarCliente() {
        nome= nomecadcli.getText();
        cpf= cpfcadcli.getText();
        endereco= endcadcli.getText();
        email= mailcadcli.getText();
        telefone= telcadcli.getText();
        nascimento= Date.valueOf(datacadcli.getValue());
        
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
            }
        }
    }
    
    public boolean validarDados() {
    	String errorMessage= "";
    	
        if(!ValidacaoDados.validaTamanho(nomecadcli.getText(), 60)) {
        	errorMessage+= "Nome muito comprido.\n";
        }
        if(!ValidacaoDados.validaCpf(cpfcadcli.getText())) {
        	errorMessage+= "CPF inválido.\n";
        }
        if(!ValidacaoDados.validaTamanho(endcadcli.getText(), 80)) {
        	errorMessage+= "Endereço muito comprido.\n";
        }
        if(!ValidacaoDados.validaTamanho(mailcadcli.getText(), 60)) {
        	errorMessage+= "E-mail muito comprido.\n";
        }
        if(!ValidacaoDados.validaTamanho(telcadcli.getText(), 11)) {
        	errorMessage+= "Telefone muito comprido.\n";
        }
        if(datacadcli.getValue() == null) {
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
