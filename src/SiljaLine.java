import java.awt.*;
import java.util.Queue;

public class SiljaLine extends MotorVehicle {
    public SiljaLine(int nrDoors, Color color, double enginePower, String modelName, double weight, int xCord, int yCord) {
        super(1000, color.white, Math.pow(10, 4), "SiljaSymphony", Math.pow(10, 6), 0, 0);
    }
    private Queue<MotorVehicle> carsInCargo;
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.05;
    }
}


//plan:
// Skapa en loaderclass och delegera metoder dit. eller load i ett interface
//går det att skapa en generisk metod i denna loader?