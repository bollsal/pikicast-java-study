package quiz.chess.util;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Created by bollsal on 2016. 12. 14..
 */
public class StringUtilTest {

    @Test
    public void NEW_LINE_TEST() {
        assertThat(StringUtil.NEW_LINE, is("\n"));
    }
}
