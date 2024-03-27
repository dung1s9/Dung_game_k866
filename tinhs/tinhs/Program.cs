using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace tinhs
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //int chieu_rong = 23;
            //int chieu_dai = 48;
            //int chu_vi = (chieu_rong + chieu_dai) * 2;
            //int s = chieu_rong * chieu_dai;
            //Console.WriteLine("chu vi cua HCN la : {0}, dien tich hinh chu nhat la : {1}", chu_vi, s);
            //Console.ReadLine();

            Console.WriteLine("xin nhap chieu rong cua ban : ");
            int weigh = int.Parse(Console.ReadLine());
            Console.WriteLine("moi nhap chieu dai cua ban : ");
            int light = int.Parse(Console.ReadLine());
            int chu_vi = (weigh + light) * 2;
            int S = weigh * light;
            Console.WriteLine("ket qua chu vi = {0}\nKet qua dien tich = {1}", chu_vi, S);
            //.....................................................................
            Console.WriteLine("xin nhap ban kinh cua ban : ");
            int R = int.Parse(Console.ReadLine());
            double chu_vi_2 = 2 * 3.14 * R;
            Double S_2 = 3.14*R*R;
            Console.WriteLine("ket qua chu vi hinh tron = {0}\nKet qua dien tich hinh tron = {1}", chu_vi_2, S_2);
            Console.WriteLine("xin nhap quang duong cua ban : ");
            int Q = int.Parse(Console.ReadLine());
            Console.WriteLine("moi nhap thoi gian cua ban : ");
            int T = int.Parse(Console.ReadLine());
            int van_toc = Q/T;
            Console.WriteLine("ket qua cua van toc : {0} ", van_toc);
            //.....................................
            Console.WriteLine("moi nhap so thu nhat");
            int a = int.Parse(Console.ReadLine());
            Console.WriteLine("moi nhap so thu hai");
            int b = int.Parse(Console.ReadLine());
            int x;
            if (a == 0)
            {
                if (b == 0)
                    Console.WriteLine("phuong trinh co vo so nghiem");
                else
                    Console.WriteLine("phuong trinh vo nghiem ");
            }
            else
            {
                x = -b / a;
                Console.WriteLine("nghiem cua phuong trinh bac nhat la {0}", x);
            }
            Console.ReadLine();
        }
    }
}
