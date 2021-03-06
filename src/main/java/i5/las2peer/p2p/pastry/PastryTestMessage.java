package i5.las2peer.p2p.pastry;

import rice.p2p.commonapi.Id;
import rice.p2p.commonapi.Message;


/**
 * A simple test message to be sent through the pastry network
 * will be removed later
 * 
 * @author Holger Jan&szlig;en
 *
 */
public class PastryTestMessage implements Message {

	private static final long serialVersionUID = -4167032756391621253L;

	private static int counter = 0;

	/**
	 * Where the Message came from.
	 */
	private Id from;
	/**
	 * Where the Message is going.
	 */
	private Id to;

	private int messageCounter;

	/**
	 * Constructor.
	 */
	public PastryTestMessage(Id from, Id to) {
		counter++;
		this.from = from;
		this.to = to;

		messageCounter = counter;
	}

	public String toString() {
		return "TestMessage: " + messageCounter + " from " + from + " to " + to;
	}

	/**
	 * Use low priority to prevent interference with overlay maintenance
	 * traffic.
	 */
	public int getPriority() {
		return Message.LOW_PRIORITY;
	}
}