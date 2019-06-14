package hansune.android.exam.ctcalendar;
 
import java.util.Calendar;
 
import ctartifact.android.common.CTCalendarView;
import ctartifact.android.common.Oneday;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
 
public class CalendarView extends CTCalendarView {
     
    private Oneday basisDay;
    private int during;
    String str = "";
    int transfer;
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         
        setTitle("원하는 날짜를 선택해 주세요.");
        initialize();
         
        basisDay = new Oneday(this);
        
        Intent intent = getIntent();
        int[] b = intent.getIntArrayExtra("basisDay");
        during = intent.getIntExtra("during", 0);
        if(b != null){
            basisDay.setYear(b[0]);
            basisDay.setMonth(b[1]);
            basisDay.setDay(b[2]);
        } else {
            Calendar cal = Calendar.getInstance();
            basisDay.setYear(cal.get(Calendar.YEAR));
            basisDay.setMonth(cal.get(Calendar.MONTH));
            basisDay.setDay(cal.get(Calendar.DAY_OF_MONTH));
        }
    }
     
    @Override
    protected void onTouched(Oneday touchedDay){
         
        if(isInside(touchedDay, basisDay, during)){
            Calendar cal = Calendar.getInstance();
            cal.set(basisDay.getYear(), basisDay.getMonth(), basisDay.getDay());
            cal.add(Calendar.DAY_OF_MONTH,during);
            Toast.makeText(this, (cal.get(Calendar.MONTH) + 1)+"월"+
                    cal.get(Calendar.DAY_OF_MONTH) + "일 이후 선택 가능", Toast.LENGTH_SHORT).show();
            return;
        }
         
        final String year = String.valueOf(touchedDay.getYear());
        final String month = doubleString(touchedDay.getMonth() + 1);
        final String date = doubleString(touchedDay.getDay());
        //
        AlertDialog.Builder builder =  new AlertDialog.Builder(CalendarView.this);
        builder.setTitle("다음 날짜로 설정하시겠습니까?");
        builder.setMessage(year + "." + month + "." + date + "(" + touchedDay.getDayOfWeekKorean()+")");
        builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
            	intent = new Intent(CalendarView.this, CalendarModify.class);
                //int a=1;
                //str = year + "." + month + "." + date;
            	str = year + month + date;
            	transfer = Integer.parseInt(str.trim());
                //intent.putExtra("date", transfer);
            	intent.putExtra("Param1", transfer);
                //setResult(RESULT_OK, intent);
                //finish();
            	//Toast.makeText(getApplicationContext(), year + "." + month + "." + date, Toast.LENGTH_SHORT).show();
                
                startActivity(intent);
            }
        });
        builder.setNegativeButton("아니오", null);
        builder.show();
    }
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.calendar_menu, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         
        switch (item.getItemId()) {
             
        //오늘
        case R.id.menuitem_calendar_0:
            gotoToday();
            return true;
        }
         
        return false;
    }
     
}