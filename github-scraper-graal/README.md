# Sample code for the QAtalk 'Microservices with Micronaut'

## Native binary with GraalVM

1. Install [sdkman](https://sdkman.io/)
1. `sdk install java 20.3.0.r11-grl`
1. `sdk use java 20.3.0.r11-grl`
1. Install native-image tool: `gu install native-image`
1. I had to install `libstdc++-static` to get `libstdc++.a` via my package manager
1. Build the native image: `./gradlew nativeImage`
1. Run the `build/native-image/application` binary

## Workarounds needed:

Caffeine uses a lot of reflection and unsafe access,
see [this Quarkus issue](https://github.com/quarkusio/quarkus/issues/10420).

Solution: I added some JSON snippets into the [reflect.json](src/main/graal/reflect.json).
