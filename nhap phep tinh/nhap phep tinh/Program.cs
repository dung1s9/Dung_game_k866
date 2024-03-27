using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace nhap_phep_tinh
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int alpha;
            do
            {
                Console.WriteLine("=== MAY TINH CA NHAN === ");
                Console.WriteLine("(1) phep cong :");
                Console.WriteLine("(2) phep tru : ");
                Console.WriteLine("(3) phep nhan: ");
                Console.WriteLine("(4) phep chia: ");
                Console.WriteLine("(5) phep chia lay du: ");
                Console.WriteLine("moi ban nhap lua chon: ");
                alpha = int.Parse(Console.ReadLine());
                //................................................................
                Console.WriteLine("moi ban nhap so thu nhat: ");
                double a = int.Parse(Console.ReadLine());
                Console.WriteLine("moi ban nhap so thu hai: ");
                double b = double.Parse(Console.ReadLine());
                double x, y, z, W, m;
                switch (alpha)
                {
                    case 1:
                        x = a + b;
                        Console.WriteLine("phep cong: {0}", x);
                        break;
                    case 2:
                        y = a - b;
                        Console.WriteLine("phep tru: {0}", y);
                        break;
                    case 3:
                        z = a * b;
                        Console.WriteLine("phep nhan: {0}", z);
                        break;
                    case 4:
                        W = a / b;
                        if (b != 0)
                            Console.WriteLine("phep chia: {0}", W);
                        else
                            Console.WriteLine("ko hop le");
                        break;
                    case 5:
                        m = a % b;
                        if (b != 0)
                            Console.WriteLine("phep chia lay du: {0}", m);
                        else
                            Console.WriteLine("ko hop le");
                        break;
                    default:
                        Console.WriteLine("ban troll toi a, chon 1 trong 5 thoi :<");
                        break;
                }
            } while (alpha != 0);
            Console.ReadLine();

        }
    }
}
