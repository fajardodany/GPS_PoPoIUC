package pt.isec.a21240085.popoiuc;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class TestesUnitarios {
    //Testar se o ano não é compatível
    @Test
    public void ano_nao_compativel() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(1980,0,0,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano é compatível
    @Test
    public void ano_compativel() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(1981,0,0,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }
}
