package com.alicelab.maiapp;

import java.util.Random;

public class Mai {
    Random rnd = new Random();
    private String name;
    private Responder responder,randomResponder,patternResponder;

    Mai(String name){
        this.name = name;
        this.randomResponder = new RandomResponder("Random");
        this.patternResponder = new PatternResponder("Pattern");
        this.responder = this.patternResponder;
    }

    String dialogue(String input){
        int n = rnd.nextInt(100);
        if(0 < n || n < 100) {
            responder = patternResponder;
        }else{
            responder = randomResponder;
        }

        return this.responder.response(input);
    }

    String responder_name(){
        return this.responder.getName();
    }

    public String getName(){
        return this.name;
    }
}
