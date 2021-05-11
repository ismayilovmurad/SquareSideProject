package com.martiandeveloper.squareside

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.martiandeveloper.squareside.databinding.ActivityMainBinding
import com.martiandeveloper.squareside.tools.EventObserver

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    private lateinit var myView: MyView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.let {
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }

        observe()

        myView = MyView(this,200F)

        binding.activityMainContainerFL.addView(myView)

    }

    private fun observe() {

        with(viewModel) {

            viewModel.drawMBTNClick.observe(this@MainActivity, EventObserver {

                if (!number.value.isNullOrEmpty())

                    if (number.value!!.toFloat() in 0.5..4.0) {
                        (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                            (currentFocus ?: View(this@MainActivity)).windowToken,
                            0
                        )

                        binding.activityMainContainerFL.removeView(myView)
                        myView = MyView(this@MainActivity,(number.value!!.toFloat().times(200)))
                        binding.activityMainContainerFL.addView(myView)

                    } else Toast.makeText(
                        this@MainActivity,
                        "Please enter a number between 0.5 and 4",
                        Toast.LENGTH_SHORT
                    ).show()



            })

        }

    }

}
