package appleinsider;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/**
 * ������� �������� ����� appleinsider.ru
 */
public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@type='text']");

    public MainPage(String url) {
        Selenide.open(url);
    }

    /**
     * ����������� ����� �� ����� ����� ������ ���������� ������ Enter
     * @param searchString ��������� ������
     */

    public SearchPage search(String searchString){ //������� void �� appleinsider.SearchPage ��� ���������� ������
        textBoxInput.setValue(searchString);
        textBoxInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }

}
