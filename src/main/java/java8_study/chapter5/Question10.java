package java8_study.chapter5;

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
		String dptTime = "03:05";
		String time = "10:50";

		LocalTime arrivedTime = getArrivedTime(dptZoneId,arvZoneId,dptTime,time);
		System.out.println(arrivedTime);

    }

	private static LocalTime getArrivedTime(String dptZoneId, String arvZoneId, String dptTime, String time){

		LocalTime  dptLocalTime = LocalTime.parse(dptTime);
		LocalTime duration = LocalTime.parse(time);

		ZonedDateTime depZonedTime = ZonedDateTime.of(LocalDate.now(),dptLocalTime,ZoneId.of(dptZoneId));
		ZonedDateTime arvZonedTime = depZonedTime.plusHours(duration.getHour()).plusMinutes(duration.getMinute());
		ZonedDateTime arvTime = arvZonedTime.withZoneSameInstant(ZoneId.of(arvZoneId));

		//System.out.println(depZonedTime);
		//System.out.println(arvZonedTime);
		//System.out.println(arvTime);
		//System.out.println(arvTime.toLocalTime());

		return arvTime.toLocalTime();
	}
}
