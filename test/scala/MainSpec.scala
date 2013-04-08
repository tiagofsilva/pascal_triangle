package scala

import main.scala.Main;

import org.scalatest.FunSpec
import org.scalatest.BeforeAndAfter
import org.scalatest.matchers.ShouldMatchers
import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

class MainSpec extends FunSpec with BeforeAndAfter with ShouldMatchers {
	
  var triangle:Main = _
  
  before {
    triangle = new Main
  }
  
  describe("Pascal Triangle") {
	  it("should find a 1 at the top") {
	    val result = triangle.pascal(0,0)
	    result should equal(1)
	  }
	  
	  describe("when a column is bigger than a row") {
	    it("should immediately return zero") {
	      val result = triangle.pascal(2,1)
	      result should equal(0)
	    }
	  }
	  
	  it("should find a '1' in every first column") {
	     var only1s = new ListBuffer[Int]
	     val rows = List.range(1, 10)
	     rows.foreach(row => only1s += triangle.pascal(0, row))
	     val result = only1s.filter(elem => elem != 1)
	     result should be('empty)
	  }
	  
	    it("should generate the sum of trivials triangles recursively") {
	      val result1 = triangle.pascal(0, 1)
	      val result2 = triangle.pascal(0, 0)
	      val result3 = triangle.pascal(1, 1)
	      result1 should equal(result2)
	      result2 should equal(result3)
	    }
	    
	    it("should generate the sum of more complex triangles recursively") {
	      val result1 = triangle.pascal(0,2)
	      val result2 = triangle.pascal(1,2)
	      val result3 = triangle.pascal(1,3)
	      val result4 = triangle.pascal(2,4)
	      result1 should equal(1)
	      result2 should equal(2)
	      result3 should equal(3)
	      result4 should equal(6)
	    }
	    
	    it("should generate the correct result with very large numbers") {
	      val result1 = triangle.pascal(10,11)
	      val result2 = triangle.pascal(10,12)
	      result1 should equal(11)
	      result2 should equal(66)
	    }
	    
     }
}