namespace timer
{
    partial class Edit
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
            this.btnEdit = new System.Windows.Forms.Button();
            this.btnCanCle = new System.Windows.Forms.Button();
            this.txtBox = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnEdit
            // 
            this.btnEdit.Location = new System.Drawing.Point(37, 94);
            this.btnEdit.Name = "btnEdit";
            this.btnEdit.Size = new System.Drawing.Size(71, 29);
            this.btnEdit.TabIndex = 0;
            this.btnEdit.Text = "Edit";
            this.btnEdit.UseVisualStyleBackColor = true;
            this.btnEdit.Click += new System.EventHandler(this.btnEdit_Click);
            // 
            // btnCanCle
            // 
            this.btnCanCle.Location = new System.Drawing.Point(116, 94);
            this.btnCanCle.Name = "btnCanCle";
            this.btnCanCle.Size = new System.Drawing.Size(71, 29);
            this.btnCanCle.TabIndex = 1;
            this.btnCanCle.Text = "Cancle";
            this.btnCanCle.UseVisualStyleBackColor = true;
            this.btnCanCle.Click += new System.EventHandler(this.btnCancle_Click);
            // 
            // txtBox
            // 
            this.txtBox.Location = new System.Drawing.Point(37, 40);
            this.txtBox.Multiline = true;
            this.txtBox.Name = "txtBox";
            this.txtBox.Size = new System.Drawing.Size(150, 27);
            this.txtBox.TabIndex = 2;
            // 
            // Edit
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(229, 156);
            this.Controls.Add(this.txtBox);
            this.Controls.Add(this.btnCanCle);
            this.Controls.Add(this.btnEdit);
            this.Name = "Edit";
            this.Text = "Edit";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnEdit;
        private System.Windows.Forms.Button btnCanCle;
        private System.Windows.Forms.TextBox txtBox;
    }
}