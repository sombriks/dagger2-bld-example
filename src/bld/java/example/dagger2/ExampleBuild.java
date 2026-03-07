package example.dagger2;

import rife.bld.Project;
import rife.bld.operations.JavacOptions;

import java.nio.file.Paths;
import java.util.List;

import static rife.bld.dependencies.Repository.*;
import static rife.bld.dependencies.Scope.*;

public class ExampleBuild extends Project {

    public ExampleBuild() {

        pkg = "example.dagger2";
        name = "dagger2-bld-example";
        mainClass = "example.dagger2.Example";
        version = version(0, 1, 0);

        javaRelease = 25;
        downloadSources = true;
        repositories = List.of(MAVEN_CENTRAL, RIFE2_RELEASES);

        scope(test)
                .include(dependency("org.junit.jupiter", "junit-jupiter", version(5, 11, 4)))
                .include(dependency("org.junit.platform", "junit-platform-console-standalone", version(1, 11, 4)));

        // dagger, javalin, jdbi, htmx, pug4j and sqlite
        scope(compile)
                .include(dependency("com.google.dagger:dagger:2.59.2"))
                .include(dependency("io.javalin:javalin:7.0.1"))
                .include(dependency("org.jdbi:jdbi3-core:3.51.0"))
                .include(dependency("org.webjars.npm:htmx.org:2.0.8"))
                .include(dependency("de.neuland-bfi:pug4j:2.4.1"));

        scope(runtime)
                .include(dependency("org.slf4j:slf4j-simple:2.0.17"))
                .include(dependency("org.xerial:sqlite-jdbc:3.51.2.0"));

        // dagger compiler
        scope(provided)
                .include(dependency("com.google.dagger:dagger-compiler:2.59.2"));

        // set up the generated source folder
        compileOperation()
                .compileOptions()
                .process(JavacOptions.Processing.FULL)
                .sourceOutput(Paths.get("src", "generated", "java"));
    }

    public static void main(String[] args) {
        new ExampleBuild().start(args);
    }
}
