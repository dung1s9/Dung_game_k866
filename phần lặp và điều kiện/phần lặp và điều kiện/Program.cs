using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tính_chẵn_lẻ
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("moi ban nhap so : ");
            int a = int.Parse(Console.ReadLine());
                if (a % 2 == 0)
                    Console.WriteLine("day la mot so chan ");
                else
                    Console.WriteLine("day La mot so le ");
            Console.WriteLine("so tuoi cua nguoi do la: ");
            int b = int.Parse(Console.ReadLine());
            if (b < 18)
                Console.WriteLine("ban chua du 18 tuoi");
            else
                Console.WriteLine("So tuoi cua ban hop le");
         Console.ReadLine();
        }
    }
}
