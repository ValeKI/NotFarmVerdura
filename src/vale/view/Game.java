package vale.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import vale.logic.Cibo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game {

    HashMap<String,Cibo> cibi = new HashMap<String, Cibo>();
    private boolean endGame = false;
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (!endGame)
                nuoveRichieste();
        }
    });

    Random r = new Random();
    Object[] values;


    Cibo c1 = null;
    Cibo c2 = null;
    Cibo c3 = null;

    Cibo scelta = null;

    Cibo cp1 = null;
    Cibo cp2 = null;
    Cibo cp3 = null;


    public void initialize()
    {
        t.start();

        cibi.put(Cibo.ANANAS,new Cibo(Cibo.ANANAS));
        cibi.put(Cibo.BISTECCA,new Cibo(Cibo.BISTECCA));
        cibi.put(Cibo.CIAMBELLA,new Cibo(Cibo.CIAMBELLA));
        cibi.put(Cibo.CILIEGIA,new Cibo(Cibo.CILIEGIA));
        cibi.put(Cibo.CIOCCOLATO,new Cibo(Cibo.CIOCCOLATO));

        cibi.put(Cibo.COLA,new Cibo(Cibo.COLA));
        cibi.put(Cibo.COLAZIONESALATA,new Cibo(Cibo.COLAZIONESALATA));
        cibi.put(Cibo.CROSTATA,new Cibo(Cibo.CROSTATA));
        cibi.put(Cibo.FORMAGGIO,new Cibo(Cibo.FORMAGGIO));
        cibi.put(Cibo.GAMBERIFRITTI,new Cibo(Cibo.GAMBERIFRITTI));

        cibi.put(Cibo.HOTDOG,new Cibo(Cibo.HOTDOG));
        cibi.put(Cibo.INSALATA,new Cibo(Cibo.INSALATA));
        cibi.put(Cibo.KIWI,new Cibo(Cibo.KIWI));
        cibi.put(Cibo.LATTE,new Cibo(Cibo.LATTE));
        cibi.put(Cibo.LECCALECCA,new Cibo(Cibo.LECCALECCA));

        cibi.put(Cibo.LIMONE,new Cibo(Cibo.LIMONE));
        cibi.put(Cibo.MELA,new Cibo(Cibo.MELA));
        cibi.put(Cibo.PANCAKE,new Cibo(Cibo.PANCAKE));
        cibi.put(Cibo.PANE,new Cibo(Cibo.PANE));
        cibi.put(Cibo.PANINO,new Cibo(Cibo.PANINO));

        cibi.put(Cibo.PASTA,new Cibo(Cibo.PASTA));
        cibi.put(Cibo.PERA,new Cibo(Cibo.PERA));
        cibi.put(Cibo.PESCA,new Cibo(Cibo.PESCA));
        cibi.put(Cibo.PIZZA,new Cibo(Cibo.PIZZA));
        cibi.put(Cibo.POLLO,new Cibo(Cibo.POLLO));

        cibi.put(Cibo.POPCORN,new Cibo(Cibo.POPCORN));
        cibi.put(Cibo.SPIEDINO,new Cibo(Cibo.SPIEDINO));
        cibi.put(Cibo.SUSHI,new Cibo(Cibo.SUSHI));
        cibi.put(Cibo.THE,new Cibo(Cibo.THE));
        cibi.put(Cibo.TORTA,new Cibo(Cibo.TORTA));

        values = cibi.keySet().toArray();

        c1 = cibi.get((String) values[r.nextInt(values.length)]);
        c2 = cibi.get((String) values[r.nextInt(values.length)]);
        c3 = cibi.get((String) values[r.nextInt(values.length)]);

        mainLabel.setText(
                " - " + c1.toString() + "\n" + " - " + c2.toString() + "\n" + " - " + c3.toString()
        );
    }

    public void nuoveRichieste() {
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (c1 != null && c2 != null && c3 != null &&
                cp1 != null && cp2 != null && cp3 != null &&
                c1.equals(cp1) && c2.equals(cp2) && c3.equals(cp3)) {

            c1 = cibi.get((String) values[r.nextInt(values.length)]);
            c2 = cibi.get((String) values[r.nextInt(values.length)]);
            c3 = cibi.get((String) values[r.nextInt(values.length)]);

            plate1.setImage(null);
            plate2.setImage(null);
            plate3.setImage(null);

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    mainLabel.setText(
                            "- " + c1.toString() + "\n" + "- " + c2.toString() + "\n" + "- " + c3.toString()
                    );
                }
            });

            character.setImage(new Image("file:/home/vale/intellijProjects/FarmVerdure2/out/production/FarmVerdure2/vale/view/fxml/img/c0" + (r.nextInt(5) + 1) + ".png"));
        }
    }



    @FXML
    public ImageView plate1;

    @FXML
    public ImageView plate2;

    @FXML
    public ImageView plate3;

    @FXML
    public ImageView character;

    @FXML
    public Label mainLabel;

    @FXML
    public void onPlate1(MouseEvent event) {
        if(scelta != null) {
            try {
                cp1 = scelta.clone();
                plate1.setImage(cp1.getImage());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onPlate2(MouseEvent event) {
        if(scelta != null) {
            try {
                cp2 = scelta.clone();
                plate2.setImage(cp2.getImage());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void onPlate3(MouseEvent event) {
        if(scelta != null) {
            try {
                cp3 = scelta.clone();
                plate3.setImage(cp3.getImage());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }


    @FXML
    public void OnAnanas(MouseEvent event) {
        scelta = cibi.get(Cibo.ANANAS);
    }

    @FXML
    public void OnBistecca(MouseEvent event) {
        scelta = cibi.get(Cibo.BISTECCA);

    }

    @FXML
    public void OnCiambella(MouseEvent event) {
        scelta = cibi.get(Cibo.CIAMBELLA);
    }

    @FXML
    public void OnCiliegia(MouseEvent event) {
        scelta = cibi.get(Cibo.CILIEGIA);
    }

    @FXML
    public void OnCioccolata(MouseEvent event) {
        scelta = cibi.get(Cibo.CIOCCOLATO);
    }

    @FXML
    public void OnCola(MouseEvent event) {
        scelta = cibi.get(Cibo.COLA);
    }


    @FXML
    public void OnColazioneSalata(MouseEvent event) {
        scelta = cibi.get(Cibo.COLAZIONESALATA);
    }

    @FXML
    public void OnCrostata(MouseEvent event) {
        scelta = cibi.get(Cibo.CROSTATA);
    }

    @FXML
    public void OnFormaggio(MouseEvent event) {
        scelta = cibi.get(Cibo.FORMAGGIO);
    }

    @FXML
    public void OnGamberiFritti(MouseEvent event) {
        scelta = cibi.get(Cibo.GAMBERIFRITTI);
    }

    @FXML
    public void OnHotdog(MouseEvent event) {
        scelta = cibi.get(Cibo.HOTDOG);
    }

    @FXML
    public void OnInsalata(MouseEvent event) {
        scelta = cibi.get(Cibo.INSALATA);
    }

    @FXML
    public void OnKiwi(MouseEvent event) {
        scelta = cibi.get(Cibo.KIWI);
    }

    @FXML
    public void OnLatte(MouseEvent event) {
        scelta = cibi.get(Cibo.LATTE);
    }

    @FXML
    public void OnLeccalecca(MouseEvent event) {
        scelta = cibi.get(Cibo.LECCALECCA);
    }

    @FXML
    public void OnLimone(MouseEvent event) {
        scelta = cibi.get(Cibo.LIMONE);
    }


    @FXML
    public void OnMela(MouseEvent event) {
        scelta = cibi.get(Cibo.MELA);
    }

    @FXML
    public void OnPancake(MouseEvent event) {
        scelta = cibi.get(Cibo.PANCAKE);
    }

    @FXML
    public void OnPane(MouseEvent event) {
        scelta = cibi.get(Cibo.PANE);
    }

    @FXML
    public void OnPanino(MouseEvent event) {
        scelta = cibi.get(Cibo.PANINO);
    }

    @FXML
    public void OnPasta(MouseEvent event) {
        scelta = cibi.get(Cibo.PASTA);
    }

    @FXML
    public void OnPera(MouseEvent event) {
        scelta = cibi.get(Cibo.PERA);
    }

    @FXML
    public void OnPesca(MouseEvent event) {
        scelta = cibi.get(Cibo.PESCA);
    }

    @FXML
    public void OnPizza(MouseEvent event) {
        scelta = cibi.get(Cibo.PIZZA);
    }

    @FXML
    public void OnPollo(MouseEvent event) {
        scelta = cibi.get(Cibo.POLLO);
    }

    @FXML
    public void OnPopcorn(MouseEvent event) {
        scelta = cibi.get(Cibo.POPCORN);
    }

    @FXML
    public void OnSpiedino(MouseEvent event) {
        scelta = cibi.get(Cibo.SPIEDINO);
    }

    @FXML
    public void OnSushi(MouseEvent event) {
        scelta = cibi.get(Cibo.SUSHI);
    }

    @FXML
    public void OnThe(MouseEvent event) {
        scelta = cibi.get(Cibo.THE);
    }

    @FXML
    public void OnTorta(MouseEvent event) {
        scelta = cibi.get(Cibo.TORTA);
    }

    @FXML
    public void OnUva(MouseEvent event) {
        scelta = cibi.get(Cibo.UVA);
    }

    @FXML
    public void tornaAlMenu(ActionEvent event) {
        endGame = true;
        Main.getInstance().replaceSceneContent("menu.fxml");
    }
}
