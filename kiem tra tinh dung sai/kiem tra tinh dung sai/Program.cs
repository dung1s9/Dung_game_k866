using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace kiem_tra_tinh_dung_sai
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("moi ban nhap so cua minh: ");
            int n;
            int m = int.Parse(Console.ReadLine());
            if (m < 0)
                n = -1;
            else if (m < 1)
                n = 0;
            else
                n = 1;
            Console.WriteLine("kiem tra: {0}", n);
            Console.ReadLine();
        }
    }
}
