import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

public class PifagorTask {

    @Test
    void task() {
        List<int[]> numbers = IntStream.rangeClosed(1, 100).boxed().flatMap(a ->
                IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
        ).toList();
    }
}