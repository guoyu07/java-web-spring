package com.tutorialspoint;

import javax.annotation.Resource;

public class SpellChecker {

    public String name = "Default";

    @Resource/*(name = "from")*/
    public String from = "china";

    public void setName(String name) {
        this.name = name;
    }

    public SpellChecker(){
        System.out.println("Inside SpellChecker constructor." );
    }
    public void checkSpelling() {
        System.out.println("Inside checkSpelling..." + name + "," + from);
    }
}