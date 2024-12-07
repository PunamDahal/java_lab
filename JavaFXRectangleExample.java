import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class JavaFXRectangleExample extends Application {
    @Override
    public void start(Stage primaryStage) {
        Rectangle rectangle = new Rectangle(200, 100);
        rectangle.setFill(javafx.scene.paint.Color.BLUE);
        
        StackPane root = new StackPane();
        root.getChildren().add(rectangle);
        
        Scene scene = new Scene(root, 400, 300);
        
        primaryStage.setTitle("JavaFX Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
