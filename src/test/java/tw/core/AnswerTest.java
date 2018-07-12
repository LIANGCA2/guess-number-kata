package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.core.Is.is;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = Answer.createAnswer("1 2 3 4");
    }

    @Test
    public void should_be_Record_when_Answer_format_is_incorrect(){
        assertThat(actualAnswer.toString(),is("1 2 3 4"));

    }

    @Test
    public void should_be_return_2A1B_when_Answer_check(){
        Answer inputAnswer =  Answer.createAnswer("6 2 1 4");
        Record record =  actualAnswer.check(inputAnswer);
        Record record1 = mock(Record.class);
        when(record1.getValue()).thenReturn(String.format("2A1B"));
        assertThat(record.getValue(),is(record1.getValue()));
    }


}