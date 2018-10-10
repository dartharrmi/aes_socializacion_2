package com.dartharrmi.aes.pas.borboapp.managers

import com.dartharrmi.aes.pas.borboapp.model.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
class FirebaseDatabaseManager {

    private val mReferenceProducts = "products"
    private val mFirebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()

    fun fetchProducts(): Observable<List<Product>> {
        return Observable.create { emitter ->
            mFirebaseDatabase.getReference(mReferenceProducts).addValueEventListener(object : ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    emitter.onError(p0.toException())
                    emitter.onComplete()
                }

                override fun onDataChange(p0: DataSnapshot) {
                    if (p0.exists()) {
                        val m = p0.getValue() as Map<*, *>?
                        m?.let {
                            val countries = m[mReferenceProducts] as List<HashMap<*, *>>
                            val newList = countries.map { hashMap: HashMap<*, *> ->
                                Product(hashMap)
                            }.toCollection(ArrayList())

                            emitter.onNext(newList)
                        }
                    }
                }
            })
        }
    }
}