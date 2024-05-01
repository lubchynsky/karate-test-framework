package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

class PerfTest extends Simulation {
  // Protocol
  val protocol = karateProtocol();

  // 2 - Load scenario
  val listAllPets = scenario("Get all pets")
    .exec(karateFeature("classpath:beapitests/performance/GetAllPets.feature"))

  val createAndDeletePet = scenario("Create and delete pet")
    .exec(karateFeature("classpath:beapitests/performance/CreateAndDelete.feature"))

  // 3 Load simulation
  setUp(
    listAllPets.inject(atOnceUsers(10)).protocols(protocol),
    createAndDeletePet.inject(
      atOnceUsers(1),
      nothingFor(3),
      rampUsers(50).during(10),
      constantUsersPerSec(5).during(10),
      rampUsersPerSec(1).to(5).during(10)
    ).protocols(protocol)
  )
}