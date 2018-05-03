package iMat;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;

public class ItemThumbnail {

    private Controller parentController;
    private Product product;

    @FXML
    private ImageView thumbnailImageView;
    @FXML
    private Label buyThumbnailLabel;
    @FXML
    private ImageView buyThumbnailImageView;
    @FXML
    private ImageView addThumbnailImageView;
    @FXML
    private ImageView removeThumbnailImageView;
    @FXML
    private Label quantityThumbnailLabel;
    @FXML
    private Label priceThumbnailLabel;
    @FXML
    private Label nameThumbnailLabel;

    public ItemThumbnail(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("item_thumbnail.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        // Specifika
        this.product = product;
        this.parentController = parentController;
        // TODO this.thumbnailImageView.setImage(getSquareImage(product.getImageName()));
        this.nameThumbnailLabel.setText(product.getName());
        this.priceThumbnailLabel.setText(Double.toString(product.getPrice()));


        // Generella
        this.buyThumbnailLabel.setText("Köp");
        // TODO this.removeThumbnailImageView.setImage();
        this.quantityThumbnailLabel.setText("1");


    }

    public Image getSquareImage(Image image){

        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;

        if(image.getWidth() > image.getHeight()){
            width = (int) image.getHeight();
            height = (int) image.getHeight();
            x = (int)(image.getWidth() - width)/2;
            y = 0;
        }

        else if(image.getHeight() > image.getWidth()){
            width = (int) image.getWidth();
            height = (int) image.getWidth();
            x = 0;
            y = (int) (image.getHeight() - height)/2;
        }

        else{
            //Width equals Height, return original image
            return image;
        }
        return new WritableImage(image.getPixelReader(), x, y, width, height);
    }

}
