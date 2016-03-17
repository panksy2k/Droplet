package com.pardasani.digital.util;

import com.google.common.collect.Ordering;

import java.util.Comparator;

/**
 * Created by pardasap on 14/10/2015.
 */
public class QuestionNumberOrdering {

    private static final Comparator<Long> questionNumberminComparator = new Comparator<Long>() {
        @Override
        public int compare(Long q1, Long q2) {
            return (q1.longValue() < q2.longValue() ? -1 : (q1.longValue() > q2.longValue() ? 1 : 0) );
        }
    };

    public static final Ordering<Long> questionNumberOrdering = Ordering.from(questionNumberminComparator);
}
