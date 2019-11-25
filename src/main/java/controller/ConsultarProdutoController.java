package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Cliente;
import model.Produto;
import modeldao.ClienteDAO;
import modeldao.ProdutoDAO;
import utils.RenderizarView;

public class ConsultarProdutoController implements Initializable {
    RenderizarView tela;
    
    List<Produto> produtos;
    ObservableList<Produto> produtosObs;
    ProdutoDAO produtoDao;
	
	@FXML
	private TableView<Produto> tableconcprod;
	
	@FXML
	private TableColumn<Produto, Integer> idtableconprod;
	@FXML
	private TableColumn<Produto, String> nometableconprod;
	@FXML
	private TableColumn<Produto, String> marcatableconprod;
	@FXML
	private TableColumn<Produto, String> desctableconprod;
	@FXML
	private TableColumn<Produto, Integer> qmintableconprod;
	@FXML
	private TableColumn<Produto, Integer> qatualtableconprod;
	@FXML
	private TableColumn<Produto, Double> precotableconprod;
	
	public void onActionBack() throws IOException {
        tela= new RenderizarView();
        tela.criarTela("/view/MenuView.fxml", Main.MenuView);
        Main.ConsultarProdutoView.close();
    }
	
	public void carregarClientes() throws SQLException {
    	try {
    		idtableconprod.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("produtoId"));
    		nometableconprod.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
    		marcatableconprod.setCellValueFactory(new PropertyValueFactory<Produto, String>("marca"));
    		desctableconprod.setCellValueFactory(new PropertyValueFactory<Produto, String>("descriaco"));
    		qmintableconprod.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidadeMinima"));
    		qatualtableconprod.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidadeAtual"));
    		precotableconprod.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
	    	
	    	produtoDao= new ProdutoDAO();

	    	produtos= produtoDao.carregar();
	    	produtosObs= FXCollections.observableArrayList(produtos);
	    	tableconcprod.setItems(produtosObs);
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
