package beapitests.runners;

import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

public class PostRunner {

    @Test
    void testPost() {
        Runner.path("classpath:beapitests/features/post.feature")
                .parallel(1);
    }
}
