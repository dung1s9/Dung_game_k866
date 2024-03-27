using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Class
{
    internal class LÙN_TỊT_IT0504
    {
        public int AGE;
        public string NAME;
        public string ID;
        public int HEiGHT;
        public string GENDER;
        public string ADDRESS;

        public LÙN_TỊT_IT0504()
        {

        }

        public LÙN_TỊT_IT0504(int AGE, string NAME, string ID, int HEIGHT, string GENDER, string ADDRESS)
        {
            this.AGE = AGE;
            this.NAME = NAME;
            this.GENDER = GENDER;
            this.ID = ID;  
            this.ADDRESS = ADDRESS;
            this.HEiGHT = HEIGHT;
        }

        public void show()
        {
            Console.WriteLine("ID: " + ID);
            Console.WriteLine("AGE: " + AGE);
            Console.WriteLine("NAME: " + NAME);
            Console.WriteLine("ADDRESS: " + ADDRESS);
            Console.WriteLine("HEIGHT: " + HEiGHT);
            Console.WriteLine("GENDER: " + GENDER);
        }

    }

}
