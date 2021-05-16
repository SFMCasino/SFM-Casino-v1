/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */
public class CasinoProfileController implements Initializable {
    
    @FXML
    void MenuCloseButton(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    
    Globalis global = new Globalis();
    
    @FXML
    void MenuFooldalGomb(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Fomenu");
    }
    
    @FXML
    void MenuKijelentkezesButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Login");
    }

    @FXML
    void MenuRouletteButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Roulette");
    }
    
    @FXML
    void MenuBJButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "BJ");
    }

    @FXML
    void MenuBoltButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Bolt");
    }

    @FXML
    void MenuCoinButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Coin");
    }

    @FXML
    void MenuDiceButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Dice");
    }

    @FXML
    void MenuFeltoltesButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Feltoltes");
    }

    @FXML
    void MenuSlotIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotI");
    }

    @FXML
    void MenuWheelButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Wheel");
    }

    @FXML
    void MenuSlotIIButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "SlotII");
    }
    
      @FXML
    private Label KNev, VNev, Nem, Datum, Mail, Bankszam, AccID, ONYP, OLJ, LGYS, LNYO, LJJ;

    @FXML
    private LineChart<String, Number> MoneyChart;

    
    List<Integer> penzmozgas = new ArrayList<>();
    
    @FXML
    private Label BankMoney,ChipMoney,getID;

    @FXML
    private Button ProfilKep;
    @FXML
    private Pane ProfileAvataros;
    
    String id = "";
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        XYChart.Series<String, Number> penzm = new XYChart.Series<String, Number>();
        XYChart.Series<String, Number> penzm2 = new XYChart.Series<String, Number>();
        penzm.setName("Nyert");
        penzm2.setName("Bukott");
        
        for (int i = 0; i < 12; i++) {
            Random random = new Random();
            int asd = (random.nextInt(50000 - (0)) + (0));
            int asd3 = (random.nextInt(50000 - (0)) + (0));
            String asd2 = "";
            switch(i){
                case 0:
                    asd2 = "Jan";
                    break;
                case 1:
                    asd2 = "Feb";
                    break;
                case 2:
                    asd2 = "Mar";
                    break;
                case 3:
                    asd2 = "Apr";
                    break;
                case 4:
                    asd2 = "Maj";
                    break;
                case 5:
                    asd2 = "Jun";
                    break;
                case 6:
                    asd2 = "Jul";
                    break;
                case 7:
                    asd2 = "Aug";
                    break;
                case 8:
                    asd2 = "Sep";
                    break;
                case 9:
                    asd2 = "Oct";
                    break;
                case 10:
                    asd2 = "Nov";
                    break;
                case 11:
                    asd2 = "Dec";
                    break;
                default:
                    break;
            }
            penzm.getData().add(new XYChart.Data<String, Number>(asd2, asd));
            penzm2.getData().add(new XYChart.Data<String, Number>(asd2, asd3));
            
        }
        MoneyChart.getData().addAll(penzm,penzm2);
        
    }

    public void Adatatvitel(String ID){
        id = ID;
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();
        for(var a : Profile){
            if(id.equals(a.getSetID())){
                getID.setText(id);
                BankMoney.setText(""+a.getJatekospenz());
                ChipMoney.setText(""+a.getJatekospenz2());
                nem = a.getJatekos_neme();
                hajszem = a.getJatekos_hajszem();
                Kellekek[0] = ""+a.getKellekek0();
                Kellekek[1] = ""+a.getKellekek1();
                Kellekek[2] = ""+a.getKellekek2();
                Kellekek[3] = ""+a.getKellekek3();
                break;
            }
        }
        ProfilKep.setStyle(global.ProfilKepCsere(nem, hajszem));
    }
    
}