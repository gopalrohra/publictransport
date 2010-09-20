import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;
import javax.microedition.lcdui.*;

public class AutoMeter extends MIDlet implements CommandListener {
	private Display display;
	// Main form
	private Form form;
	// For the message
	// For the exit command
	private Command exitCommand;
	private Command calculateCommand;
	private TextField meterReading;

	public AutoMeter() {
		// TODO Auto-generated constructor stub
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

	}

	protected void pauseApp() {
		// TODO Auto-generated method stub

	}

	protected void startApp() throws MIDletStateChangeException {
		// stringItem = new StringItem("Hello", "Hello World!");
		meterReading = new TextField("Enter meter reading", "", 5,
				TextField.NUMERIC);
		form = new Form(null, new Item[] { meterReading });
		exitCommand = new Command("Exit", Command.EXIT, 1);
		calculateCommand = new Command("Calculate", Command.OK, 2);

		form.addCommand(exitCommand);
		form.addCommand(calculateCommand);
		form.setCommandListener(this);
		form.setTitle("Mumbai autoriksha meter calculator");
		meterReading.setString("10");
		// Get display for drawing
		display = Display.getDisplay(this);
		display.setCurrent(form);

	}

	public void commandAction(Command command, Displayable displayable) {
		if (displayable == form) {
			if (command == exitCommand) {
				exitMIDlet();
			}
			else if (command == calculateCommand) 
			{
					calculateMeterReading();
				
			}

		}

	}

	private void calculateMeterReading() {
		int value = Integer.valueOf(meterReading.getString()).intValue();
		int result = (value * 13) - 20;
		meterReading.setString(String.valueOf(result));
	}

	public void exitMIDlet() {
		display.setCurrent(null);
		notifyDestroyed();
	}

}
