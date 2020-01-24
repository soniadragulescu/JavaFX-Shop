package sample;

import domain.Aquisition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import repositories.AquisitionRepo;
import repositories.ClientRepo;
import repositories.StoreRepo;
import services.FilterService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ClientRepo clientRepo=new ClientRepo("C:\\Users\\sonia\\IdeaProjects\\MAP_magazine\\src\\data\\clients.txt");
        StoreRepo storeRepo=new StoreRepo("C:\\Users\\sonia\\IdeaProjects\\MAP_magazine\\src\\data\\stores.txt");
        AquisitionRepo aquisitionRepo=new AquisitionRepo("C:\\Users\\sonia\\IdeaProjects\\MAP_magazine\\src\\data\\aquisitions.txt",clientRepo,storeRepo);
        FilterService service=new FilterService(clientRepo,storeRepo,aquisitionRepo);

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root=loader.load();

        Controller controller=loader.getController();
        controller.setService(service);

        primaryStage.setTitle("MAGAZINE");
        primaryStage.setScene(new Scene(root, 650, 520));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        /*ClientRepo clientRepo=new ClientRepo("C:\\Users\\sonia\\IdeaProjects\\MAP_magazine\\src\\data\\clients.txt");
        StoreRepo storeRepo=new StoreRepo("C:\\Users\\sonia\\IdeaProjects\\MAP_magazine\\src\\data\\stores.txt");
        AquisitionRepo aquisitionRepo=new AquisitionRepo("C:\\Users\\sonia\\IdeaProjects\\MAP_magazine\\src\\data\\aquisitions.txt",clientRepo,storeRepo);
        FilterService service=new FilterService(clientRepo,storeRepo,aquisitionRepo);
        System.out.println("interval varste 18-20");
        service.clientiVarstaInterval(18,20).forEach(x-> System.out.println(x));
        System.out.println("sex predominant magazin");
        service.sexPredominantMagazin().forEach(x-> System.out.println(x));
        System.out.println("pret mediu pe categorie:");
        service.mediePeCategorie().forEach(x-> System.out.println(x));
        System.out.println("procentaj pe categorie:");
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String start="03/03/1999 06:00", end="20/05/2021 23:59";
        service.procentajeCategorii(LocalDateTime.parse(start,pattern),LocalDateTime.parse(end,pattern)).forEach(x-> System.out.println(x.getCategory().toString()+" "+x.getProcentaj()));*/
    }
}
