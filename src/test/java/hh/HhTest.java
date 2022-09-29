package hh;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HhTest extends BaseTest {
    private final static String URL = "https://hh.ru/applicant/resumes/view?resume=1edf0c93ff095811d20039ed1f6a3638497073";

    @Test
    public void checkAttributesHashMap(){
        HhResumePage hhResumePage = new HhResumePage(URL);
        Map<String,Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(HhResumePage.GENDER, "М");
        expectedAttributes.put(HhResumePage.AGE, 26);
        expectedAttributes.put(HhResumePage.CITY, "Санкт-Петербург");
        expectedAttributes.put(HhResumePage.CONFIRMED_PHONE, true);
        expectedAttributes.put(HhResumePage.READY_TO_RELOCATE, false);

        Map<String,Object> actualAttributes = hhResumePage.getAttributes();

        Assert.assertEquals(expectedAttributes,actualAttributes);
    }

}
