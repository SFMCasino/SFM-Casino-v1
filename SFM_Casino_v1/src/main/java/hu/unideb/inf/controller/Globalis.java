/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import hu.unideb.inf.model.JpaCasinoDAO;
import hu.unideb.inf.model.User2;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author XeroFox
 */
public class Globalis {
    void LoadScene(ActionEvent event,String ID, String hova) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Casino" + hova + ".fxml"));
        Parent root = (Parent) loader.load();
        
        switch(hova){
            case "SlotII":
                CasinoSlotIIController menu1 = loader.getController();
                menu1.Adatatvitel(ID);
                break;
            case "SlotI":
                CasinoSlotIController menu2 = loader.getController();
                menu2.Adatatvitel(ID);
                break;
            case "Coin":
                CasinoCoinController menu3 = loader.getController();
                menu3.Adatatvitel(ID);
                break;
            case "Dice":
                CasinoDiceController menu4 = loader.getController();
                menu4.Adatatvitel(ID);
                break;
            case "Wheel":
                CasinoWheelController menu5 = loader.getController();
                menu5.Adatatvitel(ID);
                break;
            case "Feltoltes":
                CasinoFeltoltesController menu7 = loader.getController();
                menu7.Adatatvitel(ID);
                break;
            case "Bolt":
                CasinoBoltController menu8 = loader.getController();
                menu8.Adatatvitel(ID);
                break;
            case "Profile":
                CasinoProfileController menu9 = loader.getController();
                menu9.Adatatvitel(ID);
                break;
            case "Fomenu":
                CasinoFomenuController menu10 = loader.getController();
                menu10.Adatatvitel(ID);
                break;
            case "BJ":
                CasinoBJController menu11 = loader.getController();
                menu11.Adatatvitel(ID);
                break;
            default:
                break;
        }
        

        Scene ViewScene = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(ViewScene);
        window.show();
    }
    
    String[] checkGenderID(String nem,String haj,String szem){
        String[] genderID = {"",""};
        if(nem.equals("F??rfi")){
            genderID[0] = "0";
            switch(haj){
                case "Barna":
                    switch(szem){
                        case "Arany":
                            genderID[1] = "0";
                            break;
                        case "Barna":
                            genderID[1] = "4";
                            break;
                        case "K??k":
                            genderID[1] = "8";
                            break;
                        case "Z??ld":
                            genderID[1] = "12";
                            break;
                        default:
                            break;
                    }
                    break;
                case "Fekete":
                    switch(szem){
                        case "Arany":
                            genderID[1] = "16";
                            break;
                        case "Barna":
                            genderID[1] = "20";
                            break;
                        case "K??k":
                            genderID[1] = "24";
                            break;
                        case "Z??ld":
                            genderID[1] = "28";
                            break;
                        default:
                            break;
                    }
                    break;
                case "Sz??ke":
                    switch(szem){
                        case "Arany":
                            genderID[1] = "32";
                            break;
                        case "Barna":
                            genderID[1] = "36";
                            break;
                        case "K??k":
                            genderID[1] = "40";
                            break;
                        case "Z??ld":
                            genderID[1] = "44";
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }else if(nem.equals("N??")){
            genderID[0] = "1";
            switch(haj){
                case "Barna":
                    switch(szem){
                        case "Arany":
                            genderID[1] = "0";
                            break;
                        case "Barna":
                            genderID[1] = "4";
                            break;
                        case "K??k":
                            genderID[1] = "8";
                            break;
                        case "Z??ld":
                            genderID[1] = "12";
                            break;
                        default:
                            break;
                    }
                    break;
                case "Fekete":
                    switch(szem){
                        case "Arany":
                            genderID[1] = "16";
                            break;
                        case "Barna":
                            genderID[1] = "20";
                            break;
                        case "K??k":
                            genderID[1] = "24";
                            break;
                        case "Z??ld":
                            genderID[1] = "28";
                            break;
                        default:
                            break;
                    }
                    break;
                case "Sz??ke":
                    switch(szem){
                        case "Arany":
                            genderID[1] = "32";
                            break;
                        case "Barna":
                            genderID[1] = "36";
                            break;
                        case "K??k":
                            genderID[1] = "40";
                            break;
                        case "Z??ld":
                            genderID[1] = "44";
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        return genderID;
    }
    
    void saveData(String id, int jatekospenz, int jatekospenz2, String nem, String hajszem, String[] Kellekek){
        /*
        try(BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(System.getProperty("user.home") + File.separator + (id+".txt")))){
                    bufferedWriter2.write(jatekospenz + ":" + jatekospenz2 + ":" + nem + ":" + hajszem + ":" + Kellekek[0] + ":" + Kellekek[1] + ":" + Kellekek[2] + ":" + Kellekek[3]);
                }catch (IOException e) {
                    // Exception handling
                }*/
        JpaCasinoDAO userDAO = new JpaCasinoDAO();
        List<User2> Profile = userDAO.getUser();
        for (var felhasznalo : Profile ) {
            if (felhasznalo.getSetID().equals(id)){
                getOssznyeremeny(felhasznalo.getNyereseg());
                felhasznalo.setJatekospenz(jatekospenz);
                felhasznalo.setJatekospenz2(jatekospenz2);
                felhasznalo.setNem(nem);
                felhasznalo.setJatekos_hajszem(hajszem);
                felhasznalo.setKellekek0(Integer.parseInt(Kellekek[0]));
                felhasznalo.setKellekek1(Integer.parseInt(Kellekek[1]));
                felhasznalo.setKellekek2(Integer.parseInt(Kellekek[2]));
                felhasznalo.setKellekek3(Integer.parseInt(Kellekek[3]));
                userDAO.saveUser(felhasznalo);
                break;
            }
        }

    }

    public int getOssznyeremeny(List<Integer> nyereseg) {
        int sum = 0;
        for (var elem : nyereseg) {
            sum += elem;
        }
        return sum;
    }

    String ProfilKepCsere(String nemid, String id){
        String kep = "";
        if(nemid.equals("0")){
            switch (id){
                case "0":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Arany/1.png\")";
                    break;
                case "1":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Arany/2.png\")";
                    break;
                case "2":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Arany/3.png\")";
                    break;
                case "3":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Arany/4.png\")";
                    break;
                case "4":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Gesztenye/1.png\")";
                    break;
                case "5":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Gesztenye/2.png\")";
                    break;
                case "6":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Gesztenye/3.png\")";
                    break;
                case "7":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Gesztenye/4.png\")";
                    break;
                case "8":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/K??k/1.png\")";
                    break;
                case "9":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/K??k/2.png\")";
                    break;
                case "10":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/K??k/3.png\")";
                    break;
                case "11":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/K??k/4.png\")";
                    break;
                case "12":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Z??ld/1.png\")";
                    break;
                case "13":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Z??ld/2.png\")";
                    break;
                case "14":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Z??ld/3.png\")";
                    break;
                case "15":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Barna/Z??ld/4.png\")";
                    break;
                case "16":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Arany/1.png\")";
                    break;
                case "17":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Arany/2.png\")";
                    break;
                case "18":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Arany/3.png\")";
                    break;
                case "19":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Arany/4.png\")";
                    break;
                case "20":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Gesztenye/1.png\")";
                    break;
                case "21":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Gesztenye/2.png\")";
                    break;
                case "22":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Gesztenye/3.png\")";
                    break;
                case "23":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Gesztenye/4.png\")";
                    break;
                case "24":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/K??k/1.png\")";
                    break;
                case "25":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/K??k/2.png\")";
                    break;
                case "26":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/K??k/3.png\")";
                    break;
                case "27":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/K??k/4.png\")";
                    break;
                case "28":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Z??ld/1.png\")";
                    break;
                case "29":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Z??ld/2.png\")";
                    break;
                case "30":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Z??ld/3.png\")";
                    break;
                case "31":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Fekete/Z??ld/4.png\")";
                    break;
                case "32":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Arany/1.png\")";
                    break;
                case "33":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Arany/2.png\")";
                    break;
                case "34":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Arany/3.png\")";
                    break;
                case "35":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Arany/4.png\")";
                    break;
                case "36":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Gesztenye/1.png\")";
                    break;
                case "37":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Gesztenye/2.png\")";
                    break;
                case "38":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Gesztenye/3.png\")";
                    break;
                case "39":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Gesztenye/4.png\")";
                    break;
                case "40":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/K??k/1.png\")";
                    break;
                case "41":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/K??k/2.png\")";
                    break;
                case "42":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/K??k/3.png\")";
                    break;
                case "43":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/K??k/4.png\")";
                    break;
                case "44":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Z??ld/1.png\")";
                    break;
                case "45":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Z??ld/2.png\")";
                    break;
                case "46":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Z??ld/3.png\")";
                    break;
                case "47":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMfiu/Sz??ke/Z??ld/4.png\")";
                    break;
                default:
                    break;
            }
        }else if(nemid.equals("1")){
            switch (id){
                case "0":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Arany/1.png\")";
                    break;
                case "1":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Arany/2.png\")";
                    break;
                case "2":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Arany/3.png\")";
                    break;
                case "3":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Arany/4.png\")";
                    break;
                case "4":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Gesztenye/1.png\")";
                    break;
                case "5":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Gesztenye/2.png\")";
                    break;
                case "6":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Gesztenye/3.png\")";
                    break;
                case "7":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Gesztenye/4.png\")";
                    break;
                case "8":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/K??k/1.png\")";
                    break;
                case "9":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/K??k/2.png\")";
                    break;
                case "10":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/K??k/3.png\")";
                    break;
                case "11":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/K??k/4.png\")";
                    break;
                case "12":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Z??ld/1.png\")";
                    break;
                case "13":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Z??ld/2.png\")";
                    break;
                case "14":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Z??ld/3.png\")";
                    break;
                case "15":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Barna/Z??ld/4.png\")";
                    break;
                case "16":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Arany/1.png\")";
                    break;
                case "17":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Arany/2.png\")";
                    break;
                case "18":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Arany/3.png\")";
                    break;
                case "19":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Arany/4.png\")";
                    break;
                case "20":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Gesztenye/1.png\")";
                    break;
                case "21":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Gesztenye/2.png\")";
                    break;
                case "22":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Gesztenye/3.png\")";
                    break;
                case "23":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Gesztenye/4.png\")";
                    break;
                case "24":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/K??k/1.png\")";
                    break;
                case "25":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/K??k/2.png\")";
                    break;
                case "26":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/K??k/3.png\")";
                    break;
                case "27":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/K??k/4.png\")";
                    break;
                case "28":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Z??ld/1.png\")";
                    break;
                case "29":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Z??ld/2.png\")";
                    break;
                case "30":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Z??ld/3.png\")";
                    break;
                case "31":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Fekete/Z??ld/4.png\")";
                    break;
                case "32":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Arany/1.png\")";
                    break;
                case "33":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Arany/2.png\")";
                    break;
                case "34":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Arany/3.png\")";
                    break;
                case "35":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Arany/4.png\")";
                    break;
                case "36":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Gesztenye/1.png\")";
                    break;
                case "37":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Gesztenye/2.png\")";
                    break;
                case "38":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Gesztenye/3.png\")";
                    break;
                case "39":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Gesztenye/4.png\")";
                    break;
                case "40":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/K??k/1.png\")";
                    break;
                case "41":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/K??k/2.png\")";
                    break;
                case "42":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/K??k/3.png\")";
                    break;
                case "43":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/K??k/4.png\")";
                    break;
                case "44":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Z??ld/1.png\")";
                    break;
                case "45":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Z??ld/2.png\")";
                    break;
                case "46":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Z??ld/3.png\")";
                    break;
                case "47":
                    kep = "-fx-background-image: url(\"/Profilkepek/SFMlany/Sz??ke/Z??ld/4.png\")";
                    break;
                default:
                    break;
            }
        }
        return kep;
    }
}
