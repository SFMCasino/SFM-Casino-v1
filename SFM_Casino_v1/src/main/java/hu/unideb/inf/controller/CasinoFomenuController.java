package hu.unideb.inf.controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import org.hibernate.sql.ordering.antlr.OrderingSpecification;

/**
 * FXML Controller class
 *
 * @author XeroFox
 */



public class CasinoFomenuController implements Initializable {
    
    Globalis global = new Globalis();
    @FXML
    private Button ProfilKep;

    @FXML
    void MenuCloseButton(ActionEvent event){
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.close();
    }
    
    @FXML
    void MenuKijelentkezesButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Login");
    }

    @FXML
    void MenuProfileButton(ActionEvent event) throws IOException {
        global.LoadScene(event, getID.getText(), "Profile");
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

    //////////////////
    //////////////////

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;



    @FXML
    void BJPushed(ActionEvent event) {

        ButtonType foo = new ButtonType("J??t??k!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kil??p??s!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretn?? elind??tani a j??t??kot?",
                foo, bar);
        alert.setTitle("Blackjack");
        alert.setHeaderText(null);  //  header lev??tele
        alert.setGraphic(null);     //  k??p lev??tele
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);   //  m??ret fix??l??s

        alert.setContentText("Ki ne szeretn?? a gyors, egyszer?? k??rtyaj??t??koktat? Szerencs??re a Blackjackre mindk??t ??ll??t??s igaz.\n" +
                "A j??t??kos ??s az oszt?? is 2-2 lapot kap, azonban az oszt??nak csak az els?? lapja l??that??. A j??t??kosnak addig van lehet??s??ge ??j lapot k??rni, am??g a lapok ??rt??ke nem haladja meg a 21-t. Ebben az esetben automatikuson vesz??t is." +
                " Ha a j??t??kos lapjainak ??rt??ke 21, akor nyert. Ammennyiben ??gy d??nt, hogy meg??ll, de nem tal??lta meg a legjobb kezet az oszt??ra ker??l a sor. " +
                "?? is addig h??zhat, mint a j??t??kos ??s ha t??lhalad a 21-en vesz??t. Ha nincs egy??rtelm?? nyertes vagy vesztes, akkor az nyer akinek a lapok ??sszege k??zeleb ??ll a 21-hez.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "BJ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void CoinPushed(ActionEvent event) {

        ButtonType foo = new ButtonType("J??t??k!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kil??p??s!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretn?? elind??tani a j??t??kot?",
                foo, bar);
        alert.setTitle("Coin flip");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A j??t??kos tesztelheti a szerencs??j??t egy ??rme feldob??s??val. Ha eltal??lja, " +
                "hogy az ??rme melyik oldal??ra ??rkezik megdupl??zza " +
                "a p??nz??t, ha pedig rosszul tippel elveszti.\nMint ahogy a mond??s is tartja a gy??zelmi es??ly itt t??nyleg 50-50.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "Coin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void DicePushed(ActionEvent event) {
        ButtonType foo = new ButtonType("J??t??k!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kil??p??s!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretn?? elind??tani a j??t??kot?",
                foo, bar);
        alert.setTitle("Dice");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A k??vetkez?? j??t??kban 6 db egyszer?? dob??kock??t haszn??lunk ??s azok ??rt??keit vizsg??ljuk. Rengeteg lehet??s??g el??fordulhat, de minket els??sorban az ??rdekel, hogy melyik sz??m h??nyszor fordult el??.\nA k??vetkez?? le??r??s t??j??koztat a k??l??nb??z?? kombin??ci??k szorz??ir??l:\n" +
                "6 db k??l??nb??z?? kocka: 6x\n6 db egyforma kocka: 6x\n5 db egyforma kocka: 5x\n4 db egyforma kocka: 4x\n" +
                "1 db tripla ??s 1 db p??r: 3x\n2 db tripla: 2x\n1 db tripla: 1x\n3 db p??r: 2x\n2 db p??r: 1x\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "Dice");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void Slot1Pushed(ActionEvent event) {
        ButtonType foo = new ButtonType("J??t??k!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kil??p??s!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretn?? elind??tani a j??t??kot?",
                foo, bar);
        alert.setTitle("Slot I");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A Slot I egy egyszer??, p??rg??s j??t??k, ahol abban kell b??zni, hogy 3 egyforma szimb??lumot tal??ljunk. A szimb??lumok m??s-m??s ??rt??ket k??pviselnek, p??ld??ul csereszny??t p??rgetve kevesebb, m??g Genjit l??tva rengeteget nyer??nk.\nHa siker??l legal??bb egy Overwatch ikont p??rgetni nem maradunk ??res k??zzel az adott k??rben.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "SlotI");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void Slot2Pushed(ActionEvent event) {
        ButtonType foo = new ButtonType("J??t??k!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kil??p??s!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretn?? elind??tani a j??t??kot?",
                foo, bar);
        alert.setTitle("Slot II");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A Slot 2 egy v??laszthat??an 5-10 vonalon fizethet?? j??t??k. Az alap t??t vonalank??nt rak??dik meg. A j??t??k vonalank??nt balr??l jobbra fizet, amennyiben a szimb??lum megegyezik a vonalon el??tte l??v?? szimb??lummal, a leghosszabb k??t??s fizet egy vonalon.\n3 krist??lyg??mb eset??n aktiv??l??dik a b??nusz j??t??k, ahol kip??r??g egy v??letlenszer?? szimb??lum, amely a b??nuszj??t??k idej??n kiterjed a teljes t??rcs??ra ??s figyelmen k??v??l hagyja hogy maradt-e ki hely k??t??sek k??z??tt. A vill??mj??t??kkal a gyors b??nusz szerz??st val??s??thatjuk meg.\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "SlotII");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void WheelPushed(ActionEvent event) {
        ButtonType foo = new ButtonType("J??t??k!", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Kil??p??s!", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Szeretn?? elind??tani a j??t??kot?",
                foo, bar);
        alert.setTitle("Wheel");
        alert.setHeaderText(null);
        alert.setGraphic(null);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setContentText("A k??zismert szerencseker??k, ahol ny??lt \"lapokkal\" teheti pr??b??ra szerencs??j??t. A ker??k k??l??nb??z??i ter??leteihez k??l??nb??z?? nyerem??nyek tartoznak.\nVajon legk??zelebb hol fog meg??llni a b??v??s ker??k?\n\n\n");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {

            try {
                global.LoadScene(event, getID.getText(), "Wheel");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    /////////////////
    /////////////////

    @FXML
    private Label BankMoney,ChipMoney,getID;

    String id = "";
    int jatekospenz = 0;
    int jatekospenz2 = 0;
    String nem = "", hajszem = "";
    String[] Kellekek = new String[4];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        HashMap<String, Integer> map = new HashMap<>();

        for (var user : Profile ) {
            map.put(user.getUsername(),(global.getOssznyeremeny(user.getNyereseg())));
        }


        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        int i = 0;
        for (Map.Entry<String,Integer> x : result.entrySet()){
            if(i==5) break;
            pieChartData.add(new PieChart.Data(x.getKey(), x.getValue()));
            i++;
        }

        pieChart.setData(pieChartData);
        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().divide(1000)," K"
                        )
                )
        );

        ////////////////
        //  BarChart
        ///////////////

        XYChart.Series set1 = new XYChart.Series<>();

        HashMap<String, Integer> map2 = new HashMap<>();

        for (var user : Profile ) {
            map2.put(user.getUsername(),user.getLogin_db());
        }

        LinkedHashMap<String, Integer> result2 = new LinkedHashMap<>();
        map2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        i = 0;
        for (Map.Entry<String,Integer> x : result2.entrySet()){
            if(i==10) break;
            set1.getData().add(new XYChart.Data(x.getKey(),x.getValue()));
            i++;
        }

        barChart.getData().addAll(set1);
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
                jatekospenz = a.getJatekospenz();
                jatekospenz2 = a.getJatekospenz2();
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