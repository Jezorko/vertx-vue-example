package jezorko.com.github.example


import io.vertx.core.logging.LoggerFactory.getLogger
import io.vertx.rxjava.core.AbstractVerticle
import io.vertx.rxjava.core.http.HttpServer
import io.vertx.rxjava.ext.web.Router
import io.vertx.rxjava.ext.web.handler.BodyHandler
import io.vertx.rxjava.ext.web.handler.CorsHandler
import io.vertx.rxjava.ext.web.handler.StaticHandler

private val log = getLogger(ServerVerticle::class.qualifiedName)

class ServerVerticle : AbstractVerticle() {
    override fun start() {
        log.info("starting server")

        val serverHost = "localhost"
        val serverPort = 3000

        val router = Router.router(vertx)
        router.route().handler(CorsHandler.create("*"))
        router.route().handler(BodyHandler.create())

        setUpBackEnd(router)
        setUpFrontEnd(router)

        vertx.createHttpServer()
                .requestHandler(router)
                .rxListen(serverPort, serverHost)
                .subscribe(this::onServerStart, this::onServerError)
    }

    private fun setUpBackEnd(router: Router) {
        router.get("/api/health").handler {
            it.response().setStatusCode(200).end("{\"isHealthy\":true}")
        }
    }

    private fun setUpFrontEnd(router: Router) {
        router.route("/*").handler(StaticHandler.create("static"))
    }

    private fun onServerStart(server: HttpServer) {
        log.info("server listening on port ${server.actualPort()}")
    }

    private fun onServerError(error: Throwable) {
        log.error("server error", error)
    }
}