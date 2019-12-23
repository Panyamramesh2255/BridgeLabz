package bridgelabz.screenshot;

import java.io.IOException;

import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener.class)
public class ScreenShots extends Base {
	@BeforeTest
	public void setUp() throws IOException {
		init();

	}

	@Test(priority = 2)
	public void screenShots() {
		Assert.assertEquals(true, true);
	}

	@Test(priority = 1)
	public void flasesscreenShots() {
		Assert.assertEquals(true, false);
	}

	@Test(priority = 3)
	public void trueScreenShot() {
		Assert.assertEquals(true, true);
	}

	@AfterTest
	public void quit() {
		driver.quit();
	}

}
