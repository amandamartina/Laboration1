import java.awt.*;
import java.util.*;
import javax.swing.*;

public class CarView extends JPanel implements Observer {
    private ListAccessor carModel;
    private Map<MotorVehicle, CarImages> imageMap = new HashMap<>();

    public CarView(ListAccessor carModel, int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.carModel = carModel;
    }

    public void updateImages() {
        Map<MotorVehicle, CarImages> tempMap = new HashMap<>();
        for (MotorVehicle car : carModel.getCars()) {
            tempMap.put(car, new CarImages(car));
        }
        imageMap = tempMap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MotorVehicle car : imageMap.keySet()) {
            imageMap.get(car).drawCar(car, g);
        }
    }

    @Override
    public void actOnUpdate() {
        updateImages();
        repaint();
    }
}