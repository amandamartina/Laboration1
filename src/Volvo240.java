import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Volvo240 extends MotorVehicle { //implements CarImages

    /**
     * Increases the speed with a factor 1.25
     */
    private final static double trimFactor = 1.25;
//    private BufferedImage volvoImage;


    /**
     * Constructor for Volvo240 objects
     */
    public Volvo240() {
        super(4, Color.black, 300, "Volvo240", 1000, 0, 0);
//        try {
//            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
    }

    /**
     * Uses trimFactor and a constant number to increase the speed factor
     *
     * @return enginePower times 0.01 times trimfactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

//    @Override
//    public BufferedImage getCarImage() {
//        return volvoImage;
    }
