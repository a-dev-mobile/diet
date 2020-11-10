package a.dev.mobile.diet

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragment)

        val appBarConfig =
            AppBarConfiguration(setOf(R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment))
        setupActionBarWithNavController(navController, appBarConfig)

        bottomNavigationView.setupWithNavController(navController)

        val db = FirebaseFirestore.getInstance()


        // Create a new user with a first and last name
        val user: MutableMap<String, Any> = HashMap()
        user["fir2st"] = "Ada"
        user["l2ast"] = "Lovelace"
        user["bo3rn"] = 1815

// Add a new document with a generated ID


        addToDB(db, user)


        // Create a new user with a first, middle, and last name

        // Create a new user with a first, middle, and last name

        user["1"] = "Alan"
        user["2"] = "Mathison"
        user["5"] = "Turing"
        user["3"] = 1912

// Add a new document with a generated ID

// Add a new document with a generated ID
        addToDB(db, user)



        user["first2"] = "112Alan"
        user["middle3"] = "1212Mathison"


        addToDB(db, user)


    }

    private fun addToDB(
        db: FirebaseFirestore,
        user: MutableMap<String, Any>
    ) {
        db.collection("users2")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    TAG,
                    "DocumentSnapshot added with ID: " + documentReference.id
                )
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }


        user.clear()
    }


}