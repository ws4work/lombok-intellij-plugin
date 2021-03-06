import java.lang.Exception;

class Exception {
}

interface Callable<V> {
  V call() throws Exception;
}

public class DelegateWithException implements Callable<Integer> {

  @lombok.Delegate
  private final Callable<Integer> delegated;

  @java.beans.ConstructorProperties({"delegated"})
  public DelegateWithException(Callable<Integer> delegated) {
    this.delegated = delegated;
  }

  public static void main(String[] args) throws Exception {
    DelegateWithException myCallable = new DelegateWithException(new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        return 1;
      }
    });

    System.out.println(myCallable.call());
  }
}
