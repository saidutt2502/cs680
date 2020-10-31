package src.edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw06.DVDPlayer;
import edu.umb.cs680.hw06.DrawerClosedNotPlaying;
import edu.umb.cs680.hw06.DrawerClosedPlaying;
import edu.umb.cs680.hw06.DrawerOpen;

class DVDPlayerTest {
	
	@Test
	public void StopButtonPushed_When_DrawerClosedPlaying() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.playButtonPushed();
		player.stopButtonPushed();
		assertEquals(DrawerClosedNotPlaying.getInstance(), player.getCurrentState());
	}
	
	@Test
	public void PlayButtonPushed_When_DrawerClosedNotPlaying() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.playButtonPushed();
		assertEquals(DrawerClosedPlaying.getInstance(), player.getCurrentState());
	}

	@Test
	public void OpenCloseButtonPushed_When_DrawerClosedPlaying() {
		DVDPlayer player = DVDPlayer.getInstance();
		player.playButtonPushed();
		player.openCloseButtonPushed();
		assertEquals(DrawerOpen.getInstance(), player.getCurrentState());
	}

}
