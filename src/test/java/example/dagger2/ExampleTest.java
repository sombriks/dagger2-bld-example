package example.dagger2;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    private final ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();

    @Test
    void verifyHello() {
        assertEquals("Hello World!", new Example().getMessage());
    }

    @Test
    void aaaa() {
        int result = exampleComponent.kanbanRepo().hello();
        assertThat(result, equalTo(2));
    }
}
