# Sample code for the QAtalk 'Microservices with Micronaut'

## Native binary with GraalVM

1. Enable the feature `graal-native-image` in micronaut

1. Change the script and include `https` in the `-H:EnableURLProtocols` flag in `build-native-image.sh`
   *Note*: The call which generates the `build/reflect.json` is best run with the java binary from GraalVM

1. Copy `libsunec.so` from a JDK under `jre/lib/` to the current directory

1. Change `build/reflect.json` and add this part:
    ```json
      {
        "name": "java.util.ArrayList",
        "allDeclaredConstructors": true
      },
      {
        "name": "github.scraper.client.ItemDto",
        "allDeclaredConstructors": true
      }
    ```
    Otherwise the JSON deserialization will fail.

1. Run `build-native-image.sh`

1. Run `github-scraper` binary
