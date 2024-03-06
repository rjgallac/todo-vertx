package com.example.starter;

import com.example.starter.model.Todo;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {
  @Override
  public void start() throws Exception {
    // Create a Router
    Router router = Router.router(vertx);

    // Mount the handler for all incoming requests at every path and HTTP method
//    router.route().handler(context -> {
//      // Get the address of the request
//      String address = context.request().connection().remoteAddress().toString();
//      // Get the query parameter "name"
//      MultiMap queryParams = context.queryParams();
//      String name = queryParams.contains("name") ? queryParams.get("name") : "unknown";
//      // Write a json response
//      context.json(
//        new JsonObject()
//          .put("name", name)
//          .put("address", address)
//          .put("message", "Hello " + name + " connected from " + address)
//      );
//    });

    router.get("/api/todo/:id")
      .handler(this::getTodo);

    // Create the HTTP server
    vertx.createHttpServer()
      // Handle every request using the router
      .requestHandler(router)
      // Start listening
      .listen(8888)
      // Print the port
      .onSuccess(server ->
        System.out.println(
          "HTTP server started on port " + server.actualPort()
        )
      );
  }

  private void getTodo(RoutingContext routingContext) {
    String todoid = routingContext.request()
      .getParam("id");
    Todo todo = new Todo(todoid,
      "get milk", "true", "01-02-2017");

    routingContext.response()
      .putHeader("content-type", "application/json")
      .setStatusCode(200)
      .end(Json.encodePrettily(todo));
  }

}
