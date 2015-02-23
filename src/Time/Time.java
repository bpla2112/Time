package Time;

// The Time class stores the time in military format and returns it as 
// a String in AM/PM format

public class Time
{
   // instance vars store time in military format

   private int hour;		// 0..23
   private int minute;		// 0..59
   private int second;		// 0..59

   // create a Time object with a given hour, minute, and second
   public Time(int hr, int min, int sec) throws Exception
   {
      // eliminate duplicate code by calling setTime
      this.setTime(hr, min, sec);
   }

   // returns the time as A.M./P.M. in this form:   hh:mm:ss A.M./P.M.
   public String toString()
   {
      String out = "";			// initialize the return string

      if (hour == 0)			// 12 a.m. (midnight)
      {
         out += "12";
      }
      else if (hour <= 12)		// a.m.
      {
         out += hour;
      }
      else
      {
         out += hour % 12;		// mod for p.m.  ex: 17 is 5 pm
      }
      // assure two-digit minute
      if (minute <= 9)			// if single digit...
      {
         out += ":0" + minute;	//...concatenate leading 0
      }
      else
      {
         out += ":" + minute;
      }

      // assure two-digit second
      if (second <= 9)			// if single digit...
      {
         out += ":0" + second;	//...concatenate leading 0
      }
      else
      {
         out += ":" + second;
      }

      // concatenate am or pm
      if (hour <= 11)
      {
         out += " A.M.";
      }
      else
      {
         out += " P.M.";
      }

      return out;
   }

   // set a Time object to a specified hour, minute, and second
   // any illegal values will throw an exception
   public void setTime(int hr, int min, int sec) throws Exception
   {
      // set the hour
      if (hr >= 0 && hr <= 23)
      {
         hour = hr;
      }
      else
      {
         throw new Exception("ILLEGAL HOUR: " + hr +
                           "  (must be between 0 and 23, inclusive)");
      }
      // set the minute
      if (min >= 0 && min <= 59)
      {
         minute = min;
      }
      else
      {
         throw new Exception("ILLEGAL MINUTE:  " + min +
                           "  (must be between 0 and 59, inclusive)");
      }
      // set the second
      if (sec >= 0 && sec <= 59)
      {
         second = sec;
      }
      else
      {
         throw new Exception("ILLEGAL SECOND:  " + sec +
                           "  (must be between 0 and 59, inclusive)");
      }
   }
}

