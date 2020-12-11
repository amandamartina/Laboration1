import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class CarImages {
    Map<String, BufferedImage> map = new HashMap<>();
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    public CarImages() {
        {
            try {
                volvoImage = read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("Volvo240", volvoImage);

        {
            try {
                saabImage = read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("Saab95", saabImage);

        {
            try {
                scaniaImage = read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("Scania", scaniaImage);
    }

    public BufferedImage getCarImage(MotorVehicle car) {
        if (car instanceof Volvo240) {
            return volvoImage;
        } else if (car instanceof Saab95) {
            return saabImage;
        } else {
            return scaniaImage;
        }
    }
}
