package java8_study.chapter3;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Question1 {
	public static void main( String[] args )
    {
		int i = 3;
		String[] a = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l"};

		LoggerEx logger = LoggerEx.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.logif(Level.FINEST,() -> i == 10, () -> "a[10] = " + a[10]);

    }

	public static class LoggerEx{
		private Logger logger;
		protected LoggerEx(String name) {
			logger = Logger.getLogger(name);
		}

		public static LoggerEx getLogger(String name){
			return  new LoggerEx(name);
		}

		public void logif(Level level, BooleanSupplier condition, Supplier<String> msgSupplier){
			if (logger.isLoggable(level) && condition.getAsBoolean()){
				logger.log(level,msgSupplier.get());
			}

		}

	}
}
