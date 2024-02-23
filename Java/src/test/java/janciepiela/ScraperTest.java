package janciepiela;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Jan Ciepiela
 *
 */
public class ScraperTest {

	@Test
	/**
	 * Testing out the first scraper
	 */
	public void firstScraperTest() {

		String output = Main.pageOne("camera");

		assertEquals("https://www.gearbest.com/search/?Keyword=camera", output);

	}

	@Test
	/**
	 * Testing out the second scraper
	 */
	public void secondScraperTest() {

		String output = Main.pageTwo("camera");

		assertEquals("https://ritzcamera.com/search?q=camera&type=product", output);
	}

	@Test
	/**
	 * Testing out the third scraper
	 */
	public void thirdScraperTest() {

		String output = Main.pageThree("camera");

		assertEquals("https://www.teds.com.au/catalogsearch/result/?q=camera", output);
	}

	@Test
	/**
	 * Testing out the fourth scraper
	 */
	public void fourthScraperTest() {

		String output = Main.pageFour("camera");

		assertEquals("https://www.wilkinson.co.uk/catalogsearch/result/?cat=0&q=camera", output);
	}

	@Test
	/**
	 * Testing out the fifth scraper
	 */
	public void fifthScraperTest() {

		String output = Main.pageFive("camera");

		assertEquals("https://www.42photo.com/Search?keywords=camera", output);
	}

}
