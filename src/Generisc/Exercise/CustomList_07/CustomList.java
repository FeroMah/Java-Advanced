package Generisc.Exercise.CustomList_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> content;

    public CustomList() {
        this.content = new ArrayList<>();
    }

    void add(T element) {
        this.content.add(element);
    }

    void remove(int index) {
        this.content.remove(index);
    }

    boolean contains(T element) {
        return this.content.contains(element);
    }

    void swap(int position1, int position2) {
        T element1 = this.content.get(position1);
        T element2 = this.content.get(position2);
        this.content.set(position1, element2);
        this.content.set(position2, element1);
    }

    T getMax() {
        return Collections.max(this.content);
    }

    T getMin() {
        return Collections.min(this.content);
    }
    int size(){
        return this.content.size();
    }
    T get(int index){
        return this.content.get(index);
    }
}
