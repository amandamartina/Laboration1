import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 * This class includes all of the buttons which are related to user input.
 */
public class CarController extends JPanel {
    private ButtonsAccessor carModel;
    private final int X;
    private CarFactory carFactory;

    /**
     * The CarController constructor.
     * This constructor is listening to changes that effects the functions of the buttons.
     * These changes comes from CarModel and are communicated with an observer pattern.
     *
     * @param carModel a CarModel, representing our model.
     * @param X
     */
    public CarController(ButtonsAccessor carModel, int X) {
        this.carModel = carModel;
        this.X = X;
        initComponents();
        addListeners();
    }

    /**
     * The control panel.
     */
    JPanel controlPanel = new JPanel();
    /**
     * The gas panel.
     */
    JPanel gasPanel = new JPanel();
    /**
     * The graphical area where the user can put in an amount of gas.
     */
    JSpinner gasSpinner = new JSpinner();
    /**
     * The initial gas amount.
     */
    int gasAmount = 0;
    /**
     * This label shows what speed a specific car has.
     */
    JLabel gasLabel = new JLabel("Amount of gas");

    /**
     * The graphics for the gasbutton.
     */
    JButton gasButton = new JButton("Gas");

    /**
     * The graphics for the brake button.
     */
    JButton brakeButton = new JButton("Brake");

    /**
     * The graphics for the turboOn button.
     */
    JButton turboOnButton = new JButton("Saab Turbo on");

    /**
     * The graphics for the turboOff button.
     */
    JButton turboOffButton = new JButton("Saab Turbo off");

    /**
     * The graphics for the liftBed button.
     */
    JButton liftBedButton = new JButton("Scania Lift Bed");

    /**
     * The graphics for the lowerBed button.
     */
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    /**
     * Graphics for the button that starts the cars.
     */
    JButton startButton = new JButton("Start all cars");

    /**
     * Graphics for the button that stops the car.
     */
    JButton stopButton = new JButton("Stop all cars");

    /**
     * Graphics for the button that adds a Volvo240 to the frame.
     */
    JButton addVolvoButton = new JButton("Add car");

    /**
     * Graphics for the button that removes cars from the frame.
     */
    JButton removeCarButton = new JButton("Remove car");

    /**
     * This method is listening to user input through buttons being used.
     * This method includes all of the buttons that the user can use.
     */
    private void addListeners() {
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.gas(gasAmount);
            }

        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.brake(gasAmount);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.startAllCars();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.stopAllCars();
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOn();
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.scaniaLiftBed();
            }

        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.lowerLiftBed();
            }
        });
        addVolvoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.addCar(carFactory.createVolvo());
            }
        });
        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carModel.removeCar();
            }
        });
    }

    /**
     * This method is used to set everything in place and fit everything.
     * In this method the layout is created.
     */
    private void initComponents() {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        10);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addVolvoButton, 6);
        controlPanel.add(removeCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);

        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);
    }

    /**
     * The delay (ms) corresponds to 20 updates a sec (hz)
     */
    private final int delay = 20;

    /**
     * The timer is started with an listener (see below) that executes the statements
     * each step between delays.
     */

    protected Timer timer = new Timer(delay, new CarController.TimerListener());

    /**
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images.
     */
    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            carModel.update();
        }
    }
}
