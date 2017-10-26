package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

public class TextEditor {
    private SpellChecker spellChecker;
    // @Autowired
    private SpellChecker anotherOne;
    private SpellChecker innerSpell;

    private Map kv;
    private List arr;

    public TextEditor(SpellChecker spellChecker, String words) {
        System.out.println("Inside TextEditor constructor...." + words);
        this.spellChecker = spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
        anotherOne.checkSpelling();
        innerSpell.checkSpelling();
    }

    @Qualifier("spellChecker2")
    @Autowired /*(required=false)*/
    public void setAnotherOne(SpellChecker spellChecker) {
        anotherOne = spellChecker;
    }

    public void setInnerSpell(SpellChecker spellChecker) {
        innerSpell = spellChecker;
    }

    public void setKv(Map kv) {
        this.kv = kv;
    }

    public void setArr(List arr) {
        this.arr = arr;
    }

    public Map getKv() {
        return this.kv;
    }

    public List getArr() {
        return this.arr;
    }

    @PostConstruct
    public void init() {
        System.out.println("Init textEditor");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy textEditor");
    }
}