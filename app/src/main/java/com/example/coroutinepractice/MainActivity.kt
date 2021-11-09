package com.example.coroutinepractice

import android.app.Person
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await
import kotlin.concurrent.thread
import kotlin.math.log
import kotlin.system.measureTimeMillis

data class Person(
    val name: String = "",
    val age: Int = -1
)

class MainActivity : AppCompatActivity() {

    val TAG = "TELINA"
    lateinit var textid: TextView

    //    private lateinit var tvDummy: TextView
    // private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textid = findViewById(R.id.tvData)
        val tutorialDocument = Firebase.firestore.collection("coroutines")
            .document("tutorial")
        val peter = Person("peter", 25)
        GlobalScope.launch(Dispatchers.IO) {
            tutorialDocument.set(peter).await()
            val person = tutorialDocument.get().await().toObject(com.example.coroutinepractice.Person::class.java)
            withContext(Dispatchers.Main) {
                textid.text = person.toString()
            }
        }

//        button = findViewById(R.id.btnStartActivity)
//        button.setOnClickListener {
//            lifecycleScope.launch {
//                while (true) {
//                    delay(1000)
//                    Log.d(TAG, "Still running")
//                }
//            }
//            GlobalScope.launch {
//                delay(5000)
//                Intent(this@MainActivity, SecondActivity::class.java).also { telina ->
//                    startActivity(telina)
//                    finish()
//                }
//
//            }
    }

//        tvDummy = findViewById(R.id.tvDummy)

//       GlobalScope.launch {
//            val networkCallAnswer = doNetworkcall()
//            delay(3000L)
//            Log.d(TAG, "coroutines says hi from thread ${Thread.currentThread().name}")
//            Log.d(TAG, networkCallAnswer)
//        }
//
//        Log.d(TAG, "hi from thread ${Thread.currentThread().name}")

//        runBlocking {
//        GlobalScope.launch(Dispatchers.IO){
//           Log.d(TAG, "starting coroutines in thread ${thread { Thread.currentThread().name }}")
//            val answer = doNetworkcall()
//            withContext(Dispatchers.Main) {
//                Log.d(TAG, "setting text in thread ${thread { Thread.currentThread().name }}")
//                tvDummy.text = answer
//            }
//        }
//Log.d(TAG,"start runblocking")
//            delay(30000L)
//            Log.d(TAG, "end of runblocking")
//        }
//
//
//    }
//    suspend fun doNetworkcall(): String{
//        delay(3000L)
//        return "This is the answer"

//        val job = GlobalScope.launch(Dispatchers.Default) {
//            Log.d(TAG, "start long running calculation")
//            withTimeout(3000L) {
//                for (i in 30..40) {
//                    if (isActive) {
//                        Log.d(TAG, "Result of i = $i: ${fib(i)}")
//                    }
//            }
//            }
//
//        }
//        runBlocking {
//            delay(2000)
//            job.cancel()
//            Log.d(TAG, "join job")
//
//        }
//
//    }
//    fun fib( n: Int): Long {
//        return if (n == 0) 0
//        else if (n == 1) 1
//        else fib( n - 1) + fib( n - 2)
//    }

//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                val answer1 = async { networkCall1() }
//                val answer2 = async { networkCall2() }
//                Log.d(TAG, "Answer1 is ${answer1.await()}")
//                Log.d(TAG, "Answer2 is ${answer2.await()}")
//            }
//            Log.d(TAG, "Request took $time ms.")
//        }
//    }
//
//    suspend fun networkCall1(): String {
//
//        delay(2000)
//        return "answer1"
//    }
//
//    suspend fun networkCall2(): String {
//
//        delay(2000)
//        return "answer2"
//    }
    //  }
}
