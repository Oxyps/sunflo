package controller;

import java.io.IOException;
import java.sql.SQLException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Funcionario;
import modeldao.FuncionarioDAO;
import utils.RenderizarView;
import utils.ValidarDados;

public class LoginController {
    RenderizarView tela;

    @FXML
    private TextField txtFieldCpf;

    @FXML
    private PasswordField txtFieldPassword;

    @FXML
    private Label labelError;
    
    public void onActionLogin() throws IOException, SQLException {
    	String cpfDigitado= txtFieldCpf.getText();
    	String passwordDigitado= txtFieldPassword.getText();
    	
    	if (!ValidarDados.validaTamanho(passwordDigitado, 0, 12) || !ValidarDados.validaTamanho(cpfDigitado, 0, 11)) {
    		labelError.setText("Erro no preenchimento dos dados!");
        }else if(!ValidarDados.validaCpf(cpfDigitado)){
            labelError.setText("CPF inválido!");
        }else {
            Funcionario funcionario;
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            funcionario= funcionarioDAO.buscarPorCpf(cpfDigitado);
            if (funcionario == null) {
                labelError.setText("Funcionario não encontrado!");
            }else if(!funcionario.getPassword().equals(passwordDigitado))
                labelError.setText("Senha inválida!");
            else {
//                TelaLoginController.str=funcionario.getNome();
            	tela= new RenderizarView();
            	tela.criarTela("/view/MenuView.fxml", Main.MenuView);
                Main.LoginView.close();
            }
        }
		labelError.setVisible(true);
    }

}
