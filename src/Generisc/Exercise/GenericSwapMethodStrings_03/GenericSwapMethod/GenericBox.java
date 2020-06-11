package Generisc.Exercise.GenericSwapMethod;

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

    void swap(int position1, int position2) {
        T element1= this.content.get(position1);
        T element2= this.content.get(position2);
        this.content.set(position1,element2);
        this.content.set(position2,element1);
    }
}
