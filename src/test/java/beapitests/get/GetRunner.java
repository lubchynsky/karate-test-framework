package beapitests.get;

import com.intuit.karate.junit5.Karate;

public class GetRunner {

    @Karate.Test
    Karate testGet(){
        return Karate.run("get").relativeTo(getClass());
    }
}
