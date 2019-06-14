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
	public partial class MyTimer : Form
	{
		int hour;
		int minute;
		int sec;

		public MyTimer()
		{
			InitializeComponent();
		}

		private void timer1_Tick(object sender, EventArgs e)
		{
			if(sec > 0 || minute > 0 || hour > 0)
			{
				if(sec == 0)
				{
					if(minute == 0)
					{
						if(hour > 0)
						{
							minute = 60;
							lblHour.Text = (hour <= 10 ? "0" : "") + --hour;
						}
					}
					if(minute > 0)
					{
						sec = 60;
						lblMinute.Text = (minute <= 10 ? "0" : "") + --minute;
					}
				}
				lblSeconds.Text = (sec <= 10 ? "0" : "") + --sec;
			}
			else
			{
				timer1.Stop();
				btnStart.Text = "시작";
			}
		}

		private void btnStart_Click(object sender, EventArgs e)
		{
			if(!timer1.Enabled)
			{
				hour = int.Parse(txtHour.Text);
				minute = int.Parse(txtMinute.Text);
				sec = int.Parse(txtSeconds.Text);
				lblHour.Text = (txtHour.Text.Length == 1 ? "0" : "") + txtHour.Text;
				lblMinute.Text = (txtMinute.Text.Length == 1 ? "0" : "") + txtMinute.Text;
				lblSeconds.Text = (txtSeconds.Text.Length == 1 ? "0" : "") + txtSeconds.Text;
				timer1.Start();
				btnStart.Text = "중지";
			}
			else
			{
				timer1.Stop();
                btnStart.Text = "시작";
                if (MessageBox.Show("Do you want to stop it?", "Stop", MessageBoxButtons.OKCancel, MessageBoxIcon.Question) == DialogResult.OK)
                   this.Close();
            }
		}

		private void txt_TextChanged(object sender, EventArgs e)
		{
			TextBox txt = sender as TextBox;

			switch(txt.Name)
			{
				case "txtHour":
					lblHour.Text = (txt.Text.Length == 1 ? "0" : "") + txt.Text;
					break;
				case "txtMinute":
					lblMinute.Text = (txt.Text.Length == 1 ? "0" : "") + txt.Text;
					break;
				case "txtSeconds":
					lblSeconds.Text = (txt.Text.Length == 1 ? "0" : "") + txt.Text;
					break;
			}
		}

        private void informationIToolStripMenuItem_Click(object sender, EventArgs e)
        {
            // 프로그램 정보를 표시할 폼을 만들어 나타내기
            AboutInform af = new AboutInform();
            af.Show();
        }

        private void exitEToolStripMenuItem_Click(object sender, EventArgs e)
        {            
            // 프로그램 종료 메시지 박스를 이용하여 종료 여부 다시 확인
            if (MessageBox.Show("Will you close the program?", "Exit", MessageBoxButtons.OKCancel, MessageBoxIcon.Question) == DialogResult.OK)
                Application.Exit();

        }

        private void MyTimer_MouseMove(object sender, MouseEventArgs e)
        {
            // 마우스 포인터 위치 표시
            if (statusStrip1.Items.Count > 0)
                statusStrip1.Items[0].Text = "마우스 포인터 : " + e.X + "," + e.Y;
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            // 사용자 정의 대화상자 호출
            Edit ed = new Edit();
            ed.Show();
        }
    }
}
