using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace bai_13
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Moi nhap so dau tien: ");
            double a = double.Parse(Console.ReadLine());
            Console.WriteLine("Moi nhap so thu hai: ");
            double b = double.Parse(Console.ReadLine());
            double x = a + b;
            Console.WriteLine("a + b = {0}", x);
            double y = a - b;
            Console.WriteLine("a - b = {0}", y);
            double z = a * b;
            Console.WriteLine("a * b = {0}", z);
            double w = a / b;
            Console.WriteLine("a / b = {0}", w);
            Console.ReadLine();

        }
    }
}
