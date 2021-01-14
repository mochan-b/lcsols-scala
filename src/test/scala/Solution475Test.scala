import org.scalatest.FunSuite
import lcsols.Solution475

class Solution475Test extends FunSuite {
  test("[1,2,3], [2]") {
    val houses = Array(1, 2, 3)
    val heaters = Array(2)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 1)
  }

  test("[1,3,2], [2]") {
    val houses = Array(1, 3, 2)
    val heaters = Array(2)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 1)
  }

  test("[1,2,3,4], [1,4]") {
    val houses = Array(1, 2, 3, 4)
    val heaters = Array(1, 4)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 1)
  }

  test("[1,5], [2]") {
    val houses = Array(1, 5)
    val heaters = Array(2)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 3)
  }

  test("[1,5], [10]") {
    val houses = Array(1, 5)
    val heaters = Array(10)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 9)
  }

  test("unsorted heaters") {
    val houses = Array(282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923)
    val heaters = Array(823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 161834419)
  }

  test("[474833169,264817709,998097157,817129560],[197493099,404280278,893351816,505795335]") {
    val houses = Array(474833169, 264817709, 998097157, 817129560)
    val heaters = Array(197493099, 404280278, 893351816, 505795335)

    var solution = new Solution475()
    val result = solution.findRadius(houses, heaters)

    assert(result == 104745341)
  }
}