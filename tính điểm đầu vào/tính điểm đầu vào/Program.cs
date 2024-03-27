using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace tính_điểm_đầu_vào
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("nhap diem mon toan:");
            int math = int.Parse(Console.ReadLine());
            Console.WriteLine("nhap diem mon vat li:");
            int phys = int.Parse(Console.ReadLine());
            Console.WriteLine("nhap diem mon hoa:");
            int chem = int.Parse(Console.ReadLine());
            string tieu_chuan;
            if (math < 65 && phys < 55 && chem < 50)
                tieu_chuan = "ban chua du tieu chuan";
            else if (math + phys + chem < 170)
                tieu_chuan = "ban chua du tieu chuan";
            else if (math + phys < 140 && math + chem < 140)
                tieu_chuan = "ban chua du tieu chuan";
            else
                tieu_chuan = "ban du tieu chuan";
            Console.WriteLine("chac chan {0}", tieu_chuan);
            Console.ReadLine();

        }
    }
}
