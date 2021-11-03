public class CatNotFoundException extends RuntimeException{
    public CatNotFoundException(){

    }
    public CatNotFoundException(String msg){
        super(msg);
    }
}
