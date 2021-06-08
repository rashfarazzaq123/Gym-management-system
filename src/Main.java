import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {

    private static MyGymManager myGymManager = new MyGymManager();

    @Override
    public void start(Stage primaryStage ) throws Exception {


        TableView tableView = new TableView();

        TableColumn<String, DefaultMember> column1 = new TableColumn<>("Membership number");
        column1.setCellValueFactory(new PropertyValueFactory<>("membershipNo"));

        TableColumn<String, DefaultMember> column2 = new TableColumn<>("Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<String, DefaultMember> column3 = new TableColumn<>("Date");
        column3.setCellValueFactory(new PropertyValueFactory<>("membershipStartDate"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);


        for (DefaultMember defaultMember : myGymManager.getmemberList()) {
            tableView.getItems().add(defaultMember);
        }

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        Scanner managingTheGym = new Scanner(System.in);
        System.out.println("hello welcome to the gym manegment system");
        System.out.println("choose  what you want from here");
        System.out.println("for add member type add ");
        System.out.println("for delete member type delete ");
        System.out.println("for sort member type sort ");
        System.out.println("for save member type save ");
        System.out.println("for print member type print ");
        System.out.println("for search member type search ");
        System.out.println("====================================================================");

        while (true) {

            System.out.println("what you want to do ?");
            String choise = managingTheGym.next();
            if (choise.equals("add")) {
                Scanner input = new Scanner(System.in);
                System.out.println("what is the member type ? D-default member/s-student/o-over60member");
                String ageType = input.next();

                if (ageType.equals("s")) {
                    System.out.println("enter your school name");
                    String schoolName = input.next();

                    System.out.println("enter the date");
                    System.out.println("enter day");
                    String day = input.next();
                    while (Integer.parseInt(day) > 30) {
                        System.out.println("invalid  number of days more than in a month");
                        System.out.println("enter day");
                        day = input.next();
                    }
                    System.out.println("enter month");
                    String month = input.next();
                    while (Integer.parseInt(month)>12) {
                        System.out.println("invalid ");
                        System.out.println("enter month");
                        month = input.next();
                    }
                    System.out.println("enter year");
                    String year = input.next();

                    Date date = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));
                    System.out.println("enter the name");
                    String name = input.next();

                    System.out.println("enter the membership number");
                    String membershipNumber = input.next();

                    StudentMember studentMember = new StudentMember(membershipNumber, name, date, schoolName);
                    myGymManager.addMember(studentMember);

                } else if (ageType.equals("o")) {

                    System.out.println("enter your age");
                    int age = input.nextInt();
                    while (age<60){
                        System.out.println("invalid");
                        System.out.println("enter your age");
                        age = input.nextInt();
                    }
                    System.out.println("enter the date");
                    System.out.println("enter day");
                    String day = input.next();
                    while (Integer.parseInt(day) > 30) {
                        System.out.println("invalid  number of days more than in a month");
                        System.out.println("enter day");
                        day = input.next();
                    }
                    System.out.println("enter month");
                    String month = input.next();
                    while (Integer.parseInt(month)>=12 ) {
                        System.out.println("invalid ");
                        System.out.println("enter month");
                        month = input.next();
                    }
                    System.out.println("enter year");
                    String year = input.next();

                    Date date = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));


                    System.out.println("enter the name");
                    String name = input.next();

                    System.out.println("enter the membership number");
                    String membershipNumber = input.next();

                    Over60Member over60Member1 = new Over60Member(membershipNumber, name, date,age);
                    myGymManager.addMember(over60Member1);

                } else {
                    System.out.println("enter the date");
                    System.out.println("enter day");
                    String day = input.next();
                    while (Integer.parseInt(day) > 30) {
                        System.out.println("invalid  number of days more than in a month");
                        System.out.println("enter day");
                        day = input.next();
                    }
                    System.out.println("enter month");
                    String month = input.next();
                    while (Integer.parseInt(month)>=12) {
                        System.out.println("invalid ");
                        System.out.println("enter month");
                        month = input.next();
                    }
                    System.out.println("enter year");
                    String year = input.next();

                    Date date = new Date(Integer.parseInt(day), Integer.parseInt(month), Integer.parseInt(year));

                    System.out.println("enter the name");
                    String name = input.next();

                    System.out.println("enter the membership number");
                    String membershipNumber = input.next();

                    DefaultMember defaultMember1 = new DefaultMember(membershipNumber, name, date);
                    myGymManager.addMember(defaultMember1);

                }

            } else if (choise.equals("delete")) {
                Scanner input = new Scanner(System.in);
                System.out.println("what is the member type ? D-default member/s-student/o-over60member");
                String ageType = input.next();
                if (ageType.equals("s")) {

                    System.out.println("enter the membership number");
                    String membershipNumber = input.next();
                    myGymManager.deleteMember(membershipNumber);

                } else if (ageType.equals("o")) {

                    System.out.println("enter the membership number");
                    String membershipNumber = input.next();
                    myGymManager.deleteMember(membershipNumber);
                } else {
                    System.out.println("enter the membership number");
                    String membershipNumber = input.next();
                    myGymManager.deleteMember(membershipNumber);
                }
            } else if (choise.equals("save")) {
                myGymManager.save();
            } else if (choise.equals("sort")) {
                myGymManager.sort();
            } else if (choise.equals("print")) {
                myGymManager.printListMember();
            } else if (choise.equals("search")) {
                launch(args);
                continue;
            }
        }
    }
}