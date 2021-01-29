# Code for the talk "Microservices with Micronaut"

[Looking for the slides?](slides.pdf)

## Contents

* [GitHub scraper implemented with Micronaut](github-scraper)
* [GitHub scraper implemented with Spring Boot](github-scraper-spring)
* [GitHub scraper implemented with Micronaut, compiled with Graal](github-scraper-graal)

## Benchmarks

Start the application with:

```
java -Xms16M -Xmx512M -jar github-scraper-*.jar
```

and run the benchmark with [wrk](https://github.com/wg/wrk):

```
wrk -t 8 -c 80 -d 30s --latency http://localhost:8080/github/stars
```

## Author

Moritz Kammerer ([@phxql](https://github.com/phxql))

## License

[MIT](LICENSE)
