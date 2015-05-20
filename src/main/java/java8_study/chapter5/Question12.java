package java8_study.chapter5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question12 {
	public static void main( String[] args )
    {
		Todo todo = new Todo();
		todo.add(new Task(LocalDateTime.parse("2015-04-22T10:10:10"),"Asia/Tokyo","meting1"));
		todo.add(new Task(LocalDateTime.parse("2015-04-23T02:10:10"),"Asia/Tokyo","meting2"));
		todo.add(new Task(LocalDateTime.parse("2015-04-23T03:10:10"),"Asia/Tokyo","meting3"));


		List<Task> alerts = todo.getAlerts();
		for(Task task:alerts){
			System.out.println(task.getTimeStr() + " "+ task.getTask());
		}
    }

	public static class Todo{
		private List<Task> tasks;
		public Todo(){
			tasks = new ArrayList<Task>();
		}
		public void add(Task task){
			tasks.add(task);
		}
		public List<Task> getAlerts(){
			ZonedDateTime now = ZonedDateTime.now();
			return tasks.stream().filter( t -> t.isTime(now)).collect(Collectors.toList());
		}
	}

	public static class Task{
		private ZonedDateTime time;
		private String task;
		public Task(LocalDateTime time,String zoneid,String task){
			this.time = ZonedDateTime.of(time,ZoneId.of(zoneid));
			this.task = task;
		}
		public String getTask(){
			return task;
		}
		public String getTimeStr(){
			return time.toString();
		}
		public boolean isTime(ZonedDateTime now){
			ZoneId zoneid = now.getZone();
			ZonedDateTime tasktime = this.time.withZoneSameLocal(zoneid);
			Duration d = Duration.between(now,tasktime);
			return d.getSeconds() >= 0 && d.getSeconds() < 3600;
		}
	}
}
