package main;

import java.util.ArrayList;
import java.util.List;

/**
 * GKislin
 * 15.04.2016
 */
public class MainGeneric<T> {

    private T member;

    public MainGeneric(T member) {
        this.member = member;
    }

    T doSmth() {
        System.out.println(member);
        return member;
    }

    //    void doSmth(List<Integer> intList){
//
//    }
    public static void main(String[] args) {
        new MainGeneric<>("Hello").doSmth();
        MainGeneric<Integer> intIns = new MainGeneric<>(12);
        MainGeneric<?> objIns = new MainGeneric<Object>(12) {
            @Override
            Object doSmth() {
                return super.doSmth();
            }
        };
        intIns.doSmth();
        List<String> list = new ArrayList<>();
        List l = (List) list;
    }
}
