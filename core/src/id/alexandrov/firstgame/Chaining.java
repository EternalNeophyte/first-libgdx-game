package id.alexandrov.firstgame;

public interface Chaining<T extends Chaining<T>> {

    default T chaining(Runnable action) {
        action.run();
        return (T) this;
    }

    default T chainingIf(boolean condition, Runnable action) {
        return condition ? chaining(action) : (T) this;
    }
}
