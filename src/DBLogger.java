
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class does the job of handling the logger for the JDBC&DBMS.
 * 
 * @author H
 *
 */
public class DBLogger {
	
private static DBLogger instance;

	public static DBLogger getInstance() {
		if (DBLogger.instance == null) {
			synchronized (DBLogger.class) {
				if (DBLogger.instance == null) {
					DBLogger.instance = new DBLogger();
				}
			}
		}
		return DBLogger.instance;
	}

	public Logger log;

	private FileHandler fh;

	private DBLogger() {
		final File f = new File("log.txt");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (final IOException e) {
				System.out.println("Failed to create log file.");
				e.printStackTrace();
			}
		}
		try {
			fh = new FileHandler("log.txt", true);
		} catch (SecurityException | IOException e) {
			System.out.println("Failed to handle log file.");
			e.printStackTrace();
		} // Appends to log.txt file.
		log = Logger.getLogger("MainLog");
		log.addHandler(fh);
		fh.setFormatter(new SimpleFormatter());
		log.setLevel(Level.INFO);
	}

}