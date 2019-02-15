#!/usr/bin/env bash

set -euo pipefail

GRAAL_HOME="/home/moe/Software/graalvm"

./gradlew assemble
# ${GRAAL_HOME}/bin/java -cp build/libs/github-scraper-0.1-all.jar io.micronaut.graal.reflect.GraalClassLoadingAnalyzer build/reflect.json
${GRAAL_HOME}/bin/native-image --no-server \
             --class-path build/libs/github-scraper-0.1-all.jar \
             -H:ReflectionConfigurationFiles=build/reflect.json \
             -H:EnableURLProtocols=http,https \
             -H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
             -H:Name=github-scraper \
             -H:Class=github.scraper.Application \
             -H:+ReportUnsupportedElementsAtRuntime \
             -H:+AllowVMInspection \
             -H:-UseServiceLoaderFeature \
             --allow-incomplete-classpath \
             --rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext' \
             --delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom,com.sun.jndi.dns.DnsClient
