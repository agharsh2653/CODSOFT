package com.example.quizapp2;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private static List<QuestionsList> javaQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("How do you create a variable with the numeric value 5?","x = 5;","int x = 5;","float x = 5;","num x = 5;","int x = 5;","");
        final QuestionsList question2 = new QuestionsList("What is a correct syntax to output \"Hello World\" in Java?","echo(\"Hello World\");","print(\"Hello World\");","Console.WriteLine(\"Hello World\");","System.out.println(\"Hello World\");","System.out.println(\"Hello World\");","");
        final QuestionsList question3 = new QuestionsList("Which data type is used to create a variable that should store text?","string","Txt","String","myString","String","");
        final QuestionsList question4 = new QuestionsList("Which method can be used to find the length of a string?","len()","getSize()","getLength()","length()","length()","");
        final QuestionsList question5 = new QuestionsList("Which operator can be used to compare two values?","=","<>","==","><","==","");
        final QuestionsList question6 = new QuestionsList("Which method can be used to find the highest value of x and y?","Math.max(x,y)","Math.maxNum(x,y)","Math.maximum(x,y)","Math.largest(x,y)","Math.max(x,y)","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionsList> phpQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("What does php stand for?","Professional Home Page","Hypertext Preprocessor","Pretext Hypertext Processor","Preprocessor Home Page","Hypertext Preprocessor","");
        final QuestionsList question2 = new QuestionsList("Wh0 is the father of php?","Rasmus Lerdorf","Willam Makespiece","Drek Kolkevi","List Barely","Rasmus Lerdorf","");
        final QuestionsList question3 = new QuestionsList("which of the following is/are a PHP code editor?\n" + "i)Notepad\n"+ "ii)Notepad++\n"+"iii)Adobe Dreamweaver\n"+"iv)PDT","i),ii),iii) and iv)","i),ii) and iv)","Only iii)","Only iv)","i),ii),iii) and iv)","");
        final QuestionsList question4 = new QuestionsList("What should be the correct syntax  to write a PHP code?","<? php ?>","<php>","<??>","<?php?>","<?php?>","");
        final QuestionsList question5 = new QuestionsList("How should be add single line comment in our PHP code?\ni)/?\nii)//\niii)#\niv)/**/","Both ii) and iv)","ii),iii) and iv)","i),iii) and iv)","Only ii)","ii),iii) and iv)","");
        final QuestionsList question6 = new QuestionsList("Which version of PHP introduced Try/catch Exception","PHP 5","PHP 4","PHP 5 and later","PHP 6","PHP 5 and later","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionsList> htmlQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("HTML stand for?","Hyper Text Markup Language","Hyper Tabular Markup Language","High Text Markup Language","None of these","Hyper Text Markup Language","");
        final QuestionsList question2 = new QuestionsList("How is document type initialized in HTML5.?","</DOCTYPE HTML>","</DOCTYPE>","<!DOCTYPE HTML>","</DOCTYPE html>","<!DOCTYPE HTML>","");
        final QuestionsList question3 = new QuestionsList("Which of the following HTML Elements is used for making any text bold ?","<p>","<i>","<li>","<b>","<b>","");
        final QuestionsList question4 = new QuestionsList("Which of the following HTML element is used for creating an unordered list?","<ui>","<i>","<em>","<ul>","<ul>","");
        final QuestionsList question5 = new QuestionsList("What is the font-size of the h1 heading tag?","3.5 em","2.17 em","2 em","1.5 em","2 em","");
        final QuestionsList question6 = new QuestionsList("How many heading tags are there in HTML5?","2","3","5","6","6","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    private static List<QuestionsList> androidQuestions(){
        final List<QuestionsList> questionsLists = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Select a component which is Not part of android architecture","Android Framework","Libraries","Linux Kernal","Android Documentation","Linux Kernal","");
        final QuestionsList question2 = new QuestionsList("A_______ makes a specific  set of  the application data available to other applications","Content provider","Brodcast Receivers","Intent","None of thses","Content provider","");
        final QuestionsList question3 = new QuestionsList("What is bean class in android?","A class used to hold states and objects","A been class can be passed from one activity to another activity","A mandatory class in android","None of above","A class used to hold states and objects","");
        final QuestionsList question4 = new QuestionsList("What is Pending Intent in android?","It is a kind of an intent","It is used to pass data between activities","It will fire at a future point of time.","None of the above","It will fire at a future point of time.","");
        final QuestionsList question5 = new QuestionsList("How to find the JSON element length in android JSON?","Count()","sum()","add()","length()","length()","");
        final QuestionsList question6 = new QuestionsList("How many ports are allocated for new emulator?","2","0","10","None of the above","2","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;
    }

    public static List<QuestionsList> getQuestions(String selecTopicName){
        switch (selecTopicName){
            case "Java":
                return javaQuestions();

            case "PHP":
                return phpQuestions();

            case "HTML":
                return htmlQuestions();
            default:
                return androidQuestions();
        }
    }
}
