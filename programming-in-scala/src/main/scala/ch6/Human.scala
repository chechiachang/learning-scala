package ch6

/**
  * Created by David Chang on 2017/1/17.
  */
class HumanWarrior(hp: Int, mp: Int) extends Object{
  require(hp > 0)

  private var str = 1
  private var int = 1
  private var wis = 1
  private var dex = 1
  private var vit = 1
  private var spd = 1

  def this(hp: Int) = this(hp, 0)

  def hit(target: HumanWarrior): Unit = {
    target.hp -= str + 1
  }

  def cast(target: HumanWarrior): Unit = {
    if(mp > int) {
      mp -= int
      target.hp -= int * 2 + 1 - target.wis
    }
  }

  def equip(item: Equipment): Unit = {

  }
}
