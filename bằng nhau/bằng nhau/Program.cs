using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace bằng_nhau
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("nhap so thu nhat: ");
            int a = int.Parse(Console.ReadLine());
            Console.WriteLine("nhap so thu hai: ");
            int b = int.Parse(Console.ReadLine());
            if (a == b)
                Console.WriteLine("Hai so bang nhau");
            else if (a > b)
                Console.WriteLine("so thu nhat lon hon so thu hai");
            else
                Console.WriteLine("so thu nhat be hon so thu hai");
            Console.ReadLine();
                
        }
    }
}
