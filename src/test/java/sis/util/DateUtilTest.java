package sis.util;

import org.junit.Test;
import sis.util.DateUtil;

import java.util.Date;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by bollsal on 2016. 11. 22..
 */
public class DateUtilTest {

    @Test
    public void startData() {
        Date startDate = DateUtil.createDate(2016, 1, 4);
        assertThat(DateUtil.getEndDate(startDate), is(DateUtil.createDate(2016, 4, 22)));
    }
}
