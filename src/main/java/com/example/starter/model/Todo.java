package com.example.starter.model;

public class Todo {
  private String name;
  private String done;

  private String date;

  public Todo(String name, String done, String date) {
    this.name = name;
    this.done = done;
    this.date = date;
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
