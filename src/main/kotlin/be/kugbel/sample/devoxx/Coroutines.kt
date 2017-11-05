package be.kugbel.sample.devoxx

import kotlinx.coroutines.experimental.TimeoutCancellationException
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.runBlocking

//https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md
fun main(args: Array<String>) = runBlocking<Unit> {

    println("Starting in UI thread")

    println("Finishing in UI thread")

}

//    val task1 = async(CommonPool) { loadData("Task 1") }
//    val task2 = async(CommonPool) { loadData("Task 2") }
//
//    val result = "${task1.await()} ${task2.await()}" // non ui thread, suspend until finished

//    val task1 = async(CommonPool) { loadData("Task 1") }.await()
//    val task2 = async(CommonPool) { loadData("Task 2") }.await()
//
//    val result = "${task1} ${task2}" // non ui thread, suspend until finished

//    val task1 = async(CommonPool) { loadData("Task 1") }
//    val result = withTimeoutOrNull(2, TimeUnit.SECONDS) { task1.await() }

//    val job = launch { suspendLoadData("Task 1") }
//    job.join()

//    val job = launch {
//        repeat(1000) { i ->
//            println("I'm sleeping $i ...")
//            delay(500L)
//        }
//    }
//
//    delay(1300L) // delay a bit
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin()
//    println("main: Now I can quit.")

//    val task1 = async(CommonPool) { loadWithException("Task 1") }

//    try {
//        val task1 = async(CommonPool) { loadWithException("Task 1") }.await()
//    } catch (exception: Exception){
//        println("Oops I crashed because of" + exception)
//    }

//    val exceptionHandler: CoroutineContext = CoroutineExceptionHandler { _, throwable -> throwable.printStackTrace() }
//    val task1 = async(CommonPool + exceptionHandler) { loadWithException("Task 1") }.await()

fun loadData(params: String): String {
    println("Loading data for $params")
    Thread.sleep(5000)
    println("Data loaded for $params")
    return "data for $params"
}

suspend fun suspendLoadData(params: String) {
    println("Loading data for $params")
    delay(1000L)
    println("Data loaded for $params")
}

fun loadWithException(params: String): String {
    println("Loading data for $params")
    Thread.sleep(5000)
    throw TimeoutCancellationException("I'm done with this")
}