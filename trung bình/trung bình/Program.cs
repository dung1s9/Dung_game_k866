using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace trung_bình
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("nhap so diemthu nhat: ");
            float ASM1 = float.Parse(Console.ReadLine());
            Console.WriteLine("nhap so thu hai: ");
            float ASM2 = float.Parse(Console.ReadLine());
            double diem_trung_binh = (ASM1 + ASM2) / 2;
            string DIEM;
            if (diem_trung_binh < 60)
                DIEM = "F";
            else if (diem_trung_binh < 80)
                DIEM = "P";
            else if (diem_trung_binh < 90)
                DIEM = "M";
            else
                DIEM = "D";
            Console.WriteLine("Ban sinh vien do duoc diem {0}", DIEM);
            Console.ReadLine();
        }
    }
}
