using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace di_tuoi_bo_phieu
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("moi nhap so tuoi cua ban: ");
            int tuoi = int.Parse(Console.ReadLine());
            if (tuoi < 21)
                Console.WriteLine("ban chua du tuoi de bo phieu.");
            else
                Console.WriteLine("xin chuc mung, ban da du dieu kien de bor phieu.");
            Console.ReadLine();
        }
    }
}
