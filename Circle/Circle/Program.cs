using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Circle
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Circle cricle1 = new Circle(2, 3.14, "red");
            Console.WriteLine("Radius: " + cricle1.r);
            cricle1.show();
            Console.ReadLine();
        }

    }
}
