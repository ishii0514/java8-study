package java8_study.chapter3;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

//参考にするサイト
//http://closedunbounded.hatenablog.com/entry/2015/02/27/190524
//https://github.com/namihiran/java8
public class Question1 {
	public static void main( String[] args )
    {
		int i = 10;
		String[] a = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l"};

		LoggerEx logger = LoggerEx.getLogger(Logger.GLOBAL_LOGGER_NAME);
		logger.logif(Level.FINEST,() -> i == 10, () -> "a[10] = " + a[10]);

    }

	public static class LoggerEx{
		private Logger logger;
		private LoggerEx(String name) {
			//ハンドルを切り替えないと、
			//setLevelでALLにしても、INFO以上(INFO,WARNING,SEVERE)しか標準エラー出力に出力されない。
			//setLevelでWARNINGにすると、INFOは出力されなくなる。
			Level newLevel = Level.ALL;
			logger = Logger.getLogger(name);
			logger.setLevel(newLevel);
			ConsoleHandler handler = new ConsoleHandler();
			handler.setLevel(newLevel);
			logger.addHandler(handler);
			logger.setUseParentHandlers(false);
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
