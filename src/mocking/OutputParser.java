package mocking;

public abstract class OutputParser<T> {
    public abstract T parse(String output);
}
