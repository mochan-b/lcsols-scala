package lcsols

class Solution475 {
  def binarySearch(house: Int, heaters: Array[Int], left: Int, right: Int): Int = {
    val mid = (left + right) / 2
    if (left > right) left
    else if (heaters(mid) == house) mid
    else if (heaters(mid) < house) binarySearch(house, heaters, mid + 1, right)
    else binarySearch(house, heaters, left, mid - 1)
  }

  def findHeater(house: Int, heaters: Array[Int]): Int = {
    binarySearch(house, heaters, 0, heaters.size - 1)
  }

  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    val housesSorted = houses.sorted
    val heatersSorted = heaters.sorted

    val MAX_VAL = (Math.max(housesSorted(housesSorted.length - 1), heatersSorted(heatersSorted.length - 1))
      - Math.min(housesSorted(0), heatersSorted(0))) + 1

    val houseHeaters = housesSorted.map(house => {
      val heaterIndex = findHeater(house, heatersSorted)
      val leftDist = if (heaterIndex != 0) house - heatersSorted(heaterIndex - 1) else MAX_VAL
      val rightDist = if (heaterIndex != heaters.size) heatersSorted(heaterIndex) - house else MAX_VAL
      Math.min(leftDist, rightDist)
    })
    houseHeaters.max
  }
}
