package ru.javawebinar.webapp.storage;

import ru.javawebinar.webapp.model.Resume;

import java.util.Map;

/**
 * Created by arkan on 15.04.2016.
 */
public class MapCondition extends Condition {
    private Resume state;

    public Integer getValue(){
        return state!=null?1:-1; //пока так
    }


    public Boolean getState() {
        return state!=null;
    }

    public void setValue(Resume state) {
        this.state = state;
    }
}
