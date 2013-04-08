package main.scala

class Main extends App {

  def pascal(col: Int, row: Int):Int = {
    if(col == 0) 1
    else if(col > row) 0
    else {
      pascal(col, row-1) + pascal(col-1, row-1)
    }
  }
  
}