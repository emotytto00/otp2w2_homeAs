import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.io.IOException;
import java.util.ResourceBundle;

public class HelloController {
    public Button button1;
    public Button button2;
    public Button button3;
    public Label nameLabel;
    public Label timeLabel;

    public void initialize() {
        //ResourceBundle bundle = ResourceBundle.getBundle("bundle2");
        //button1.setText(bundle.getString("button1.text"));
        //button2.setText(bundle.getString("button2.text"));
        //button3.setText(bundle.getString("button3.text"));
    }
    public void loadView(Locale locale) {
        // Set the language for the buttons
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundle", locale));
        try {
            Parent root = fxmlLoader.load();
            Stage s = (Stage) button1.getScene().getWindow();
            s.setScene(new Scene(root));

            // Update the nameLabel and timeLabel
            HelloController controller = fxmlLoader.getController();
            controller.updateLabels(locale);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Methods to change languages
    public void setEn(ActionEvent event) {
        loadView(new Locale("en", "UK"));
    }

    public void setIR(ActionEvent event) {
        loadView(new Locale("fa", "IR"));
    }

    public void setJP(ActionEvent event) {
        loadView(new Locale("ja", "JP"));
    }

    public void updateLabels(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);

        String name = bundle.getString("yourName");
        nameLabel.setText(name);

        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.LONG, locale);
        String currentTime = timeFormat.format(new Date());
        timeLabel.setText("Current Time: " + currentTime);
    }

}