package ru.javawebinar.webapp.storage;

/**
 * Created by arkan on 15.04.2016.
 */
public class IndexCondition extends Condition {
    private Integer index;



    public Boolean getState(){
        return index>=0;
    }

    public Integer getValue() {
        return index;
    }

    public void setIndex(Integer state) {
        this.index = state;
    }
}
