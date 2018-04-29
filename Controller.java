package iMat;

import javafx.fxml.Initializable;
import se.chalmers.cse.dat216.project.CartEvent;
import se.chalmers.cse.dat216.project.ShoppingCartListener;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, ShoppingCartListener {

    // Account pane actions
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    // Shope pane methods
    @Override
    public void shoppingCartChanged(CartEvent evt) {
        // TODO
    }
}
