using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.BackColor = Color.LightGoldenrodYellow;
        }

        private void btnTong_Click(object sender, EventArgs e)
        {
            int a, b, tong;
            a = int.Parse(txtNum1.Text);
            b = int.Parse(txtNum2.Text);
            tong = a + b;
            txtResult.Text = tong.ToString();
        }

        private void btnTich_Click(object sender, EventArgs e)
        {
            int a, b, tich;
            a = int.Parse(txtNum1.Text);
            b = int.Parse(txtNum2.Text);
            tich = a * b;
            txtResult.Text = tich.ToString();
        }

        private void btnThuong_Click(object sender, EventArgs e)
        {
            double a, b, thuong;
            a = double.Parse(txtNum1.Text);
            b = double.Parse(txtNum2.Text);
            thuong = a / b;
            txtResult.Text = thuong.ToString();
        }

        private void btnTru_Click(object sender, EventArgs e)
        {
            int a, b, tru;
            a = int.Parse(txtNum1.Text);
            b = int.Parse(txtNum2.Text);
            tru = a - b;
            txtResult.Text = tru.ToString();
        }

        private void btnNhap_Click(object sender, EventArgs e)
        {
            txtNum1.Text = "";
            txtNum2.Text = "";
            txtResult.Text = "";

                
        }

        private void THOAT_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void txtResult_TextChanged(object sender, EventArgs e)
        {

        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void txtNum1_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtNum2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
