using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace số_dương_hay_số_âm
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("moi nhap so cua ban vao: ");
            int a = int.Parse(Console.ReadLine());
            if (a > 0)
                Console.WriteLine("so nay la so duong");
            else
                Console.WriteLine("so nay la so am");
            Console.ReadLine();
        }
    }
}
