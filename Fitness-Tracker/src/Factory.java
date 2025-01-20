public interface Factory<T> {
    T create(String type, double targetValue, double currentValue, double specificValue);
}