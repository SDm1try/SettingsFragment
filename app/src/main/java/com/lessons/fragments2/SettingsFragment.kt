package com.lessons.fragments2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton

/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {
    lateinit var checkBoxAddToBackStack: CheckBox
    lateinit var radioButtonAdd: RadioButton
    lateinit var radioButtonReplace: RadioButton
    lateinit var buttonAdd: Button
    lateinit var buttonRemove: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        buttonAdd = view.findViewById(R.id.button_add)
        buttonRemove = view.findViewById(R.id.button_remove)
        checkBoxAddToBackStack = view.findViewById(R.id.checkBox)
        radioButtonReplace = view.findViewById(R.id.radio_replace)
        radioButtonAdd = view.findViewById(R.id.radio_add)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SettingsFragment()
    }
}