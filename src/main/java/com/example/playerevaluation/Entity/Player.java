package com.example.playerevaluation.Entity;

public class Player {
    private int id;
    private String name;
    private int age;
    private String position;
    private String team;



    public int getId() {
         return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    @Override
    public String toString() {
        return "Players{"+
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                '}';
    }
}
