using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de_mo_vong_lap
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("moi ban nhap so de chung toi lam bang: ");
            long delta = int.Parse(Console.ReadLine());
            long D = 1;
            for (long i = 1; i <= 10; i ++)
            {
                long x = delta * i;
                Console.WriteLine( "{0} * {1} = {2} ",delta, i , x);
                D = D * x;
            }
            Console.WriteLine("tich tat ca cac so la: ");
            Console.WriteLine(D);
            Console.ReadLine();
        }
    }
}
