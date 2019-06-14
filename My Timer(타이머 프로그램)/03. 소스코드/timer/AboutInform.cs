using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace timer
{
    public partial class AboutInform : Form
    {
        public AboutInform()
        {
            InitializeComponent();
            linkLabel1.Links.Add(0, 0, "www.hallym.ac.kr");

        }

        private void OKButton_Click(object sender, EventArgs e)
        {
            // 확인 버튼을 누르면 프로그램 창 닫힘
            this.Close();
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            // 하이퍼링크
            System.Diagnostics.Process.Start(e.Link.LinkData.ToString());
        }
    }
}
