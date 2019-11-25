package controller;

import application.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import modeldao.ClienteDAO;
import utils.RenderizarView;

public class ConsultarClienteController implements Initializable {
    RenderizarView tela;
    
    List<Cliente> clientes;
    ObservableList<Cliente> clientesObs;
    ClienteDAO clienteDAO;
    
    @FXML
    private TableView<Cliente> tableClientes;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteNome;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteCpf;
    
    @FXML
    private TableColumn<Cliente, Date> tableClienteNascimento;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteTelefone;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteEndereco;
    
    @FXML
    private TableColumn<Cliente, String> tableClienteEmail;

    public void onActionBack() throws IOException {
        tela= new RenderizarView();
        tela.criarTela("/view/MenuView.fxml", Main.MenuView);
        Main.ConsultarClienteView.close();
    }
    
    public void onActionCarregarClientesPorNome() throws SQLException {
    	//fazer
    }
    
    public void carregarClientes() throws SQLException {
    	try {
	        tableClienteNome.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
	        tableClienteCpf.setCellValueFactory(new PropertyValueFactory<Cliente, String>("cpf"));
	        tableClienteNascimento.setCellValueFactory(new PropertyValueFactory<Cliente, Date>("nascimento"));
	        tableClienteTelefone.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
	        tableClienteEndereco.setCellValueFactory(new PropertyValueFactory<Cliente, String>("endereco"));
	        tableClienteEmail.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
	    	
	    	clienteDAO= new ClienteDAO();

	    	clientes= clienteDAO.carregar();
	    	clientesObs= FXCollections.observableArrayList(clientes);
	    	tableClientes.setItems(clientesObs);
	    } catch(SQLException e) {
	    	e.printStackTrace();
	    }
    }
    
    public void initialize(URL location, ResourceBundle resources) {
		try {
			carregarClientes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
