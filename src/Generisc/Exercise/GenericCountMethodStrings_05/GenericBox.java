package Generisc.Exercise.GenericCountMethodStrings_05;


class GenericBox<T extends Comparable<T>> {
    private T content;

    public GenericBox() {
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

}
