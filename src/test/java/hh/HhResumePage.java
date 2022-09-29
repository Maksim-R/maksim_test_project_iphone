package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HhResumePage {
    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveDate = $x("//span[@data-qa='resume-personal-address']//ancestor::p");
    private final SelenideElement tick = $x("//div[@data-qa='resume-serp_resume-item-content']//span[1]");

    public static String GENDER = "���";
    public static String AGE = "�������";
    public static String CITY = "�����";
    public static String CONFIRMED_PHONE = "�������������� �����";
    public static String READY_TO_RELOCATE = "���������� � ��������";


    public HhResumePage(String url) {
        Selenide.open(url);
    }

    public Map<String,Object> getAttributes(){
        return new HashMap<>(){{
        put(GENDER, getGender());
        put(AGE, getAge());
        put(CITY, getCity());
        put(CONFIRMED_PHONE, isPhoneConfirmed ());
        put(READY_TO_RELOCATE, isReadyToRelocate ());
        }};
        /**
         * ��� ���� ��� ������� � ������ ����.
         * Map<String,Object> attributes = new HashMap<>();
         * attributes.put(GENDER, getGender());
         * attributes.put(AGE, getGender());
         * attributes.put(CITY, getCity());
         * attributes.put(CONFIRMED_PHONE, isPhoneConfirmed ());
         * attributes.put(READY_TO_RELOCATE, isReadyToRelocate ());
         * return attributes;
         */

    }

    public boolean isPhoneConfirmed(){
        return tick.isDisplayed();
    }

    public boolean isReadyToRelocate(){
        return !liveDate.getText().split(", ")[1].equals("�� ����� � ��������");

        /**
         * ��� ���� ��� ������� � ������ ����.
         * String[] array = liveDate.getText().split(", ");
         * String relocate = array[2];
         * return false;
         */

    }

    public String getCity(){
        return city.getText();
    }

    public int getAge(){
       return Integer.parseInt(age.getText().replaceAll("\\D+",""));

    }
/*
    public String getGender(){
        String genderValue = gender.getText();
        if (genderValue == "�������"){
            return "�";
        }
        return "�";
    }
*/
    public String getGender() {
        return gender.getText().equals("�������") ? "�" : "�";
    }
}
