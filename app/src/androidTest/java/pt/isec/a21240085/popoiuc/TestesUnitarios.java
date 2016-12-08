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
    //Testar se o ano não é compatível (< 1981)
    @Test
    public void teste1() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(1980,1805,102,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano é compatível (1981 <= ano <= ano_do_sistema)
    @Test
    public void teste2() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2004,1200,115,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano não é compatível ( > ano_do_sistema)
    @Test
    public void teste3() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2036,1200,115,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano é compatível + cilindrada errada
    @Test
    public void teste4() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2012,-1,110,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano é compatível + cilindrada correta + CO2 errado
    @Test
    public void teste5() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2012,1200,-1,0,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano é compatível + cilindrada correta + CO2 correto + combustivel errado
    @Test
    public void teste6() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2012,1200,119,3,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar se o ano é compatível + cilindrada correta + CO2 correto + combustivel errado
    @Test
    public void teste7() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2012,1200,119,-1,c);
        reality = m.code;
        assertEquals(expected, reality);
    }

    //Testar método moduloCalculo tudo correto
    @Test
    public void teste8() throws Exception{
        boolean expected = true;
        moduloCalculo m = null;
        Context c = null;
        boolean reality = true;

        m = new moduloCalculo(2012,1200,119,1,c);
        reality = m.code;
        assertEquals(expected, reality);
    }
}
