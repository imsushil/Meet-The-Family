package geektrust.family;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import geektrust.family.exceptions.InvalidCommandException;
import geektrust.family.pojo.Family;

/**
 * Start of the application
 * 
 * @author Sushil
 */
public class MainApplication {
	private static final Logger LOGGER = Logger.getLogger(MainApplication.class.getName());

	public static void main(String[] args) throws IOException {
		new Family();
		// String filePath = args[0];
		String filePath = "C:/Users/sushil/Desktop/Family/input.txt";
		QueryProcessor queryProcessor = new QueryProcessor();
		Family shanFamily = new Family();
		queryProcessor.processInitCommand(shanFamily);

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String command;
			while ((command = br.readLine()) != null) {
				System.out.println(queryProcessor.processInputCommand(command, shanFamily));
			}
		} catch (InvalidCommandException e) {
			LOGGER.log(Level.INFO, e.getMessage());
		} catch (IOException e) {
			LOGGER.log(Level.INFO, e.getMessage(), e);
		} catch (Exception e) {
			LOGGER.log(Level.INFO, "Some exception occurred.", e);
		}
	}
}
