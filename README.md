# Dagger2 bld example

Sample project on how to use [bld][bld] to build a [dagger2][dagger2],
[javalin][javalin], [jdbi3][jdbi3] and [htmx][htmx]  project.

[bld]: https://rife2.com/bld
[dagger2]: https://dagger.dev/
[javalin]: https://javalin.io
[jdbi3]: https://jdbi.org/
[htmx]: https://htmx.org

## Base setup

Install [sdkman](https://sdkman.io)

```bash
curl -s "https://get.sdkman.io" | bash
```

Use it to install `bld` command line tool

```bash
sdk install bld
```

Create the project

```bash
bld create-app example.dagger2 dagger2-bld-example Example
cd dagger2-bld-example
mkdir -p src/main/java/example/dagger2/{configs,controllers,models,services,repositories}
touch src/main/java/example/dagger2/models/{Task,State,Kanban}.java

# or code .
idea .
```

## How to build

```bash
./bld download compile
```

## How to test

```bash
./bld test
```

## How to run

```bash
./bld run
```

## Noteworthy

- Dagger2 depends on code generation, and annotation processing must be enabled
  in bld build class.
- Do not reuse regular source directory for generated classes. Instead, define
  in build class a custom generated source folder and add it in your IDE.
- One key aspect when dealing with compile-time solutions like Dagger is how
  erros tend to be more present at compile-time than runtime. Reflection-heavy
  applications tends to show errors at runtime only.
