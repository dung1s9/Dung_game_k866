using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Circle
{
    internal class Circle
    {
        public double r;
        public double Pi;
        public string color;

        public Circle ()
        {

        }

        public Circle(double r, double Pi, string color)
        {
            this.r = r;
            this.Pi = Pi;
            this.color = color;
        }

        public void show()
        {
            double Area = r * r * Pi;
            double Perimeter = r * 2 * Pi;
            Console.WriteLine("The Area of the Circle is: " + Area);
            Console.WriteLine("The Perimeter of the Circle is: " + Perimeter);
            Console.WriteLine("Color: " + color);
        }

    }

}
