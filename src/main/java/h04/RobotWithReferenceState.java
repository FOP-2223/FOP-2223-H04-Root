package h04;
import fopbot.Direction;

/**
 * Represents a robot with a reference state.
 */
public interface RobotWithReferenceState{

    /**
     * This method sets the current state of the robot as the reference state.
     *
     */
    void setCurrentStateAsReferenceState();

    /**
     * This method returns the difference of the current value of the attribute x of the robot and the
     * previously saved reference value of x.
     *
     * @return the difference between the current x-value of the robot and the reference x-value
     */
    int getDiffX();

    /**
     * This method returns the difference of the current value of the attribute y of the robot and the
     * previously saved reference value of y.
     *
     * @return the difference between the current y-value of the robot and the reference y-value
     */
    int getDiffY();

    /**
     * This method returns the difference of the current value of the attribute direction of the robot and the
     * previously saved reference value of direction.
     *
     * @return the difference between the current direction-value of the robot and the reference direction-value
     */
    Direction getDiffDirection();

    /**
     * This method returns the difference of the current value of the attribute numberOfCoins of the robot and the
     * previously saved reference value of numberOfCoins.
     *
     * @return the difference between the current numberOfCoins-value of the robot
     * and the reference numberOfCoins-value
     */
    int getDiffNumberOfCoins();
}
