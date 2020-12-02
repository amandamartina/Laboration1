import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
<<<<<<< HEAD
    //BufferedImage carsImage;
=======
    BufferedImage scaniaImage;
>>>>>>> 5d622c7... nu studsar bilen
    BufferedImage saabImage;
    //BufferedImage carsImage;

    // To keep track of a single cars position
<<<<<<< HEAD
    Point volvoPoint = new Point(100, 100);
    //Point carsPoint = new Point();
    Point saabPoint = new Point(500, 500);
=======
    Point volvoPoint = new Point();
    Point scaniaPoint = new Point();
    Point saabPoint = new Point();
    //Point carsPoint = new Point();
>>>>>>> 5d622c7... nu studsar bilen
    // TODO: Make this genereal for all cars
    void moveit(int x, int y ){
    /*    for (int i = 0; i < z; i++){
            carsPoint.x = x;
            carsPoint.y = y + i;
            }
      */
<<<<<<< HEAD

        volvoPoint.x = x;
        volvoPoint.y = y;

        saabPoint.x = x;
        saabPoint.y = y;

       /* if (volvoPoint.x == 80) {
            volvoPoint.x = -x;
        }*/

=======
        volvoPoint.x = x;
        volvoPoint.y = y;
        saabPoint.x = x;
        saabPoint.y = y+100;
        scaniaPoint.x = x;
        scaniaPoint.y = y + 200;
>>>>>>> 5d622c7... nu studsar bilen


        //kanske här man ska ändra
        }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
<<<<<<< HEAD
            //carsImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
=======
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
>>>>>>> 5d622c7... nu studsar bilen
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
<<<<<<< HEAD
       g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
=======
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
>>>>>>> 5d622c7... nu studsar bilen
        g.drawImage(saabImage,saabPoint.x,saabPoint.y,null);
        g.drawImage(scaniaImage,scaniaPoint.x, scaniaPoint.y, null);
    }

}
