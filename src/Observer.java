/**
 * This interface is a part of the observer pattern that has been applied.
 * This interface is implemented in views that are interested in different changes that occur in the model.
 * The views and the model that are mentioned is a part of the MVC-pattern that has been applied in this code base.
 */
public interface Observer {
/**
 * Method used for listeners in our observer-pattern to act on update that happens in the model.
 */
    void actOnUpdate();
}
