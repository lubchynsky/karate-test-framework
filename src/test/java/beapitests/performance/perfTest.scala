package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

class PerfTest extends Simulation {
  // Protocol
  val protocol = karateProtocol();

  // 2 - Load scenario
  val listAllPets = scenario("Get all pets")
    .exec(karateFeature("classpath:beapitests/performance/GetAllPets.feature"))

  // 3 Load simulation
  setUp(
    listAllPets.inject(atOnceUsers(5)).protocols(protocol)
  )
}