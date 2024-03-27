namespace WindowsFormsApp2
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.txtNum1 = new System.Windows.Forms.TextBox();
            this.contextMenuStrip1 = new System.Windows.Forms.ContextMenuStrip(this.components);
            this.txtNum2 = new System.Windows.Forms.TextBox();
            this.btnTich = new System.Windows.Forms.Button();
            this.txtResult = new System.Windows.Forms.TextBox();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.btnTong = new System.Windows.Forms.Button();
            this.btnThuong = new System.Windows.Forms.Button();
            this.btnTru = new System.Windows.Forms.Button();
            this.THOAT = new System.Windows.Forms.Button();
            this.btnNhap = new System.Windows.Forms.Button();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // txtNum1
            // 
            this.txtNum1.BackColor = System.Drawing.SystemColors.WindowText;
            this.txtNum1.ForeColor = System.Drawing.SystemColors.Info;
            this.txtNum1.Location = new System.Drawing.Point(214, 74);
            this.txtNum1.Name = "txtNum1";
            this.txtNum1.Size = new System.Drawing.Size(249, 26);
            this.txtNum1.TabIndex = 0;
            this.txtNum1.TextChanged += new System.EventHandler(this.txtNum1_TextChanged);
            // 
            // contextMenuStrip1
            // 
            this.contextMenuStrip1.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.contextMenuStrip1.Name = "contextMenuStrip1";
            this.contextMenuStrip1.Size = new System.Drawing.Size(61, 4);
            // 
            // txtNum2
            // 
            this.txtNum2.BackColor = System.Drawing.SystemColors.WindowText;
            this.txtNum2.ForeColor = System.Drawing.SystemColors.Info;
            this.txtNum2.Location = new System.Drawing.Point(214, 151);
            this.txtNum2.Name = "txtNum2";
            this.txtNum2.Size = new System.Drawing.Size(249, 26);
            this.txtNum2.TabIndex = 2;
            this.txtNum2.TextChanged += new System.EventHandler(this.txtNum2_TextChanged);
            // 
            // btnTich
            // 
            this.btnTich.BackColor = System.Drawing.SystemColors.WindowText;
            this.btnTich.ForeColor = System.Drawing.SystemColors.Info;
            this.btnTich.Location = new System.Drawing.Point(150, 255);
            this.btnTich.Name = "btnTich";
            this.btnTich.Size = new System.Drawing.Size(75, 42);
            this.btnTich.TabIndex = 3;
            this.btnTich.Text = "TICH";
            this.btnTich.UseVisualStyleBackColor = false;
            this.btnTich.Click += new System.EventHandler(this.btnTich_Click);
            // 
            // txtResult
            // 
            this.txtResult.BackColor = System.Drawing.SystemColors.WindowText;
            this.txtResult.ForeColor = System.Drawing.SystemColors.Info;
            this.txtResult.Location = new System.Drawing.Point(126, 345);
            this.txtResult.Name = "txtResult";
            this.txtResult.Size = new System.Drawing.Size(251, 26);
            this.txtResult.TabIndex = 4;
            this.txtResult.TextChanged += new System.EventHandler(this.txtResult_TextChanged);
            // 
            // textBox4
            // 
            this.textBox4.Location = new System.Drawing.Point(126, 74);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(10, 26);
            this.textBox4.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.SystemColors.WindowText;
            this.label1.ForeColor = System.Drawing.SystemColors.Info;
            this.label1.Location = new System.Drawing.Point(38, 77);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(116, 20);
            this.label1.TabIndex = 6;
            this.label1.Text = "SO THU NHAT";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.SystemColors.WindowText;
            this.label2.ForeColor = System.Drawing.SystemColors.Info;
            this.label2.Location = new System.Drawing.Point(38, 157);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(101, 20);
            this.label2.TabIndex = 7;
            this.label2.Text = "SO THU HAI";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.SystemColors.WindowText;
            this.label3.ForeColor = System.Drawing.SystemColors.Info;
            this.label3.Location = new System.Drawing.Point(12, 351);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(78, 20);
            this.label3.TabIndex = 8;
            this.label3.Text = "KET QUA";
            this.label3.Click += new System.EventHandler(this.label3_Click);
            // 
            // btnTong
            // 
            this.btnTong.BackColor = System.Drawing.SystemColors.WindowText;
            this.btnTong.ForeColor = System.Drawing.SystemColors.Info;
            this.btnTong.Location = new System.Drawing.Point(16, 252);
            this.btnTong.Name = "btnTong";
            this.btnTong.Size = new System.Drawing.Size(75, 42);
            this.btnTong.TabIndex = 9;
            this.btnTong.Text = "TONG";
            this.btnTong.UseVisualStyleBackColor = false;
            this.btnTong.Click += new System.EventHandler(this.btnTong_Click);
            // 
            // btnThuong
            // 
            this.btnThuong.BackColor = System.Drawing.SystemColors.WindowText;
            this.btnThuong.Font = new System.Drawing.Font("Microsoft YaHei UI", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnThuong.ForeColor = System.Drawing.SystemColors.Info;
            this.btnThuong.Location = new System.Drawing.Point(301, 255);
            this.btnThuong.Name = "btnThuong";
            this.btnThuong.Size = new System.Drawing.Size(96, 39);
            this.btnThuong.TabIndex = 10;
            this.btnThuong.Text = "THUONG";
            this.btnThuong.UseVisualStyleBackColor = false;
            this.btnThuong.Click += new System.EventHandler(this.btnThuong_Click);
            // 
            // btnTru
            // 
            this.btnTru.BackColor = System.Drawing.SystemColors.WindowText;
            this.btnTru.ForeColor = System.Drawing.SystemColors.Info;
            this.btnTru.Location = new System.Drawing.Point(468, 257);
            this.btnTru.Name = "btnTru";
            this.btnTru.Size = new System.Drawing.Size(102, 38);
            this.btnTru.TabIndex = 11;
            this.btnTru.Text = "TRU";
            this.btnTru.UseVisualStyleBackColor = false;
            this.btnTru.Click += new System.EventHandler(this.btnTru_Click);
            // 
            // THOAT
            // 
            this.THOAT.BackColor = System.Drawing.SystemColors.WindowText;
            this.THOAT.ForeColor = System.Drawing.SystemColors.Info;
            this.THOAT.Location = new System.Drawing.Point(79, 397);
            this.THOAT.Name = "THOAT";
            this.THOAT.Size = new System.Drawing.Size(75, 41);
            this.THOAT.TabIndex = 12;
            this.THOAT.Text = "THOAT";
            this.THOAT.UseVisualStyleBackColor = false;
            this.THOAT.Click += new System.EventHandler(this.THOAT_Click);
            // 
            // btnNhap
            // 
            this.btnNhap.BackColor = System.Drawing.SystemColors.WindowText;
            this.btnNhap.ForeColor = System.Drawing.SystemColors.Info;
            this.btnNhap.Location = new System.Drawing.Point(204, 402);
            this.btnNhap.Name = "btnNhap";
            this.btnNhap.Size = new System.Drawing.Size(106, 36);
            this.btnNhap.TabIndex = 13;
            this.btnNhap.Text = "NHAP LAI";
            this.btnNhap.UseVisualStyleBackColor = false;
            this.btnNhap.Click += new System.EventHandler(this.btnNhap_Click);
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(-150, -322);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(1488, 802);
            this.pictureBox1.TabIndex = 14;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1117, 450);
            this.Controls.Add(this.btnNhap);
            this.Controls.Add(this.THOAT);
            this.Controls.Add(this.btnTru);
            this.Controls.Add(this.btnThuong);
            this.Controls.Add(this.btnTong);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox4);
            this.Controls.Add(this.txtResult);
            this.Controls.Add(this.btnTich);
            this.Controls.Add(this.txtNum2);
            this.Controls.Add(this.txtNum1);
            this.Controls.Add(this.pictureBox1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtNum1;
        private System.Windows.Forms.ContextMenuStrip contextMenuStrip1;
        private System.Windows.Forms.TextBox txtNum2;
        private System.Windows.Forms.Button btnTich;
        private System.Windows.Forms.TextBox txtResult;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnTong;
        private System.Windows.Forms.Button btnThuong;
        private System.Windows.Forms.Button btnTru;
        private System.Windows.Forms.Button THOAT;
        private System.Windows.Forms.Button btnNhap;
        private System.Windows.Forms.PictureBox pictureBox1;
    }
}

