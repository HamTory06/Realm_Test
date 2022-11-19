package com.example.realm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

class MainActivity : AppCompatActivity() {
    val config = RealmConfiguration.Builder(schema = setOf(Item::class))
        .build()
    val realm: Realm = Realm.open(config)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}