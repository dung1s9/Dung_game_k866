using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace tiền_nha_khoa
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btthoat_Click(object sender, EventArgs e)
        {
            DialogResult thongbao;
            thongbao = (MessageBox.Show("Do you want to escape ?", " Demon NOTIFICATION", MessageBoxButtons.YesNo, MessageBoxIcon.Warning));
            if (thongbao == DialogResult.Yes)
                Application.Exit();
        }
        int tien1, tien2, tien3, tien4, tien5, tien6, slrang;

        private void bthoadon_Click(object sender, EventArgs e)
        {

            if (Trongranggia.Checked == false)
                textBox2.Text = Convert.ToString(tien1 + tien2 + tien3 + tien5 + tien6);
            else
            {
                slrang = Convert.ToInt32(textBox3.Text);
                textBox2.Text = Convert.ToString(tien1 + tien2 + tien3 + (tien4 * slrang) + tien5 + tien6);
            }
         
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void btNhaplai_Click(object sender, EventArgs e)
        {
            textBox2.Text = "";
            textBox1.Text = "";
            textBox3.Text = "";
            Laymenrang.Checked = false;
            Niengrang.Checked = false;
            Tramrang.Checked = false;
            Trongranggia.Checked = false;
            Nhorang.Checked = false;
            Caovoirang.Checked = false;
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void Caovoirang_CheckedChanged(object sender, EventArgs e)
        {
            if (Caovoirang.Checked == true)
                tien6 = 500000;
            else
                tien6 = 0;
        }

        private void Nhorang_CheckedChanged(object sender, EventArgs e)
        {
            if (Nhorang.Checked == true)
                tien5 = 400000;
            else
                tien5 = 0;
        }

        private void Trongranggia_CheckedChanged(object sender, EventArgs e)
        {
            if (Trongranggia.Checked == true)
            {
                tien4 = 1000000;
                if (label9.Text == "")
                {
                    MessageBox.Show("Bạn vui lòng chọn số lượng trồng", "Demon thông báo");
                }
            }
            else
                tien4 = 0;

        }

        private void Tramrang_CheckedChanged(object sender, EventArgs e)
        {
            if (Tramrang.Checked == true)
                tien3 = 300000;
            else
                tien3 = 0;
        }

        private void Niengrang_CheckedChanged(object sender, EventArgs e)
        {
            if (Niengrang.Checked == true)
                tien2 = 200000;
            else
                tien2 = 0;
        }

        private void Laymenrang_CheckedChanged(object sender, EventArgs e)
        {
            if (Laymenrang.Checked == true)
                tien1 = 100000;
            else
                tien1 = 0;
        }
    }
}
