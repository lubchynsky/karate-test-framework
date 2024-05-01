package beapitests.runners;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class DeleteRunner {

    @Test
    void testDelete() {
        Runner.path("classpath:beapitests/features/delete.feature")
                .parallel(1);
    }
}
