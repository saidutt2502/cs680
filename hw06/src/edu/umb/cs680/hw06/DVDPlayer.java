package edu.umb.cs680.hw06;

public class DVDPlayer {
	
	private static DVDPlayer instance = null;
	private static State state;

	private DVDPlayer(State s) {
		state = s;
	}

	public static DVDPlayer getInstance() {
		if (instance == null) {
			State s = DrawerClosedNotPlaying.getInstance();
			instance = new DVDPlayer(s);
		}
		return instance;
	}

	public void changeState(State s) {
		state = s;
	}
	
	public Object getCurrentState() {
		return state;
	}

	public void openCloseButtonPushed() {
		state.openCloseButtonPushed();
	}

	public void playButtonPushed() {
		state.playButtonPushed();
	}

	public void stopButtonPushed() {
		state.stopButtonPushed();
	}

	public void open() {
		System.out.println("Opening DVD Player Drawer.");
	}

	public void close() {
		System.out.println("Closing DVD Player Drawer.");
	}

	public void play() {
		System.out.println("Playing DVD.");
	}

	public void stop() {
		System.out.println("Stopped.");
	}

	public static void main(String args[]) {
		DVDPlayer player = DVDPlayer.getInstance();
		player.openCloseButtonPushed();
		player.playButtonPushed();
		player.stopButtonPushed();
	}
}
