package com.github.phillbarber;

import com.google.common.collect.Lists;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import rx.Observable;

import java.util.ArrayList;

public class DoubleObservableServiceTest {

    @Test
    public void emitsTwoItems(){
        Observable<String> contentFromDownstreamSystem = new DoubleObservableService().getContent();
        ArrayList<String> listOfItems = Lists.newArrayList(contentFromDownstreamSystem.toBlocking().getIterator());
        Assertions.assertThat(listOfItems.size()).isEqualTo(2);
    }
}
