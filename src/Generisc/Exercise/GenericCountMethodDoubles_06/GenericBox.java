package Generisc.Exercise.GenericCountMethodDoubles_06;


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
