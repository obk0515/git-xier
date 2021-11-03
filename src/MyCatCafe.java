import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MyCatCafe implements CatCafe{
    private double balance;
    private ArrayList<Cat> catArrayList=new ArrayList<>();
    private ArrayList<Customer> customerArrayList=new ArrayList<>();

    public MyCatCafe(double balance, ArrayList<Cat> catArrayList, ArrayList<Customer> customerArrayList) {
        this.balance = balance;
        this.catArrayList = catArrayList;
        this.customerArrayList = customerArrayList;
    }

    @Override
    public void buyCat(Cat cat) throws RuntimeException{
        if(balance-cat.getPrice()>=0){
            balance-=cat.getPrice();
            catArrayList.add(cat);
        }else {
            throw new InsufficientBalanceException("余额不足");
        }
    }

    @Override
    public void entertainCustomer(Customer customer) throws RuntimeException {
        if(catArrayList.isEmpty()){
            throw new CatNotFoundException("无猫可rua");
        }else{
            customerArrayList.add(customer);
            for (int i = 0; i < customer.getRua(); i++) {
                balance+=15;
                Random random=new Random();
                System.out.println(catArrayList.get(random.nextInt(catArrayList.size())));
            }
        }
    }

    @Override
    public void close() {
//        for (int i = 0; i < customerArrayList.size(); i++) {
//            customerArrayList.get(i).toString();
//        }

        for (Customer customer : customerArrayList) {
            if(customer.getDate().equals(LocalDate.now())){
                System.out.println(customer);
            }
        }
    }

}
