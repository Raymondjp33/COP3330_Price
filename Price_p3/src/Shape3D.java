import java.lang.Math.*;
public abstract class Shape3D extends Shape2D
{
    public abstract double getVolume();

}


class Cube extends Shape3D
{
    double sideLength;

    Cube(double sideLengthin)
    {
        sideLength = sideLengthin;
    }

    public String getName()
    {
        return "cube";
    }

    public double getArea()
    {
        return 6*sideLength*sideLength;
    }

    public double getVolume()
    {
        return sideLength*sideLength*sideLength;
    }

}

class Pyramid extends Shape3D
{
    double length;
    double width;
    double height;

    Pyramid(double lengthin, double widthin, double heightin)
    {
        length = lengthin;
        width = widthin;
        height = heightin;
    }

    public String getName()
    {
        return "pyramid";
    }

    public double getArea()
    {
        return (length*width)+(length*Math.sqrt(((width/2)*(width/2))+(height*height)))+(width*Math.sqrt(((length/2)*(length/2))+(height*height)));
    }

    public double getVolume()
    {
        return (length*width*height)/3;
    }
}

class Sphere extends Shape3D
{
    double radius;

    Sphere(double radiusin)
    {
        radius = radiusin;
    }

    public String getName()
    {
        return "sphere";
    }

    public double getArea()
    {
        return 4*Math.PI*radius*radius;
    }


    public double getVolume()
    {
        return 1.3333333333*radius*radius*radius*Math.PI;
    }
}