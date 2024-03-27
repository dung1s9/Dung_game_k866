using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace staff
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }

        private void Login_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            DialogResult dg = MessageBox.Show("Bạn có muốn thoát ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (dg == DialogResult.Yes)
                Application.Exit();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string user = "Dungvip";
            string pass = "Dungpro";
            if (user.Equals(textBox1.Text) && pass.Equals(textBox2.Text))
            {
                MessageBox.Show("Dang nhap thanh cong");
            }
            else
                MessageBox.Show("Sai tai khoan hoac mat khau");
            if (user.Equals(textBox1.Text) && pass.Equals(textBox2.Text))
            {
                this.Hide();
               
            }    
            else
            {
                label2.Visible = true;
                label2.Text = "wrong username or password ";
            }    
        }

    }
}
