package introduction;

import static java.lang.Math.sqrt;

public class Point2D {
      int x;
      int y;


    //Constructors
    Point2D(int x, int y) {
        this(x);
        this.y = y;
    }

    Point2D(int x) {
        this();
        this.x = x;
    }

    Point2D() {

    }

    //Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    //Add Function
     Point2D add(Point2D point) {
        x = x + point.x;
        y = y + point.y;
        return new Point2D(x,y);
    }

    //Distance Function (could also be made a bit clearer with better readability
    double getDistanceFromOrigin() {
        return sqrt(this.x * this.x + this.y * this.y);
    }

}
