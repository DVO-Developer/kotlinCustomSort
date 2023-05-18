// Алгоритм быстрой сортировки


fun main(){
    var array = mutableListOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)

    println("Заданный массив - $array")
    array.shuffle()
    println("Перемешанный массив - $array\nНачинаем сортировку массива ")

   customQuickSort2(array, 0, array.size-1)
    println("Массив отсортирован- $array")


}

fun customQuickSort (array: MutableList<Int>, start: Int, end: Int)  {
    if (start >= end) return
    var numberInWrongPlaceStart = start
    var numberInWrongPlaceEnd = end
    var pivot = numberInWrongPlaceStart - (numberInWrongPlaceStart - numberInWrongPlaceEnd) / 2
    while (numberInWrongPlaceStart < numberInWrongPlaceEnd) {
        while (numberInWrongPlaceStart < pivot && array[numberInWrongPlaceStart] <= array[pivot]) {
            numberInWrongPlaceStart++
        }
        while (numberInWrongPlaceEnd > pivot && array[pivot] <= array[numberInWrongPlaceEnd]) {
            numberInWrongPlaceEnd--
        }
        //После этих двух циклов мы имеем индекс числа не на своем месте слева и индекс числа не на своем месте справа.
        //Далее меняем их местами

        if (numberInWrongPlaceStart < numberInWrongPlaceEnd) {
            val temp = array[numberInWrongPlaceStart]
            array[numberInWrongPlaceStart] = array[numberInWrongPlaceEnd]
            array[numberInWrongPlaceEnd] = temp
            when {
                numberInWrongPlaceStart == pivot -> pivot = numberInWrongPlaceEnd
                numberInWrongPlaceEnd == pivot -> pivot = numberInWrongPlaceStart
            }
        }
        // Так будет продолжаться до тех пор, пока индекс левого будет меньше правого.
    }
    // После выхода из внешнего цикла вызываем всю функцию заново для элементов слева от pivot
    // и отдельно для элементов справа от pivot.

    customQuickSort(array,start,pivot)
    customQuickSort(array,pivot+1, end)



}


fun customQuickSort2(array: MutableList<Int>, start: Int, end: Int) {
    if (start >= end) return
    var startWrongPlace = start
    var endWrongPlace = end
    var pivot = startWrongPlace - (startWrongPlace-endWrongPlace)/2

    while (startWrongPlace < endWrongPlace) {
        while (startWrongPlace < pivot && array[startWrongPlace] <= array[pivot]) {
            startWrongPlace++
        }
        while (endWrongPlace > pivot && array[pivot] <= array[endWrongPlace]) {
            endWrongPlace--
        }
        if (startWrongPlace < endWrongPlace) {
            var t = array[startWrongPlace]
            array[startWrongPlace] = array[endWrongPlace]
            array[endWrongPlace] = t
            when {
                startWrongPlace == pivot -> pivot = endWrongPlace
                endWrongPlace == pivot -> pivot = startWrongPlace
            }
        }
    }

    customQuickSort2(array, start, pivot)
    customQuickSort2(array, pivot+1, end)
}



















