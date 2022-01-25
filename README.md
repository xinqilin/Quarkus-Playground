# Quarkus Project

## Running the application in dev mode

```zsh
  ./mvnw compile quarkus:dev
```
> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

```zsh
  ./mvnw package
```

```zsh
  ./mvnw package -Dquarkus.package.type=uber-jar
```

## Creating a native executable

```zsh
  ./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```zsh
  ./mvnw package -Pnative -Dquarkus.native.container-build=true
```

### GraalVM install

```zsh
    brew install --cask graalvm/tap/graalvm-ce-lts-java11
    ### .zshrc setting start
        JAVA_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-lts-java11-20.3.4/Contents/Home
        PATH=$JAVA_HOME/bin:$PATH:.
        CLASSPATH=$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar:.
        export JAVA_HOME
        export PATH
        export CLASSPATH
    ### .zshrc setting end
    
    sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/<graalvm-path>
```