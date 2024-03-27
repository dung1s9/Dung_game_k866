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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }


        staff[] liststaff = new staff[100];
        int index, n = 0;

        private void button2_Click(object sender, EventArgs e)
        {
            liststaff[index].ID = txtID.Text;
            liststaff[index].Name = txtname.Text;
            liststaff[index].Address = txtaddress.Text;
            liststaff[index].Phone = txtphone.Text;
            liststaff[index].Email = txtemail.Text;
            liststaff[index].Born = txtborn.Text;
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = liststaff;
             dataGridView1.Refresh();
        }


        private void txtthem_Click(object sender, EventArgs e)
        {
            // Create a new staff object
            staff Staff = new staff();
            Staff.ID = txtID.Text;
            Staff.Name = txtname.Text;
            Staff.Address = txtaddress.Text;
            Staff.Phone = txtphone.Text;
            Staff.Email = txtemail.Text;
            Staff.Born = txtborn.Text;


            // Put the staff object in turn into the listStaff . array
            liststaff[n] = Staff;
            n++;
            //Display the DataGridView
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = liststaff;
           
            loaddata();


        }

        public void loaddata()
        {
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = liststaff;
            dataGridView1.Refresh();

        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            DataGridViewRow row = new DataGridViewRow();
            row = dataGridView1.Rows[e.RowIndex];
            txtID.Text = Convert.ToString(row.Cells["ID"].Value);
            txtname.Text = Convert.ToString(row.Cells["Name"].Value);
            txtborn.Text = Convert.ToString(row.Cells["Born"].Value);
            txtaddress.Text = Convert.ToString(row.Cells["Address"].Value);
            txtemail.Text = Convert.ToString(row.Cells["Email"].Value);
            string Giới_tinh = Convert.ToString(row.Cells["GioiTinh"].Value);
            txtphone.Text = Convert.ToString(row.Cells["Phone"].Value);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            Login login = new Login();
            login.ShowDialog();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void txtxoa_Click(object sender, EventArgs e)
        {
            bool alert;
            alert = MessageBox.Show("Do you want to delete??", "Warning", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning) == DialogResult.OK;
            if (alert)
            {
                while (index < n)
                {
                    liststaff[index] = liststaff[index + 1];
                    index++;
                }
            }
            liststaff[n - 1] = null;
            n = n - 1;
            MessageBox.Show("successful delete", "Notification", MessageBoxButtons.OK);
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = liststaff;
            dataGridView1.Refresh();
        }

        private void txtthoat_Click(object sender, EventArgs e)
        {
            bool alpha;
            alpha = MessageBox.Show("Do you want to exit?", "Warning", MessageBoxButtons.YesNo, MessageBoxIcon.Warning) == DialogResult.Yes;
            this.Close();
        }
    }
}
