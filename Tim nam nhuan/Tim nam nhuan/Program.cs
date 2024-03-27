using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tim_nam_nhuan
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int so_nam_nho_nhat = 1900, so_nam_lon_nhat = 10000;
            Console.WriteLine("nhap so nam cua ban: ");
            int nam = int.Parse(Console.ReadLine());
            string nam_do;
            if (nam < so_nam_nho_nhat || nam > so_nam_lon_nhat)
                nam_do = "nam khong hop le";
            else
            {
                if (nam % 4 != 0)
                    nam_do = "nam khong nhuan";
                else
                {
                    if (nam % 100 != 0)
                        nam_do = "nam nhuan";
                    else
                    {
                        if (nam % 400 == 0)
                            nam_do = "nam nhuan";
                        else
                            nam_do = "nam khong nhuan";
                    }    
                }    
            }
            Console.WriteLine("Nam do la: {0}", nam_do);
            Console.ReadLine();
        }
    }
}
