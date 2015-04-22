package java8_study.chapter5;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class Question10 {
	public static void main( String[] args )
    {
		//for(String id :  ZoneId.getAvailableZoneIds().toArray(new String[0])){
			//	System.out.println(id);
		//};
		String dptZoneId = "America/Los_Angeles";
		String arvZoneId = "CET";
		LocalTime  dptTime = LocalTime.parse("03:05");
		Duration duration = Duration.parse("PT10H50M");
		
		LocalTime arrivedTime = getArrivedTime(dptZoneId,arvZoneId,dptTime,duration);
		System.out.println(arrivedTime);

    }

	private static LocalTime getArrivedTime(String dptZoneId, String arvZoneId, LocalTime dptTime, Duration duration){

		ZonedDateTime depZonedTime = ZonedDateTime.of(LocalDate.now(),dptTime,ZoneId.of(dptZoneId));
		ZonedDateTime arvZonedTimeAtdep = depZonedTime.plus(duration);
		ZonedDateTime arvTime = arvZonedTimeAtdep.withZoneSameInstant(ZoneId.of(arvZoneId));

		//System.out.println(depZonedTime);
		//System.out.println(arvZonedTime);
		//System.out.println(arvTime);
		//System.out.println(arvTime.toLocalTime());

		return arvTime.toLocalTime();
	}
}
