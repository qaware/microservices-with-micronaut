# Sample code for the QAtalk 'Microservices with Micronaut'

## Native binary with GraalVM

1. Download GraalVM from [GitHub](https://github.com/oracle/graal/releases)
1. Install native-image tool: `gu install native-image`
1. Build the project with **Java 8**: `./gradlew clean build`
1. Run `native-image --no-server -jar build/libs/github-scraper-graal-*-all.jar`
1. Copy `$GRAAL_DIR/jre/lib/$PLATFORM/libsunec.so` to current working directory
1. Run `./github-scraper-graal` binary

### Issues with GraalVM
