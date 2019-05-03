package jezorko.com.github.example

import io.vertx.core.logging.LoggerFactory
import io.vertx.rxjava.core.Vertx

private val log = LoggerFactory.getLogger("main")

fun main() {
    Vertx.vertx()
            .rxDeployVerticle(ServerVerticle())
            .subscribe(
                    { verticleId -> log.info("server verticle deployment successful, ID: $verticleId") },
                    { error -> log.error("server verticle deployment failed", error) }
            )
}