package Demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lofg4j_demo {


	// create logger for this particular class 
	private static Logger logger = LogManager.getLogger(Lofg4j_demo.class) ;

	public static void main(String[] args) {
		System.out.println("\n hello world   \n");


		logger.trace("This is trace message ");
		logger.info("this is info message ");
		logger.error("this is error message");
		logger.warn("this is warn message");
		logger.fatal("this is fatal message");


		System.err.println("\n  DONE   \n");


	}

}
