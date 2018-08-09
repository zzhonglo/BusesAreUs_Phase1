package ca.ubc.cpsc210.remotecontrol;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * A remote control.
 */
public class RemoteControl implements Iterable<Channel>{
	
	private List<Channel> channels;


	/*
	 * Constructs remote control with no channels.
	 */
	public RemoteControl() {
		channels = new ArrayList<>();
		
		
	}
	
	/*
	 * Adds a channel with the given channel number 
	 * to the remote control.  Maintains the order 
	 * in which channels were added.  Does not allow
	 * duplicate channels.
	 */
	public void addChannel(int numberOfChannel) {
		Channel c = new Channel(numberOfChannel);
		if (!channels.contains(c)) {
			channels.add(c);
		}
	}

	public Iterator<Channel> iterator(){
		return channels.iterator();
	}

}

