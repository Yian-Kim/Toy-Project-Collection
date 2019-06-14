namespace timer
{
    partial class MyTimer
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MyTimer));
            this.timer1 = new System.Windows.Forms.Timer(this.components);
            this.lblSeconds = new System.Windows.Forms.Label();
            this.lblMinute = new System.Windows.Forms.Label();
            this.lblHour = new System.Windows.Forms.Label();
            this.btnStart = new System.Windows.Forms.Button();
            this.txtHour = new System.Windows.Forms.TextBox();
            this.txtMinute = new System.Windows.Forms.TextBox();
            this.txtSeconds = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fileFToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitEToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.helpHToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.informationIToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.Information = new System.Windows.Forms.ToolStripLabel();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.Exit = new System.Windows.Forms.ToolStripButton();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.lblTextBox = new System.Windows.Forms.Label();
            this.btnEdit = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.toolStrip1.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // timer1
            // 
            this.timer1.Interval = 1000;
            this.timer1.Tick += new System.EventHandler(this.timer1_Tick);
            // 
            // lblSeconds
            // 
            this.lblSeconds.AutoSize = true;
            this.lblSeconds.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.lblSeconds.Location = new System.Drawing.Point(239, 202);
            this.lblSeconds.Name = "lblSeconds";
            this.lblSeconds.Size = new System.Drawing.Size(47, 37);
            this.lblSeconds.TabIndex = 0;
            this.lblSeconds.Text = "00";
            // 
            // lblMinute
            // 
            this.lblMinute.AutoSize = true;
            this.lblMinute.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.lblMinute.Location = new System.Drawing.Point(186, 202);
            this.lblMinute.Name = "lblMinute";
            this.lblMinute.Size = new System.Drawing.Size(47, 37);
            this.lblMinute.TabIndex = 1;
            this.lblMinute.Text = "00";
            // 
            // lblHour
            // 
            this.lblHour.AutoSize = true;
            this.lblHour.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.lblHour.Location = new System.Drawing.Point(133, 202);
            this.lblHour.Name = "lblHour";
            this.lblHour.Size = new System.Drawing.Size(47, 37);
            this.lblHour.TabIndex = 2;
            this.lblHour.Text = "00";
            // 
            // btnStart
            // 
            this.btnStart.Location = new System.Drawing.Point(205, 29);
            this.btnStart.Name = "btnStart";
            this.btnStart.Size = new System.Drawing.Size(64, 37);
            this.btnStart.TabIndex = 3;
            this.btnStart.Text = "Start";
            this.btnStart.UseVisualStyleBackColor = true;
            this.btnStart.Click += new System.EventHandler(this.btnStart_Click);
            // 
            // txtHour
            // 
            this.txtHour.Font = new System.Drawing.Font("맑은 고딕", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.txtHour.Location = new System.Drawing.Point(101, 91);
            this.txtHour.MaxLength = 2;
            this.txtHour.Multiline = true;
            this.txtHour.Name = "txtHour";
            this.txtHour.Size = new System.Drawing.Size(39, 31);
            this.txtHour.TabIndex = 0;
            this.txtHour.Text = "00";
            this.txtHour.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.txtHour.TextChanged += new System.EventHandler(this.txt_TextChanged);
            // 
            // txtMinute
            // 
            this.txtMinute.Font = new System.Drawing.Font("맑은 고딕", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.txtMinute.Location = new System.Drawing.Point(156, 91);
            this.txtMinute.MaxLength = 2;
            this.txtMinute.Multiline = true;
            this.txtMinute.Name = "txtMinute";
            this.txtMinute.Size = new System.Drawing.Size(39, 31);
            this.txtMinute.TabIndex = 1;
            this.txtMinute.Text = "00";
            this.txtMinute.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.txtMinute.TextChanged += new System.EventHandler(this.txt_TextChanged);
            // 
            // txtSeconds
            // 
            this.txtSeconds.Font = new System.Drawing.Font("맑은 고딕", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.txtSeconds.Location = new System.Drawing.Point(210, 91);
            this.txtSeconds.MaxLength = 2;
            this.txtSeconds.Multiline = true;
            this.txtSeconds.Name = "txtSeconds";
            this.txtSeconds.Size = new System.Drawing.Size(39, 31);
            this.txtSeconds.TabIndex = 2;
            this.txtSeconds.Text = "00";
            this.txtSeconds.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            this.txtSeconds.TextChanged += new System.EventHandler(this.txt_TextChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label3.Location = new System.Drawing.Point(138, 84);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(23, 37);
            this.label3.TabIndex = 7;
            this.label3.Text = ":";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label4.Location = new System.Drawing.Point(192, 84);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(23, 37);
            this.label4.TabIndex = 8;
            this.label4.Text = ":";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label5.Location = new System.Drawing.Point(171, 200);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(23, 37);
            this.label5.TabIndex = 9;
            this.label5.Text = ":";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("맑은 고딕", 20.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label6.Location = new System.Drawing.Point(225, 200);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(23, 37);
            this.label6.TabIndex = 10;
            this.label6.Text = ":";
            // 
            // statusStrip1
            // 
            this.statusStrip1.Location = new System.Drawing.Point(0, 293);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(431, 22);
            this.statusStrip1.TabIndex = 11;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fileFToolStripMenuItem,
            this.helpHToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(431, 24);
            this.menuStrip1.TabIndex = 12;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fileFToolStripMenuItem
            // 
            this.fileFToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.exitEToolStripMenuItem});
            this.fileFToolStripMenuItem.Name = "fileFToolStripMenuItem";
            this.fileFToolStripMenuItem.Size = new System.Drawing.Size(51, 20);
            this.fileFToolStripMenuItem.Text = "File(&F)";
            // 
            // exitEToolStripMenuItem
            // 
            this.exitEToolStripMenuItem.Name = "exitEToolStripMenuItem";
            this.exitEToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.exitEToolStripMenuItem.Text = "Exit(&E)";
            this.exitEToolStripMenuItem.Click += new System.EventHandler(this.exitEToolStripMenuItem_Click);
            // 
            // helpHToolStripMenuItem
            // 
            this.helpHToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.informationIToolStripMenuItem});
            this.helpHToolStripMenuItem.Name = "helpHToolStripMenuItem";
            this.helpHToolStripMenuItem.Size = new System.Drawing.Size(61, 20);
            this.helpHToolStripMenuItem.Text = "Help(&H)";
            // 
            // informationIToolStripMenuItem
            // 
            this.informationIToolStripMenuItem.Name = "informationIToolStripMenuItem";
            this.informationIToolStripMenuItem.Size = new System.Drawing.Size(152, 22);
            this.informationIToolStripMenuItem.Text = "Information(&I)";
            this.informationIToolStripMenuItem.Click += new System.EventHandler(this.informationIToolStripMenuItem_Click);
            // 
            // toolStrip1
            // 
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.Information,
            this.toolStripSeparator1,
            this.Exit});
            this.toolStrip1.Location = new System.Drawing.Point(0, 24);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(431, 25);
            this.toolStrip1.TabIndex = 13;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // Information
            // 
            this.Information.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Information.Name = "Information";
            this.Information.Size = new System.Drawing.Size(70, 22);
            this.Information.Text = "information";
            this.Information.Click += new System.EventHandler(this.informationIToolStripMenuItem_Click);
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(6, 25);
            // 
            // Exit
            // 
            this.Exit.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Text;
            this.Exit.Image = ((System.Drawing.Image)(resources.GetObject("Exit.Image")));
            this.Exit.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.Exit.Name = "Exit";
            this.Exit.Size = new System.Drawing.Size(30, 22);
            this.Exit.Text = "Exit";
            this.Exit.Click += new System.EventHandler(this.exitEToolStripMenuItem_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.btnEdit);
            this.groupBox1.Controls.Add(this.lblTextBox);
            this.groupBox1.Controls.Add(this.btnStart);
            this.groupBox1.Location = new System.Drawing.Point(59, 58);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(311, 120);
            this.groupBox1.TabIndex = 14;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Setting";
            // 
            // lblTextBox
            // 
            this.lblTextBox.AutoSize = true;
            this.lblTextBox.Location = new System.Drawing.Point(45, 86);
            this.lblTextBox.Name = "lblTextBox";
            this.lblTextBox.Size = new System.Drawing.Size(91, 12);
            this.lblTextBox.TabIndex = 15;
            this.lblTextBox.Text = "Fill in the Blank";
            // 
            // btnEdit
            // 
            this.btnEdit.Location = new System.Drawing.Point(205, 74);
            this.btnEdit.Name = "btnEdit";
            this.btnEdit.Size = new System.Drawing.Size(64, 37);
            this.btnEdit.TabIndex = 16;
            this.btnEdit.Text = "Edit";
            this.btnEdit.UseVisualStyleBackColor = true;
            this.btnEdit.Click += new System.EventHandler(this.btnEdit_Click);
            // 
            // MyTimer
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(431, 315);
            this.Controls.Add(this.toolStrip1);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.menuStrip1);
            this.Controls.Add(this.txtSeconds);
            this.Controls.Add(this.txtMinute);
            this.Controls.Add(this.txtHour);
            this.Controls.Add(this.lblHour);
            this.Controls.Add(this.lblMinute);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.lblSeconds);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.groupBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MainMenuStrip = this.menuStrip1;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "MyTimer";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "MyTimer";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Timer timer1;
        private System.Windows.Forms.Label lblSeconds;
        private System.Windows.Forms.Label lblMinute;
        private System.Windows.Forms.Label lblHour;
        private System.Windows.Forms.Button btnStart;
        private System.Windows.Forms.TextBox txtHour;
        private System.Windows.Forms.TextBox txtMinute;
        private System.Windows.Forms.TextBox txtSeconds;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fileFToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem helpHToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem informationIToolStripMenuItem;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripLabel Information;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripButton Exit;
        private System.Windows.Forms.ToolStripMenuItem exitEToolStripMenuItem;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button btnEdit;
        private System.Windows.Forms.Label lblTextBox;
    }
}

