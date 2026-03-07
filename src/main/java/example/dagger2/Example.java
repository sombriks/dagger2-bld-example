package example.dagger2;

import example.dagger2.configs.DaggerExampleComponent;
import example.dagger2.configs.ExampleComponent;

public class Example {
    public static void main(String[] args) {
        ExampleComponent exampleComponent = DaggerExampleComponent.builder().build();

    }
}
