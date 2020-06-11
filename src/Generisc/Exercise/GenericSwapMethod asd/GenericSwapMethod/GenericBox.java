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
        T element1 = this.content.get(position1);
        T element2 = this.content.get(position2);
        this.content.set(position1, element2);
        this.content.set(position2, element1);
    }

    private int sumOfChars(T word) {
        int charSum = 0;
        for (int i = 0; i < word.toString().length(); i++) {
            int symbolValue = word.toString().charAt(i);
            charSum += symbolValue;
        }
        return charSum;
    }

    int hasBiggerElement(T inputElement) {
        int countOfBiggerElements = 0;
        for (T element : content) {
            if (inputElement.toString().length() == element.toString().length()) {
                for (int i = 0; i < inputElement.toString().length(); i++) {
                    if (inputElement.toString().charAt(i) < element.toString().charAt(i)) {
                        countOfBiggerElements++;
                        break;
                    }
                    if ((inputElement.toString().charAt(i) > element.toString().charAt(i))){
                        break;
                    }
                }
            } else if (element.toString().length() > inputElement.toString().length()) {
                countOfBiggerElements++;
            }
        }
        return countOfBiggerElements;
    }
}
