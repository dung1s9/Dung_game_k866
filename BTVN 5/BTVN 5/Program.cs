using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTVN_5
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //for (int i = 0; i < 100; i++)
            //{
            //    khoi lenh
            //            Console.WriteLine("I love You {0}", i);
            //}
            //Console.ReadLine();
            //{
            //    {
            //        int n = int.Parse(Console.ReadLine());
            //        int sum = 0;
            //        for (int i = 0; i < n + 1; i++)
            //        {
            //            sum = sum + i;
            //        }
            //        Console.ReadLine();

            //        Console.WriteLine(sum);
            //        Console.WriteLine("Moi bn nhap n ");
            //        int m = int.Parse(Console.ReadLine());

            //        int nhan = 1;
            //        for (int i = 1; i <= m; i++)
            //        {
            //            nhan = nhan * i;
            //        }
            //        Console.WriteLine("Giai thua la {0}", nhan);
            //    }
            //    bafi 1
            //for (int i = 1; i <= 20; i += 2)
            //    {
            //        Console.WriteLine(i);
            //    }
            //    bai 2
            //    Console.WriteLine("Moi bn nhap n");
            //    int a = int.Parse(Console.ReadLine());
            //    Console.WriteLine("cac so do la");
            //    for (int i = 1; i <= a; i++)
            //    {
            //        Console.Write(" {0} ", i);
            //    }
            //    bai 3
            //    Console.WriteLine("Moi bn nhap n");
            //    int tong = 0;
            //    int n = int.Parse(Console.ReadLine());
            //    for (int i = 0; i <= n; i++)
            //    {
            //        tong = tong + i;
            //    }
            //    Console.WriteLine(tong);
            //    bai 4
            //    Console.WriteLine("Moi bn nhap n");
            //    int giaithua = 1;
            //    int n = int.Parse(Console.ReadLine());
            //    for (int i = 1; i <= n; i++)
            //    {
            //        giaithua = giaithua * i;
            //    }
            //    Console.WriteLine(giaithua);
            //    bai 5
            //    int a = int.Parse(Console.ReadLine());
            //    int tich = 0;
            //    for (int i = 0; i <= 10; i++)
            //    {
            //        tich = a * i;
            //        Console.WriteLine(tich);
            //    }
            //    bai 6
            //    int a = int.Parse(Console.ReadLine());
            //    int lapphuong = 0;
            //    for (int i = 0; i <= a; i++)
            //    {
            //        lapphuong = i * i * i;
            //        Console.WriteLine(lapphuong);
            //    }
            //    bai7
            //    int a = int.Parse(Console.ReadLine());
            //    int tongle = 0;
            //    for (int i = 1; i <= a; i += 2)
            //    {
            //        tongle = tongle + i;
            //    }
            //    Console.WriteLine(tongle);
            //    bai 8
            //    double a = double.Parse(Console.ReadLine());
            //    double tong = 0;

            //    for (double i = 1; i <= a; i++)
            //    {
            //        double b = 1 / i;
            //        tong = tong + b;
            //    }
            //    Console.WriteLine(tong);
            //    bai 9
                Console.WriteLine("Moi ban nhap so gioi han: ");
                    int n = int.Parse(Console.ReadLine());
                    int sum = 0, j = 1, x = 0;
                    for (int i = 1; i <= n; i++)
                    {
                     x++;
                Console.WriteLine("gia tri so thu {0}: {1}", x, j);
                    sum = sum + j;
                        j = (j * 10) + 1;
                    }
                    Console.WriteLine("tong cua cac so: {0}", sum);
            Console.ReadLine();
            }
        }
}
