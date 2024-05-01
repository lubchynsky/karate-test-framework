package beapitests.runners;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class GetRunner {

    @Test
    void testGet(){
        Runner.path("classpath:beapitests/features/get.feature")
                .parallel(1);
    }
}
