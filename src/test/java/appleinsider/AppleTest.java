package appleinsider;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class AppleTest extends BaseTest {

    private final static String BASE_URL = "https://appleinsider.ru";
    private final static String SEARCH_STRING = "��� iPhone 13 ���������� �� iPhone 12";
    private final static String EXEPTED_WORD = "iphone-12";

    @Test
    public void checkHref(){
        /**
         * ��������� ���� � ������� ������������ ������� ������� �������.
         */
        Assert.assertTrue(new MainPage(BASE_URL)
                .search(SEARCH_STRING)
                .getHrefFromFirstArticle()
                .contains(EXEPTED_WORD));
        /**
         * appleinsider.MainPage mainPage = new appleinsider.MainPage(BASE_URL);
         * mainPage.search(SEARCH_STRING);
         * appleinsider.SearchPage searchPage = new appleinsider.SearchPage();
         * String href = searchPage.getHrefFromFirstArticle();
         * Assert.assertTrue(href.contains("iphone-13"));
         */

    }

}
