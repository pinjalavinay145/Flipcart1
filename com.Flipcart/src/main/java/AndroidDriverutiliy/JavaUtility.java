package AndroidDriverutiliy;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNum()
	{
		Random ran= new Random();
		int num=ran.nextInt(5000);
		return num;
	}

	public String getSystemDateYYYYDDMM()
	{
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = sim.format(dateobj);
		return currentdate;
	}
	public String getRequiredDateYYYYDDMM(int days)
	{
		Date dateobj= new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String requireddate = sim.format(cal.getTime());
		return requireddate;

	}
	public String getTimeStamp()
	{
		String timestamp= new Date().toString().replace(" ","_").replace(":","_");
		
		return timestamp;
		
	}
	
}
