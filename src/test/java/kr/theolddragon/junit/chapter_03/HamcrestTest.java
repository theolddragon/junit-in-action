package kr.theolddragon.junit.chapter_03;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * 예제 3.17 난해한 JUnit assert 메서드
 * Created By tigger on 2018-05-31
 */
public class HamcrestTest {

    private List<String> values;

    @Before
    public void setUpList() {

        values = new ArrayList<String>();

        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void testWithoutHamcrest() {
        assertTrue(values.contains("x") || values.contains("two") || values.contains("three"));
    }

    @Test
    public void testWithHamcrest() {
        assertThat(values, hasItem(anyOf(equalTo("x"), equalTo("two"), equalTo("three"))));
    }
}
