package controller;

import application.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import modeldao.ClienteDAO;
import utils.RenderizarView;
import utils.ValidarDados;

public class AlterarClienteController implements Initializable{
    RenderizarView tela= new RenderizarView();

    List<Cliente> clientes;
    ObservableList<Cliente> clientesObs;
    ClienteDAO clienteDAO= new ClienteDAO();
    
    @FXML
    private TableView<Cliente> tableClientes;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteNome;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteCpf;
    
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
    
    @FXML
    private Button btnAlterarCliente;

    public void carregarClientes() throws SQLException {
        tableClienteNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
        tableClienteCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
    	
    	clientes= clienteDAO.carregar();
    	clientesObs= FXCollections.observableArrayList(clientes);
    	tableClientes.setItems(clientesObs);
    }

	public void initialize(URL location, ResourceBundle resources) {
		try {
			carregarClientes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tableClientes.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Cliente>() {
					public void changed(ObservableValue<? extends Cliente> observable, Cliente oldValue, Cliente newValue) {
						if(newValue != null) {
							txtFieldNome.setText(newValue.getNome());
							txtFieldEmail.setText(newValue.getEmail());
							txtFieldEndereco.setText(newValue.getEndereco());
							txtFieldTelefone.setText(newValue.getTelefone());
							datePickerNascimento.setValue(newValue.getNascimento().toLocalDate());
						}
					}
				}
        );
	}
    
    public void onActionBack() throws IOException {
        tela.criarTela("/view/MenuView.fxml", Main.MenuView);
        Main.AlterarClienteView.close();
    }
    
    public void onActionAlterarCliente() throws IOException, SQLException {
		Cliente clienteAntigo= tableClientes.getSelectionModel().getSelectedItem();
		
		if(btnAlterarCliente.isArmed() && clienteAntigo != null) {
    		Cliente clienteNovo= new Cliente(
    				clienteAntigo.getCpf(),
    				txtFieldNome.getText(),
    				txtFieldEndereco.getText(),
    				Date.valueOf(datePickerNascimento.getValue())
    	    );
    		
    		if(txtFieldTelefone.getText() != null)
    			clienteNovo.setTelefone(txtFieldTelefone.getText());
    		if(txtFieldEmail.getText() != null)
    			clienteNovo.setEmail(txtFieldEmail.getText());
    		
    		if(dadosValidos(clienteNovo)) {
	    		try {
	    			clienteDAO.alterar(clienteNovo);
	    			
	    			tela.criarMensagemConfirmation("Cliente alterado com sucesso!");
	    		} catch(SQLException ex) {
	    			tela.criarMensagemError(ex.getMessage());
	    		}
    		}
    	} else {
    		tela.criarMensagemError("Por favor, selecione um cliente para ser alterado!");
    	}
    }
    
    public boolean dadosValidos(Cliente cliente) {
    	String errorMessage= "";
    	
        if(!ValidarDados.validaTamanho(cliente.getNome(), 0, 60)) {
        	errorMessage+= "Erro no nome, por favor corrija.\n";
        }
        if(!ValidarDados.validaCpf(cliente.getCpf())) {
        	errorMessage+= "CPF inválido.\n";
        }
        if(!ValidarDados.validaTamanho(cliente.getEndereco(), 0, 80)) {
        	errorMessage+= "Erro no endereço, por favor corrija.\n";
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
