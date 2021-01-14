package lcsols

import scala.annotation.tailrec

class Solution475 {
  def findHeater(house: Int, heaters: Array[Int]): Int = {
    @tailrec def binarySearch(left: Int, right: Int): Int = {
      val mid = (left + right) / 2
      if (left > right) left
      else if (heaters(mid) == house) mid
      else if (heaters(mid) < house) binarySearch(mid + 1, right)
      else binarySearch(left, mid - 1)
    }

    binarySearch(0, heaters.size - 1)
  }

  def findRadius(houses: Array[Int], heaters: Array[Int]): Int = {
    val housesSorted = houses.sorted
    val heatersSorted = heaters.sorted
    
    housesSorted.map(house => {
      val heaterIndex = findHeater(house, heatersSorted)
      val leftDistFn = () => house - heatersSorted(heaterIndex - 1)
      val rightDistFn = () => heatersSorted(heaterIndex) - house
      if (heaterIndex == 0) rightDistFn()
      else if (heaterIndex == heaters.size) leftDistFn()
      else Math.min(leftDistFn(), rightDistFn())
    }).max
  }
}
