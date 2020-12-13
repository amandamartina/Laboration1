import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements Observer {


    // Just a single image, TODO: Generalize
    private CarModel carModel;
    private Map<MotorVehicle, CarImages> imageMap = new HashMap<>();

    public BufferedImage getCarImage() {
        return null;
    }

    // TODO: Make this genereal for all cars
    void moveit(ArrayList<MotorVehicle> vehicles) {
        this.cars = vehicles;
    }

    // Initializes the panel and reads the images
    public DrawPanel(CarModel carModel, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
    }

    public void updateImages() {
        Map<MotorVehicle, CarImages> tempMap = new HashMap<>();
        for (MotorVehicle car : carModel.cars) {
            tempMap.put(car, new CarImages(car));
        }
        imageMap = tempMap;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MotorVehicle car : cars) {
            g.drawImage(carImage.getCarImage(car), (int) car.getxCord(), (int) car.getyCord(), null);
        }
    }

    @Override
    public void actOnUpdate() {
        updateImages();
        repaint();
    }
}


// Comments
// Print an error message in case file is not found with a try/catch block
        /*
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
             = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

         */
