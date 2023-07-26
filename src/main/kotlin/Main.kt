open class Car{
    var color : String = ""
    var speed : Int = 0
    //정적 메소드, 정적필드
    companion object{
        var carCount : Int = 0
        // const val을 붙이면 값을 변경할 수 없는 상수가 된다. (상수필드)
        const val MAXSPEED : Int = 200
        const val MINSPEED : Int = 0

        fun currentCarCount() : Int{
            return carCount
        }
    }

    constructor(color : String, speed: Int){
        //this: 자기 자신의 클래스를 의미
        this.color = color
        this.speed = speed
        carCount++
    }
    // 오버로딩: 한 클래스 내에서 메소드의 이름이 같아도 파라미터의 개수나 데이터 형식만 다르다면 여러 개를 선언할 수 있음
    constructor(speed : Int){
        this.speed = speed
    }
    // 오버로딩: 한 클래스 내에서 메소드의 이름이 같아도 파라미터의 개수나 데이터 형식만 다르다면 여러 개를 선언할 수 있음
    constructor(){      }


    open fun upSpeed(value: Int){
        if(speed + value >= 200)
            speed = 200
        else
            speed +=value
    }

    fun downSpeed(value : Int){
        if(speed - value <= 0)
            speed = 0
        else
            speed = speed - value
    }
}

// " : Car"은 Car 클래스로부터 상속받겟다는 의미이다.
class Automobile : Car{
    var seatNum : Int = 0
    var value : Int = 0

    // constructor(value : Int) : super(value) {      }
    // 기본생성자
    constructor() {      }

    fun countSeatNum(): Int{
        return seatNum
    }

    override fun upSpeed(value: Int) {
        // 슈퍼 클래스의 upSpeed를 호출하려면 super.upSpeed(value) 사용
        // speed는 슈퍼 클래스의 필드
        if (speed + value >= 300)
            speed = 300
        else
            speed += value
    }
}

fun main(args: Array<String>) {

    var auto : Automobile = Automobile()
    auto.upSpeed(250)
    println("승용차의 속도는 ${auto.speed}km 입니다.")

}