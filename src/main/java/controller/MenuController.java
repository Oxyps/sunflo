package controller;

import application.Main;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import application.Tela;

public class MenuController {
    Tela tela;
    
    @FXML
    private BorderPane mainbgborderp;

    @FXML
    private TabPane tabsmenu;

    @FXML
    private Tab agendatab;

    @FXML
    private TabPane subtabmenu;

    @FXML
    private GridPane gridconsultar;

    @FXML
    private DatePicker dateagendar1;

    @FXML
    private Accordion acrdnhorasagendar1;

    @FXML
    private TitledPane hora10;

    @FXML
    private TableColumn<?, ?> horatableserv;

    @FXML
    private TableColumn<?, ?> horatablefunc;

    @FXML
    private TableColumn<?, ?> horatablecli;

    @FXML
    private TitledPane hora101;

    @FXML
    private TableColumn<?, ?> horatableserv1;

    @FXML
    private TableColumn<?, ?> horatablefunc1;

    @FXML
    private TableColumn<?, ?> horatablecli1;

    @FXML
    private TitledPane hora102;

    @FXML
    private TableColumn<?, ?> horatableserv2;

    @FXML
    private TableColumn<?, ?> horatablefunc2;

    @FXML
    private TableColumn<?, ?> horatablecli2;

    @FXML
    private TitledPane hora103;

    @FXML
    private TableColumn<?, ?> horatableserv3;

    @FXML
    private TableColumn<?, ?> horatablefunc3;

    @FXML
    private TableColumn<?, ?> horatablecli3;

    @FXML
    private TitledPane hora104;

    @FXML
    private TableColumn<?, ?> horatableserv4;

    @FXML
    private TableColumn<?, ?> horatablefunc4;

    @FXML
    private TableColumn<?, ?> horatablecli4;

    @FXML
    private TitledPane hora105;

    @FXML
    private TableColumn<?, ?> horatableserv5;

    @FXML
    private TableColumn<?, ?> horatablefunc5;

    @FXML
    private TableColumn<?, ?> horatablecli5;

    @FXML
    private TitledPane hora106;

    @FXML
    private TableColumn<?, ?> horatableserv6;

    @FXML
    private TableColumn<?, ?> horatablefunc6;

    @FXML
    private TableColumn<?, ?> horatablecli6;

    @FXML
    private TitledPane hora107;

    @FXML
    private TableColumn<?, ?> horatableserv7;

    @FXML
    private TableColumn<?, ?> horatablefunc7;

    @FXML
    private TableColumn<?, ?> horatablecli7;

    @FXML
    private TitledPane hora108;

    @FXML
    private TableColumn<?, ?> horatableserv8;

    @FXML
    private TableColumn<?, ?> horatablefunc8;

    @FXML
    private TableColumn<?, ?> horatablecli8;

    @FXML
    private GridPane gridagendar;

    @FXML
    private DatePicker dateagendar;

    @FXML
    private Accordion acrdnhorasagendar;

    @FXML
    private TitledPane hora;

    @FXML
    private GridPane gridhora;

    @FXML
    private ChoiceBox<?> chserv1;

    @FXML
    private ChoiceBox<?> chfunc1;

    @FXML
    private ChoiceBox<?> chcli1;

    @FXML
    private Button agendarbttn1;

    @FXML
    private ChoiceBox<?> chserv19;

    @FXML
    private TitledPane hora1;

    @FXML
    private GridPane gridhora1;

    @FXML
    private ChoiceBox<?> chserv11;

    @FXML
    private ChoiceBox<?> chfunc11;

    @FXML
    private ChoiceBox<?> chcli11;

    @FXML
    private Button agendarbttn11;

    @FXML
    private ChoiceBox<?> chserv191;

    @FXML
    private TitledPane hora2;

    @FXML
    private GridPane gridhora2;

    @FXML
    private ChoiceBox<?> chserv12;

    @FXML
    private ChoiceBox<?> chfunc12;

    @FXML
    private ChoiceBox<?> chcli12;

    @FXML
    private Button agendarbttn12;

    @FXML
    private ChoiceBox<?> chserv192;

    @FXML
    private TitledPane hora3;

    @FXML
    private GridPane gridhora3;

    @FXML
    private ChoiceBox<?> chserv13;

    @FXML
    private ChoiceBox<?> chfunc13;

    @FXML
    private ChoiceBox<?> chcli13;

    @FXML
    private Button agendarbttn13;

    @FXML
    private ChoiceBox<?> chserv193;

    @FXML
    private TitledPane hora4;

    @FXML
    private GridPane gridhora4;

    @FXML
    private ChoiceBox<?> chserv14;

    @FXML
    private ChoiceBox<?> chfunc14;

    @FXML
    private ChoiceBox<?> chcli14;

    @FXML
    private Button agendarbttn14;

    @FXML
    private ChoiceBox<?> chserv194;

    @FXML
    private TitledPane hora5;

    @FXML
    private GridPane gridhora5;

    @FXML
    private ChoiceBox<?> chserv15;

    @FXML
    private ChoiceBox<?> chfunc15;

    @FXML
    private ChoiceBox<?> chcli15;

    @FXML
    private Button agendarbttn15;

    @FXML
    private ChoiceBox<?> chserv195;

    @FXML
    private TitledPane hora6;

    @FXML
    private GridPane gridhora6;

    @FXML
    private ChoiceBox<?> chserv16;

    @FXML
    private ChoiceBox<?> chfunc16;

    @FXML
    private ChoiceBox<?> chcli16;

    @FXML
    private Button agendarbttn16;

    @FXML
    private ChoiceBox<?> chserv196;

    @FXML
    private TitledPane hora7;

    @FXML
    private GridPane gridhora7;

    @FXML
    private ChoiceBox<?> chserv17;

    @FXML
    private ChoiceBox<?> chfunc17;

    @FXML
    private ChoiceBox<?> chcli17;

    @FXML
    private Button agendarbttn17;

    @FXML
    private ChoiceBox<?> chserv197;

    @FXML
    private TitledPane hora8;

    @FXML
    private GridPane gridhora8;

    @FXML
    private ChoiceBox<?> chserv18;

    @FXML
    private ChoiceBox<?> chfunc18;

    @FXML
    private ChoiceBox<?> chcli18;

    @FXML
    private Button agendarbttn18;

    @FXML
    private ChoiceBox<?> chserv198;

    @FXML
    private Tab clitab;

    @FXML
    private VBox allmain1;

    @FXML
    private HBox mainbttns;

    @FXML
    private Button bttncadcli;

    @FXML
    private Button bttnconcli;

    @FXML
    private Button bttnaltcli;

    @FXML
    private HBox mainlbls;

    @FXML
    private Tab servtab;

    @FXML
    private VBox allmain2;

    @FXML
    private HBox mainbttns1;

    @FXML
    private Button bttnservcabelo;

    @FXML
    private Button bttnservunhas;

    @FXML
    private Button bttnservmaquiagem;

    @FXML
    private HBox mainlbls1;

    @FXML
    private Tab estoquetab;

    @FXML
    private VBox allmain3;

    @FXML
    private HBox mainbttns2;

    @FXML
    private Button bttncadprod;

    @FXML
    private Button bttnconestoque;

    @FXML
    private Button bttnaltprod;

    @FXML
    private HBox mainlbls2;

    @FXML
    private Tab functab;

    @FXML
    private VBox allmain4;

    @FXML
    private HBox mainbttns3;

    @FXML
    private Button bttnconfunc;

    @FXML
    private Button bttnaltfunc;

    @FXML
    private Button bttncadfunc;

    @FXML
    private HBox mainlbls3;
    
    @FXML
    private void onActionCadastrarCliente() throws IOException {
        tela= new Tela();
        tela.criarTela("/fxml/CadastroCliente.fxml", Main.CadastroCliente);
        Main.MainMenu.close();
    }
}
