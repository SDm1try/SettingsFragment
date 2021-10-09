package com.lessons.fragments2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val settingsFragment = SettingsFragment.newInstance()
    private val fragments = mutableListOf<TextVewFragment>()
    private val textFragmentId = R.id.fragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragments.add(newTextFragment().apply { text = "0" })

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment1, settingsFragment)
            .add(textFragmentId, fragments.last())
            .commit()
    }

    private fun newTextFragment() = TextVewFragment.newInstance().apply { text = fragments.lastIndex.toString() }

    override fun onStart() {
        super.onStart()

        settingsFragment.buttonRemove.setOnClickListener {
            if (fragments.size > 1) {
                supportFragmentManager.beginTransaction().remove(fragments.last())
                    .commit()
                fragments.removeLast()
//                fragments.last().textView.text = fragments.lastIndex.toString()
            }

        }
        settingsFragment.buttonAdd.setOnClickListener {

            Log.d("buttonAdd", "setOnClickListener")
            val transaction = supportFragmentManager.beginTransaction()


            if (settingsFragment.checkBoxAddToBackStack.isChecked){
                Log.d("buttonAdd", "checkBoxAddToBackStack")
                transaction.addToBackStack("name: ${fragments.lastIndex}")
            }
            if (settingsFragment.radioButtonAdd.isChecked) {
                Log.d("buttonAdd", "radioButtonAdd")
                fragments.add(newTextFragment())
                transaction.add(textFragmentId, fragments.last())
            }
            if (settingsFragment.radioButtonReplace.isChecked) {
                Log.d("buttonAdd", "radioButtonReplace")
                fragments.removeLast()
                fragments.add(newTextFragment())
                transaction.replace(textFragmentId, fragments.last())
            }
            Log.d("buttonAdd", "commit")

            transaction.commit()
//            fragments.last().text = fragments.lastIndex.toString()
        }
    }
}