package com.ianpedraza.aboutme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ianpedraza.aboutme.databinding.ActivityMainBinding
import com.ianpedraza.aboutme.utils.hideKeyboard
import com.ianpedraza.aboutme.utils.toVisibility
import com.ianpedraza.aboutme.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        setupUI()
    }

    private fun setupUI() {
        viewBinding.apply {
            button.setOnClickListener {
                addNickname(it)
            }
        }
    }

    private fun addNickname(view: View) {
        viewBinding.apply {
            val nickname = etNickname.text.toString()
            tvNickname.text = nickname
        }

        showNickname()
        showEditView(false)

        hideKeyboard(view)
    }

    private fun showNickname(show: Boolean = true) {
        viewBinding.apply {
            tvNickname.visibility = show.toVisibility()
        }
    }

    private fun showEditView(show: Boolean = true) {
        viewBinding.apply {
            val visibility = show.toVisibility()
            etNickname.visibility = visibility
            button.visibility = visibility
        }
    }
}
