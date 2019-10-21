FROM oracle/graalvm-ce:19.2.0.1 as graalvm
COPY . /home/app/hello-world
WORKDIR /home/app/hello-world
RUN gu install native-image
RUN native-image --no-server -jar build/libs/github-scraper-graal-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/hello-world .
ENTRYPOINT ["./hello-world"]
