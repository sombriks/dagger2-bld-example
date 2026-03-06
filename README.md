# Dagger2 bld example

Sample project on how to use bld to build a dagger2, javalin, jdbi and htmx  project.

## Base setup

Install sdkman

Use it to install bld command line tool

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
