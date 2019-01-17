package com.vertxinaction.chapter2;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class SomeVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> startFuture) {
        vertx.createHttpServer()
                .requestHandler(req -> req.response().end("Ok\n"))
                .listen(8080, ar -> {
                    if (ar.succeeded()) {
                        startFuture.complete();
                    } else {
                        startFuture.fail(ar.cause());
                    }
        });
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new SomeVerticle());
    }
}

