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
        "name": "github.scraper.client.ProjectResponseDto",
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

### Notes

1. Service discovery / client side load balancing is broken when running as native binary, see [this ticket](https://github.com/micronaut-projects/micronaut-core/issues/1121)
1. `@Cacheable` doesn't work with GraalVM