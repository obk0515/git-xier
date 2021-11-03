public interface CatCafe {
    void buyCat(Cat cat) throws RuntimeException;
    void entertainCustomer(Customer customer) throws RuntimeException;
    void close();
}
