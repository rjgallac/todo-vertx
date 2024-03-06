package com.example.starter.model;

public class Todo {
  private String id;
  private String name;
  private String done;

  private String date;

  public Todo(String id, String name, String done, String date) {
    this.id = id;
    this.name = name;
    this.done = done;
    this.date = date;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDone() {
    return done;
  }

  public void setDone(String done) {
    this.done = done;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }
}
