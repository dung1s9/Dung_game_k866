using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace tôi_cao
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("nhap du lieu chieu cao cua phat: ");
            int phat = int.Parse(Console.ReadLine());
            string chieu_cao;
            if (phat <= 135)
                chieu_cao = "nguoi lun";
            else if (phat < 170)
                chieu_cao = "nguoi binh thuong";
            else if (phat < 200)
                chieu_cao = "nguoi cao";
            else
                chieu_cao = "nguoi bat thuong";
            Console.WriteLine("Phat la: {0}", chieu_cao);
            Console.ReadLine();
        }
    }
}
