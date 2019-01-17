package com.vertxinaction.chapter2;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class SampleVerticle extends AbstractVerticle {
    private final Logger logger = LoggerFactory.getLogger(SampleVerticle.class);

    @Override
    public void start() {
        logger.info("n = {}", config().getInteger("n",  -1));
    }

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        for (int n = 0; n < 4; n++) {
            JsonObject conf = new JsonObject().put("n", n);
            DeploymentOptions opts = new DeploymentOptions()
                    .setConfig(conf)
                    .setInstances(n);
            vertx.deployVerticle("com.vertxinaction.chapter2.SampleVerticle", opts);
        }
    }
}
