package com.example.starter;

import com.example.starter.model.Todo;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainVerticle extends AbstractVerticle {

  HashMap<Integer, Todo> todos = new HashMap<>();
  @Override
  public void start() throws Exception {
    // Create a Router
    Router router = Router.router(vertx);

    router.get("/api/todo/:id")
      .handler(this::getTodo);

    router.post("/api/todo")
        .handler(this::addTodo);

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

  private void addTodo(RoutingContext routingContext) {
    Todo todo = new Todo(
      "get milk", "true", "01-02-2017");
    this.todos.put(todos.size() + 1, todo);

  }

  private void getTodo(RoutingContext routingContext) {
    String todoid = routingContext.request()
      .getParam("id");
    Todo todo = new Todo(
      "get milk", "true", "01-02-2017");
    this.todos.put(todos.size() + 1, todo);
    Todo todo2 = todos.get(todoid);

    routingContext.response()
      .putHeader("content-type", "application/json")
      .setStatusCode(200)
      .end(Json.encodePrettily(todo));
  }

}
