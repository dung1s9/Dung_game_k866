using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("moi ban nhap so: ");
            int n = int.Parse(Console.ReadLine());
            int sum = 0;
            int j = 1;
            for (int i = 1;i <= n; i++)
            {
                
                j = j * 10;
                j++;
                Console.WriteLine("{0}", j);
                sum += j;
            }
            Console.WriteLine("{0}", sum);
            Console.ReadLine();
        }
    }
}
