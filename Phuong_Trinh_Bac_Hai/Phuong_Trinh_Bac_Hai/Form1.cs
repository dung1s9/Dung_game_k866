using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Phuong_Trinh_Bac_Hai
{
    public partial class Form1 : Form
    {
        double a, b, c, delta, x1, x2;
        string s;

        private void RadioGPTBac1_CheckedChanged(object sender, EventArgs e)
        {
            KhungNhapC.Enabled = false;
            this.KhungNhapA.ResetText();
            this.KhungNhapB.ResetText();
            this.KhungNhapC.ResetText();
            this.KhungKetQua.ResetText();
        }

        private void RadioGPTBac2_CheckedChanged(object sender, EventArgs e)
        {
            KhungNhapC.Enabled = true;
            this.KhungNhapA.ResetText();
            this.KhungNhapB.ResetText();
            this.KhungNhapC.ResetText();
            this.KhungKetQua.ResetText();
        }

        //............................................
        private void btn_thuchien_Click(object sender, EventArgs e)
        {
            if (RadioGPTBac1.Checked == true)
            {
                a = Convert.ToDouble(KhungNhapA.Text);
                b = Convert.ToDouble(KhungNhapB.Text);
                if (a == 0)
                    if (b == 0)
                        KhungKetQua.Text = "Phuong Trinh Vo so Nghiem";
                    else
                        KhungKetQua.Text = "Phuong Trinh Vo Nghiem";
                else
                    KhungKetQua.Text = "Phuong Trinh co nghiem: " + ((-b) / a).ToString();
            }
            if (RadioGPTBac2.Checked == true)
            {
                a = Convert.ToDouble(KhungNhapA.Text);
                b = Convert.ToDouble(KhungNhapB.Text);
                c = Convert.ToDouble(KhungNhapC.Text);
                if (a == 0)
                    if (b == 0)
                        if (c == 0)
                            KhungKetQua.Text = "Phuong Trinh Vo so nghiem";
                        else
                            KhungKetQua.Text = "Phuong Trinh Vo nghiem";
                    else
                        KhungKetQua.Text = "Phuong Trinh Co Nghiem: " + ((-c) / b).ToString();
                else
                    delta = (b * b) - (4 * a * c);
                if (delta < 0)
                    KhungKetQua.Text = "Phuong Trinh Vo Nghiem";
                else
                {
                    if (delta == 0)
                        KhungKetQua.Text = "Phuong Trinh co nghiem kep: " + ((-b)/ (2*a));
                    else
                    {
                        x1 = (-b + Math.Sqrt(delta)) / (2 * a);
                        x2 = (-b - Math.Sqrt(delta)) / (2 * a);
                        KhungKetQua.Text = "Phuong Trinh co 2 nghiem: " + "x1 = " + x1 + "                x2 = " + x2;
                    }
                }
            }
        }

        private void btnthoat_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
