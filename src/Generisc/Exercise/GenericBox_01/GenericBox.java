package Generisc.Exercise.GenericBox_01;

import java.util.ArrayList;
import java.util.List;

class GenericBox<T> {
    private List<T> content;

    GenericBox() {
        this.content = new ArrayList<>();
    }

    T get(int index) {
        return content.get(index);
    }

    void add(T element) {
        this.content.add(element);
    }

    int size() {
        return this.content.size();
    }
}
