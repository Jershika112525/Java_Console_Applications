import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class WaterPosterrr extends Application {

    private ProgressBar progressBar;
    private Label progressLabel;
    private CheckBox[] tasks;

  
    public void start(Stage stage) {

        // Main poster heading
        Label goal = new Label("UN SUSTAINABLE DEVELOPMENT GOAL 06");
        goal.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        goal.setTextFill(Color.WHITE);

        Label drop = new Label("💧");
        drop.setFont(Font.font(65));

        Label title = new Label("CLEAN WATER");
        title.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 42));
        title.setTextFill(Color.WHITE);

        Label subtitle = new Label("& SANITATION FOR ALL");
        subtitle.setFont(Font.font("Arial", FontWeight.BOLD, 23));
        subtitle.setTextFill(Color.web("#B9F3FF"));

        Label slogan = new Label(
            "\"EVERY DROP COUNTS — SAVE WATER, SAVE LIFE!\""
        );
        slogan.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        slogan.setTextFill(Color.WHITE);
        slogan.setWrapText(true);

        VBox header = new VBox(8, goal, drop, title, subtitle, slogan);
        header.setAlignment(Pos.CENTER);
        header.setPadding(new Insets(25));
        header.setStyle(
            "-fx-background-color: linear-gradient(to bottom right, " +
            "#0066CC, #00B4D8, #48CAE4);" +
            "-fx-background-radius: 22;" +
            "-fx-effect: dropshadow(gaussian, #003566, 15, 0.3, 0, 7);"
        );

        // Information cards
        VBox card1 = createCard(
            "🌍  WHY WATER MATTERS",
            "• Water is essential for every living being.\n\n" +
            "• Clean water protects our health.\n\n" +
            "• Safe sanitation prevents diseases."
        );

        VBox card2 = createCard(
            "💦  SAVE EVERY DROP",
            "• Turn off taps when not in use.\n\n" +
            "• Repair leaking pipes and taps.\n\n" +
            "• Reuse water whenever possible."
        );

        HBox cards = new HBox(18, card1, card2);
        cards.setAlignment(Pos.CENTER);
        HBox.setHgrow(card1, Priority.ALWAYS);
        HBox.setHgrow(card2, Priority.ALWAYS);
        card1.setMaxWidth(Double.MAX_VALUE);
        card2.setMaxWidth(Double.MAX_VALUE);

        // Interactive water-saving checklist
        Label checklistTitle = new Label("🌱  TAKE THE WATER-SAVING PLEDGE");
        checklistTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        checklistTitle.setTextFill(Color.web("#005F99"));

        tasks = new CheckBox[] {
            new CheckBox("I will close taps properly."),
            new CheckBox("I will fix water leaks."),
            new CheckBox("I will avoid wasting drinking water.")
        };

        for (CheckBox task : tasks) {
            task.setFont(Font.font("Arial", 14));
            task.setTextFill(Color.web("#174A65"));
            task.setOnAction(e -> updateProgress());
        }

        progressBar = new ProgressBar(0);
        progressBar.setMaxWidth(Double.MAX_VALUE);
        progressBar.setPrefHeight(18);
        progressBar.setStyle(
            "-fx-accent: #00A878;"
        );

        progressLabel = new Label("Your pledge progress: 0%");
        progressLabel.setFont(Font.font("Arial", FontWeight.BOLD, 13));
        progressLabel.setTextFill(Color.web("#005F99"));

        VBox pledge = new VBox(
            12, checklistTitle,
            tasks[0], tasks[1], tasks[2],
            progressBar, progressLabel
        );
        pledge.setPadding(new Insets(20));
        pledge.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 18;" +
            "-fx-border-color: #90E0EF;" +
            "-fx-border-width: 2;" +
            "-fx-border-radius: 18;" +
            "-fx-effect: dropshadow(gaussian, #0077B6, 9, 0.15, 0, 4);"
        );

        // Interactive buttons
        Button factsButton = new Button("💧 WATER FACT");
        factsButton.setStyle(buttonStyle("#0077B6"));
        factsButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Water Fact");
            alert.setHeaderText("Did You Know?");
            alert.setContentText(
                "Water is essential for life. Saving water today " +
                "helps protect our future!"
            );
            alert.showAndWait();
        });

        Button pledgeButton = new Button("🌿 MY PROMISE");
        pledgeButton.setStyle(buttonStyle("#009B72"));
        pledgeButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("My Water Promise");
            alert.setHeaderText("Be a Water Hero!");
            alert.setContentText(
                "Thank you for caring about clean water. " +
                "Small actions can make a big difference!"
            );
            alert.showAndWait();
        });

        HBox buttons = new HBox(15, factsButton, pledgeButton);
        buttons.setAlignment(Pos.CENTER);

        Label footer = new Label(
            "SDG 6  |  CLEAN WATER • HEALTH • A BETTER FUTURE"
        );
        footer.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        footer.setTextFill(Color.WHITE);
        footer.setWrapText(true);
        footer.setAlignment(Pos.CENTER);

        VBox poster = new VBox(
            22, header, cards, pledge, buttons, footer
        );
        poster.setPadding(new Insets(25));
        poster.setAlignment(Pos.TOP_CENTER);
        poster.setStyle(
            "-fx-background-color: linear-gradient(to bottom, " +
            "#CAF0F8, #ADE8F4, #90E0EF);"
        );

        ScrollPane scrollPane = new ScrollPane(poster);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #CAF0F8;");

        Scene scene = new Scene(scrollPane, 900, 780);

        stage.setTitle("SDG Goal 6 - Clean Water and Sanitation");
        stage.setScene(scene);
        stage.setMinWidth(650);
        stage.setMinHeight(600);
        stage.show();
    }

    private VBox createCard(String heading, String content) {

        Label title = new Label(heading);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        title.setTextFill(Color.web("#0077B6"));
        title.setWrapText(true);

        Label description = new Label(content);
        description.setFont(Font.font("Arial", 14));
        description.setTextFill(Color.web("#174A65"));
        description.setWrapText(true);

        VBox card = new VBox(15, title, description);
        card.setPadding(new Insets(20));
        card.setMinWidth(0);
        card.setStyle(
            "-fx-background-color: white;" +
            "-fx-background-radius: 18;" +
            "-fx-border-color: #48CAE4;" +
            "-fx-border-radius: 18;" +
            "-fx-border-width: 2;" +
            "-fx-effect: dropshadow(gaussian, #0077B6, 10, 0.2, 0, 5);"
        );

        return card;
    }

    private String buttonStyle(String color) {
        return "-fx-background-color: " + color + ";" +
               "-fx-text-fill: white;" +
               "-fx-font-size: 13px;" +
               "-fx-font-weight: bold;" +
               "-fx-background-radius: 25;" +
               "-fx-padding: 12 20 12 20;" +
               "-fx-cursor: hand;";
    }

    private void updateProgress() {
        int completed = 0;

        for (CheckBox task : tasks) {
            if (task.isSelected()) {
                completed++;
            }
        }

        double progress = completed / 3.0;
        progressBar.setProgress(progress);
        progressLabel.setText(
            "Your pledge progress: " +
            (int) (progress * 100) + "% completed"
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}
