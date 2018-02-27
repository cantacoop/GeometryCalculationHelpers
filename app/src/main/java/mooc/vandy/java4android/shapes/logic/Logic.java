package mooc.vandy.java4android.shapes.logic;

import android.text.TextUtils;
import android.util.Log;

import mooc.vandy.java4android.shapes.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = 
        Logic.class.getName();

    /*
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough)
     */
    private OutputInterface mOut;

    /**
     * These are the numeric values that you will receive from the
     * User Interface and use in your calculations.
     */
    private static double mRadius = 0;
    private static double mLength = 0;
    private static double mWidth = 0;
    private static double mHeight = 0;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    @Override
    public void process() {
        // Get which calculation should be computed.  Do not worry
        // about the specifics of this right now.
        Shapes shapeForCalculations = mOut.getShape();

        // Store the values returned by the User Interface.
        mLength = mOut.getLength();
        mWidth = mOut.getWidth();
        mHeight = mOut.getHeight();
        mRadius = mOut.getRadius();

        // Determine which calculation to process right now.  Again,
        // do not worry about the specifics of how this works for now.
        switch (shapeForCalculations) {
            case Box:
                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " by " 
                           + mHeight 
                           + " box has a volume of: ");
                mOut.println("" 
                             + String.format("%.2f",
                                             boxVolume(mLength, mWidth, mHeight)));
                mOut.println("");

                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " by " 
                           + mHeight 
                           + " box has a surface area of: ");
                mOut.println("" 
                             + String.format("%.2f",
                                             boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println("");
                // If you are paying attention, you will notice that
                // there is no 'break;' here like there is in other
                // places, meaning that if 'Box' was selected, it will
                // run the two sets of print statements above and the
                // two statements below until the 'break;' statement.
            case Rectangle:
                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " rectangle has a perimeter of: ");
                mOut.println("" + String.format("%.2f", 
                                                rectanglePerimeter(mLength, mWidth)));
                mOut.println("");

                mOut.print("A " 
                           + mLength 
                           + " by " 
                           + mWidth 
                           + " rectangle has area of: ");
                mOut.println("" + String.format("%.2f", rectangleArea(mLength, mWidth)));
                mOut.println("");
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println("" + String.format("%.2f", sphereVolume(mRadius)));
                mOut.println("");

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println("" + String.format("%.2f", sphereSurfaceArea(mRadius)));
                mOut.println("");
                // Same here as with 'Box' above. If 'Sphere' is picked, it will run the
                // two sets of print statements above and the two below until the 'break;'
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println("" + String.format("%.2f", circleCircumference(mRadius)));
                mOut.println("");

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println("" + String.format("%.2f", circleArea(mRadius)) );
                mOut.println("");
                break;
            case Triangle:
                mOut.print("A right triangle with base " 
                           + mLength 
                           + " and height " 
                           + mWidth + " has a perimeter of: ");
                mOut.println("" 
                             + String.format("%.2f", rightTrianglePerimeter(mLength,
                                                                       mWidth)));
                mOut.println("");

                mOut.print("A right triangle with base " 
                           + mLength 
                           + " and height " 
                           + mWidth 
                           + " has area of: ");
                mOut.println("" 
                             + String.format("%.2f", rightTriangleArea(mLength,
                        mWidth)));
                mOut.println("");
                break;
            default:
                break;
        }
    }

    // TODO -- add your code here

    /**
     * Area of rectangle
     * @param length length
     * @param width width
     * @return area
     */
    public static double rectangleArea(double length, double width) {

        // formula A = l w
        return length * width;
    }

    /**
     * Perimeter of rectangle
     * @param length length
     * @param width width
     * @return perimeter
     */
    public static double rectanglePerimeter(double length, double width) {

        // formula P = 2 (l + w)
        return 2 * (length + width);
    }

    /**
     * Area of circle
     * @param radius radius
     * @return area
     */
    public static double circleArea(double radius) {

        // formula A = PI r^2,
        return Math.PI * radius * radius;
    }

    /**
     * Circumference of circle
     * @param radius radius
     * @return circumference
     */
    public static double circleCircumference(double radius) {

        // formula C = 2 PI r
        return 2  * Math.PI * radius;
    }

    /**
     * Area of triangle
     * @param base base
     * @param height height
     * @return area
     */
    public static double rightTriangleArea(double base, double height) {

        // formula T = 1/2 (b h)
        return (base * height) / 2.0;
    }

    /**
     * Perimeter right triangle
     * @param base base
     * @param height height
     * @return perimeter
     */
    public static double rightTrianglePerimeter(double base, double height) {

        // formula P = a + b + sqrt(a^2 + b^2)
        return base + height + Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2));
    }

    /**
     * Volumn of box
     * @param length length
     * @param width width
     * @param depth depth
     * @return volume
     */
    public static double boxVolume(double length, double width, double depth) {

        // formula V = l w h
        return length * width * depth;
    }

    /**
     * Surface area of box
     * @param length
     * @param width
     * @param depth
     * @return surface area
     */
    public static double boxSurfaceArea(double length, double width,
                                        double depth) {
        // formula SA = 2 (lb + bh + hl)
        double A1 = length * width;
        double A2 = width * depth;
        double A3 = depth * length;

        return 2 * (A1 + A2 + A3);
    }

    /**
     * Volume of sphere
     * @param radius radius
     * @return volume
     */
    public static double sphereVolume(double radius) {

        // formula V = (4/3) PI r^3
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    /**
     * Surface area of sphere
     * @param radius radius
     * @return surface area
     */
    public static double sphereSurfaceArea(double radius) {

        // formula SA = 4 PI r^2
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
