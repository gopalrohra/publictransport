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
				TextField.DECIMAL);
		form = new Form(null, new Item[] { meterReading });
		exitCommand = new Command("Exit", Command.EXIT, 1);
		calculateCommand = new Command("Calculate", Command.OK, 2);

		form.addCommand(exitCommand);
		form.addCommand(calculateCommand);
		form.setCommandListener(this);
		form.setTitle("Mumbai autoriksha meter calculator");
		meterReading.setString("1.0");
		// Get display for drawing
		display = Display.getDisplay(this);
		display.setCurrent(form);

	}

	public void commandAction(Command command, Displayable displayable) {
		System.out.println("inside command listner");
		if (displayable == form) {
			System.out.println("inside form condition");
			if (command == exitCommand) {
				System.out.println("inside exit condition");
				exitMIDlet();
			}
			else if (command == calculateCommand) 
			{
				System.out.println("inside calculate");
					calculateMeterReading();
				
			}

		}

	}

	private void calculateMeterReading() {
		double value = Double.valueOf(meterReading.getString()).doubleValue();
		double result = (value * 13) - 2.0;
System.out.println(result);
		meterReading.setString(String.valueOf(result));
	}

	public void exitMIDlet() {
		display.setCurrent(null);
		notifyDestroyed();
	}

}
