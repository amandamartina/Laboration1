import java.util.List;

public class Loader <T extends MotorVehicle> implements Load  {
    //implementera interface LOAD här och delegera metoder hit :)
    //Gör klasses generisk class<C extends motorvehicle>
    T loaderObj;
    private final int Loadingproximity = 5;
    private final int MAXWEIGHT = 8000;
    public Loader(T loaderObj){
        this.loaderObj = loaderObj;
    }

    @Override
    public void loadCar(MotorVehicle car) {
        if (!car.getObjectLoaded()){
            if (car.getWeight() <= MAXWEIGHT);
        }
    }

    @Override
    public void unloadCar() {

    }

    public boolean loadingDistance(MotorVehicle car) {
        return (Math.sqrt(Math.pow(loaderObj.getyCord() - car.getxCord(), 2) + Math.pow(loaderObj.getyCord() - car.getyCord(), 2)) <= Loadingproximity);
    }
    /*
    public void loadCar(MotorVehicle car) {
        if (!car.getObjectLoaded())
            if (car.getWeight() <= MAXWEIGHT) {
                if (loadingDistance(car)) {
                    if (cars.size() < loadingCapacity) {
                        if (!rampUp) {
                            car.setxCord(getxCord());
                            car.setyCord(getyCord());
                            car.loadObject();
                            cars.push(car);
                        }
                    }
                }
            }
    }

    /**
     * Method for unloading cars in the order of first-in-last-out
     * given that the ramp is down and that the speed is equal to zero.
     * The cars that are loaded out is put down in the direction and
     * have the coordinates that the Mercedes has.


    public void unloadCar() {
        //ska det vara - 1? kom ihåg till test.
        int j = cars.size() - 1;
        if (!this.getRampUp()) {
            switch (getDir()) {
                case EAST:
                    cars.get(j).setxCord(-1);
                    break;
                case WEST:
                    cars.get(j).setxCord(1);
                    break;
                case NORTH:
                    cars.get(j).setyCord(-1);
                    break;
                case SOUTH:
                    cars.get(j).setyCord(1);
            }
            cars.get(j).unLoadObject();
            cars.pop();
        }
    }

    /**
     * Method to see distance between the loading car and car to be loaded.
     *
     * @param car The car you want to load on the Mercedes.
     * @return Returns a boolean, true if the car is close enough to load, false otherwise.



*/
}
