package com.digitalhouse.appteste;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testeInversaoPalavra(){
        MainActivity mainActivity = new MainActivity();

        String palavraInvertida= mainActivity.inverterPalavra("fabio");
        assertEquals("oibaf", palavraInvertida);
    }

}