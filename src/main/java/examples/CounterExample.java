package examples;

import java.util.concurrent.atomic.AtomicLong;

public class CounterExample {

  public void example() {
    // #counter
    AtomicLong value = new AtomicLong();
    value.incrementAndGet();
    // #counter
  }
}
