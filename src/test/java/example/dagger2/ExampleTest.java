package example.dagger2;

import example.dagger2.repositories.KanbanRepo;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    @Test
    void verifyHello() {
        assertEquals("Hello World!", new Example().getMessage());
    }

    @Test
    void aaaa(){
        int result = new KanbanRepo().hello();
        assertThat(result, equalTo(2));
    }
}
