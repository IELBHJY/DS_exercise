package com.company;

/**
 * Created by apple on 2018/1/11.
 */
public class Student implements Comparable<Student> {
    private String name;
    private int number;
    private int score;
    private int age;

    public Student(String name,int number,int score,int age){
        this.name = name;
        this.number = number;
        this.score = score;
        this.age = age;
    }
    @Override
    public int compareTo(Student o) {
        return age-o.age;
    }
    /*@Override
    public int compare(Student o1, Student o2) {
        if(o1.getNumber()>o2.getNumber()){
            return 1;
        }else if(o1.getNumber()<o2.getNumber()){
            return -1;
        }else{return 1;}
    }*/
    //重写Student类的toString()方法，在输入对象时按照以下方式输出
    @Override
    public String toString() {
        return "Student[name:"+name+",age:"+age+",number:"+number+",score:"+score+"]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
