using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Hello_World_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int age = 18;
            int Age = 30;
            int tuoitho = age * Age;
            string name = "truong viet dung";
            Console.WriteLine("tac gia cua tac pham : {0}\n so tuoi tho cua toi : {1}", name, tuoitho);
            Console.ReadLine();
        }
    }
}
