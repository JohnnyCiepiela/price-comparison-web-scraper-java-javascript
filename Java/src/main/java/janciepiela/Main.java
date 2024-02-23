package janciepiela;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author Jan Ciepiela
 */
public class Main {

	/**
	 * Main method that loops through the Multithreading class object to run the
	 * threads.
	 * 
	 * @param args for main method
	 */
	public static void main(String[] args) {

		// Running threads
		for (int i = 1; i <= 5; i++) {
			Multithreading myThread1 = new Multithreading(i);

			myThread1.start();
		}
	}

	/**
	 * Method used for scraping the first website.
	 * 
	 * @param product 1
	 * @return returns the confirmation of successful scraping
	 */
	public static String pageOne(String product) {

		final String url = "https://www.gearbest.com/search/?Keyword=" + product;

		try {

			final Document document = Jsoup.connect(url).get();

			int productCounter = 1;

			for (Element row : document.select("div.themes_prod.list_products_item.Columns_4")) {

				System.out.println(" ");
				System.out.println("*************************");
				System.out.println("     PRODUCT No. " + productCounter);
				System.out.println("*************************");

				final String description = row.select("a.item_name.themes_products_title").text();
				System.out.println("1 DESC: " + description);

				final String price = row.select("span.price_data.notranslate").text();
				System.out.println("1 PRICE: " + price);

				final String page_url = row.select("a.item_name.themes_products_title").attr("href");

				final String pageUrl = "https://www.gearbest.com" + page_url;

				System.out.println("1 PRODUCT_URL: " + pageUrl);

				System.out.println(" ");

				HibernateCamera hibernateCamera = new HibernateCamera();
				hibernateCamera.init();
				hibernateCamera.addCamera(1, description, price, pageUrl);
				hibernateCamera.shutDown();

				productCounter++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("The products from " + url + " have been added to the database.");
		return url;

	}

	/**
	 * Method used for scraping the second website.
	 * 
	 * @param product 2
	 * @return returns the confirmation of successful scraping
	 */
	public static String pageTwo(String product) {

		final String url = "https://ritzcamera.com/search?q=" + product + "&type=product";

		try {

			final Document document = Jsoup.connect(url).get();

			int productCounter = 1;

			for (Element row : document.select("div.name-actions.col-sm-9")) {

				System.out.println(" ");
				System.out.println("*************************");
				System.out.println("     PRODUCT No. " + productCounter);
				System.out.println("*************************");

				final String description = row.select("div.description").text();
				System.out.println("2 DESC: " + description);

				final String price = row.select("span.price-new.money").text();
				System.out.println("2 PRICE :" + price);

				final String page_url = row.select("a.link-learn").attr("href");

				final String pageUrl = "https://ritzcamera.com" + page_url;

				System.out.println("2 PRODUCT_URL: " + pageUrl);

				System.out.println(" ");

				HibernateCamera hibernateCamera = new HibernateCamera();
				hibernateCamera.init();
				hibernateCamera.addCamera(1, description, price, pageUrl);
				hibernateCamera.shutDown();

				productCounter++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("The products from " + url + "have been added to the database.");
		return url;
	}

	/**
	 * Method used for scraping the third website.
	 * 
	 * @param product 3
	 * @return returns the confirmation of successful scraping
	 */
	public static String pageThree(String product) {

		final String url = "https://www.teds.com.au/catalogsearch/result/?q=" + product;

		try {

			final Document document = Jsoup.connect(url).get();

			int productCounter = 1;

			for (Element row : document.select("div.product-info ")) {

				System.out.println(" ");
				System.out.println("*************************");
				System.out.println("     PRODUCT No. " + productCounter);
				System.out.println("*************************");

				final String description = row.select("a.title-link").text();
				System.out.println("3 DESC: " + description);

				final String price = row.select("span.price").text();
				System.out.println("3 PRICE :" + price);

				final String page_url = row.select("a.title-link").attr("href");

				System.out.println("3 PRODUCT_URL: " + page_url);

				System.out.println(" ");

				HibernateCamera hibernateCamera = new HibernateCamera();
				hibernateCamera.init();
				hibernateCamera.addCamera(1, description, price, page_url);
				hibernateCamera.shutDown();

				productCounter++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("The products from " + url + "have been added to the database.");
		return url;
	}

	/**
	 * Method used for scraping the fourth website.
	 * 
	 * @param product 4
	 * @return returns the confirmation of successful scraping
	 */
	public static String pageFour(String product) {

		final String url = "https://www.wilkinson.co.uk/catalogsearch/result/?cat=0&q=" + product;

		try {

			final Document document = Jsoup.connect(url).get();

			int productCounter = 1;

			for (Element row : document.select("li.item.product.product-item")) {

				System.out.println(" ");
				System.out.println("*************************");
				System.out.println("     PRODUCT No. " + productCounter);
				System.out.println("*************************");

				final String description = row.select("a.product-item-link").text();
				System.out.println("4 DESC: " + description);

				final String price = row.select("span.price").text();
				System.out.println("4 PRICE :" + price);

				final String page_url = row.select("a.product-item-link").attr("href");

				System.out.println("4 PRODUCT_URL: " + page_url);

				System.out.println(" ");

				HibernateCamera hibernateCamera = new HibernateCamera();
				hibernateCamera.init();
				hibernateCamera.addCamera(1, description, price, page_url);
				hibernateCamera.shutDown();

				productCounter++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("The products from " + url + "have been added to the database.");
		return url;
	}

	/**
	 * Method used for scraping the fifth website.
	 * 
	 * @param product 5
	 * @return returns the confirmation of successful scraping
	 */
	public static String pageFive(String product) {

		final String url = "https://www.42photo.com/Search?keywords=" + product;

		try {

			final Document document = Jsoup.connect(url).get();

			int productCounter = 1;

			for (Element row : document
					.select("li.row-first-product.span4.clearfix.42-jq-row-first-element.42-jq-equal-height-parent")) {

				System.out.println(" ");
				System.out.println("*************************");
				System.out.println("     PRODUCT No. " + productCounter);
				System.out.println("*************************");

				final String description = row.select("a.invarseColor").text();
				System.out.println("5 DESC: " + description);

				final String price = row.select("div.our-price").text();
				System.out.println("5 PRICE: " + price);

				final String page_url = row.select("a.invarseColor").attr("href");

				final String pageUrl = "https://www.42photo.com" + page_url;
				System.out.println("5 PRODUCT_URL: " + pageUrl);

				System.out.println(" ");

				HibernateCamera hibernateCamera = new HibernateCamera();
				hibernateCamera.init();
				hibernateCamera.addCamera(1, description, price, pageUrl);
				hibernateCamera.shutDown();

				productCounter++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("The products from " + url + "have been added to the database.");
		return url;
	}

}
