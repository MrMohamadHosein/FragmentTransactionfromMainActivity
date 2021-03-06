package ir.mrmohamadhosein.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.mrmohamadhosein.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var count = 0


        binding.btnRemoveFragment.setOnClickListener {

            // remove :

            val fragmentNow = supportFragmentManager.findFragmentById(R.id.frame_main_container)

            val removeTransaction = supportFragmentManager.beginTransaction()
            removeTransaction.remove( fragmentNow!! )
            //removeTransaction.addToBackStack(null)
            removeTransaction.commit()


        }

        binding.btnAddFragment.setOnClickListener {

            when (count) {

                0 -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container , FragmentFirst())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

                1 -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container , FragmentSecond())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

                2 -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container , FragmentThird())
                    transaction.addToBackStack(null)
                    transaction.commit()
                }

            }

            count += 1

            if (count >= 3) {
                count = 0
            }

        }

        binding.btnReplaceFragment.setOnClickListener {

            val replaceTransaction = supportFragmentManager.beginTransaction()
            replaceTransaction.replace(R.id.frame_main_container , FragmentThird() )
            replaceTransaction.commit()


        }



    }
}