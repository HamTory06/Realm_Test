package com.example.realm

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class Dog() : RealmObject {
    var name: String = ""
    var age : Int = 0
}

class Person : RealmObject{
    @PrimaryKey
    var name = ""
    var dog: Dog? = null
}

object Database{
    val configuration = RealmConfiguration.with(schema = setOf(Person::class, Dog::class))
    val realm = Realm.open(configuration)

    fun write(){
        val person = Person().apply{
            name = "Carlo"
            dog = Dog().apply {
                name = " Fido" ; age =16
            }
        }
        val manageedPerson =  realm.writeBlocking {
            copyToRealm(person)
        }
    }

    suspend fun writeAsync(){
        val person = Person().apply{
            name = "Carlo"
            dog = Dog().apply {
                name = " Fido" ; age =16
            }
        }
        realm.write {
            copyToRealm(person)
        }
    }
    fun query(){
        //All Person
        val all: RealmResults<Person> = realm.query<Person>().find()
    }
}