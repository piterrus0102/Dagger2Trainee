# Dagger2 Trainee

This is a study project for all who want to see simple usages of dagger2 annotations and approaches.

## Project technologies

* Jetpack Compose;
* Dagger2.

## Project Architecture

This is single module app yet. During of increasing dagger2 features it can be grown to multi-module app.


## Projects structure

There are several packages in app gradle module:
- **di**. Contains dagger common dependencies and modules
- **domain**. Contains domain entities for software environment (test)
- **presentation**. Contains @Composable functions and screens
- **ui.theme**. Contains themes, colors, typography

## Dagger2 structure (app-bb)

App Component is main dagger component. Each screen has it own dagger component. 
There are described @Binds and @Provides inject methods:
- ***Actitity*** package include two packages
  - **binds**. Contains component and two modules for demonstrating dependency injection by binds-mechanism.
  - **provides**. Contains component and module for demonstrating dependency injection by provides-mechanism.

DaggerQualifiers.kt includes two qualifier for demonstrating injects' separation by qualifiers

