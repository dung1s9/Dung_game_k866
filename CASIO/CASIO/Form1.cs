using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CASIO
{
    public partial class Form1 : Form

    {
        bool kiemtra;
        string pheptoan;
        string lastvalue;
        public Form1()
        {
            InitializeComponent();
        }

        private void btn_reset_Click(object sender, EventArgs e)
        {
            txtResult.Clear();
        }

        private void btn_so0_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "0";
            kiemtra = false;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void btn_so9_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "9";
            kiemtra = false;
        }

        private void btn_so8_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "8";
            kiemtra = false;
        }

        private void btn_so7_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "7";
            kiemtra = false;
        }

        private void btn_so6_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "6";
            kiemtra = false;
        }

        private void btn_so5_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "5";
            kiemtra = false;
        }

        private void btn_so4_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "4";
            kiemtra = false;
        }

        private void btn_so3_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "3";
            kiemtra = false;
        }

        private void btn_so2_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "2";
            kiemtra = false;
        }

        private void btn_so1_Click(object sender, EventArgs e)
        {
            if (kiemtra) txtResult.Clear();
            txtResult.Text = txtResult.Text + "1";
            kiemtra = false;
        }

        private void btn_cong_Click(object sender, EventArgs e)
        {
            lastvalue = txtResult.Text;
            kiemtra = true;
            pheptoan = "+";
        }

        private void btn_tru_Click(object sender, EventArgs e)
        {
            lastvalue = txtResult.Text;
            kiemtra = true;
            pheptoan = "-";
        }

        private void btn_nhan_Click(object sender, EventArgs e)
        {
            lastvalue = txtResult.Text;
            kiemtra = true;
            pheptoan = "*";
        }

        private void btn_chia_Click(object sender, EventArgs e)
        {
            lastvalue = txtResult.Text;
            kiemtra = true;
            pheptoan = "/";
        }

        private void btn_bang_Click(object sender, EventArgs e)
        {
            double a, b;
            a = Convert.ToDouble(lastvalue);
            b = Convert.ToDouble(txtResult.Text);
            if (pheptoan == "+")
            txtResult.Text = Convert.ToString(a + b);
            else if (pheptoan == "-")
            txtResult.Text = Convert.ToString(a - b);
            else if (pheptoan == "*")
            txtResult.Text = Convert.ToString(a * b);
            else if (pheptoan == "/")
            {
                if(b != 0)
                {

                    txtResult.Text = Convert.ToString(a / b);
                }
                else
                {

                    txtResult.Text = "khong chia duoc";
                }
            }
        }
    }
}
