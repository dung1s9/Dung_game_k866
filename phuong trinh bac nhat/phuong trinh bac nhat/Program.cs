using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace phuong_trinh_bac_nhat
{
    internal class Program
    {
        int nhap_du_lieu(int a, int b)
        {
            int x;
            if (a == 0)
            {
                if (b != 0)
                    Console.WriteLine("phuong trinh vo nghiem. ");
                else
                    Console.WriteLine("phuong trinh co vo so nghiem. ");
            }
            else
            {
                x = -b / a;
            }
        }
        int khung_so(int a, int b, int x)
        {
            Console.WriteLine("ax + b = 0");
            int learn = nhap_du_lieu(a, b);
            Console.WriteLine("nhap so dau tien {0}", a);
            Console.WriteLine("nhap so thu hai {1}", b);
            Console.WriteLine("nhap so tu nhien {2}" x);
        }
        static void Main(string[] args)
        {
            int main = khung_so(a, b, x);
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int x = int.Parse(Console.ReadLine());
            Console.ReadLine();
        }
    }
}
