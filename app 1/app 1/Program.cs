using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Console.WriteLine("=== BANG CUU CHUONG ===");
            //int tich;
            //for (int i = 1; i <= 9; i++)
            //{
            //    for (int j = 1; j <= 10; j++)
            //    {
            //        tich = i * j;
            //        Console.WriteLine("{0} x {1} = {2}", i, j, tich);
            //    }
            //    Console.Write("\n");
            //}
            //...............................................................................
            //int n = int.Parse(Console.ReadLine());
            //for (int i = 1;i <= n;)
            //{
            //    for (int j = 1; j <= i;) 
            //    {
            //        Console.Write("x");
            //        j++;
            //    }
            //    Console.Write("\n");
            //    i++;
            //}
            Console.WriteLine("moi ban nhap so: ");
            int n = int.Parse(Console.ReadLine());
            int i = 1, tich = 1;
            while ( i <= n)
            {
                tich = tich * i;
                i++;
            }
            Console.WriteLine(tich);
            Console.ReadLine();
        }
    }
}
