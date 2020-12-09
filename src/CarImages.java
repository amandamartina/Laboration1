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

    public CarImages(){
        map.put("Volvo240",volvoImage);
        {
            try {
                volvoImage = read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        map.put("Saab95",saabImage);
        {
            try {
                saabImage = read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        map.put("Scania",scaniaImage);
        {
            try {
                scaniaImage = read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Map<String, BufferedImage> getMap() {
        return map;
    }


    //    public void putElement(cm.cars.size){
//   for() {
//       map.put(modelName, image);
//   }
//}

    public BufferedImage getCarImage(){
        return null;
    }


}
