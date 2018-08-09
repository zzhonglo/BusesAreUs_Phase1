package ca.ubc.cpsc210.remotecontrol;

/*
 * A channel available on a media device
 */
public class Channel {
	
	private int channelNumber;
	
	/*
	 * Constructor
	 * 
	 * EFFECTS: channel number is set to number
	 */
	public Channel(int number) {
		channelNumber = number;
	}
	
	/*
	 * Plays the channel.
	 * EFFECTS: plays the channel (simulation)
	 */
	public void play() {
		System.out.println("Playing channel #: <" + channelNumber + ">");
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Channel channel = (Channel) o;

        if (channelNumber != channel.channelNumber) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * channelNumber;
    }
}
