using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class
{
    internal class L
    {
        static void Main(string[] args)
        {
            LÙN_TỊT_IT0504 Student = new LÙN_TỊT_IT0504();
            Student.ID = "BH00277";
            Student.NAME = "HUYNH LÙN TET";
            Student.HEiGHT = 162;
            Student.ADDRESS = "Thái NGUYÊN";
            Student.GENDER = "GAY";
            Student.AGE = 19;
            //Console.WriteLine(Student.ID + "\n " + Student.NAME + "\n " + Student.HEiGHT + "\n " + Student.ADDRESS + "\n " + Student.GENDER + "\n " + Student.AGE );
            Student.show();
            Console.ReadLine();
        }
    }
}
