import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 38307220306 on 29.01.2016.
 */
public class PalliMang extends Application{
    //ArrayList pallid;
    //static int JUHUSLIK(int max, int min){ return ((int) (Math.random()*(max - min))) + min; }
    Pane raam = new Pane();
    @Override
    public void start(Stage primaryStage) throws Exception {
        //BorderPane root = new BorderPane();


       ArrayList<Pall> pallid = new ArrayList<>();
        int i = 0;
        test:
            while (pallid.size()<20) {
                System.out.println(i);

                pallid.add(i, new Pall());
                for (int j = 0; j < pallid.size(); j++) {
                    if (i != j) {
                        //System.out.println(pallid.indexOf(i));
                        if (pallid.get(i).getBoundsInParent().intersects(pallid.get(j).getBoundsInParent())) {
                            System.out.println(pallid.get(j));
                            pallid.remove(pallid.get(i));
                            continue test;
                            //pallid.get(j).setFill(Color.RED);
                            //pallid.add(j, new Pall());
                            //System.out.println("kass");
                        }
                    }
                }
                i++;
            }




        raam.getChildren().addAll(pallid);
//        for (Pall pall: pallid) {
//            if (pall)  {
//                System.out.println("COLL");
//            }
//        }

        Scene scene = new Scene(raam, 1000, 800);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    if (event.getTarget() instanceof Pall) {
                        System.out.println(((Pall) event.getTarget()).getNumber());
                        //System.out.println(((Pall) event.getTarget()).
                        System.out.println("Raadius on " +((Pall) event.getTarget()).getRaadius());
                    }
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                    if (event.getTarget() instanceof Pall) {
                        System.out.println(pallid.size());
                        eemaldaPall(event, pallid);
                        System.out.println(pallid.size());
//                        for (Pall pall: pallid) {
//                            //pall.setRadius(pallid.indexOf(pall));
//                            pall.setRadius(Pall.JUHUSLIK(60, 10));
//
//                        }
                    }
                }
            }
        });
        //Collections.sort(pallid);

        for (Pall pall: pallid) {
            System.out.println(pallid.indexOf(pall) + " " + pall.getRaadius());
        }

        primaryStage.setTitle("Pallid");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void eemaldaPall(MouseEvent event, ArrayList pallid) {
        raam.getChildren().remove(event.getTarget());
        pallid.remove(event.getTarget());
    }

}
