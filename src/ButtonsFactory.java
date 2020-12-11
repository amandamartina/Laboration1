import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsFactory {
    public static void initButton(CarModel carM, CarController carC, CarView carV) {
        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        carV.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(carM.gasAmount);
            }

        });
        carV.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(carM.gasAmount);
            }
        });

        carV.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startAllCars();
            }
        });
        carV.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopAllCars();
            }
        });
        carV.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOn();
            }
        });
        carV.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turboOff();
            }
        });

        carV.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.scaniaLiftBed();
            }

        });
        carV.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerLiftBed();
            }
        });
    }
}
