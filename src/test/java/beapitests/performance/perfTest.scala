package performance

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

class PerfTest extends Simulation {
  // Protocol
  val protocol = karateProtocol();

  // Read test data from CSV file
  val csvFeeder = csv("pets.csv").circular

  // 2 - Load scenario
  val getAllPets = scenario("Get all pets")
    .exec(karateFeature("classpath:beapitests/performance/GetAllPets.feature"))

  val createRandomPet = scenario("Create random pet")
    .exec(karateFeature("classpath:beapitests/performance/CreateRandomPet.feature"))

  val createAndDeletePet = scenario("Create and delete pet")
    .feed(csvFeeder)
    .exec(karateFeature("classpath:beapitests/performance/CreateAndDelete.feature"))

  // 3 Load simulation
  setUp(
    getAllPets.inject(atOnceUsers(10)).protocols(protocol),
    createRandomPet.inject(atOnceUsers(10)).protocols(protocol),
    createAndDeletePet.inject(
      atOnceUsers(1),
      nothingFor(3),
      rampUsers(10).during(10),
      constantUsersPerSec(5).during(10),
      rampUsersPerSec(1).to(5).during(10)
    ).protocols(protocol)
  )
}