package controller;

import application.Main;

import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import model.Produto;
import modeldao.ProdutoDAO;
import utils.RenderizarView;
import utils.ValidarDados;

public class CadastrarProdutoController {
    RenderizarView tela= new RenderizarView();
    private Produto produto;
    private ProdutoDAO produtoDAO;

    @FXML
    private TextField nomeprodcad;

    @FXML
    private TextArea descprodcad;
   
    @FXML
    private TextField qtdminprodcad;

    @FXML
    private TextField marcaprodcad;

    @FXML
    private TextField qtdatualprodcad;
    
    @FXML
    private TextField precoprodcad;

    public void onActionBack() throws IOException {
        tela.criarTela("/view/MenuView.fxml", Main.MenuView);
        Main.CadastrarProdutoView.close();
    }
    
    public void onActionCadastrarProduto() {
        
        if(	!nomeprodcad.getText().isEmpty() &&
			!marcaprodcad.getText().isEmpty() &&
			!qtdminprodcad.getText().isEmpty() &&
			!precoprodcad.getText().isEmpty() &&
			!qtdatualprodcad.getText().isEmpty()
    	) {	
        	int quantidadeMinima= 0;
        	int quantidadeAtual= 0;
        	double preco= 0;
    		
        	try {quantidadeMinima= Integer.parseInt(qtdminprodcad.getText());} catch(Exception e) { }
    		try {quantidadeAtual= Integer.parseInt(qtdatualprodcad.getText());} catch(Exception e) { }
    		try { System.out.println(precoprodcad.getText()); preco= Double.parseDouble(precoprodcad.getText());} catch(Exception e) { }
            
    		produto= new Produto(nomeprodcad.getText(),
            		marcaprodcad.getText(),
            		quantidadeMinima,
            		quantidadeAtual,
            		preco
            );

            if(!descprodcad.getText().isEmpty())
            	produto.setDescricao(descprodcad.getText());
            
	        if(dadosValidos(produto)) {
	            produtoDAO= new ProdutoDAO();
	            try {
	            	produtoDAO.inserir(produto);
	            	
	            	tela.criarMensagemConfirmation("Produto cadastrado no sistema!");
	            } catch(SQLException ex) {
	            	tela.criarMensagemError(ex.getMessage());
	            }
	        }
    	} else {
    		tela.criarMensagemError("Por favor, preencha os campos em branco!");
    	}
    }
    
    public boolean dadosValidos(Produto produto) {
    	String errorMessage= "";
    	
        if(!ValidarDados.validaTamanho(produto.getNome(), 0, 60)) {
        	errorMessage+= "Nome muito comprido.\n";
        }
        if(!ValidarDados.validaTamanho(produto.getMarca(), 0, 25)) {
        	errorMessage+= "Descricao muito comprida.\n";
        }
        if(produto.getQuantidadeAtual() <= 0) {
        	errorMessage+= "Insira um valor numérico positivo maior do que zero na quantidade atual.\n";
        }
        if(produto.getQuantidadeMinima() <= 0) {
        	errorMessage+= "Insira um valor numérico positivo maior do que zero na quantidade mínima.\n";
        }
        if(produto.getQuantidadeAtual() < produto.getQuantidadeMinima()) {
        	errorMessage+= "Quantidade atual menor do que quantidade mínima.\n";
        }
        if(produto.getPreco() <= 0) {
        	errorMessage+= "Insira um preço numérico maior do que 0.";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        }
        
        tela.criarMensagemError(errorMessage);
        
        return false;
    }
}
