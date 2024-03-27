using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace student
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            student student1 = new student();
            student1.ID = txtid.Text;
            student1.Name = txtname.Text;
            student1.Address = txtaddress.Text;
            student1.Class = txtclass.Text;


        }
    }
}
