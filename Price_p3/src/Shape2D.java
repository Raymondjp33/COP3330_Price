import java.lang.Math.*;
public abstract class Shape2D extends Shape
{

}


class Square extends Shape2D
{
    double sideLength;

    Square(double sideLengthin)
    {
        sideLength = sideLengthin;
    }

    public String getName()
    {
        return "square";
    }

    public double getArea()
    {
        return sideLength*sideLength;

    }

}

class Triangle extends Shape2D
{
    double base;
    double height;

    Triangle(double basein, double heightin)
    {
        base = basein;
        height = heightin;
    }

    public String getName()
    {
        return "triangle";
    }

    public double getArea()
    {
        return .5*base*height;
    }

}

class Circle extends Shape2D
{
    double radius;

    Circle(double radiusin)
    {
        radius = radiusin;
    }

    public String getName()
    {
        return "circle";
    }

    public double getArea()
    {
        return Math.PI*radius*radius;
    }

}

